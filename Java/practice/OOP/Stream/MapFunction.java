package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class MapFunction {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(3, 9, 6, 2, 7, 1, 8, 4);

        Function<Integer, Integer> f = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer n) {
                return n * 2;
            }
        };

        // Function<Integer,Integer> f = (n) -> n % 2 == 0;

        nums.stream()
                .filter(n -> n % 2 == 0) // predicate interface
                .map(f) // function interface
                .forEach(n -> System.out.println(n)); // consumer interface
    }
}
