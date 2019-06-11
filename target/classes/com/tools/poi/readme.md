## POI

### 1. 添加Maven依赖
```xml
    <dependency>
      <groupId>org.apache.poi</groupId>
      <artifactId>poi</artifactId>
      <version>${poi.version}</version>
    </dependency>

    <dependency>
      <groupId>org.apache.poi</groupId>
      <artifactId>poi-ooxml</artifactId>
      <version>${poi.version}</version>
    </dependency>
```

### 2. 程序实现伪代码
```java
    获取test中的工作目录
    创建 newSheet存储结果
    按行读取workSheet中的数据Row
    {
        如果item列 value 不在噪声数据集合{
            创建新行,行内单元格
            写入到newSheet中
        }
    }
    将数据通过FileOutputStream写入到test2文件中
```
