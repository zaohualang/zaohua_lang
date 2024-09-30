
# 语言语法特性说明

## 1. 语言概述

本语言是一种函数式编程语言，采用自动继承机制，摒弃类的概念，仅支持结构体和函数作为自定义类型。语言具备强大的类型系统、函数特性、并发支持及隐式类型转换等功能，旨在提供高效且灵活的编程体验。
### 1.1 基本概念
本语言所有类型默认为值类型, 除非用$显式声明,才会当作引用类型处理,值类型只会进行值传递,引用类型只会进行引用传递.
此外,基础数据类型为不可变量, 扩展类型为可变量,扩展类型中的基础数据类型也是可变量.
### 1.2 代码结构
本语言采用包模式,在项目根目录定义package文件,文件中指定main文件的相对路径和其他包依赖, 除了main模块(文件),其他模块顶层作用域只允许进行struct声明,func声明以及sign声明;在main模块中,可以自由使用任意符合语法规则的语句,工程以main模块为入口.
---

## 2. 基本语法

### 2.1 基本类型

- **数值类型**：包括  `int8`, `int16`, `int32`, `int64`, `float8`, `float16`, `float32`, `float64`。
- **其他基本类型**：字符串类型和字节串类型和布尔型。所有基本类型都是值类型，且不可变。

  ```language
  true  # 布尔型
  float32  # 浮点型
  string  # 字符串类型
  bytes # 字节串类型
  ```

### 2.2 控制结构

- **选择结构**：使用 `if exp: exp; elif exp: exp; else: exp` 形式，其中 `elif` 和 `else` 可省略，但可以进行特殊匹配选择，形式为 `exp if value: exp; elif value: exp; else: exp`。

  ```language
  if x > 0:
      print("Positive")
  else if x == 0:
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

- **赋值行为**：所有赋值行为都是复制（值传递），包括函数实参，即使是嵌套的可变类型，如嵌套的 `map`。赋值是全量映射，不传递引用。需要传递引用时，使用引用传递符 `&`。

  ```language
  func set(&int2, int4) {
      int2 = (int2)int4
      return
  }

  snap = &num_array[3:9]  # 数组切片引用传递
  ```

### 2.4 扩展类型--函数

- **函数定义与调用**：函数参数仅有类型，没有名称。函数形参类型应按字母序排序,重复形参类型必须显式添加别名,对于重复类型形参,建议使用数组，形参数量建议不超过五个。函数作为第一类值，可以传递或作为返回值。别名使用方式分别为 `arr:MetaStruct[]`, `maps:Map<Meta,Meta>`, `f:int16-string->string`，一旦使用别名，数组名、map名和函数签名在本作用域中丢失值，只作为签名保留，别名不能作为签名。

  ```language
  func add(int_arr:int[2])int {
      return int_arr[0] + int_arr[1]
  }

  func multiply(float[], int)float {
      return float[] * int
  }

  # 函数调用
  add([3, 5])           # 调用无名函数
  multiply([1.0, 2.0], 3)  # 调用无名函数
  ```
  int[2]->int和int[3]->int属于不同的签名
  相同类型的实参传入函数时会自动打包为数组

- **函数重载与超载**：函数名一致但签名不同可以重载。超载适用于函数类型形参定义，具体调用时可以传入符合签名的函数。

  ```language
  # 使用签名方式定义超载函数
  func apply(f:<int->int>, int)int {
      return f(int)
  }

  func increment(int)int {
      return int + 1
  }

  # 使用签名方式调用超载函数
  apply(increment, 5)  # 输出：6
  ```
- **匿名函数**
    当作为实参或者返回值的时候,以及其他不需要函数名的情况下
- **隐式类型转换**：对于基本类型,可以自动进行隐式类型转换,转换原则为安全第一原则,低位转高位是安全的,高位转低位是不安全的,对于结构体子类隐式转化父类是安全的,父类隐式转化子类是不安全的,对于不安全的隐式转换编译器会警告。如果将子类型传入父类型，参数的所有行为以子类型拥有的优先。如果子类型没有此行为，则调用父类型，如果父类型也没有该行为，则编译器报错;如果将父类型传入子类型,行为以父类型拥有的优先,如果父类型没有对应行为,则调用子类型的对应行为,如果都没有,则编译器报错.

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

  # 隐式
  process(Child { 42, "example" })
  ```

- **函数的调用**: 一般情况下, 直接使用函数名(实参)对函数进行调用, 如果函数有形参, 也可使用 实参.函数名(其他实参)的方式进行调用,特殊的,如果有多个实参,也可以以匿名结构{实参1, 实参2}.函数名(其他实参)的方式对函数进行调用

### 2.5 结构体定义与调用

