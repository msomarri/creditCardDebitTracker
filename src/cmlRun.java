import java.util.Scanner;

public class cmlRun {

    public cmlRun(){
        app();
    }
    creditList ownersList = new creditList();
    Scanner userInput = new Scanner(System.in);
    public void app(){
        boolean done = false;
        //Run untill we are done
        while ( !done)
        {
            printText( "Welcome to the Credit Card Tracker App \n" +
                    "Here is the Menu\n" +
                    menuItems() );
                    String userInputKey = userInput.nextLine();
                    switch ( userInputKey )
                    {
                        //1:Manage Cards
                        case "1": {
                            manageCard();
                            break;
                        }

                        //2:Payment Impact"
                        case "2":{
                            break;
                        }
                        //3:Total Interest for the month
                        case "3":{
                            totalInterestForTheMonth();
                            break;
                        }
                        //4:Write to Fil
                        case "4":{
                            writeFile();
                            break;
                        }
                        //5.Read File
                        case "5":
                        {
                            readFile();
                            break;
                        }
                        //7:Quit
                        case "7":
                        {
                        done = true;
                        break;
                        }
                        default:{
                            printText("Please Enter a Key");
                            break;
                        }
                    }
        }
        userInput.close();

    }
    
    public String menuItems()
    {
        return "1:Manage Cards\n" +
                "2:Payment Impact\n" +
                "3:Total Interest for the month\n" +
                "4:Write to File\n" +
                "5.Read File\n" +
                "7:Quit\n";
    }
    public String manageCardMenu()
    {
        return "1:Add Card\n" +
                "2:Remove Card\n" +
                "3:View Cards\n" +
                "4:Return to main menu";
    }
    public void manageCard(){
        boolean done = false;
        //Run untill we are done
        while ( !done) {
            printText("Manage your credit card stack here \n" +
                    "Here is the Menu\n" +
                    manageCardMenu());
            String userInputKey = userInput.nextLine();
            switch (userInputKey){
                //1:Add Card
                case "1":{
                    addNewCard();
                    break;
                }
                //2:Remove Card
                case "2":{
                    break;
                }
                //3:View Cards
                case "3":{
                    printText(""+ownersList);
                    break;
                }
                //4:Return to main menu"
                case "4":{
                    done = true;
                    return;
                }
            }
        }
    }
    /** command line prompt for adding a new card **/
    public void addNewCard() {
        //Add code to make menu item 1
        String name = "";
        double balance = 0;
        double apr = 0;

        String answer ="";

        boolean done = false;
        boolean addName = false;
        boolean addBalance = false;
        boolean addAPR = false;


        try {
            while (!done) {
                //Add the name to the card
                if(!addName) {
                    printText("Enter the Name of the Card");
                    answer = userInput.nextLine();
                    if (!confirm(answer)) {
                        continue;
                    }
                    name = answer;
                    addName = true;
                }
                // Add the Balance
                if(!addBalance) {
                    printText("Enter the Balance ");
                    answer = userInput.nextLine();
                    if (!confirm("" + answer)) {
                        continue;
                    }
                    balance = Double.parseDouble(answer);
                    addBalance = true;
                }
                // Add the APR of the card
                if(!addAPR) {
                    printText("Enter the APR ");
                    answer = userInput.nextLine();

                    if (!confirm("" + answer)) {
                        continue;
                    }
                    apr = Double.parseDouble(answer);
                    addAPR = true;
                }
                done = true;
            }
            Card newCard = new Card(name,balance,apr);
            ownersList.addNewCard(newCard);
            printText(" Card: "+newCard);
            printText("Has been added");
        }catch (Exception e )
        {
            printText("Please Enter a number");
        }
    }
    public void removeCard()
    {
        String name = "";
        boolean done = false;

        while(!done)
        {
            printText("Please Enter the name of the card that u wan to delete. Hit . to go back");
            name = userInput.nextLine();
            if( name == ".")
            {
                done = true;
            }
            else {
                if(ownersList.removeCard(name))
                {
                    printText("Card has been removed!");
                    done = true;
                    return;
                }
                else {
                    printText("Card does not exist");
                }
            }
        }

    }
    public void seeTotalBalance(){
        //Add code to see the total balance
        printText("Here is your Total Balance So far  "+ ownersList.getTotalBalance());
    }
    public void paymentImpact(){
        //Add code to see the impact  that a payment will make
    }
    public void totalInterestForTheMonth(){
        //Add code to show what the total interest is for the month
        creditDebitMangement ret = new creditDebitMangement(ownersList);
        printText(""+ ret.totalInterest() ) ;
    }
    public void writeFile(){
        printText("Please enter the File/Filepath ");
        String FilePath = userInput.nextLine();
        creditDebitMangement ret = new creditDebitMangement(ownersList);
        ret.writeToText(FilePath);
        printText("File has been created");
    }
    public void readFile(){
        printText("Please enter the File/Filepath ");
        String Filepath = userInput.nextLine();
        creditDebitMangement ret = new creditDebitMangement(ownersList);
        ret.readFile(Filepath);
        ownersList = ret.getDebit();
        printText("File has been Read");
    }
    public void printText(String txt)
    {
        System.out.println(txt);
    }

    public boolean confirm(String info){
        boolean done = false;
        while(!done) {
            printText(info + " is this correct? Y for YES and N for NO");
            String input = userInput.nextLine();
            if (input.equalsIgnoreCase("Y")) {
               // userInput.close();
                return true;
            } else if ( input.equalsIgnoreCase("N")){
                return false;
            }
            printText("Please Enter a Y or N");
        }
        return false;
    }
    // Example Program interface using the command line as an interface
    public static void main(String arg[] ){
        cmlRun test = new cmlRun();



    }
}
