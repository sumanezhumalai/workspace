public class TypeConversion {
    public static void main(String[] args) {
        // widening (implicit): byte->short->int->long->float->double
        int i = 100;
        long l = i;
        float f = l;
        double d = f;
        System.out.println(l + " " + f + " " + d);

        // narrowing (explicit cast), may lose data
        double dd = 9.99;
        int ii = (int) dd; // 9, fraction dropped
        byte b = (byte) 130; // -126, overflow wraps
        System.out.println(ii + " " + b);

        // char <-> int (ASCII/Unicode)
        char c = 'A';
        int code = c; // 65
        char back = (char) (code + 1); // 'B'
        System.out.println(code + " " + back);

        // promotion: byte/short/char -> int in expressions
        byte x = 10, y = 20;
        // byte z = x + y; // error: result is int
        int z = x + y;
        System.out.println(z);

        // int division vs double division
        System.out.println(5 / 2); // 2, not 2.5
        System.out.println(5 / 2.0); // 2.5, int promoted

        // String -> primitive (parse), primitive -> String
        int n = Integer.parseInt("123");
        double m = Double.parseDouble("3.14");
        // Integer.parseInt("abc"); // NumberFormatException
        String s1 = String.valueOf(n);
        String s2 = Integer.toString(n);
        String s3 = "" + n + m; // quick concat hack
        System.out.println(n + " " + m + " " + s1 + " " + s2 + " " + s3);

        // widening then narrowing round-trip
        long big = 3_000_000_000L; // _ separator, exceeds int
        int cut = (int) big; // garbage, no error
        System.out.println(big + " " + cut);
    }
}
