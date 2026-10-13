package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class ConstructorReference {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Suman", "Sakthi", "Sham", "Sundar", "Pritham");

        List<Person> people = new ArrayList<>();

        // for (String name : names) {
        // people.add(new Person(name));
        // }

        people = names.stream()
                // .map(n -> new Person(n)) // classic way
                .map(Person::new) // use Constructor reference whenever we need to create a stream of objects from a
                                  // collections , Modern way
                .toList();

        System.out.println(people);
    }
}
