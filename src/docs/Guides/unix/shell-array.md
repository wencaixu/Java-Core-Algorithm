# Shell数组

Shell只支持一维数组，不支持多维数组。其数组内元素个数可以为任意多个，类似于Java,C++等高级语言，Shell数组的下标必须大于等于0。并且Shell是一种弱类型语言，数组内可以是任意类型数据。

##### 创建Shell数组

Shell数组是使用（）进行定义，（）内元素使用空格进行分割。同时创建的数组长度不是固定不变的可以任意扩展。初始化举例如下：

```shell
arr=(1 2 3 4 5)   		 # 标准的shell数组定义
arr=(1 3 4 'abc') 		 # 数字，字符串组合,第三个元素是异类
arr=([1]=1 [2]=5 [3]=7)  # 对arr的第1，2，3位置赋值
arr[7]=4 				 #对数组进行扩展
```

说明：arr和等号之间以及等号与（）之间不能有空格。

##### 数组元素的获取

Shell数据的元素的获取某一索引位置的值，使用[]方式获取，其格式如下：

```shell
${array_name[index]} # 其中array_name是数组名称，index是元素索引
```

可以直接对shell数组的所有元素进行输出，@和* 是输出数组中所有元素。其格式如下：

```shell
${array_name[*|@]}    # 输出所有元素
```

##### 数组长度获取

shell数组长度的获取可以使用*和@符号将数组变成列表，然后使用#获取数组的长度。其格式如下：

```shell
${#array_name[@]}     # 输出数组长度
${#array_name[0]}     # 如果第0个元素部位空且为字符串的时候，显示字符串长度
```

##### 删除数组元素

```shell
unset nums[1]         # 删除第一个位置的元素
```

##### 数组的拼接

数组的拼接思路是将数组转换成列表，然后对列表进行数组操作，其命令如下：

```shell
new_array=(${array_name[@]},${array[@]})   # 数组拼接
```

##### 关联数组

关联数组的特点是可以将任何类型的文本数据作为数组的索引，但是在使用之前必须使用declare -A array进行声明，类似与Java中的map映射。操作如下：

```shell
declare	-A new_array   # 声明数组
# 添加值的方式
new_array=(["hello"]=1 ["hi"]=2)  # 方式1
new_array["hello"]=1   			  # 方式2
# 输出索引
echo ${!new_array[*]}             # 输出索引值
echo ${!new_array[@]}             # 输出索引值
```

##### 练习

冒泡排序，其代码和相关注释如下：

```shell
sorted=(1 3 2 4)  # 定义被排序数组
len=${#sorted[@]} # 定义数组长度
for((i=0;i<len-1;i++)){
  for((j=i+1;j<len-1;j++)){
     if [ ${sorted[$i]} -gt ${sorted[$j]} ]
     then
        # 交换位置
        vt=${sorted[$j]}
        vi=${sorted[$i]}
        sorted[$j]=$vi
        sorted[$i]=$vt
     fi
  }  
}
```

插入排序，其代码和相关注释如下：

```shell
sorted=(1 3 2 4)    # 定义被排序数组
len=${#sorted[@]}   # 计算数组长度

for((i=1;i<$len-1;i++)){
   # 设置哨兵
   if [ ${sorted[$i]} -lt ${sorted[$i-1]} ]
   then
      garud=${sorted[$i]}
      for((j=$i;j>=0;j--)){
         if [[ $j -gt 0 ]] && [[ ${sorted[$j-1]} -gt $garud ]]
         then
           sorted[$j]=${sorted[$j-1]}
         else
           sorted[$j]=$garud
           break
         fi
      }
   fi
}
echo ${sorted[@]}
```

