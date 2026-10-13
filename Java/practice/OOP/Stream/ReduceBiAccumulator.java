package Stream;

import java.util.Arrays;
import java.util.List;

public class ReduceBiAccumulator {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(3, 9, 6, 2, 7, 1, 8, 4);

        int result = nums.stream()
                .filter(n -> n % 2 == 0) // Predicate interface: keeps only even numbers [6, 2, 8, 4]
                .map(n -> n / 3) // Function interface: divides each by 3 [2, 0, 2, 1]
                .reduce(0, (c, e) -> c + e); // BinaryOperator (Indentity, Accumulator)

        /*
         * INTERFACE USED:
         * This overload of reduce(identity, accumulator) uses the BinaryOperator<T>
         * interface
         * (specifically BinaryOperator<Integer> in this context).
         * BinaryOperator<T> extends BiFunction<T, T, T>, representing an operation upon
         * two operands
         * of the same type, producing a result of the same type.
         *
         * LAMBDA FUNCTION EXPLANATION: (c, e) -> c + e
         * - 'c' (accumulator/carrier): Holds the cumulative result after processing
         * previous elements.
         * It starts with the identity value (0).
         * - 'e' (element): Represents the current element coming from the stream
         * pipeline.
         * - 'c + e': Returns the sum of the accumulator and the current element, which
         * becomes
         * the new value of 'c' for the next element.
         *
         * STEP-BY-STEP EXECUTION TRACE:
         * Stream elements reaching reduce: [2, 0, 2, 1]
         * Initial accumulator (identity) = 0
         * 
         * 1st element (2): c = 0, e = 2 -> returns 0 + 2 = 2 (new accumulator)
         * 2nd element (0): c = 2, e = 0 -> returns 2 + 0 = 2 (new accumulator)
         * 3rd element (2): c = 2, e = 2 -> returns 2 + 2 = 4 (new accumulator)
         * 4th element (1): c = 4, e = 1 -> returns 4 + 1 = 5 (final result)
         *
         * Result value: 5
         */

        System.out.println(result); // Outputs: 5
    }
}