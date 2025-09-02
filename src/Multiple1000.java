import java.util.Scanner;

/**
 * Program to check if a number is a multiple of 100.
 *
 * Input: An integer number.
 * Output: "multiple of 100" if divisible by 100, otherwise "not multiple of 100".
 *
 * Example:
 * Input: 12600
 * Output: multiple of 100
 *
 * Author: Valentina
 * Version: 1.0
 * Date: 01/09/2025
 */
public class Multiple1000 {

    /**
     * Main method to execute the program.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter an integer number: ");
        int number = sc.nextInt();

        // Processing and output
        if (number % 100 == 0) {
            System.out.println("multiple of 100");
        } else {
            System.out.println("not multiple of 100");
        }

        sc.close();
    }
}
