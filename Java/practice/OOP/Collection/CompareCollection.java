package Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person implements Comparable<Person> {
    int age;
    String Name;

    @Override
    public String toString() {
        return "Person [age=" + age + ", Name=" + Name + "]";
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Person(int age, String name) {
        this.age = age;
        Name = name;
    }

    @Override // comparable is to define the default comparative property at Class
    public int compareTo(Person that) {
        // TODO Auto-generated method stub
        // if (this.getName() > that.getName()){ //cannot comare Strings with
        // compareTo()
        // return 1;
        // } else if (this.getName() < that.getName()){
        // return -1;
        // } else {
        // return 0;
        // }
        return this.getName().compareTo(that.getName());
    }
}

public class CompareCollection {
    public static void main(String[] args) {
        // Comparator<Integer> com = new Comparator<Integer>() {
        // public int compare(Integer a, Integer b) {
        // if (a % 10 > b % 10) {
        // return 1;
        // } else {
        // return -1;
        // }
        // }
        // };
        // List<Integer> list = new ArrayList<>();
        // list.add(62);
        // list.add(21);
        // list.add(83);
        // list.add(52);

        Comparator<Person> com = (p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()); // Comparator is to define
                                                                                        // custom comparative property
                                                                                        // as per the needed at an
                                                                                        // instance

        List<Person> list = new ArrayList<>();
        list.add(new Person(18, "Suman"));
        list.add(new Person(21, "Soham"));
        list.add(new Person(34, "Pritvik"));
        list.add(new Person(24, "Karthik"));

        Collections.sort(list, com); //comparator
        // Collections.sort(list); // comparable

        System.out.println(list);
    }
}
