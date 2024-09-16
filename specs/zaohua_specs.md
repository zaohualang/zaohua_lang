
# 语言语法特性说明

## 1. 语言概述

本语言是一种函数式编程语言，采用自动继承机制，摒弃类的概念，仅支持结构体和函数作为自定义类型。语言具备强大的类型系统、函数特性、并发支持及显式类型转换等功能，旨在提供高效且灵活的编程体验。

---

## 2. 基本语法

### 2.1 基本类型

- **数值类型**：包括 `int1`, `int2`, `int4`, `int8`, `int16`, `int32`, `int64`, `float8`, `float16`, `float32`, `float64`。其中 `int1` 用于布尔值。没有 `bool` 类型。
- **其他基本类型**：字符串类型和字节串类型。所有基本类型都是值类型，且不可变。

  ```language
  int1  # 布尔型
  float32  # 浮点型
  string  # 字符串类型
  bytes # 字节串类型
  ```

### 2.2 控制结构

- **选择结构**：使用 `if exp: exp; elif exp: exp; else: exp` 形式，其中 `elif` 和 `else` 可省略，但可以进行特殊匹配选择，形式为 `exp if value: exp; elif value: exp; else: exp`。

  ```language
  if x > 0:
      print("Positive")
  elif x == 0:
      print("Zero")
  else:
      print("Negative")
  ```

- **循环结构**：语言仅支持 `for _ in _` 形式的循环结构，用于遍历范围或集合。

  ```language
  for i in range(10) {
      # 循环体
  }
  ```

### 2.3 赋值与引用传递

- **赋值行为**：所有赋值行为都是复制（值传递），包括函数实参，即使是嵌套的可变类型，如嵌套的 `Map`。赋值是全量映射，不传递引用。需要传递引用时，使用引用传递符 `&`。

  ```language
  func set(&int2, int4) {
      int2 = (int2)int4
      return
  }

  snap = &num_array[3:9]  # 数组切片引用传递
  ```

### 2.4 函数

- **函数定义与调用**：函数参数仅有类型，没有名称。函数参数类型不能重复，重复类型必须以数组形式传入，形参数量不能超过五个。函数作为第一类值，可以传递或作为返回值。可以使用别名，使用方式分别为 `arr:MetaStruct[]`, `maps:Map<Meta,Meta>`, `f:int16-string->string`，一旦使用别名，数组名、Map名和函数签名在本作用域中失去含义，只保留签名作用，别名不能作为签名。

  ```language
  func add(int_arr:int[2])int {
      return int_arr[1] + int_arr[2]
  }

  func multiply(float[], int)float {
      return float[] * int
  }

  # 函数调用
  add([3, 5])           # 调用无名函数
  multiply([1.0, 2.0], 3)  # 调用无名函数
  ```

- **函数重载与超载**：函数名一致但签名不同可以重载。超载适用于函数类型形参定义，具体调用时可以传入符合签名的函数。

  ```language
  # 使用签名方式定义超载函数
  func apply(func:int->int, int)int {
      return func(int)
  }

  func increment(int)int {
      return int + 1
  }

  # 使用签名方式调用超载函数
  apply(increment, 5)  # 输出：6
  ```

- **显式类型转换**：对于结构体其他情况下需要使用 `(parent)Child` 进行显式类型转换。如果将子类型传入父类型，参数的所有行为以子类型拥有的优先。如果子类型没有此行为，则调用父类型，如果父类型也没有该行为，则编译器报错。

  ```language
  struct Parent {
      int
  }

  struct Child {
      int, string
  }

  func process(Parent): string {
      return "Processed Parent"
  }

  # 显式类型转换
  process((Parent) Child { 42, "example" })
  ```

### 2.5 结构体定义与调用

- **结构体定义**：结构体字段仅使用类型定义，字段按字母序排列，字段调用时使用 `struct.字段类型` 的形式。字段类型不能重复，若重复则以数组形式表示，字段数不能超过五个。同一签名的结构体不能重名

  ```language
  struct Point {
      float, int
  }

  struct Vector {
      float[], int
  }

  # 结构体字段调用
  Point.float  # 访问结构体字段类型
  Vector.int    # 访问结构体字段类型
  ```

- **自动继承机制**：包含另一个结构体所有字段的结构体将自动继承该结构体。字段调用仍使用 `struct.字段类型` 的形式。

  ```language
  struct ColorPoint {
      float, int, string
  }

  struct RichVector {
      float[], int, string
  }

  # 结构体字段调用
  ColorPoint.string  # 访问结构体字段类型
  RichVector.float[] # 访问结构体字段类型
  ```

### 2.6 数组与动态数组

- **数组定义**：定义数组时，中括号内有数字表示固定数组，没有数字则为动态数组。同类型（或有继承关系的类型）的数组，长度较长的数组继承长度较短的数组，可以进行里氏替换。

  ```language
  intArray[10]  # 固定长度数组
  dynamicArray[]  # 动态数组
  ```

- **哈希表定义**：元哈希表为 `Map<Meta, Meta>`，其中 `Map` 为关键字，用于声明哈希表。哈希表之间有继承关系，遵循里氏替换原则。当键和值同时具有继承关系且继承关系同向时，继承关系才成立。

  ```language
  Map<int, string> exampleMap
  ```

---

## 3. 高级特性

### 3.1 泛型

- **限制型泛型**：任何结构体和函数都可以视为限制型泛型。
- **无限制泛型**：元类型 `Meta` 视为无限制泛型，可以解包为任何类型。

---

## 4. 并发支持

