package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * StreamIntro
 */
public class StreamIntro {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(3, 9, 6, 2, 7, 1, 8, 4);

        // Consumer<Integer> cons = (n) -> {
        // System.out.println(n);
        // };

        // nums.forEach(cons); // these
        // nums.forEach(n -> System.out.println(n)); // these 2 are same we just
        // skipping the consumer referencing and yet
        // passing its as new consumer object's function interface working
        // directly as Lambda expression (only works for accept() functions , no
        // returns)

        // returns a Stream object, (that is isolated from th original object - so
        // doesnt change the original object)
        // Stream<Integer> s1 = nums.stream(); // can not be reused , operations must be
        // done in one go .
        // // If did , will throw runtime error : Stream has laredy been used upon or
        // // closed

        // Stream<Integer> s2 = s1.filter(n -> n % 2 == 0);
        // Stream<Integer> s3 = s2.map(n -> n * 2);

        // // Stream object can also return a other types as values (by reducing)
        // int result = s3.reduce(0, (c, e) -> c + e); // prov

        // System.out.println(result);

        // Now the above multi Step can be written in Nested way , skipping object
        // storing ,instead working on it directly|

        nums.stream()
                .filter(n -> n % 2 == 1) // predicate
                .map(n -> n / 3)
                .forEach(n -> System.out.println(n)); // consumer
    }
}

/**
 * 💡 JAVA STREAMS & LAMBDA EXPRESSIONS CHEAT SHEET
 * 
 * Lambda expressions inside Java Streams are NOT always Consumer objects.
 * Java uses "Target Typing" to match a lambda to the specific functional
 * interface expected by the Stream method.
 * 
 * Below are the primary functional interfaces used across Java Streams:
 * 
 * 1. Predicate<T> -> test(T) -> Takes 1 input, returns boolean.
 * Used in: .filter(), .anyMatch(), .allMatch(), .noneMatch()
 * Example: .filter(s -> s.isEmpty())
 * 
 * 2. Function<T, R> -> apply(T) -> Takes 1 input, returns 1 transformed output.
 * Used in: .map(), .flatMap()
 * Example: .map(s -> s.length())
 * 
 * 3. Consumer<T> -> accept(T) -> Takes 1 input, returns void (performs action).
 * Used in: .forEach(), .peek()
 * Example: .forEach(s -> System.out.println(s))
 * 
 * 4. Supplier<T> -> get() -> Takes no input, returns a new object.
 * Used in: .collect(Collectors.toCollection(ArrayList::new))
 * Example: () -> new ArrayList<>()
 * 
 * 5. BiFunction<T,U,R> -> apply(T,U) -> Takes 2 inputs (diff types), returns 1
 * output.
 * Used in: .reduce(identity, accumulator, combiner)
 * 
 * 6. BinaryOperator<T> -> apply(T,T) -> Takes 2 inputs (same type), returns 1
 * output (same type).
 * Used in: .reduce()
 * Example: .reduce(0, (a, b) -> a + b)
 * 
 * 7. Comparator<T> -> compare(T,T)-> Takes 2 inputs, returns an int (-/0/+).
 * Used in: .sorted(), .max(), .min()
 * Example: .sorted((a, b) -> a.compareTo(b))
 */
