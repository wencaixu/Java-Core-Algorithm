package java8.java8Turtorials.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Java8 流式处理  用户身高面试题
 * @author wencaixu
 * @since JDK 1.8
 */
public class Java8Stream {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Stream{
        String dollar;
        double money;
    }

    public static void main(String[] args) {
        List<Stream> streamList = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            if(i % 2 == 0){
                streamList.add(new Stream("dollar",100 + new Random().nextDouble()));
            }else{
                streamList.add(new Stream("rmb",100 + new Random().nextDouble()));
            }
        }

        Map<String, List<Stream>> collect = streamList.stream().filter((x -> x.getMoney() >= 100)).collect(Collectors.groupingBy(Stream::getDollar));

        for(String key:collect.keySet()){
            System.out.println(key);
            collect.get(key).forEach(x->{
                System.out.println(x.getDollar()+" "+ x.getMoney());
            });
        }


        List<String> mapList = streamList.stream().filter(x->x.getMoney() > 100)
                .distinct()
                .sorted(Comparator.comparing(Stream::getDollar).reversed()).map(Stream::getDollar)
            .collect(Collectors.toList());

        mapList.forEach(System.out::println);
    }
}