- **进程与线程**：语言支持进程、线程、协程以及闭包式并发。
- **缺失概念**：语言不支持接口、原始泛型、抽象方法和抽象类。
- **编译型语言**：编译后自带轻量级运行时，主要处理垃圾回收和创建签名之间的映射关系。

---

## 5. 关键字、异常处理与注解

### 5.1 关键字

本语言保留了以下关键字，用于构建程序的基本结构和控制流程：

- **break**: 终止当前循环。
- **chan**: 声明通道类型，用于并发操作。
- **continue**: 跳过当前循环的剩余部分，继续下一次迭代。
- **else**: 与 `if` 语句配合使用，表示条件不满足时的代码块。
- **for**: 用于循环迭代。
- **in**: 用于循环控制和集合操作。
- **func**: 声明函数。
- **goto**: 跳转到指定的代码位置。
- **if**: 条件判断语句。
- **import**: 导入模块或库。
- **map**: 声明哈希表类型。
- **return**: 从函数返回值。
- **struct**: 声明结构体类型。
- **try**: 异常处理结构的开始。
- **catch**: 异常处理结构的结束，可以捕获异常或无条件执行代码块。
- **raise**: 抛出异常。

### 示例

```language
func example(int)int {
    if int > 10 {
        return int * 2
    } else {
        return int + 2
    }
}

for i in range(5) {
    if i % 2 == 0 {
        continue
    }
    print(i)
}
```




### 5.2 异常处理

- **异常处理结构**：`try: ... catch Exception: ... catch: ...`。`catch` 块用于处理异常或无条件

执行代码。

  ```language
  try {
      # 可能抛出异常的代码
  } catch Exception:
      # 异常处理代码
  catch:
      # 无论如何都会执行的代码
  ```

### 5.3 注解

- **函数注解**：可以通过 `@` 增加注解，用于扩展函数的行为或添加元数据。

  ```language
  @deprecated
  func oldFunction() {
      # 函数体
  }
  ```

---

## 6. [表达式与运算符](https://github.com/zaohualang/zaohua_lang/edit/main/specs/operator.md)


## 7.`chan` 特性文档

### 7.1. 概述

在本语言中，`chan` 关键字用于声明和操作通道。通道用于在并发操作中进行数据传递，支持发送和接收操作。通道可以用于进程和线程之间的数据通信，确保数据的一致性和线程安全。

### 7.2. 声明通道

#### 7.2.1 声明通道

使用 `chan` 关键字声明一个通道。通道类型由通道的元素类型指定。

```language
chan int myChannel  # 声明一个元素类型为 int 的通道
```

#### 7.2.2 缓冲区通道

可以声明带有缓冲区的通道，通过指定缓冲区的大小来定义。

```language
chan int bufferedChannel[10]  # 声明一个缓冲区大小为 10 的 int 类型通道
```

### 7.3. 发送与接收

#### 7.3.1 发送数据

使用 `<-` 操作符向通道发送数据。

```language
myChannel <- 42  # 向通道发送整数 42
```

#### 7.3.2 接收数据

使用 `<-` 操作符从通道接收数据。接收操作是阻塞的，直到有数据可用。

```language
value = <-myChannel  # 从通道接收数据并赋值给变量 value
```

### 7.4. 通道操作

#### 7.4.1 关闭通道

使用 `close` 函数关闭通道。关闭通道后，无法再发送数据，但可以接收剩余的数据。

```language
close(myChannel)  # 关闭通道
```

#### 7.4.2 检查通道是否关闭

通过接收操作的第二个返回值来检查通道是否已关闭。第二个返回值为 `false` 表示通道已关闭且没有更多数据可读。

```language
value, ok = <-myChannel  # value 为接收到的数据，ok 为通道状态
if !ok {
    print("Channel closed")
}
```

### 7.5. 示例

#### 7.5.1 基本示例

```language
func producer(chan int) {
    for i in range(5) {
        myChannel <- i  # 向通道发送数据
    }
    close(myChannel)  # 发送完数据后关闭通道
}

func consumer(chan int) {
    for {
        value, ok = <-myChannel  # 从通道接收数据
        if !ok {
            break  # 通道关闭，退出循环
        }
        print(value)
    }
}

myChannel = chan int[5]  # 创建一个缓冲区大小为 5 的通道
go producer(myChannel)
go consumer(myChannel)
```

#### 7.5.2 带缓冲区的通道

```language
func main() {
    bufferedChannel = chan int[3]  # 创建一个缓冲区大小为 3 的通道

    // 发送数据
    bufferedChannel <- 1
    bufferedChannel <- 2
    bufferedChannel <- 3

    // 关闭通道
    close(bufferedChannel)

    // 接收数据
    for value, ok = <-bufferedChannel; ok; value, ok = <-bufferedChannel {
        print(value)
    }
}
```

## 6. 注意事项

- 通道的发送和接收操作是阻塞的，直到通道的另一端准备好。
- 对于缓冲区通道，发送操作只有在缓冲区未满时才能成功，接收操作只有在缓冲区非空时才能成功。
- 关闭通道后，只能接收数据，无法再发送数据。

```
## 6. 总结

- **类型系统**：值传递，支持丰富的基本类型和自定义结构体类型。
- **函数特性**：支持函数重载、超载、显式类型转换及引用传递。
- **控制结构**：支持有限的循环和选择结构。
- **并发支持**：原生支持进程、线程和闭包式并发。
- **异常处理**：提供灵活的异常处理机制。
- **关键字**：定义了语言的基本控制结构和语法。

本语言的设计目标是提供一种简洁高效的编程方式，支持强大的类型系统和并发能力，并通过精简的控制结构和显式的类型系统实现代码的清晰与可维护性。
