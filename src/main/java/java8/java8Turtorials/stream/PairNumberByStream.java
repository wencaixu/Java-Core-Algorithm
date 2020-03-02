package java8.java8Turtorials.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 生成数对
 * Array 1 ->[1,2]
 * Array 2 ->[3,4]
 * <p>
 * Result -> [[1,3],[1,4],[2,3],[2,4]]
 *
 * @author wencaixu
 * @since JDK 1.8
 */
public class PairNumberByStream {


    public static void main(String[] args) {
        List<Integer> arr1 = Arrays.asList(1, 2);
        List<Integer> arr2 = Arrays.asList(3, 4);

        arr1.stream().map(i -> arr2.stream().map(j -> new int[]{i, j}))
                .collect(Collectors.toList()).forEach(x -> {
            x.filter(k -> (k[0] + k[1]) % 3 == 0).collect(Collectors.toList()).forEach(y -> {
                System.out.println("[" + y[0] + " " + y[1] + "]");
            });
        });

    }


}
