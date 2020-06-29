# SED学习总结

## 基础篇
SED编译器被称为流编辑器。可以在处理数据之前基于事先提供的一组规则遍历数据流。可以包括文本文件中的搜索关键字全局替换、局部替换（特定行，和标记）、删除行、添加或追加行；处理单个字符的转换
命令（y）；执行效率极高。

SED命令格式
  ```sh
     sed options program file
  ```
  options常用的可以包括如下表：

| 选项 | 描述 |
| :----: | :----: |
| -F  | 读取行后划分字段的分隔符 |
| -f  | 执行sed文件中的命令集合 |
| -n  | 禁止sed编译器的输出,对比P命令|
| -v var = value  | 设置变量并设置默认值 |
| -e | 执行多个命令 |

  sed命令实践举例如下：
  
1. 管道命令向sed命令中传递数据

```sh
  echo 'hello,world' | sed 's/hello,world/hello,jerry/' # 此处将输出hello,jerry
```
 说明：s命令可以对匹配字符串进行替换，hello,jerry替换hello,world
 
2. sed指定多条命令

```sh
  sed -e 's/hello/hi/; s/nihao/how are you/' data.txt 
```
 说明：sed将分别执行两条语句，多条命令之间需要使用‘;’进行分割，也可以使用** 次命令行 **。

3. sed执行文件命令，文件的命名常以.sed结尾

```sh
  sed -f multicommands.sed data.txt  # 此时将顺序执行multicommands中的函数
```
 说明：sed将分别执行.sed文件中的命令，.sed中的命令按行填写

### 1 : 替换(s)
 s命令默认替换每一行的第一个匹配的字符串，s命令具有以下的替换标记，其书写命令如下：
 
```sh
  sed 's/hello/hi/** flag **' data.txt
```

 | 选项 | 描述 |
| :----: | :----: |
| 数字i  | 替换行中的第i个位置的元素 |
| g  | 替换匹配的数据 |
| p  | 输出替换之前的行 |
| w file  | 将替换结果写入到文件中 |

说明：不同的flag可以组合使用，一般组合使用g和w替换标记。

** 特别提示重点(替换特殊字符，如'\') **

```sh
  sed 's!/bin!/sbin!' data.txt  # 使用感叹号来分隔模式
```
### 2 : 行寻址方式：数字形式，文本形式

** 数字形式 **

```sh
  sed '1s!/bin!/sbin!' data.txt # 替换确定行，本例为第一行
```

```sh
  sed '2,3s!/bin!/sbin!' data.txt # 替换范围，本地为[2,3]行
```

```sh 
  sed '2,$s!/bin/!sbin!' data.txt # 从某一行开始的所有行，从第2行开始
```

** 文本形式 **

以文本方式的命令行格式 ```sh /pattern/command/```


```sh
  sed -n '/hello/s/hello/hi/p' data.txt  # 输出匹配行替换之前的数据
```

** 命令组合 **

组合命令需要使用{}来进行处理，如下：

```sh
  sed '3{s/hello/hi/p; s/nihao/hi/p}' data.txt
```
### 3 : 删除命令（d）
删除指定行

```sh
  sed '1d' data.txt # 删除第一行，其中1可替换为范围1,3或1,$删除所有
```
删除匹配模式的行
```sh
  sed '/hello 1d' data.txt # 删除匹配模式中的第一行
```
删除某区间里的行

```sh
  sed '/1/ /2/d' data.txt # 删除第一行到第二行
```
说明：/1/第一个不是打开命令，/2/d关闭行删除

### 4 : 插入（i）和附加行(a)
该处着重介绍，在某一行前插入和某一行后附加，以及在末尾行append的命令。

```sh
  sed  '1i\abc' data.txt  # 在第一行前插入一行新的数据为abc
  sed  '1a\abc' data.txt  # 在第一行后append abc
  sed  '$a\abc' data.txt  # 在最后一行append abc 
```
### 5 : 修改行（c）

```sh
  sed '1c\acv' data.txt # 修改第一行为acv，其中范围修改可以参考以上插入和附加，替换的命令方式
```
### 6 : 转换命令（y）

y命令是唯一一个可以处理单个字符的命令。其主要命令格式如下：

```sh
[address]y/inchars/outchars/
```
inchars 和outchars会一一映射，如果长度不同，会产生一条错误信息。错误信息如下：

```console
  sed: -e expression #1, char 11: strings for `y' command are different lengths
```

### 7 ：sed练习题目

- [tenth line](https://leetcode.com/problems/tenth-line/)
- [Questions one](https://blog.csdn.net/y1412813204/article/details/86701837)
- [Questions two](https://www.centos.bz/2017/08/sed-12-exercise/)

## 高级篇
