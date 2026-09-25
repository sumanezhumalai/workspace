public class WrapperClasses {
    public static void main(String[] args) {
        // primitive <-> wrapper: Integer, Long, Double, Character, Boolean...
        Integer a = Integer.valueOf(5); // prefer over new Integer(5)
        int b = a.intValue();
        Integer c = b; // autoboxing
        int d = c; // unboxing
        System.out.println(a + " " + b + " " + c + " " + d);

        // parse vs valueOf: parse returns primitive, valueOf returns object
        int n = Integer.parseInt("123");
        Integer m = Integer.valueOf("123");
        System.out.println(n + " " + m);

        // == compares refs for objects! use equals()
        Integer x = 127, y = 127;
        Integer p = 128, q = 128;
        System.out.println(x == y); // true, Integer cache -128..127
        System.out.println(p == q); // false, different objects
        System.out.println(p.equals(q)); // true

        // unboxing null -> NullPointerException
        // Integer z = null; int w = z;

        // utilities
        System.out.println(Integer.MAX_VALUE + " " + Integer.min(3, 5));
        System.out.println(Character.isDigit('5') + " " + Character.isLetter('a'));
        System.out.println(Character.toUpperCase('a') + " " + Double.isNaN(0.0 / 0));
    }
}
