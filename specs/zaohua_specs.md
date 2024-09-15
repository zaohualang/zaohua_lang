

# 语言语法特性说明

## 1. 语言概述

本语言是一种函数式编程语言，采用自动继承机制，摒弃类的概念，仅支持结构体和函数作为自定义类型。语言具备强大的类型系统、函数特性、并发支持及显式类型转换等功能，旨在提供高效且灵活的编程体验。

---

## 2. 基本语法

### 2.1 结构体定义与调用

- **结构体定义**：结构体字段仅使用类型定义，字段按字母序排列，字段调用时使用 `struct.字段类型` 的形式。字段类型不能重复，若重复则以数组形式表示，字段数不能超过五个。

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
  @tags float[] 和 float 没有继承关系
  # 结构体字段调用
  ColorPoint.string  # 访问结构体字段类型
  RichVector.float[] # 访问结构体字段类型
  ```

### 2.2 数组与动态数组

- **数组定义**：定义数组时，中括号内有数字表示固定数组，没有数字则为动态数组。同类型（或有继承关系的类型）的数组，长度较长的数组继承长度较短的数组，可以进行里氏替换。

  ```language
  intArray[10]  # 固定长度数组
  dynamicArray[]  # 动态数组
  ```

### 2.3 哈希表

- **哈希表定义**：元哈希表为 `Map<Meta, Meta>`，其中 `Map` 为关键字，用于声明哈希表。哈希表之间有继承关系，遵循里氏替换原则。当键和值同时具有继承关系且继承关系同向时，继承关系才成立。

  ```language
  Map<int, string> exampleMap
  ```

---

## 3. 函数

### 3.1 函数定义与调用

- **函数定义**：函数参数仅有类型，没有名称。函数参数类型不能重复，重复类型必须以数组形式传入，形参数量不能超过五个。函数作为第一类值，可以传递或作为返回值。其中,数组,Map 和函数签名可以使用别名,使用方式分别为
  arr:MetaStruct[], maps:Map<Meta,Meta>, func:int16-string->string, 一旦使用别名,数组名,Map名和函数签名就在本作用域中失去含义

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

### 3.2 函数重载与超载

- **重载**：函数名一致但签名不同可以重载。超载适用于函数类型形参定义，具体调用时可以传入符合签名的函数。

  ```language
  #使用签名方式定义超载函数
  func apply(func:int->int, int)int {
      return func(int)
  }

  func increment(int)int {
      return int + 1
  }

  # 使用签名方式调用超载函数
  apply(increment, 5)  # 输出：6
  ```

### 3.3 显式类型转换

- **显式转换**：除了函数参数传入之外，对于结构体其他情况下需要使用 `(parent)Child` 进行显式类型转换。如果将子类型传入父类型，参数的所有行为以子类型拥有的优先。如果子类型没有此行为，则调用父类型，如果父类型也没有该行为，则编译器报错。

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

### 3.4 赋值与引用传递

- **赋值行为**：所有赋值行为都是复制（值传递），包括函数实参，即使是嵌套的可变类型，如嵌套的 `Map`。赋值是全量映射，不传递引用。需要传递引用时，使用引用传递符 `&`。

  ```language
  func set(&int2, int4)
    int2 = (int2)int4
    return

  snap = &num_array[3:9]  # 数组切片引用传递
  ```

---

## 4. 控制结构

### 4.1 循环结构

- **循环结构**：语言仅支持 `for _ in _` 形式的循环结构，用于遍历范围或集合。

  ```language
  #range为内置函数
  for i in range(10) {
      # 循环体
  }
  ```

### 4.2 选择结构

- **选择结构**：使用 `if exp: exp; elif exp: exp; else: exp` 形式，其中 `elif` 和 `else` 可省略，但可以进行特殊匹配选择，形式为 `exp if value: exp; elif value: exp; else: exp`。

  ```language
  if x > 0:
      print("Positive")
  elif x == 0:
      print("Zero")
  else:
      print("Negative")
  ```

---

## 5. 类型系统

### 5.1 基本类型

- **数值类型**：包括 `int1`, `int2`, `int4`, `int8`, `int16`, `int32`, `int64`, `float8`, `float16`, `float32`, `float64`。其中 `int1` 用于布尔值。没有 `bool` 类型。
- **其他基本类型**：字符串类型和字节串类型。所有基本类型都是值类型，且不可变。

  ```language
  int1  # 布尔型
  float32  # 浮点型
  string  # 字符串类型
  bytes #字节串类型
  ```

### 5.2 泛型

- **限制型泛型**：任何结构体和函数都可以视为限制型泛型。
- **无限制泛型**：元类型 `Meta` 视为无限制泛型，可以解包为任何类型。

---

## 6. 并发支持

- **进程与线程**：语言支持进程、线程、协程以及闭包式并发。
- **缺失概念**：语言不支持接口、原始泛型、抽象方法和抽象类。
- **编译型语言**：编译后自带轻量级运行时，主要处理垃圾回收和创建签名之间的映射关系。

---
