import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

public class creditDebitMangement {
    creditList debit = new creditList();


    // Given a card find out how long it will take to payoff that card with a given amount
    //The total amount of months it would take for a card be payoff with the given amount
    public int payoffCardTime(String name, double amount) {
        Card curr = debit.getCard(name);
        double interest = curr.getMonthlyApr();
        double balance = curr.getBalance();
        int months = 0;
        while (balance > 0) {
            balance -= amount;
            balance = balance + curr.monthlyInterest(balance , interest);
            months++;
//             System.out.println( " "+balance + "  "+ months);
        }

        return months;
    }

    // Writes the current information to a text file
    //Format will be just the info of card written down
    public void writeToText(String path) {
        String fileName = "debit.txt";
        File write = new File(fileName);

        //Create the file if it does not exist
        try {
            if (write.createNewFile()) {
                System.out.println("File created: " + write.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            FileWriter myWriter = new FileWriter(fileName);

            for (int i = 0; i < debit.size(); i++) {

                Card writeout = debit.getCard(i);

                myWriter.write(writeout.getName() + "\n");
                myWriter.write("" + writeout.getApr() + "\n");
                myWriter.write("" + writeout.getBalance() + "\n");
                ;


            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void readFile(String path) {
        try {
            String fileName = "debit.txt";
            File read = new File(fileName);
            Scanner myReader = new Scanner(read);
            int counter = 1;
            creditList newDebit = new creditList();
            Card add = new Card();
            while (myReader.hasNext()) {

                String name = myReader.nextLine();
                double balance = Double.parseDouble(myReader.nextLine());
                double apr = Double.parseDouble(myReader.nextLine());

                Card newC = new Card(name,balance, apr);
                newDebit.addNewCard(newC);
            }
            setDebit(newDebit);
            myReader.close();
        } catch(FileNotFoundException e) {

    }

}


    public void setDebit(creditList newCard) {
        this.debit = newCard;
    }
        @Override
        public String toString() {
            return "creditDebitMangement{" +
                    "debit=" + debit +
                    '}';
        }


    // Testing method TOOD is to add some junit testing
    public static void main(String arg[]) {
        String cardNames[] = {"A","B" , "C" , "D" , "E" };
        double aprs[] = {1.0,1.2,1.3,22,24.99};
        double balances[] = {1111, 1000 , 1232 , 133.21 , 122.33};
        int size = 5;

        double pay = 54.00;

        creditList test = new creditList();
        creditDebitMangement test2 = new creditDebitMangement();
        for (int i = 0 ; i < size ; i++ )
        {
            Card temp = new Card( cardNames[i], balances[i],aprs[i] );
            test.addNewCard(temp);
            test2.setDebit(test);

            System.out.println(" Card has been added : "+temp);
            System.out.println(" The amount of pay off using "+pay);
            System.out.println("Months to payoff " + test2.payoffCardTime(cardNames[i] , pay));
        }
        test2.writeToText("");


    }

//        creditDebitMangement test = new creditDebitMangement();
//        test.readFile("");
//        System.out.println(test);
//    }
}
