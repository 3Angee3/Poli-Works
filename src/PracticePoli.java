import java.util.Scanner;

/**
 * @author Valentina
 * @version 1.0
 * @since 1/9/2025
 The {@code PracticePoli} class simulates a simple ATM (Automated Teller Machine).
 * <p>
 * Features:
 * <ul>
 *   <li>Withdrawals must be in multiples of 5,000.</li>
 *   <li>Validates that the withdrawal does not exceed the available balance.</li>
 *   <li>Breaks down the withdrawal into available denominations:
 *       50,000; 20,000; 10,000; and 5,000.</li>
 *   <li>Updates the remaining balance after each withdrawal.</li>
 *   <li>Terminates automatically when the balance reaches zero.</li>
 * </ul>
 * */

public class PracticePoli
{
    /**
     * Main method that executes the ATM flow
     *
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balance = 500000; //Opening balance
        int withdraw;
        boolean continueSession = true; //Control the cycle

        System.out.println("Welcome to the ATM");
        System.out.println("Opening balance: $" + balance);


        //Input validations
        while (continueSession && balance > 0) {
            System.out.print("\nEnter the amount to be withdrawn (multiple of 5000):");
            withdraw = sc.nextInt();

            //Another Input validations
            if (withdraw > balance) {
                System.out.println("Error: The amount exceeds the available balance.");
            } else if (withdraw % 5000 != 0) {
                System.out.println("Error: The amount must be a multiple of 5000.");
            } else {
                /**
                 * Calculation of banknotes delivered.
                 * Divide the amount into large bills first, updating the remaining amount at each step.
                 */

                // Calculation of bills issued
                int bills50 = withdraw / 50000; // Calculate how many $50000 bills can be delivered
                withdraw %= 50000;  //Update the remaining amount after handing over those bills

                int bills20 = withdraw / 20000; // Calculate $20000 bills
                withdraw %= 20000;

                int bills10 = withdraw / 10000; //Calculate $10000 bills
                withdraw %= 10000;

                int bills5 = withdraw / 5000; // Calculate $5000 bills

                /**
                 * Displays the bills given to the user and updates the remaining balance.
                 *
                 * This method prints the bills delivered according to the calculated amounts,
                 * adds up the total withdrawn, and deducts that amount from the current balance.
                 *
                 * @param bills50 Number of $50000 bills delivered
                 * @param bills20 Number of $20000 bills delivered
                 * @param bills10 Number of $10000 bills delivered
                 * @param bills5  Number of $5000 bills delivered
                 * @param balance Current balance before withdrawal
                 * @return New balance after deducting the withdrawal
                 */
                //Show tickets delivered
                System.out.println("Successful withdrawal. Tickets delivered:");
                if (bills50 > 0) System.out.println(" - $50000 x " + bills50);
                if (bills20 > 0) System.out.println(" - $20000 x " + bills20);
                if (bills10 > 0) System.out.println(" - $10000 x " + bills10);
                if (bills5 > 0)  System.out.println(" - $5000  x " + bills5);

                //Update balance
                int totalWithdrawn = (bills50 * 50000) + (bills20 * 20000) + (bills10 * 10000) + (bills5 * 5000);
                balance -= totalWithdrawn;
                System.out.println("Remaining balance: $" + balance);
            }
        }
        sc.close();
    }
}


