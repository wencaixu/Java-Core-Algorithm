package java8.java8Turtorials.collection;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * Java 8 排序 - 内含有一道面试题
 *
 * @author wencaixu<br />
 * @since JDK 1.8
 */
public class Java8CollectionSorts {

    @Data
    @AllArgsConstructor
    static
    class Node {
        String name;
        Integer weight;
    }

    /**
     * 筛选身高>平均身高 - 面试题
     */
    @Data
    @AllArgsConstructor
    static class User {
        String name;
        Double hight;
        Double salary;
    }

    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            nodes.add(new Node("nodes" + i + "th", i + new Random().nextInt()));
            users.add(new User("wencaixu1", new Random().nextDouble() + 1,10000+8000.0 + new Random().nextDouble()));
        }
        Collections.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.getWeight().compareTo(o1.getWeight());
            }
        });

        //默认从小到大排序
        nodes.sort(Comparator.comparing(Node::getWeight).reversed());

        nodes.forEach((x) -> {
            System.out.println(x.getName() + " " + x.getWeight());
        });

        Double subHeight = users.stream().map(User::getHight).reduce(0.0, Double::sum);

        double avg = subHeight / users.size();
        Long startTime = System.currentTimeMillis();
        List<User> sorted = users.parallelStream()
                .filter(x -> x.getHight() > avg).sorted(Comparator.comparing(User::getHight))
                .collect(Collectors.toList());
        Long endTime = System.currentTimeMillis();
        System.out.println("时间" + (endTime - startTime));

        //通过多个字段进行排序，类似于SQL的Order By
        List<User> sortedByHeightAndSalary = users.stream().filter(x->x.getHight() > avg)
                .sorted(Comparator.comparing(User::getHight)
                .thenComparing(User::getSalary).reversed())
                .collect(Collectors.toList());
        sortedByHeightAndSalary.forEach(x -> System.out.println(">平均身高" + x.getHight() + " " + x.getName() +" "+ x.getSalary()));


        //reduce 规约求最大值
        Optional<Double> reduce = users.stream().map(User::getHight).reduce(Double::max);
        reduce.ifPresent(System.out::println);
    }

}
