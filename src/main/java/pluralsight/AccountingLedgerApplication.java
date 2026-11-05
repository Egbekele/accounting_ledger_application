package pluralsight;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AccountingLedgerApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


    }

    // ask the user to choose from the menu
    public static String chooseOption (Scanner scanner){
        System.out.println("==========Home Screen==========");
        System.out.print("D) Add Deposit");
        System.out.print("P) Make Payment (Debit)");
        System.out.print("L) Ledger");
        System.out.print("X) Exit");

        System.out.print("Pick from one from the following option: ");
        return scanner.nextLine().trim().toUpperCase();

    }
    // ask the user for deposit information
    public static void addDeposit (Scanner scanner){
        System.out.println("==========Deposit Center==========");


        //D) Add Deposit - prompt the user for the deposit information and save it to the CSV file
        // P) Make Payment (Debit) - pro
    }




    // Writing to the transactions file

}
