package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ForEachConsumer {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(3, 9, 6, 2, 7, 1, 8, 4);

        Consumer<Integer> c = new Consumer<Integer>() {
            @Override
            public void accept(Integer n) {
                System.out.println(n);
            }
        };

        nums.stream()
                .filter(n -> n % 2 == 0) // predicate interface
                .map(n -> n / 3)
                .forEach(c); // consumer interface
    }
}
