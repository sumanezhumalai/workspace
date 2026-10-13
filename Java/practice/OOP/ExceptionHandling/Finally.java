package ExceptionHandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Finally
 */
public class Finally {

    public static void main(String[] args) throws IOException {

        // BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // try {
        // System.out.println("Enter a Number : ");
        // int num = Integer.parseInt(bf.readLine());

        // System.out.println("\n" + num);

        // } catch (Exception e) {
        // System.out.println("Exception Occured: " + e);
        // } finally {
        // bf.close();
        // }

        // can also do the below for - Automatic Resource closage
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            // this try(){} format is called "Try witg Resources"
        }
    }
}