package java8.java8Turtorials.lambda.inter;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * 文件注释
 * Description: <br/>
 * date: 2020/3/1 20:14<br/>
 *
 * @author wencaixu<br />
 * @since JDK 1.8
 */
@FunctionalInterface
public interface BufferReaderProcessor {
    String process(BufferedReader br) throws IOException;
}
