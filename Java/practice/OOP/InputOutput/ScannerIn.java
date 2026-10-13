package InputOutput;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ScannerIn {

    // BEST PRACTICES:
    // - One Scanner per System.in, reuse it (don't create many).
    // - try-with-resources for files/strings; avoid closing System.in Scanner early.
    // - Prefer hasNextX() check before nextX() to avoid InputMismatchException.
    // - After nextInt()/nextDouble(), call nextLine() once to consume leftover newline.
    // - Set locale for decimals (nextDouble expects '.' in US locale).
    // - Use nextLine() + parse (Integer.parseInt) for robust line-based input.

    public static void main(String[] args) {
        basicTokens();
        lineVsToken();
        allNextTypes();
        validationLoop();
        newlineTrapFix();
        delimiterRadixLocale();
        charAndLineParsing();
        findSkipMatch();
        exceptionHandling();
        // interactiveDemo(); // uncomment for real keyboard input
    }

    // next(), nextInt(), hasNext() basics
    static void basicTokens() {
        Scanner sc = new Scanner("hello world 123"); // scan from String, no keyboard wait
        System.out.println(sc.next()); // hello (token split on whitespace)
        System.out.println(sc.next()); // world
        System.out.println(sc.nextInt()); // 123
        System.out.println(sc.hasNext()); // false (nothing left)
        sc.close(); // always close non-System.in scanners
    }

    // next() = one token, nextLine() = whole line
    static void lineVsToken() {
        Scanner sc = new Scanner("hello world\nsecond line");
        System.out.println(sc.next()); // hello (stops at space)
        System.out.println(sc.nextLine()); // " world" (rest of line incl. leading space)
        System.out.println(sc.nextLine()); // second line
        System.out.println(sc.hasNextLine()); // false
        sc.close();
    }

    // All common nextX() / hasNextX() types
    static void allNextTypes() {
        String data = "127 32000 100000 3.14 2.71828 true 42 9999999999999999999999 12.345678901234567890";
        Scanner sc = new Scanner(data);
        sc.useLocale(Locale.US); // ensure '.' decimal

        byte b = sc.nextByte(); // -128..127
        short s = sc.nextShort(); // -32768..32767
        int i = sc.nextInt(); // 32-bit int
        float f = sc.nextFloat(); // 32-bit decimal
        double d = sc.nextDouble(); // 64-bit decimal
        boolean bool = sc.nextBoolean(); // true/false (case-insensitive)
        long l = sc.nextLong(); // 64-bit int
        BigInteger bi = sc.nextBigInteger(); // arbitrary-size int
        BigDecimal bd = sc.nextBigDecimal(); // arbitrary-precision decimal

        System.out.println(b + " " + s + " " + i + " " + f + " " + d + " " + bool + " " + l);
        System.out.println(bi + " | " + bd);
        sc.close();
    }

    // Safe int input: validate before reading
    static void validationLoop() {
        Scanner sc = new Scanner("abc 12.5 42"); // simulate bad then good input
        int n = 0;
        while (!sc.hasNextInt()) { // peek without consuming
            System.out.println("skip invalid: " + sc.next()); // consume bad token
        }
        n = sc.nextInt(); // 42, safe now
        System.out.println("valid int: " + n);
        sc.close();
    }

    // SPECIAL CASE: nextInt() leaves '\n', nextLine() reads it as empty
    static void newlineTrapFix() {
        Scanner sc = new Scanner("25\nJohn Doe\n");
        int age = sc.nextInt(); // reads 25, leaves '\n'
        sc.nextLine(); // consume leftover newline (FIX)
        String name = sc.nextLine(); // John Doe
        System.out.println(age + " " + name);
        sc.close();
    }

    // Custom delimiter, radix (base), locale decimals
    static void delimiterRadixLocale() {
        Scanner sc = new Scanner("apple,banana;cherry 1A");
        sc.useDelimiter("[,;\\s]+"); // split on comma/semicolon/space
        System.out.println(sc.next()); // apple
        System.out.println(sc.next()); // banana
        System.out.println(sc.next()); // cherry
        System.out.println(sc.nextInt(16)); // 26 (hex 1A, radix 16)
        sc.reset(); // restore default whitespace delimiter
        sc.close();

        Scanner sc2 = new Scanner("3,14"); // comma decimal (many EU locales)
        sc2.useLocale(Locale.FRANCE);
        System.out.println(sc2.nextDouble()); // 3.14
        sc2.close();
    }

    // Read char, parse line safely, read all input at once
    static void charAndLineParsing() {
        Scanner sc = new Scanner("Z\n100\n");
        char c = sc.nextLine().charAt(0); // whole line -> no leftover '\n'
        int n = Integer.parseInt(sc.nextLine().trim()); // safe line parse
        System.out.println(c + " " + n);
        sc.close();

        Scanner sc2 = new Scanner("a b c");
        String all = sc2.nextLine(); // whole remaining input
        System.out.println("all: " + all);
        sc2.close();
    }

    // skip(), findInLine(), match(), delimiter(), radix(), locale(), ioException()
    static void findSkipMatch() {
        Scanner sc = new Scanner("abc123def456");
        System.out.println(sc.findInLine("\\d+")); // 123 (first regex match, no consume past it)
        System.out.println(sc.next()); // def456 (rest of token)
        System.out.println(sc.match().group()); // last match result (def456 via next())
        sc.close();

        Scanner sc2 = new Scanner("   spaced");
        sc2.skip("\\s+"); // skip leading whitespace
        System.out.println("[" + sc2.nextLine() + "]"); // [spaced]
        System.out.println("delim=" + sc2.delimiter() + " loc=" + sc2.locale()); // inspect state
        System.out.println("ioEx=" + sc2.ioException()); // null if no IO error
        sc2.close();
    }

    // Must-handle errors: bad type, missing token, closed scanner
    static void exceptionHandling() {
        Scanner sc = new Scanner("xyz");
        try {
            sc.nextInt(); // throws: token isn't int
        } catch (InputMismatchException e) {
            System.out.println("mismatch, got: " + sc.next()); // consume bad token to recover
        }

        try {
            sc.next(); // throws: nothing left
        } catch (NoSuchElementException e) {
            System.out.println("no more tokens");
        }

        sc.close();
        try {
            sc.next(); // throws: scanner closed
        } catch (IllegalStateException e) {
            System.out.println("scanner closed");
        }

        // ByteArrayInputStream demo: feed fake System.in (UTF-8)
        byte[] bytes = "hello".getBytes(StandardCharsets.UTF_8);
        Scanner sc3 = new Scanner(new ByteArrayInputStream(bytes), StandardCharsets.UTF_8);
        System.out.println(sc3.nextLine()); // hello
        sc3.close();
    }

    // Real keyboard template: one Scanner, line-based, no close on System.in
    static void interactiveDemo() {
        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);
        sc.useLocale(Locale.US);
        System.out.print("name age height married? (e.g. Ann 21 5.6 true): ");
        String name = sc.nextLine().trim(); // full line (allows spaces)
        // int age = Integer.parseInt(sc.nextLine().trim()); // robust alt to nextInt()
        int age = sc.nextInt();
        sc.nextLine(); // consume newline
        double height = sc.nextDouble();
        sc.nextLine();
        boolean married = sc.nextBoolean();
        sc.nextLine();
        System.out.printf("hi %s %d %.1f %b%n", name, age, height, married);
        // don't sc.close() here if program continues using System.in
    }
}
