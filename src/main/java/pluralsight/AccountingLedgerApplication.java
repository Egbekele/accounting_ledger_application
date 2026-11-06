package pluralsight;
import java.util.Scanner;

public class AccountingLedgerApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Welcome banner
        System.out.println("=======================================================");
        System.out.println("        WELCOME TO [Accounting Ledger Application]");
        System.out.println("   Track every dollar in and every dollar out");
        System.out.println("========================================================");


        // ask the user to choose from the menu
        boolean run = true;
        while (run) {
            System.out.println("\n==========Home Screen==========");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");

            System.out.print("Pick one from the following option: ");
            String pick = scanner.nextLine().trim().toUpperCase();

            switch (pick){
                case "D":
                    DepositAndPayment.addDeposit(scanner);
                    break;
                case "P":
                    DepositAndPayment.makePayment(scanner);
                    break;
                case"L":
                    LedgerScreen.ledger(scanner);
                    break;
                case "X":
                    System.out.println("Left the Screen!");
                    run = false;
                    break;
                default:
                    System.out.println("Please try again. Make sure to pick from the list!");
            }
        }
    }

}
