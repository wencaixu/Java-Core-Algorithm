# Java 8 学习总结

## 4、函数式数据处理
### 4.4 流操作
#### 4.4.1 中间操作
|  操作  |  类型 |  返回类型 | 操作参数 | 函数描述符 |
|  ---- | ---- | ---- | ---- | ---- |
|  filter  | 中间操作 |  Stream<T> | Predicate<T> | T -> boolean |
|  map   |  中间操作 |  Stream<R>  | Function<T, R>  | T -> R  |
|  limit   |  中间操作 |  Stream<T> | 操作参数 |  |
|  sorted    |  中间操作 |  Stream<T> | Comparator<T> | (T, T) -> int  |
|  distinct    |  中间操作 |  Stream<T> | 操作参数 |  |
#### 4.4.2 终端操作
|  操作  |  类型 |  作用 |
|  ---- | ---- | ---- |
|  forEach  | 终端操作 |  消费遍历集合的每一个元素，消费过程中可以使用lambda表达式 |
|  collect  | 终端操作 |  将流式集合Stream<T> 转换成 List或Set等，如Collectors类的toList静态方法 |
|  count  | 终端操作 |  返回数量，数据类型为long类型 |

## 6、用流收集数据