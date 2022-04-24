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
             balance -=amount;
             curr.setBalance(balance);
             balance = balance + curr.monthlyInerest();
             months++;
         }

        return months;
    }
}
