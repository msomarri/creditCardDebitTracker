import java.util.ArrayList;
/** Credit management will the brains behind tracking down the total expense that a user has and show that to the user
     TODO add sorting for the arraylist
 **/
public class creditList {
    private ArrayList<Card> ownersCards = new ArrayList<Card>();
    private double totalBalance;

    public creditList()
    {
        totalBalance = 0;
    }

    public double getTotalBalance() {
        return totalBalance;
    }

    public int size(){
        return ownersCards.size();
    }
    /**
      @addNewCard Add a new card to the list as well as tracking the total balance for all the cards**/
    public void addNewCard(Card newCard){
        if( !cardExist(newCard.getName())) {
            ownersCards.add(newCard);
            totalBalance += newCard.getBalance();
        }
        else{
            System.out.println("Sorry but you have already added a card with this name");
        }
    }
    public void removeCard(String name){
        for( int i = 0 ; i < ownersCards.size() ; i++) {
            Card curr_card = ownersCards.get(i);
            if(curr_card.getName() == name)
            {
                ownersCards.remove(curr_card);
            }
            totalBalance -= curr_card.getBalance();
        }
    }
    public int getCardIndex(String name){
        for ( int i =0 ; i < ownersCards.size();i++)
        {
            if ( ownersCards.get(i).getName() == name)
            {
                return i;
            }

        }
        return -1;
    }
    public Card getCard(int i )
    {
        return ownersCards.get(i);
    }
    public Card getCard(String name){
        for ( int i =0 ; i < ownersCards.size();i++)
        {
            if ( ownersCards.get(i).getName() == name)
            {
                return ownersCards.get(i);
            }

        }
        return null;
    }
    public boolean updateCard(String name , double balance)
    {
        for ( int i =0 ; i < ownersCards.size();i++)
        {
            if ( ownersCards.get(i).getName() == name)
            {
                ownersCards.get(i).setBalance(balance);
                return true;
            }

        }
        return false;

    }
    public boolean cardExist(String name){

        for ( int i = 0 ; i < ownersCards.size() ; i++)
        {
                if( ownersCards.get(i).getName() == name){
                    return true;
                }
        }
        return false;
    }

}
