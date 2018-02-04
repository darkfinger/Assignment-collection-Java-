/*
 */
package palindrome;

import java.util.Scanner;

/**
 * @author David Kapanga
 */
public class Palindrome {

   public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        boolean palidromeStatus=false;
        String restart="";
        System.out.println("PALINDROME CHECKER Ver1.0");
        System.out.println("--------------------------");        
        do{
        System.out.print("Please give me your String : ");        
        StringBuilder userImput=new StringBuilder(sc.nextLine());
        palidromeStatus=palindromeFinder(userImput,palidromeStatus );
        System.out.println();
        DisplayResult(palidromeStatus );
        System.out.println();
        System.out.print("Press 'Y' to try with another String or any other key to exit : ");
        restart=sc.nextLine();
        }while(restart.equalsIgnoreCase("y"));
    }
    
    public static boolean palindromeFinder(StringBuilder userImput,boolean palidromeStatus )
    {
        if(userImput.toString().equalsIgnoreCase(userImput.reverse().toString()))
        {            
            palidromeStatus=true;
        }
        else
        {
            palidromeStatus=false;
        }
        
        return palidromeStatus;
    }
    public static void DisplayResult(boolean palidromeStatus )
    {
        if(palidromeStatus)
        {            
            System.out.println(" YES!!, It is a palindrome");
            
        }
        else
        {
            System.out.println(" NO!!, It is Not a palindrome");
         
        }
    }
}
