package cml;

import java.util.Scanner;

/** New class that will collect everything that commandlineinterface will need to run **/
public class cmlTools {



    public cmlTools(){

    }
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
