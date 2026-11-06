package pluralsight;

import java.util.Scanner;

public class DepositAndPayment {

    //D) Add Deposit - prompt the user for the deposit information and save it to the CSV file
    public static void addDeposit (Scanner scanner){
        System.out.println("==========Deposit Center==========");
        System.out.print("Deposit Information: ");
        String depositInfo = scanner.nextLine().trim();
        System.out.print("Vendor: ");
        String vendor = scanner.nextLine().trim();
        double amount = findAmount(scanner);

        TransactionFile.saveTansactions(depositInfo, vendor, amount);
        System.out.println("Your deposit information has been saved!");

    }



    // P) Make Payment (Debit) - prompt the user for the debit information and save it to the CSV file
    public static void makePayment (Scanner scanner){
        System.out.println("==========Payment Center==========");
        System.out.print("Payment Information: ");
        String paymentInfo = scanner.nextLine().trim();
        System.out.print("Vendor: ");
        String vendor = scanner.nextLine().trim();
        double amount = findAmount(scanner);

        TransactionFile.saveTansactions (paymentInfo, vendor, -amount);
        System.out.println("Your payment information has been saved!");

    }



    // asking until we get the number we want and if it's a number
    public static double findAmount(Scanner scanner){
        while(true){
            System.out.print("Amount: ");
            try{
                double amount = Double.parseDouble(scanner.nextLine().trim());
                if(amount > 0){
                    return amount;
                }
                System.out.println("Amount must be greater than 0.");
            } catch(Exception e){
                System.out.println("Please enter a number, like the following examples would be 30.00");
            }
        }
    }

}
