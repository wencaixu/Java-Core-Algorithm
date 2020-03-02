package java8.java8Turtorials.lambda;

import java8.java8Turtorials.lambda.inter.Predicate;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 文件注释
 * Description: <br/>
 * date: 2020/3/1 17:07<br/>
 *
 * @author wencaixu<br />
 * @since JDK 1.8
 */
public class LambdaFunction {

    @Data
    @AllArgsConstructor
    static
    class Apple {
        String color;
        Double weight;

        static boolean filterGreen(Apple apple) {
            return "green".equals(apple.color);
        }
    }

    static <T> Collection<T> filter(Collection<T> collection, Predicate<T> predicate) {
        Collection<T> result = new ArrayList<>();
        for (T apple : collection) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    //匿名参数
    static List<Apple> filterApples(List<Apple> apples, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //匿名参数
        List<Apple> apples = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                apples.add(new Apple("green", 1.8));
            } else {
                apples.add(new Apple("red", 1.8 + i));
            }
        }

        List<Apple> apples1 = filterApples(apples, Apple::filterGreen);
        for (Apple apple : apples1) {
            System.out.println(apple.getColor());
        }

        //lambda
        filterApples(apples, (e) -> "green".equals(e.getColor()));

        Collection<Apple> filter = filter(apples, (e) -> "green".equals(e.getColor()));

        filter.parallelStream().forEach(x -> {
            System.out.println(x.getColor() + " " + x.getWeight());
        });

        //  Predicate复合
        Apple appleGreen = new Apple("green", 101.0);
        java.util.function.Predicate<Apple> isRed = (apple) -> "green".equals(apple.getColor());
        java.util.function.Predicate<Apple> and = isRed.and(x -> x.getWeight() > 100);
        boolean test = isRed.test(appleGreen);
        boolean test1 = and.test(appleGreen);
        System.out.println(test + " " + test1);


    }
}
