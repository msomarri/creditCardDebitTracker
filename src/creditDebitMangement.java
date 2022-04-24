
public class creditDebitMangement {
    creditList debit = new creditList();


    // Given a card find out how long it will take to payoff that card with a given amount
    //The total amount of months it would take for a card be payoff with the given amount
    public int payoffCardTime( String name , double amount){
         Card curr = debit.getCard(name);
         double balance = curr.getBalance();
         int months = 0 ;
         while(balance > 0 )
         {
             balance -= amount;
             balance = balance + curr.monthlyInerest();
             curr.setBalance(balance);
             months++;
//             System.out.println( " "+balance + "  "+ months);
         }

        return months;
    }
    public void setDebit( creditList newCard)
    {
        this.debit = newCard;
    }
        // Testing method TOOD is to add some junit testing
    public static void main(String arg[]){
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

    }


}
