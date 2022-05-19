package cml;

import card.Card;
import card.creditList;

/** Handles the operations for creating new cards
 *  reading/viewing the cards
 *  update a crad
 *  delete a card**/
public class cmlCRUD {
    private creditList ownersList;
    private cmlTools format  = new cmlTools();

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
            String userInputKey = format.readInput();
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
                    updateCard();
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
        String name ;
        double balance;
        double apr;

                //Add the name to the card
                name = collectName();
                // Add the Balance
                balance = collectDouble("balance");
                // Add the APR of the card
                apr = collectDouble("APR");


            Card newCard = new Card(name,balance,apr);
            ownersList.addNewCard(newCard);
            format.printText(" Card: "+newCard);
            format.printText("Has been added");
    }
    // Prompts the user with a menu to update their card information
    public void updateCard(){
        String name;
        double balance;
        double apr;

        viewList();
        String target = format.askInput("Please enter the name of the card that you want to change?");

        //Add the name to the card
        name = collectName();
        // Add the Balance
        balance = collectDouble("balance");
        // Add the APR of the card
        apr = collectDouble("APR");

        format.printText("Changing card with Name with "+ target);
        ownersList.updateCard(target, new Card(name,balance,apr));
        }

    //Delete and remove a card
    private void removeCard()
    {
        String name;
        boolean done = false;

        while(!done)
        {
            format.printText("Please Enter the name of the card that u want to delete. Hit . to go back");
            name = format.readInput();
            if( name.equals("."))
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
    /// Possble to update with Array.Maps require more research
    public String viewList(){
        String ret = format.linebar();
        for ( int i = 0 ; i < ownersList.size() ; i ++)
        {
            ret += "\n"+ownersList.getCard(i) +"Interest:  "+ ownersList.getCard(i).monthlyInterest()+format.sep();
        }
        return ret+format.linebar();
    }
//Helper functions to collect information from the user
    public String collectName() {
        boolean done = false;
        String name="";

        while(!done) {
            format.printText("Enter the Name of the Card");
            name = format.readInput();
            if (format.confirm(name)) {
                done = true;
            }
        }
        return name;
    }
    //Since the balance and double are both doubles. we can use this to collect both of them
    public double collectDouble(String type){
    boolean done = false;
    double ret=-1;
        while(!done) {
            ret = format.askDoubleValue(type);
            if (format.confirm("" + ret)) {
                done = true;
            }
        }
        return ret;
        }

}
