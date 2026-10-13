package Enum;

import java.lang.reflect.Array;
import java.util.Arrays;

enum Laptop { // here Status is Class
    Macbook(3000), XPS(2500), Surface(2000), ThinkPad(2200); // All these are objects (constructor parmeters) of
                                                             // "Status" class
    // 0-----1-------2--------3

    private int price;
    final private String currency = "Dollar";

    private Laptop(int price) { // we are making it private coz we only use initiate enum objects within enum
                                // class
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

}

public class EnumOperations {
    public static void main(String[] args) {
        Laptop s = Laptop.Macbook;
        System.out.println(s.name());
        System.out.println(s.getClass().getSuperclass());

        Laptop[] arr = Laptop.values();
        for (Laptop laptop : arr) {
            System.out.printf("%-12s | %,8d | %s%n",
                    laptop.name(),
                    laptop.getPrice(),
                    laptop.getCurrency());
        }
    }
}
