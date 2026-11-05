package pluralsight;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionFile {

    // transactions.csv
    // Writing to the transactions file
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

}
