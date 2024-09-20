# 编码规范

## 1. 命名规范

- **结构体命名**：结构体名称使用首字母大写的驼峰命名法，例如 `Person`, `EmployeeDetails`。
  
  ```language
  struct Person {
      string
      int
  }
  ```

- **其他命名**：函数名、变量名、常量名等使用小写单词加下划线的命名风格，例如 `calculate_area`, `max_value`, `get_user_name`。私有成员和函数以 `_` 开头，例如 `_hidden_method`, `_private_variable`。公共成员和函数不以 `_` 开头。

  ```language
  func calculate_area(float32) float32 {
      return 3.14 * float32 * float32
  }
  
  func _hidden_method() {
      # 私有方法
  }

  map custom_map(string, custom_struct){
    #键值对
  }

  ```

## 2. 注释规范

- **文档注释**：所有结构体和函数必须有文档注释。注释应详细解释每个参数及返回值的含义。可以为空字符串,没有文档注释的结构体或函数将导致编译错误。

  ```language
  # 计算圆的面积
  # 参数:
  #   float32: 圆的半径
  # 返回值:
  #   float32: 计算出的面积
  func calculate_area(float32, float32) float32 {
      return 3.14 * float32 * float32
  }
  ```

## 3. 语句与作用域

- **语句分隔**：采用换行表示语句的分隔。每行语句结尾不需要分号 `;`。
  
  ```language
  x = 10
  y = 20
  z = x + y
  ```

- **作用域分隔**：使用缩进表示作用域的分隔，相当于 `{}`。虽然也可以显式使用 `{}` 和 `;`，但规范建议使用换行和缩进。

  ```language
  if x > 0
      y = x + 1
      print(y)
  else
      print("Non-positive")
  ```

## 4. 字符串处理
对于字符串, "str" 与'str' 等效

- **原始字符串**：使用 `r"..."` 表示原始字符串，可以用于表示多行字符串，不会对字符串内容进行转义。

  ```language
  r"这是一个原始字符串
  可以包含换行和特殊字符 \n \t 不会被转义"
  ```

- **格式化字符串**：使用 `f"...{}"` 表示格式化字符串，其中 `{}` 为占位符，可以用来填充变量。

  ```language
  name = "Alice"
  age = 30
  message = f"Name: {name}, Age: {age}"
  ```

## 5. 字面值

- **数值字面值**：如果不注明类型，则采用系统位数（例如32位系统中的 `74` 表示 `(int32)74`）。显式指定类型的字面值需使用括号，例如 `(int64)74`。

  ```language
  num = 74          # 默认系统位数，例如 int32
  large_num = (int64)74  # 显式指定为 int64
  ```

- **浮点数字面值**：同样地，不注明类型则采用系统位数。显式指定类型需使用括号。

  ```language
  pi = 3.14         # 默认系统位数，例如 float32
  large_pi = (float64)3.14  # 显式指定为 float64
  ```

- **字节串**：使用 ```` 表示，默认以16进制数值显示，不进行编码。

  ```language
  data = ``0x12 0x34 0x56``
  ```

## 6. 运算符

- **双目运算符**：双目运算符两边需有空格。例如 `a + b`，`x - y`。

  ```language
  sum = a + b
  difference = x - y
  ```

- **冒号**：冒号 `:` 后面跟一个空格。如果冒号后面直接换行,冒号可以省略不写

  ```language
  func multiply(int, int) int {
      return int * int
  }
  ```

## 7. 变量声明与类型推断

- **变量声明**：所有变量声明使用海象运算符 `:=`。变量的类型会自动推断。

  ```language
  x := 10           # 自动推断为 int32
  name := "Alice"   # 自动推断为 string
  ```

- **唯一声明**：在同一作用域中，同一变量只能声明一次。如果需要重新赋值，请直接使用 `=`。

  ```language
  x := 5
  x = 10            # 重新赋值

  # 错误示例：在同一作用域中重复声明变量
  x := 10           # 错误: 变量 x 已经声明过
  ```
## 8. 当函数无返回值时,函数返回Meta类型,可以省略不写,但在签名中必须显式写出:
  ```language
  func eat(){
      print_ln("he is eating food")
      return
  }
  ```
      
