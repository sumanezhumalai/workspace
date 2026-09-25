import java.util.Scanner;

public class InputOutput {
    public static void main(String[] args) {
        // print forms
        System.out.print("a "); // no newline
        System.out.println("b"); // newline
        System.out.printf("%s %d %.2f%n", "x", 5, 3.14159); // formatted

        // format specifiers: %d int, %f float, %s str, %c char, %b bool, %n newline
        System.out.printf("%5d|%-5d|%05d%n", 42, 42, 42); // width/pad/align

        // scanner: next() word vs nextLine() line (mixing needs extra nextLine)
        Scanner in = new Scanner(System.in);
        if (in.hasNext()) {
            String word = in.next(); // up to whitespace
            System.out.println(word);
        }
        // int n = in.nextInt(); in.nextLine(); // consume leftover \n
        // String line = in.nextLine();
        in.close();

        // args from CLI: java -cp bin InputOutput a b
        System.out.println(args.length);
        for (String s : args) System.out.print(s + " ");
        System.out.println();
    }
}
