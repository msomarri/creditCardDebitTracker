package cml;

import mangement.creditDebitManagement;
import card.*;

public class cmlPaymentImpact {
    private cmlTools format = new cmlTools();
    creditDebitManagement info = new creditDebitManagement();

    public void paymentImpactCML(creditList ownersList){
        boolean done = false;
        info.setDebit(ownersList);


        while(!done)
        {
            format.printText("Welcome to the impact payment menu\n" +
                    "Where can you see the difference that your payment makes \n" +
                    "and determine what cards are bad.\n" +
                    paymentImpactMenu());
            String input = format.readInput();
            switch (input)
            {
                case "1":{
                    break;
                }
                case "2":{
                    format.printText(""+ownersList.getTotalBalance());
                    break;
                }
                case "3":{
                    format.printText(""+info.highestBalanceCard());
                    break;
                }
                case "4":{
                    format.printText(""+info.highInterestCard());
                }
                case "5":{
                    done =true;
                    return;
                }
            }
        }


    }
    public String paymentImpactMenu() {
        return "1:Make a payment and see impact\n" +
                "2.Total Balance\n" +
                "3.Highest Card Balance \n" +
                "4.Highest Card Interest\n" +
                "5. Exit to Main menu";
    }
}
