package Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Sorted {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(3, 9, 6, 2, 7, 1, 8, 4);

        nums.stream()
                .filter(n -> n % 2 == 0) // Predicate interface
                .sorted() // Comparator interface (uses natural order, Comparable<T>)
                .forEach(n -> System.out.println(n)); // Consumer interface


        // For descending sort
        // nums.stream()
        //         .filter(n -> n % 2 == 0) // Predicate interface
        //         .sorted(Comparator.reverseOrder()) // Uses Comparator interface for descending order
        //         .forEach(n -> System.out.println(n)); // Consumer interface

        /*
         * INTERFACE USED:
         * - sorted() with no arguments uses natural ordering. It requires the stream
         * elements
         * to implement the Comparable<T> interface (Integer implements
         * Comparable<Integer>).
         * - If you pass a custom order like .sorted((a, b) -> b.compareTo(a)), it uses
         * the Comparator<T> functional interface (specifically its int compare(T o1, T
         * o2) method).
         *
         * HOW sorted() WORKS:
         * 1. Stateful & Intermediate Operation:
         * Unlike filter() or map() which process elements one by one (lazily), sorted()
         * must collect ALL stream elements into an internal buffer before it can sort
         * them.
         * 2. Natural Sorting:
         * It orders elements from lowest to highest using their default compareTo()
         * logic
         * (for Integers: 2, 4, 6, 8).
         * 3. Downstream Processing:
         * Once sorted, it emits elements one by one to the next stage in the pipeline
         * (forEach).
         *
         * STREAM STEP-BY-STEP TRACE:
         * Source: [3, 9, 6, 2, 7, 1, 8, 4]
         * Filter: [6, 2, 8, 4] (keeps only even numbers)
         * Sorted: [2, 4, 6, 8] (arranges in natural ascending order)
         * Output: 2
         * 4
         * 6
         * 8
         */
    }
}