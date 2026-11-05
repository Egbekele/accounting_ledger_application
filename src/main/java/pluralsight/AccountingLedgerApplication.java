package pluralsight;
import java.util.Scanner;




public class AccountingLedgerApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        // ask the user to choose from the menu
        boolean run = true;
        while (run) {
            System.out.println("==========Home Screen==========");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");

            System.out.print("Pick from one from the following option: ");
            String pick = scanner.nextLine().trim().toUpperCase();

            switch (pick){
                case "D":
                    DepositAndPayment.addDeposit(scanner);
                    break;
                case "P":
                    DepositAndPayment.makePayment(scanner);
                    break;
                case"L":
                    ledger();
                    break;
                case "X":
                    System.out.print("Left the Screen!");
                    run = false;
                    break;
                default:
                    System.out.println("Please try again. Make sure to pick from the list!");
            }
        }
    }

}
