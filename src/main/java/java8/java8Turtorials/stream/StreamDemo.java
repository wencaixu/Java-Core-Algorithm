package java8.java8Turtorials.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 流式编程Demo
 *
 * @author wencaixu
 * @since JDK 1.8
 */
public class StreamDemo {

    private static List<Transaction> transactions;

    @Data
    @AllArgsConstructor
    static
    class Trader {
        private String name;
        private String city;
    }

    @Data
    @AllArgsConstructor
    static
    class Transaction {
        private Trader trader;
        private int year;
        private int value;
    }

    private static void init() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }

    public static void main(String[] args) {
        init();

        //2011年所有交易清单，按照交易额排序（从高到低）
        transactions.stream().filter(x -> x.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue).reversed()).collect(Collectors.toList())
                .stream().forEach(x -> {
            System.out.println(x.getTrader().toString() + "\n" + x.getYear() + " " + x.getValue());
        });

        //交易员工作城市不同
        //方式一
        transactions.stream().map(Transaction::getTrader).map(Trader::getCity).distinct().collect(Collectors.toList())
            .forEach(System.out::println);
        //方式二
        transactions.stream().map(Transaction::getTrader).map(Trader::getCity).collect(Collectors.toSet())
                .forEach(System.out::println);

        //所有来自剑桥的交易员，按照名字排序
        transactions.stream().map(Transaction::getTrader).filter(x->"Cambridge".equals(x.getCity()))
                .sorted(Comparator.comparing(Trader::getName)).distinct()
                .collect(Collectors.toList()).forEach(x-> System.out.println(x.toString()));

        //返回所有交易员的名字，按字母顺序
        transactions.stream().map(Transaction::getTrader).map(Trader::getName)
                .sorted().distinct()
                .collect(Collectors.toList())
        .forEach(System.out::println);

        //筛选有没有在米兰工作的
        boolean isMilan = transactions.stream().anyMatch(x -> "Milan".equals(x.getTrader().getCity()));
        System.out.println(isMilan);

        //查询在剑桥工作用户的交易额
        int transactionValue = transactions.stream().filter(x -> "Cambridge".equals(x.getTrader().getCity()))
                .map(Transaction::getValue).reduce(0, Integer::sum);
        System.out.println(transactionValue);

        //在Cambridge交易最大值
        Optional<Integer> reduce = transactions.stream().filter(x -> "Cambridge".equals(x.getTrader().getCity())).map(Transaction::getValue).reduce(Integer::max);
        System.out.println(reduce.get());
    }


}
