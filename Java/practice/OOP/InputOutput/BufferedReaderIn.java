package InputOutput;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * BufferedReader
 */
public class BufferedReaderIn {

    public static void main(String[] args) throws Exception {

        System.in.read(); // reads as ASCII values (only one acii valuse at a Time)

        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(in);

        System.out.println("Enter a Number : ");
        int num = Integer.parseInt(bf.readLine());

        System.out.println("\n" + num);

        bf.close();
    }
}