package pluralsight;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ReportsScreen {

    // Report menu
    public static void displayReports(Scanner scanner) {
        boolean reports = true;

        while (reports) {
            System.out.println("\n==========Reports==========");
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            //    System.out.println("6) Custom Search");
            System.out.println("0) Back");
            System.out.print("Pick from the following lists: ");
            String pick = scanner.nextLine().trim();

            switch (pick) {
                case "1":
                    monthToDate();
                    break;
                case "2":
                    previousMonth();
                    break;
                case "3":
                    yearToDate();
                    break;
                case "4":
                    previousYear();
                    break;
                case "5":
                    searchByVendor(scanner);
                    break;
                case "0":
                    reports = false;
                    break;
                default:
                    System.out.println("Try again and make sure to pick from the list");
            }
        }
    }

    // 1) Month To Date
    public static void monthToDate() {
        LocalDate rightNow = LocalDate.now();

        ArrayList<Transaction> transactions = TransactionFile.readTransactions();
        LedgerScreen.header();


        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transaction transaction = transactions.get(i);


            if (transaction.getDate().getYear() == rightNow.getYear()
                    && transaction.getDate().getMonthValue() == rightNow.getMonthValue()) {
                LedgerScreen.printTransaction(transaction);
            }

        }
    }

    // 2 Previous Month
    public static void previousMonth() {
        LocalDate rightNow = LocalDate.now();
        int month = rightNow.getMonthValue() - 1;
        int year = rightNow.getYear();

        if (month == 0) {
            month = 12;
            year = year - 1;
        }

        ArrayList<Transaction> transactions = TransactionFile.readTransactions();
        LedgerScreen.header();

        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transaction transaction = transactions.get(i);

            if (transaction.getDate().getYear() == year &&
                    transaction.getDate().getMonthValue() == month) {
                LedgerScreen.printTransaction(transaction);
            }

        }
    }

    // 3) year to date
    public static void yearToDate() {
        LocalDate rightNow = LocalDate.now();

        ArrayList<Transaction> transactions = TransactionFile.readTransactions();
        LedgerScreen.header();

        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transaction transaction = transactions.get(i);

            if (transaction.getDate().getYear() == rightNow.getYear()) {
                LedgerScreen.printTransaction(transaction);

            }
        }
    }


    // 4) Previous Year
    public static void previousYear() {
        int lastYear = LocalDate.now().getYear() - 1;

        ArrayList<Transaction> transactions = TransactionFile.readTransactions();
        LedgerScreen.header();

        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transaction transaction = transactions.get(i);

            if (transaction.getDate().getYear() == lastYear) {
                LedgerScreen.printTransaction(transaction);

            }

        }

    }

    // 5) Search by Vendor
    public static void searchByVendor(Scanner scanner) {
        System.out.print("Vendor name: ");
        String vendor = scanner.nextLine().trim();

        ArrayList<Transaction> transactions = TransactionFile.readTransactions();
        LedgerScreen.header();

        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transaction transaction = transactions.get(i);

            if (transaction.getVendor().equalsIgnoreCase(vendor)) {
                LedgerScreen.printTransaction(transaction);
            }
        }
    }

}




