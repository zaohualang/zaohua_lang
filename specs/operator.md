# 1. 表达式特性

## 1.1. 算术表达式

算术表达式用于进行数值计算，支持以下操作符：

- **加法** (`+`): 计算两个操作数的和。
  ```language
  result = 5 + 3  # 结果为 8
  ```

- **减法** (`-`): 计算两个操作数的差。
  ```language
  result = 5 - 3  # 结果为 2
  ```

- **乘法** (`*`): 计算两个操作数的积。
  ```language
  result = 5 * 3  # 结果为 15
  ```

- **除法** (`/`): 计算两个操作数的商，结果为浮点数。
  ```language
  result = 5 / 2  # 结果为 2.5
  ```

- **整数除法** (`//`): 计算两个操作数的商，结果为整数。
  ```language
  result = 5 // 2  # 结果为 2
  ```

- **取余** (`%`): 计算两个操作数的余数。
  ```language
  result = 5 % 3  # 结果为 2
  ```

- **幂运算** (`**`): 计算第一个操作数的第二个操作数次幂。
  ```language
  result = 2 ** 3  # 结果为 8
  ```

## 1.2. 逻辑表达式

逻辑表达式用于进行布尔逻辑运算，支持以下操作符：

- **逻辑与** (`&&`): 如果两个操作数都为真，则结果为真。
  ```language
  result = (5 > 3) && (2 < 4)  # 结果为 true
  ```

- **逻辑或** (`||`): 如果任一操作数为真，则结果为真。
  ```language
  result = (5 > 3) || (2 > 4)  # 结果为 true
  ```

- **逻辑非** (`!`): 对操作数取反，如果操作数为真则结果为假，反之亦然。
  ```language
  result = !(5 > 3)  # 结果为 false
  ```

- **逻辑异或** (`^`): 如果操作数不同，则结果为真。
  ```language
  result = (true ^ false)  # 结果为 true
  ```

## 1.3. 位运算表达式

位运算表达式用于对整数的位进行操作，支持以下操作符：

- **位与** (`&`): 对两个操作数的每一位进行与运算。
  ```language
  result = 5 & 3  # 结果为 1（0101 & 0011 = 0001）
  ```

- **位或** (`|`): 对两个操作数的每一位进行或运算。
  ```language
  result = 5 | 3  # 结果为 7（0101 | 0011 = 0111）
  ```

- **位异或** (`^`): 对两个操作数的每一位进行异或运算。
  ```language
  result = 5 ^ 3  # 结果为 6（0101 ^ 0011 = 0110）
  ```

- **位非** (`~`): 对操作数的每一位进行取反运算。
  ```language
  result = ~5  # 结果为 -6（~0101 = 1010）
  ```

- **左移** (`<<`): 将操作数的位向左移动指定的位数，低位补零。
  ```language
  result = 5 << 1  # 结果为 10（0101 << 1 = 1010）
  ```

- **右移** (`>>`): 将操作数的位向右移动指定的位数，符号位补充（对于有符号整数）。
  ```language
  result = 5 >> 1  # 结果为 2（0101 >> 1 = 0010）
  ```

## 1.4. 关系表达式

关系表达式用于比较两个操作数的大小或相等性，支持以下操作符：

- **等于** (`==`): 检查两个操作数是否相等。
  ```language
  result = (5 == 5)  # 结果为 true
  ```

- **不等于** (`!=`): 检查两个操作数是否不相等。
  ```language
  result = (5 != 3)  # 结果为 true
  ```

- **大于** (`>`): 检查第一个操作数是否大于第二个操作数。
  ```language
  result = (5 > 3)  # 结果为 true
  ```

- **小于** (`<`): 检查第一个操作数是否小于第二个操作数。
  ```language
  result = (5 < 3)  # 结果为 false
  ```

- **大于等于** (`>=`): 检查第一个操作数是否大于或等于第二个操作数。
  ```language
  result = (5 >= 5)  # 结果为 true
  ```

- **小于等于** (`<=`): 检查第一个操作数是否小于或等于第二个操作数。
  ```language
  result = (5 <= 3)  # 结果为 false
  ```
# 特殊操作符特性说明

本语言支持多个特殊操作符，提供灵活的变量声明、函数签名、管道处理等功能。以下是各个操作符的详细说明及用例。

## 1. 海象符 `:=`

**作用**: 用于声明并初始化变量。变量的类型会自动推断。每个变量在同一作用域内只能声明一次。

**用例**:
```language
a := 10  # 声明变量 a，并自动推断其类型为 int
b := "Hello, world!"  # 声明变量 b，类型为字符串
```

**注意**: 变量在同一作用域中只能用 `:=` 声明一次，重复声明会引发编译错误。

---

## 2. 别名 `:`

**作用**: 用于给函数签名或类型定义别名，方便调用和代码简化。别名可以用于重载签名调用。

**用例**:
```language
f: <int32,float32->string>  # 将特定签名函数取别名 f
f(5, 3.14)  # 调用别名函数
```

**注意**: 别名只能用于已有函数或签名，无法给不存在的函数或类型取别名。同一作用域别名不能重复.

---

## 3. 签名
**签名格式** \<sign>

**作用**: 连接函数参数类型，用于定义函数签名。参数类型通过连字符 `,` 连接在一起。

**用例**:
```language
func add(a:int32[], string) int32 函数签名为 <int32[],string->int32> # 
result := add(5, 10, "yes")  # 调用函数，返回结果 15
```



---

## 4. 返回值符号 `->`

**作用**: 在函数签名中，`->` 用于分隔参数类型与返回类型，表示函数的返回值类型。

**用例**:
```language
func add(a:int32[], string) int32 函数签名为 <int32[],string->int32> # 
result := add(5, 10, "yes")  # 调用函数，返回结果 15
```

---

## 5. 引用符号 `$`

**作用**: 表示传递变量的引用，允许在函数中修改传入的变量。引用传递符号 `$` 可用于传递数组切片、结构体等。

**用例**:
```language
func modify($int2, int4) {
    int2 = int4
}

a := 5
modify($a, 10)
# a 的值被修改为 10
```

**注意**: 使用 `$` 传递引用可以直接修改原始变量的值。

---

## 6. 传入通道 `<-`

**作用**: 用于将数据传入通道（`chan`）中，支持并发通信。

**用例**:
```language
chan := make(chan int32)
chan <- 42  # 将 42 传入通道
```

**注意**: 通道用于并发操作时，`<-` 操作可以阻塞直到数据被成功传入或传出。

---


## 操作符总结

| 操作符  | 描述                                                         | 用例                                                         |
|--------|--------------------------------------------------------------|--------------------------------------------------------------|
| `:=`   | 变量声明与初始化，自动推断类型                                | `x := 10`                                                    |
| `:`    | 别名定义                                                      | `f:int32_float32->string`                         |
| `-`    | 函数参数连接符                                                | `f:int32-int32->int32`                               |
| `->`   | 函数返回值符号                                                | `func multiply(int32-int32->int32)`                          |
| `$`    | 引用传递                                                      | `modify($a, 10)`                                             |
| `<-`   | 传入通道符号                                                  | `chan <- 42`                                                 |

这份操作符特性说明为本语言提供了灵活的语法规则，确保操作符能够提高代码的可读性和开发效率。

