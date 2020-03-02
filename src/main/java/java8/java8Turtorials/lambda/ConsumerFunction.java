package java8.java8Turtorials.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件注释
 * Description: <br/>
 * date: 2020/3/1 21:30<br/>
 *
 * @author wencaixu<br />
 * @since JDK 1.8
 */
public class ConsumerFunction {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10;i++){
            list.add(i);
        }

        //Consumer是一个函数
        list.forEach(System.out::println);
    }
}
