package cml;

import card.Card;
import card.creditList;

import java.util.Scanner;
/** Handles the operations for creating new cards
 *  reading/viewing the cards
 *  update a crad
 *  delete a card**/
public class cmlCRUD {
    Scanner userInput = new Scanner(System.in);
    creditList ownersList = new creditList();
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
                    removeCard();
                    break;
                }
                //3:View Cards
                case "3":{
                    printText(""+ownersList);
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
                "4:Return to main menu";
    }


    /** command line prompt for Creating and adding a new card **/
    private void addNewCard() {
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


    private void removeCard()
    {
        String name = "";
        boolean done = false;

        while(!done)
        {
            printText("Please Enter the name of the card that u want to delete. Hit . to go back");
            name = userInput.nextLine();
            if( name == ".")
            {
                done = true;
            }
            else {
                if(confirm(name)) {
                    if (ownersList.removeCard(name)) {
                        printText("Card has been removed!");
                        done = true;
                    }
                    else {
                        printText("Card does not exist");
                    }
                }
               printText("Try again");
            }
        }

    }
    public boolean confirm(String info){
        boolean done = false;
        while(!done) {
            printText(info + " is this correct? Y for YES and N for NO");
            String input = userInput.nextLine();
            if (input.equalsIgnoreCase("Y")) {
                return true;
            } else if ( input.equalsIgnoreCase("N")){
                return false;
            }
            printText("Please Enter a Y or N");
        }
        return false;
    }
    public void printText(String txt)
    {
        System.out.println(txt);
    }


}
