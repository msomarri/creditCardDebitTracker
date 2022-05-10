package cml;

import card.Card;
import card.creditList;

import java.util.Scanner;
/** Handles the operations for creating new cards
 *  reading/viewing the cards
 *  update a crad
 *  delete a card**/
public class cmlCRUD {
    private final Scanner usersEdits = new Scanner(System.in);
    private creditList ownersList;
    private cmlTools format  = new cmlTools();
    public cmlCRUD(){
        this.ownersList = null;
    }
    public cmlCRUD(creditList list){
        this.ownersList = list;
    }

    public creditList menu(){
        boolean done = false;
        //Run until we are done
        while ( !done) {
            format.printText("Manage your credit card stack here \n" +
                    "Here is the Menu\n" +
                    manageCardMenu());
            String userInputKey = usersEdits.nextLine();
            switch (userInputKey){
                //1:Add Card
                case "1":{
                    addNewCard();
                    break;
                }
                //2:Remove Card
                case "2":{
                    removeCard();
                    break;
                }
                //3:View Cards
                case "3":{
                    System.out.println(viewList());
                    break;
                }
                //4:update Card
                case "4":{
                    break;
                }
                //5:Return to main menu"
                case "5":{
                    done = true;
                }
            }
        }
        return ownersList;
    }

    public String manageCardMenu()
    {
        return "1:Add Card\n" +
                "2:Remove Card\n" +
                "3:View Cards\n" +
                "4.Update Card\n" +
                "5:Return to main menu\n";
    }


    /** command line prompt for Creating and adding a new card **/
    private void addNewCard() {
        //Add code to make menu item 1
        String name = "";
        double balance = 0;
        double apr = 0;

        String answer;

        boolean done = false;
        boolean addName = false;
        boolean addBalance = false;
        boolean addAPR = false;


        try {
            while (!done) {
                //Add the name to the card
                if(!addName) {
                    format.printText("Enter the Name of the Card");
                    answer = usersEdits.nextLine();
                    if (!format.confirm(answer)) {
                        continue;
                    }
                    name = answer;
                    addName = true;
                }
                // Add the Balance
                if(!addBalance) {
                    format.printText("Enter the Balance ");
                    answer = usersEdits.nextLine();
                    if (!format.confirm("" + answer)) {
                        continue;
                    }
                    balance = Double.parseDouble(answer);
                    addBalance = true;
                }
                // Add the APR of the card
                if(!addAPR) {
                    format.printText("Enter the APR ");
                    answer = usersEdits.nextLine();

                    if (!format.confirm("" + answer)) {
                        continue;
                    }
                    apr = Double.parseDouble(answer);
                    addAPR = true;
                }
                done = true;
            }
            Card newCard = new Card(name,balance,apr);
            ownersList.addNewCard(newCard);
            format.printText(" Card: "+newCard);
            format.printText("Has been added");
        }catch (Exception e )
        {
            format.printText("Please Enter a number");
        }
    }
    // Prompts the user with a menu to update their card information
    public void updateCard(){
        String name ;
        boolean done = false;

        while(!done){
        //name
            format.printText(" Did you want to change the Name of the card?\n Y for yes and N for No");
            if( usersEdits.nextLine().equalsIgnoreCase("y"))
            {

            }
        //balance
        //interest

        }
    }
    //Delete and remove a card
    private void removeCard()
    {
        String name = "";
        boolean done = false;

        while(!done)
        {
            format.printText("Please Enter the name of the card that u want to delete. Hit . to go back");
            name = usersEdits.nextLine();
            if( name == ".")
            {
                done = true;
            }
            else {
                if(format.confirm(name)) {
                    if (ownersList.removeCard(name)) {
                        format.printText("Card has been removed!");
                        done = true;
                    }
                    else {
                        format.printText("Card does not exist");
                    }
                }
               format.printText("Try again");
            }
        }

    }
    // View Card
    public String viewList(){
        String ret = format.linebar();
        for ( int i = 0 ; i < ownersList.size() ; i ++)
        {
            ret += "\n"+ownersList.getCard(i) +"Interest:  "+ ownersList.getCard(i).monthlyInterest()+format.sep();
        }
        return ret+format.linebar();
    }
    // Update cards based off there names
    public void updateCard(String name){
            Card temp = ownersList.getCard(name);
    }

}
