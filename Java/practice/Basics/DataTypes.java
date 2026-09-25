public class DataTypes {
    public static void main(String[] args) {
        // type | size | range | default
        System.out.printf("%-8s %-6s %-24s %s%n", "Type", "Size", "Range", "Default");
        System.out.printf("%-8s %-6s %-24s %s%n", "byte", "1B", Byte.MIN_VALUE + " to " + Byte.MAX_VALUE, "(byte)0");
        System.out.printf("%-8s %-6s %-24s %s%n", "short", "2B", Short.MIN_VALUE + " to " + Short.MAX_VALUE, "(short)0");
        System.out.printf("%-8s %-6s %-24s %s%n", "int", "4B", Integer.MIN_VALUE + " to " + Integer.MAX_VALUE, "0");
        System.out.printf("%-8s %-6s %-24s %s%n", "long", "8B", Long.MIN_VALUE + " to " + Long.MAX_VALUE, "0L");
        System.out.printf("%-8s %-6s %-24s %s%n", "float", "4B", "~1.4e-45 to 3.4e38", "0.0f");
        System.out.printf("%-8s %-6s %-24s %s%n", "double", "8B", "~4.9e-324 to 1.8e308", "0.0");
        System.out.printf("%-8s %-6s %-24s %s%n", "char", "2B", (int) Character.MIN_VALUE + " to " + (int) Character.MAX_VALUE, "'\\u0000'");
        System.out.printf("%-8s %-6s %-24s %s%n", "boolean", "1bit*", "true/false", "false");

        // literals: L for long, F for float, '' char vs "" String
        long l = 100L;
        float f = 2.5F;
        char c = 'A';
        char uni = '\u0041'; // same as 'A'
        int bin = 0b101, oct = 010, hex = 0xA; // 5, 8, 10
        double sci = 1.5e3; // 1500.0
        var inferred = 42; // int, needs initializer, local only

        System.out.println(l + " " + f + " " + c + uni + " " + bin + oct + hex + " " + sci + " " + inferred);

        // non-primitive: default null, holds reference not value
        String s = null;
        int[] arr = null;
        System.out.println(s + " " + arr);
        String s2 = "hi"; // literal, prefer over new String("hi")
        System.out.println(s2.length());
    }
}
