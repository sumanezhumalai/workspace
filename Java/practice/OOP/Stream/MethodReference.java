package Stream;

import java.util.Arrays;
import java.util.List;

public class MethodReference {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Suman", "Sakthi", "Sham", "Sundar", "Pritham");

        // List<String> uName = names.stream()
        // .map(name -> name.toUpperCase())
        // .toList();

        // shorter from
        List<String> uNames = names.stream()
                .map(String::toUpperCase) // Use method reference operator, when you only need to call a method
                .toList();

        uNames.forEach(System.out::println);

        // System.out.println(uNames);
    }
}
