import java.util.Scanner;

public class cmlRun {

    public cmlRun(){
        app();
    }
    creditList ownersList = new creditList();
    public void app(){
        boolean done = false;
        Scanner userInput = new Scanner(System.in);
        //Run untill we are done
        while ( !done)
        {
            printText( " Welcome to the Credit Card Tracker App \n" +
                    "Here is the Menu\n" +
                    menuItems() );
                    String userInputKey = userInput.nextLine();
                    switch ( userInputKey )
                    {
                        case "1": {
                            addNewCard();
                            break;
                        }
                        case "2":{
                            break;
                        }
                        case "3":{
                            break;
                        }
                        case "4":{

                        }
                        case "5":{
                            done = true;
                        }
                        default:{
                            printText("Please Enter a Key");
                        }
                    }
        }
        userInput.close();

    }
    public String menuItems()
    {
        return "1: Add New Card +\n" +
                "2: See total Balance\n" +
                "3: Project Payment\n" +
                "4:Total Interest for the month\n" +
                "5:Quit";
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

        Scanner userInput = new Scanner(System.in);
        try {
            while (!done) {
                //Add the name to the card
                if(!addName) {
                    printText(" Enter the Name of the Card");
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

                    if (!confirm("" + apr)) {
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
    public void seeTotalBalance(){
        //Add code to see the total balance
    }
    public void projectPayment(){
        //Add code to see the impact  that a payment will make
    }
    public void totalInterestForTheMonth(){
        //Add code to show what the total interest is for the month
    }
    public void printText(String txt)
    {
        System.out.println(txt);
    }

    public boolean confirm(String info){
        Scanner userInput = new Scanner(System.in);
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
        test.app();


    }
}
