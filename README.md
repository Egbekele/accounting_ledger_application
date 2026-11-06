Accounting Ledger Application


This is my first Capstone for Year Up United in the Software track.

This program is designed to track your finances. It logs your deposits and payments and lets you view your history. Each transaction is organized by date, time, description, vendor, and amount. It also has a cool feature that lets you search your transactions by vendor. Everything you log is saved in a file called transactions.csv.



Features
Home Screen

D) Add Deposit - prompts the user for the deposit information and saves it to the CSV file

P) Make Payment (Debit) - prompts the user for the payment information and saves it to the CSV file

L) Ledger - displays the Ledger screen

X) Exit - exits the application



Ledger Screen
All entries are shown newest first.

A) All - displays all entries

D) Deposits - displays only deposits (money coming in)

P) Payments - displays only payments (money going out)

R) Reports - opens the Reports screen

H) Home - goes back to the Home screen



Reports Screen
1) Month To Date - transactions from this month
2) Previous Month - transactions from last month
3) Year To Date - transactions from this year
4) Previous Year - transactions from last year
5) Search by Vendor - asks for a vendor name and displays all entries for that vendor
0) Back - goes back to the Ledger screen



Format of Transactions

Each transaction is saved as one line in transactions.csv:

date|time|description|vendor|amount

2023-04-15|10:13:25|ergonomic keyboard|Amazon|-89.50

2023-04-15|11:15:00|Invoice 1001 paid|Joe|1500.00

🌟Positive amounts are deposits and negative amounts are payments. 



Code Class Structure
* AccountingLedgerApplication.java -> where the main method is; shows the Home screen
* DepositAndPayment.java -> where the user adds a deposit or payment, and the amount is checked 
* TransactionFile.java -> writes transactions to and reads them from transactions.csv
* Transaction.java -> temporarily holds one transaction's data so it can be displayed
* LedgerScreen.java -> shows the menu to view your transaction history
* ReportsScreen.java -> shows a menu to view your transaction history in more depth
* transactions.csv -> where all the transactions are saved



How to Run ⭐️
1. Clone this repository:
    git clone https://github.com/Egbekele/accounting_ledger_application
2. Open the project in IntelliJ IDEA.
3. Make sure transactions.csv is in the project root (next to pom.xml).
4. Open src/main/java/pluralsight/AccountingLedgerApplication.java and click the green Run button next to main.
5. Follow the on-screen menus.


Proud Code of Mine 💪🏽👏🏽

The findAmount method in the DepositAndPayment class is designed to keep asking the user until they type a valid amount. If they type letters or other characters, the code doesn’t crash. Instead, they get a message with an example of what’s expected and another chance to try again. The same thing happens if they type 0 or a negative number. They can keep trying as many times as they need until it’s correct.

Code below ⬇️

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

Thanks for checking out my project! Enjoy! 🎉
