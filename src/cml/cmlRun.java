package cml;

import java.util.Scanner;
import card.Card;
import  card.creditList;
import mangement.creditDebitManagement;



public class cmlRun {

    public cmlRun(){
        app();
    }
    creditList ownersList = new creditList();
    Scanner userInput = new Scanner(System.in);
    private cmlTools format  = new cmlTools();
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
                            cmlCRUD manageMenu = new cmlCRUD(ownersList);
                            ownersList = manageMenu.menu();
                            break;
                        }

                        //2:Payment Impact"
                        case "2":{
                            cmlPaymentImpact pay = new cmlPaymentImpact();
                            pay.paymentImpactCML(ownersList, userInput);
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


    public void seeTotalBalance(){
        //Add code to see the total balance
        printText("Here is your Total Balance So far  "+ ownersList.getTotalBalance());
    }
    public void paymentImpact(){
        //Add code to see the impact  that a payment will make
    }
    public void totalInterestForTheMonth(){
        //Add code to show what the total interest is for the month
        creditDebitManagement ret = new creditDebitManagement(ownersList);
        printText("Total Interest for the Month \n"+ ret.totalInterest() ) ;
    }
    public void writeFile(){
        printText("Please enter the File/Filepath ");
        String FilePath = userInput.nextLine();
        creditDebitManagement ret = new creditDebitManagement(ownersList);
        ret.writeToText(FilePath);
        printText("File has been created");
    }
    public void readFile(){
        printText("Please enter the File/Filepath ");
        String Filepath = userInput.nextLine();
        creditDebitManagement ret = new creditDebitManagement(ownersList);
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
