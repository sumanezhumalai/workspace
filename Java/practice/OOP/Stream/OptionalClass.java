package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalClass {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Suman", "Sakthi", "Sham", "Sundar", "Pritham");

        // String name = names.stream()
        //         .filter(str -> str.contains("x"))
        //         .findFirst()
        //         .orElse("Not Found");

        Optional<String> name = names.stream() //auto handles nullpointer Exception
                        .filter(str -> str.contains("u"))
                        .findFirst();

        // System.out.println(name);
        // System.out.println(name.get());
        System.out.println(name.orElse("Not Found"));
    }
}
