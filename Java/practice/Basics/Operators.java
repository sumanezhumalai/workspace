public class Operators {
    public static void main(String[] args) {
        int a = 10, b = 3;

        // arithmetic: + - * / % ; int/int truncates
        System.out.println(a + b); // 13
        System.out.println(a / b); // 3
        System.out.println(a % b); // 1
        System.out.println(-a % b + " " + a % -b); // -1 1, sign follows left operand

        // unary: ++ -- + - ; prefix vs postfix
        int x = 5;
        System.out.println(x++); // 5, then x=6
        System.out.println(++x); // 7
        System.out.println(x-- + " " + --x); // 7 5

        // relational: == != < > <= >= ; strings use equals(), not ==
        System.out.println(a == b); // false

        // logical && || ! (short-circuit) vs bitwise & | (always evaluates)
        boolean t = true, g = false;
        System.out.println(t && g); // false
        System.out.println(t || g); // true
        // int k = 0; boolean r = g && (k++ > 0); // k stays 0, skipped
        // boolean r2 = g & (k++ > 0); // k becomes 1, evaluated

        // bitwise: & | ^ ~ << >> >>>
        System.out.println(5 & 3); // 1
        System.out.println(5 | 3); // 7
        System.out.println(5 ^ 3); // 6
        System.out.println(4 << 1); // 8
        System.out.println(4 >> 1); // 2
        System.out.println(-8 >>> 1); // big positive, fills 0

        // assignment shorthands: += -= *= /= %= &= |= <<= ...
        int n = 5;
        n += 3; // 8
        n <<= 1; // 16
        System.out.println(n);

        // ternary: cond ? v1 : v2
        System.out.println(a > b ? "big" : "small");

        // instanceof: null always false
        Object o = "hi";
        System.out.println(o instanceof String); // true
        System.out.println(null instanceof String); // false
    }
}
