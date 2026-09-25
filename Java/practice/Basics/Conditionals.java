public class Conditionals {
    public static void main(String[] args) {
        int n = 15;

        // if-else
        if (n > 0) System.out.println("pos");
        else System.out.println("non-pos");

        // ladder: first true wins, order matters
        if (n > 100) System.out.println("big");
        else if (n > 10) System.out.println("mid");
        else if (n > 0) System.out.println("small");
        else System.out.println("neg");

        // nested
        if (n % 2 == 0) {
            if (n % 3 == 0) System.out.println("div 6");
            else System.out.println("even only");
        } else System.out.println("odd");

        // ternary + nested ternary (avoid deep nesting)
        String s = n > 0 ? "pos" : (n == 0 ? "zero" : "neg");
        System.out.println(s);

        // dangling else binds to nearest if -> always use {}
        int x = 5, y = 5;
        if (x == y)
            if (x > 0) System.out.println("eq pos");
            else System.out.println("eq non-pos"); // belongs to inner if
    }
}
