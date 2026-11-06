package pluralsight;


import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class LedgerScreen {

    public static void ledger (Scanner scanner) {
        //L) Ledger - display the ledger screen

        boolean leger = true;

        while (leger){
            System.out.println("\n==========Ledger==========");
            System.out.println("A) All");
            System.out.println("D) Deposits");
            System.out.println("P) Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");
            System.out.print("Pick from the options: ");
            String pick = scanner.nextLine().trim().toUpperCase();

            switch (pick) {
                case "A":
                    displayAll();
                    break;
                case "D":
                    displayDeposits();
                    break;
                case "P":
                    displayPayment();
                    break;
                case "R":
                    ReportsScreen.displayReports(scanner);
                    break;
                case "H":
                    leger = false;
                    break;
                default:
                    System.out.println("Please try again. Make sure to pick from the list!");
            }
        }
    }

    // Column & Header
    public static void header() {
        System.out.println("DATE | TIME | DESCRIPTION | VENDOR | AMOUNT");
        System.out.println("----------------------------------------------------");
    }

    // Transaction in one row
    public static void printTransaction (Transaction transaction){
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.printf("%s | %s | %s | %s | $%.2f\n", transaction.getDate(), transaction.getTime().format(timeFormat),
                transaction.getDescription(), transaction.getVendor(), transaction.getAmount());
    }


    // A) display all transaction
    public static void displayAll(){
        ArrayList<Transaction> transactions = TransactionFile.readTransactions();
        header();
        for (int i = transactions.size() - 1; i >= 0; i--){
            printTransaction(transactions.get(i));
        }
    }

    // D) display only deposits
    public static void displayDeposits (){
        ArrayList<Transaction> transactions = TransactionFile.readTransactions();
        header();
        for (int i = transactions.size() - 1; i >= 0; i--){
            Transaction transaction = transactions.get(i);
            if(transaction.getAmount() > 0){
                printTransaction(transaction);
            }
        }
    }
    // P) display payments (negative entries)
    public static void displayPayment (){
        ArrayList<Transaction> transactions = TransactionFile.readTransactions();
        header();
        for (int i = transactions.size() - 1; i >= 0; i--){
            Transaction transaction = transactions.get(i);
            if(transaction.getAmount() < 0){
                printTransaction(transaction);
            }
        }

    }

}
