/*
 * The program reads a string from the keyboard. If the length of the string is 
 * an even number, the program should split the string into two strings of equal length. 
 * If the length of the string is odd, the program split the string into two strings  
 * where the first part has one more character than the second part. 
 * And the program output the two strings created.
 */
package dstring;

import java.util.Scanner;

/*
 * @author Kapanga David 
 */
public class Dstring {

    public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        
        System.out.println("STRING SPLITER Ver1.0");
        System.out.println("----------------------");
        String restart="";
        do{
        System.out.print("Enter your String : ");
        String userImput=sc.nextLine();
        if(userImput.length()>0){
        splitString(userImput);
        }
        else
        {
        System.out.println("You typed nothing. No string to split. :( ");          
        }
        System.out.print("Press 'Y' to try with another String or any other key to exit : ");
        restart=sc.nextLine();
        }while(restart.equalsIgnoreCase("y"));
        
    }
    
    
    public static void splitString(String userImput)
    {
        if(userImput.length()%2==0)
        {
            
            System.out.println("Your String's length is even ");
            String partA=userImput.substring(0, (userImput.length()/2));
            System.out.println("The first part of the string is :  "+partA);
            
            String partB=userImput.substring((userImput.length()/2), userImput.length());
            System.out.println("The Second part of the string is : "+partB);
            
            //in the comment, there is Other way to do this, just exploring other stringBuilder method
            /*
            char[] d=new char[userImput.length()/2];
            userImput.getChars(0, ((userImput.length()/2)), d, 0);
            for(int i=0;i<d.length;i++)
            {
                System.out.print(d[i]);
            }
            System.out.println();
            char[] parB=new char[userImput.length()/2];
            userImput.getChars((userImput.length()/2), userImput.length(), parB, 0);
            for(int i=0;i<d.length;i++)
            {
                System.out.print(parB[i]);
            }
            System.out.println();
            
            */

        }
        else
        {
            System.out.println("Your String's length is odd ");
            String partA=userImput.substring(0, ((userImput.length()+1)/2));
            System.out.println("The first part of the string is :  "+partA);
            
            String partB=userImput.substring((userImput.length()+1)/2, userImput.length());
            System.out.println("The Second part of the string is : "+partB);
            /*
            char[] partA=new char[(userImput.length()+1)/2];
            userImput.getChars(0, ((userImput.length()+1)/2), partA, 0);
            for(int i=0;i<partA.length;i++)
            {
                System.out.print(partA[i]);
            }
            System.out.println();
            char[] partB=new char[(userImput.length()-1)/2];
            userImput.getChars((userImput.length()+1)/2, userImput.length(), partB, 0);
            for(int i=0;i<partB.length;i++)
            {
                System.out.print(partB[i]);
            }
            System.out.println();
            
            */
        }
    }
}
