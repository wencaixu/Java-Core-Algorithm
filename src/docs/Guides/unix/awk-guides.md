# AWK 学习总结

## 基础篇

AWK提供了类编程环境，可以通过命令的重组对数据进行修改和整合。AWK命令可以在script中创建并保存变量，使用结构化编程语句（如IF ELSE），使用算术和字符串操作来操作数据，生成格式化报告。
### AWK常用参数

| 选项 | 描述 |
| :----: | :----: |
| -F  | 读取行后划分字段的分隔符 |
| -f  | 执行awk文件中的命令集合 |
| -mf N  | 处理数据的最大字段数 |
| -mr N  | 处理的最大行数 |

### 数字字段变量

- $0代表整个文本行；
- $1代表文本行中的第1个数据字段；
- $2代表文本行中的第2个数据字段；
- $n代表文本行中的第n个数据字段。

### 学习小例子
##### 1. 执行多个命令

```sh
	echo 'i love you,miss chen,and miss chen love me' | awk '{$4="i"; print $0}'
```
说明：多个命令之间使用;分隔，并且awk命令需要注意格式为'{command1; command2}'
##### 2. 文件中读取命令
可以将一系列awk命令封装到一个文件中，然后使用awk -f 命令执行该多条命令。详细情况如下：

```sh
  echo "miss chen love me" | awk -f awk.awk
```
其中awk的内容如下：```sh {$4="xuwencai"; print $0}```，需要注意格式
##### 3. 处理数据前运行脚本(BEGIN)

```sh
  awk 'BEGIN {print "The data3 File Contents:"} {print $0}' awk.awk
```
BEGIN命令可以用于预设表头

##### 4. 处理数据后运行脚本(END)
与BEGIN命令相似，在命令执行结束后执行

```sh
  awk '{print $0}; END {print "success"}' data.txt
```

## 高级篇