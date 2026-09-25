public class StringBasics {
    public static void main(String[] args) {
        // literal (pool) vs new (heap) -> compare with equals(), not ==
        String a = "hi";
        String e = "hi";
        String f = new String("hi");
        System.out.println(a == e); // true, same pool ref
        System.out.println(a == f); // false
        System.out.println(a.equals(f)); // true
        System.out.println(a.equalsIgnoreCase("HI")); // true

        // immutable: concat returns new string
        String g = a.concat("!"); // or a + "!"
        System.out.println(a + " " + g);

        // core methods
        String s = "  Java Prog  ";
        System.out.println(s.length()); // 13
        System.out.println(s.charAt(2)); // 'J'
        System.out.println(s.trim().length()); // 9, strips ends only
        System.out.println(s.strip()); // unicode-aware trim
        System.out.println("java".toUpperCase() + " " + "JAVA".toLowerCase());

        // search: indexOf -1 if absent, contains, starts/endsWith
        String t = "hello";
        System.out.println(t.indexOf('l')); // 2
        System.out.println(t.lastIndexOf('l')); // 3
        System.out.println(t.contains("ell")); // true
        System.out.println(t.startsWith("he") + " " + t.endsWith("lo"));

        // extract/compare
        System.out.println(t.substring(1, 4)); // "ell", end exclusive
        System.out.println(t.subSequence(1, 4)); // same
        System.out.println("a".compareTo("b")); // negative, lexicographic
        System.out.println("abc".compareToIgnoreCase("ABC")); // 0

        // modify (all return new): replace, split, join
        System.out.println(t.replace('l', 'x')); // "hexxo"
        System.out.println("a,b,c".split(",").length); // 3, regex! "." needs "\\."
        System.out.println(String.join("-", "a", "b")); // "a-b"

        // convert: toCharArray, valueOf, format
        char[] ch = t.toCharArray();
        System.out.println(ch.length + " " + String.valueOf(123));
        System.out.println(String.format("%.2f", 3.14159)); // 3.14

        // empty vs blank vs null
        System.out.println("".isEmpty() + " " + "".isBlank()); // true true
        System.out.println("  ".isEmpty() + " " + "  ".isBlank()); // false true
        // String n = null; n.length(); // NullPointerException
    }
}