- **结构体定义**：结构体字段仅使用类型定义，字段按字母序排列，字段调用时使用 `struct.字段类型` 的形式。字段类型重复会自动打包成数组, 此情况下可以使用别名，定义别名后类型丢失值,只作为签名使用,若重复建议数组形式表示，同一签名的结构体不能重名, 结构体声明中,字段类型不可以是函数,但在匿名结构体中可以有函数类型字段

  ```language
  struct Point {
      float, float
  }

  struct Vector {
      float[], int
  }

  struct Persion{
    int, int, int[4]
  }

  # 结构体字段调用
  Point.float[1]  # 表示访问大小为2的float数组的第二个元素
  Vector.int    # 访问结构体字段类型
  Persion.int[5] #表示访问第三个字段的最后一个值
  ```
- **匿名结构体**: 使用{}包裹的表达式就是匿名结构体, 函数的多返回值实际就是匿名结构体, 匿名结构体赋值时可以自动解包,但变量数量得一一对应,且遵循变量数最少原则, 匿名结构体也可以用来进行函数的调用,如
    ```language
    func add(int[2]):
        return int[0] + int[1]
    num := {422, 533}.add()
    ```
    特殊的, 没有大括号包围的则是隐式的单字段匿名结构体,对于上面的程序,可以这样`[422, 433].add()

- **自动继承机制**：包含另一个结构体所有字段的结构体将自动继承该结构体。字段调用仍使用 `struct.字段类型` 的形式。

  ```language
  struct ColorPoint {
      float, int, string
  }

  struct RichVector {
      float[], int, string
  }
  # 由于 RichVector具有ColorPoint所有字段,所以自动继承ColorPoint, 可以隐式认为是ColorPoint类型,可以直接传入ColorPoint类型
  # 结构体字段调用
  ColorPoint.string  # 访问结构体字段类型
  RichVector.float[] # 访问结构体字段类型
  ```

### 2.6 数组与动态数组

- **数组定义**：定义数组时，中括号内有数字表示固定数组，没有数字则为动态数组。同类型（或有继承关系的类型）的数组，不同长度可以隐式转换,不安全的转换编译器会警告。

  ```language
  int[10]  # 固定长度数组,显式指定类型
  [1, 2, 3, 4] #固定长度数组, 推断类型
  [1, 2, 3, 4, ] #动态数组, 推断类型
  int[]  # 动态数组, 显式指定类型
  ```
数组支持切片操作, 一般的,切片为值复制 如
```language
    slice_a := int_array[11:22] #此处将int_array的第12个到第22个元素复制给切片slice_a, 操作完成后, int_array和slice_a彼此独立, 且slice_a为动态数组
    slice_b := $int_array[11:22] #此处将int_array的第12个到第22个元素引用给切片slice_b, 当对slice_b[0]进行修改时, int_array[11]会同步修改, 如果int_array是固定数组,slice_b就是固定数组, int_array是动态数组, slice_b就是动态数组  
```
- **哈希表定义**：元哈希表为 `map MetaMap<Meta: Meta>`，其中 `map` 为关键字，用于声明哈希表。哈希表之间有继承关系，可以进行隐式替换,不安全的替换会警告

  ```language
  map example_map{"boy": 3, "girl": 4} 
  哈希表支持类型推断,如果键或值之间类型不一致,会取最近公共元类型
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
- **co**: 创建协程, 用于并发操作
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
chan int my_channel  # 声明一个元素类型为 int 的通道
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
my_channel <- 42  # 向通道发送整数 42
```

#### 7.3.2 接收数据

使用 `<-` 操作符从通道接收数据。接收操作是阻塞的，直到有数据可用。

```language
value = <-my_channel  # 从通道接收数据并赋值给变量 value
```

### 7.4. 通道操作

#### 7.4.1 关闭通道

使用 `close` 函数关闭通道。关闭通道后，无法再发送数据，但可以接收剩余的数据。

```language
close(my_channel)  # 关闭通道
```

#### 7.4.2 检查通道是否关闭
通过is_closed(my_channel)判断通道是否关闭

```language
value = <-my_channel  # value 为接收到的数据，ok 为通道状态
if is_closed(my_channel) {
    print("Channel closed")
}
```

### 7.5. 示例

#### 7.5.1 基本示例

```language
func producer(chan int) {
    for i in range(5) {
        my_channel <- i  # 向通道发送数据
    }
    close(my_channel)  # 发送完数据后关闭通道
}

func consumer(chan int) {
    for {
        value, ok = <-my_channel  # 从通道接收数据
        if is_closed(my_channel) {
            break  # 通道关闭，退出循环
        }
        print(value)
    }
}

my_channel = chan int[5]  # 创建一个缓冲区大小为 5 的通道
co producer(my_channel)
co consumer(my_channel)
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
    for value = <-bufferedChannel {
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
