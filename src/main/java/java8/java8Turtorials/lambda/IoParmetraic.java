package java8.java8Turtorials.lambda;

import java8.java8Turtorials.lambda.inter.BufferReaderProcessor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * 行为参数化 - 总结
 *
 * @author wencaixu<br />
 * @since JDK 1.8
 */
public class IoParmetraic {

    private static final String FILE_NAME = "";

    private static String processFile(BufferReaderProcessor processor) {
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
           return processor.process(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(processFile((BufferedReader::readLine)));
    }
}
