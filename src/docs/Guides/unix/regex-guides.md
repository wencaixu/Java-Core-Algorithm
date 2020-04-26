# Linux正则表达式学习总结
### 基础知识
####  BRE模式
 1.  纯文本匹配
   从日志文件中查询Spring Boot启动端口，假设日志文件为nohup.log，可以使用一下命令进行匹配。
```powershell
   sed -n '/port(s)/p' nohup.out
```
```powershell
   cat nohup.out | grep "port(s)"  # 此时输出的结果会标红,建议使用此方式
```
 2.  特殊字符 
      Linux正则表达式中主要的核心特殊字符为：`.*[]^${}\+?|()`，当需要匹配的字符串中包括这些字符需要对字符进行转义。
```powershell
	echo "hello\fhdkajf" | grep '\\'
```
```powershell
    echo "hello\fhdkajf"  | sed -n '/\\/p' # 此处sed可以修改为awk命令
```
 3.  锚字符
    正则表达式的锚点主要包括`^`和`$`两个字符，`$`可以匹配字符出现在行尾，`^`匹配字符出现在行首。
```powershell
    echo "hello\fhdkajf" | grep "^hello"  # 可以匹配出
    echo "hello\fhdkajf" | grep "^hello$" # 匹配行数据为hello的行，返回空
```
 4.  点号字符
   `.`点号字符标识一个除换行符以外的任意一个字符。`.`点号位置必须包含一个字符，如果不占一个字符则直接返回空，匹配不上
```powershell
 	echo "hello\fhdkajf" | grep "^h.llo"
    ## 打印 hello\fhdkajf
    echo "heello\fhdkajf" | grep "^h.llo"  # 输出为空
    echo "hllo\fhdkajf"   | grep "^h.llo"  # 输出为空
```
 5.  字符组
    `[]`字符组是限定每一位置的字符是在字符组内的字符,使用中括号表示其中的值，举例如下：
```powershell
   echo "hallo\fhdkajf" | grep "^h[ae]llo"  # 此时只能匹配一个字符
```
 6.  字符组排除(`^`)
```powershell
  echo "hallo\fhdkajf" | grep "^h[^ae]llo" # 排除第二个字符为a和e
  echo "hqllo\fhdkajf" | grep "^h[^ae]llo" # 输出 hqllo\fhdkajf
```
 7.  区间(`[?-?]`) 闭区间
```powershell
   echo "hqllo\fhdkajf" | grep "^[h-q]qllo" # hqllo\fhdkajf
   echo "qllo\fhdkajf" | grep "^[h-q]llo"   # qllo\fhdkajf
```
 8.  特殊字符组
     Regex正则表达式中包括一些特殊的字符组简写，可以描述部分字符组，如下列举了所有的特殊的字符组：
     
| 字符组 | 描述 |
|--|--|
| [[:alpha:]] | 匹配任意字母字符，包括A-Z和a-z |
| [[:alnum:]] | 匹配任意字母字符和数字，包括A-Z和a-z和0-9 |
| [[:blank:]] | 匹配空格和制表符 |
| [[:space:]]  | 匹配任意空白字符：空格、制表符、NL、FF、VT和CR |
| [[:upper:]] | 匹配任意大写字母，A-Z |
| [[:lower:]] | 匹配任意小写字母，a-z |
| [[:digit:]] | 匹配任意数字，0-9 |
| [[:print:]] | 匹配任意可打印字符 |
| [[:punct:]] |匹配标点符号 |

 9.  星号  
 字符后面放置星号表明该字符必须在匹配模式的文本中出现0次或多次
```powershell
     echo "qllo\fhdkajf" | grep "^ql*"  # qllo\fhdkajf # l出现了0次或多次
```
#### 扩展正则表达式 
 1.  问号`?`
    字符可以出现0次或1次。
```powershell
	echo "bet" | awk -n '/be?t/p'
```
 2.  加号`+`
    字符出现至少1次。
```powershell
    echo "bet" | awk -n '/be+t/p'
```
 3.  花括号(设定上下限)`{n,m}`
     默认情况下，gawk程序不会识别正则表达式间隔。必须指定gawk程序的--re- interval命令行选项才能识别正则表达式间隔。
```powershell
   echo "beet" | gawk --re-interval '/be{1,2}t/{print $0}' # beet
   echo "bet"  | awk  --re-interval -n '/be{3,4}t/{print $0}' # 空
   echo "bet" | awk --re-interval -n '/be{0,3}t/'  # bet
   echo "bet" | awk --re-interval -n '/be{2,3}t/'  # 空
```
 4.  管道符号(`|` 或的关系)
```powershell
    echo "The cat is asleep" | gawk '/cat|dog/{print $0}'
```
 5.  表达式分组()
```powershell
    echo "He has a hat." | gawk '/[ch]at|dog/{print $0}'
```
### `* .  ? +之间的比较总结`
|字符| 意义 | 条件类型 |
|--|--| -- |
| `*` |  匹配行中的字符出现0次或多次  |  字符出现0次或n次  |  必要条件   |
| `.` |  匹配除换行符意外的任意一个字符，有且仅有一个  |  充分必要条件 |
| `?` | 匹配字符串出现0次或一次  |  必要条件  |
| `+` | 匹配字符至少出现一次  |  充分必要条件  |

### 正则表达式实战（自己可以试试看呦，不要眼高手低）
 - 目录可执行文件计数
 - 验证电话号码格式
 - 解析邮件地址
### 小结
注意事项：

 - gawk程序可以使用大多数扩展正则表达式模式符号，并且能提供一些额外过滤功能，而这些功能都是sed编辑器所不具备的。但正因为如此，gawk程序在处理数据流时通常才比较慢.同时grep也不支持
 - 正则表达式是区分大小写的

《未完待续》
