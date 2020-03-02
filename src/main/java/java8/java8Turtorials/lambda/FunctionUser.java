package java8.java8Turtorials.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Function 函数接口
 *
 * @author wencaixu<br />
 * @since JDK 1.8
 */

@FunctionalInterface
interface Function<T,R>{
    R apply(T t);
}

public class FunctionUser {

    public static <T,R> List<R> map(List<T> list, Function<T,R> f){
        List<R> result = new ArrayList<>();
        for(T s : list){
            result.add(f.apply(s));
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = map(Arrays.asList("lambda","function"), String::length);

        list.forEach(System.out::println);

        //Function 复合
        java.util.function.Function<Integer,Integer> add = i->i+i;
        java.util.function.Function<Integer,Integer> mul = i->i*i;

        java.util.function.Function<Integer, Integer> integerIntegerFunction = add.andThen(mul);
        Integer apply = integerIntegerFunction.apply(1);
        System.out.println(apply);
    }
}
