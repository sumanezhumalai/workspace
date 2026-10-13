package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FilterPredicate {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(3, 9, 6, 2, 7, 1, 8, 4);

        // Predicate<Integer> p = new Predicate<Integer>() {
        // @Override
        // public boolean test(Integer n) {
        // if (n % 2 == 0)
        // return true;
        // else
        // return false;
        // }
        // };

        Predicate<Integer> p = (n) -> n % 2 == 0;

        nums.stream()
                .filter(p) // predicate interface
                .map(n -> n * 2) // Function interface
                .forEach(n -> System.out.println(n)); // consumer interface
    }
}
