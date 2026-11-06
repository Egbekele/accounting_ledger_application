package pluralsight;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TransactionFile {

    // transactions.csv
    // Writing to the transactions file (deposit and payment)
    public static void saveTansactions (String description, String vendor, double amount){
        LocalDateTime rightNow = LocalDateTime.now();  // the exact time now
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // format for day
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss"); // format for time

        String date = rightNow.format(dateTimeFormat);
        String time = rightNow.format(timeFormat);

        try{
            FileWriter writer = new FileWriter("transactions.csv", true);
            writer.write(date + "|" + time + "|" + description + "|" + vendor + "|" +
                    amount + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("This Data was not saved! Please make sure to save your Information");
        }
    }


    // Reading the lines of trandsctions.cvs (ledger and report)
    public static ArrayList<Transaction> readTransactions(){
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();

        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader("transactions.csv"));
            String input;

            while ((input = bufferedReader.readLine()) != null) {
                //
                if(input.startsWith("date") || input.trim().isEmpty()) {
                    continue;
                }

                // the order it should read
                String [] parts = input.split("\\|");
                LocalDate date = LocalDate.parse(parts[0]);
                LocalTime time = LocalTime.parse(parts[1]);
                String description = parts[2];
                String vendor = parts [3];
                double amount = Double.parseDouble(parts[4]);

                transactions.add(new Transaction(date, time , description, vendor, amount));
            }
            bufferedReader.close();
        } catch (IOException e){
            System.out.println("Could not read the transactions file.");
        }
        return transactions;
    }

}
