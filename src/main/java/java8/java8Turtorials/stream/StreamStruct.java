package java8.java8Turtorials.stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 构建流
 *
 * @author wencaixu<br />
 * @since JDK 1.8
 */
public class StreamStruct {

    public static void main(String[] args) {
        //由值构建流
        Stream<String> stream = Stream.of("Stream","Lambda");
        stream.map(String::toUpperCase).forEach(System.out::println);

        //由数组生成流
        int[] number = {1,2,3};
        int sum = Arrays.stream(number).sum();

        //由文件生成流
        long uniqueWords = 0;
        try(Stream<String> lines = Files.lines(Paths.get(""), Charset.defaultCharset())){
            uniqueWords = lines.flatMap(line->Arrays.stream(line.split(" ")))
                    .distinct().count();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //从函数生成流
        Stream.iterate(0,n->n+2).limit(10).forEach(System.out::println);

        Stream.generate(Math::random).forEach(System.out::println);

    }
}
