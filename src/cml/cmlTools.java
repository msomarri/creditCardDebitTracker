package cml;

import java.util.Scanner;

/** New class that will collect everything that commandlineinterface will need to run
 * Going to focus keeping the scanner object only to this class**/
public class cmlTools {

    private Scanner usersInput;

    public cmlTools(){
        usersInput = new Scanner(System.in);
    }
    // When a user ask for a double this will return that value
    public double askDoubleValue(String var){
        try{
            printText("Can you please enter a value for "+var);
            double ret = Double.parseDouble(usersInput.nextLine());
            return ret;
        }
        catch (Exception e )
        {
            printText(" Error Please try again");
        }
      return -1;
    }
    // Return userinput as a string
    public String readInput()
    {
        return usersInput.nextLine();
    }
    // When a user needs a string this will return that value
    public String askInput(String var){
        printText("Can you please enter a value for " + var );
        return usersInput.nextLine();
    }

    // Confirms an input for a user . True for yes and False for no
    public boolean confirm(String info){
        Scanner Input = new Scanner(System.in);
        boolean done = false;
        while(!done) {
            printText(info + " is this correct? Y for YES and N for NO");
            String input = Input.nextLine();
            if (input.equalsIgnoreCase("Y")) {
                return true;
            } else if ( input.equalsIgnoreCase("N")){
                return false;
            }
            printText("Please Enter a Y or N");
        }
        Input.close();
        return false;
    }
    public String bar(){
        return "\n*********************************************************************************\n";
    }
    public String linebar(){
        return "\n----------------------------------------------------------\n";
    }
    public String sep(){
        return "\n~~~~~~~~~~~~~~~~~~\n";
    }
    public void printText(String txt)
    {
        System.out.println( bar() +txt +bar()) ;
    }
}
