/*
 * the program displays a menu. You can enter 1 for addition, 2 for subtraction, 
 * 3 for multiplication or 4 for division test. 
 * You may choose another test or enter 5 to exit the system. 
 * Each test generates two random single-digit numbers to form a question.
 * For a subtraction such as number1 – number2, number1 is greater than or equal to number2.  
 * For a division question such as number1 / number2, number2 is not zero. 
 */
package mathtutor;

import java.util.*;

/**
 * @author Kapanga David 
 */
public class MathTutor {
    //static variable for scanner
    static Scanner sc=new Scanner(System.in);
    //main method
    public static void main(String[] args) 
    {
        //a is the user choice and it used for the while loop
        int a;
        //will do as long as a(the user choice) is different than 5
        do
        {
            //method that show the main menu
            showMenu();
            //method userChoice()return a int that is assign to a
            a =userChoice();
            //mathOption() method take the user choice as param and generate the
            //test according to the user choice
            mathOption(a);
            //if the user choice was 5 the program stop but if it was another choice
            //the program will show an exit message after the test
            if(a!=5){
            System.out.print("Press 5 to exit or any Key to try again : ");
            a =userChoice2();}
        }while(a!=5);
    }
    public static void mathOption(int a)
    {
        //select an action to do according to th parameter
        switch(a)
        {
            //case of a=1 call addition() method
            case 1:  
                addition();
                break;
            //case of a=1 call soustration() method
            case 2:  
                soustration();
                break;
            //case of a=1 call multiply() method    
            case 3: 
                multiply();
                break;
            //case of a=1 call division() method
            case 4: 
                division();
                break;
            //case of a=1 call exit() method
            default : 
                exit();
                break;
        }
                
    }
    public static void showMenu()
    {
        //display the menu
        System.out.println("----------------------------------");
        System.out.println("- WELCOME TO MATH TUTOR ver. 1.0 -");
        System.out.println("----------------------------------");
        System.out.println("   Main menu");
        System.out.println("   ---------");
        System.out.println(" 1: Addition \n 2: Subtraction \n 3: Multiplication \n 4: Division \n 5: Exit ");
        System.out.println("");
        System.out.print("Make a choce : ");
        
    }
    //this method retun an int between 1 to 5
    public static int userChoice()
    {
        String userChoice;//will contain a string input that will be convert to integer
        //will use it for condition once user 
        //enter a string that can't be convert to no integer 
        Exception exc1=new Exception(),exc2=new Exception();
        int userChoiceInt=0;//converted string that will be return by the method
        //while user gives a value different then 1,2,3,4 or 5
        do{
            //assign user input to variable userChoice
            userChoice=sc.nextLine();
        try
        {
            //try to convert it in int
            userChoiceInt=(int)Integer.parseInt(userChoice);
            //assign a null value to one of exception variable so we can get off the loop
            exc1=null;
        }
        catch(Exception f)
        {
            exc1=f;exc2=f;//assign the same value to both exception variable 
            //so we can remain in the loop while an exception is found
        }
        //if both excption object have same value(means exception found) or if the input is different than 1-5
        //print the error message
        if(exc1==exc2 || (userChoiceInt<1 || userChoiceInt>5))
        {System.out.print("wrong choice, your choice must be between 1-5. Try again : ");
        }
        //while both excption object have same value(means exception found) or if the input is different than 1-5
        //ask for input again       
        }while(exc1==exc2 ||(userChoiceInt<1 || userChoiceInt>5));
        //return the int value between 1-5
        return userChoiceInt;
    }
    //the methode userChoice2 works the same as userChoice methode except that this one accapt
    //string value 
    public static int userChoice2()
    {
        String userChoice;
        int userChoiceInt=0;
        userChoice=sc.nextLine();
        try
        {
            userChoiceInt=(int)Integer.parseInt(userChoice);
        }
        catch(Exception f)
        {
            //if the input value can't be convert to string, we give a default value of 1
            //means if any other key in the keybord is typed user choice will be 1
            //so any key can be pressed to restart the program when asked. 
            userChoiceInt=1;
        }
      
        return userChoiceInt;
    }
    
    public static void addition()
    {
        //giving a rendom number to num1 and num2
        int num1 = (int)(Math.random()*(9-0+1)+0);
        int num2 = (int)(Math.random()*(9-0+1)+0);
        //display the question
        System.err.print("What is "+num1+ " + "+ num2+"? : ");
        //has the answer will be a positive number, we give -1 as default answer 
        //so the do while condition will run as long as userRespInt=-1
        //when user gives a value and there is no exception, that value is asign to 
        //the variable userRespInt, so we can get of the loop
        //otherwise we aske for the user to give an int number 
        int userRespInt=-1;
        do{
            //get input from user as string
            String userChoice=sc.nextLine();
        try
        {
            //converting it to int and asign it to userRespInt
            userRespInt=(int)Integer.parseInt(userChoice);
            
        }
        catch(Exception f)
        {
            //if exception found don't show the error message and keep userRespInt=-1
            System.out.print("enter an Integer Number please : ");
        }
                
        }while(userRespInt<0);
        //now we test if the user input is equal to the result
        if(userRespInt==(num1+num2))
        {
            System.out.println("GOOD ANSWER!!");   
        }
        else
        {
            System.out.println("WRONG ANSWER!!!");
        }
    }
    public static void soustration()
    {   //giving a rendom number to num1 and num2
        int num1 = (int)(Math.random()*(9-0+1)+0);
        int num2 = (int)(Math.random()*(9-0+1)+0);
        //while num1 is less then num2, give a new value
        while(num1<num2)
        {         
            num2 = (int)(Math.random()*(9-0+1)+0);
        }
        //display the question
        System.err.print("What is "+num1+ " - "+ num2+"? : ");
        int userRespInt=-1;
        do{
            //get input from user as string
            String userChoice=sc.nextLine();
        try
        {
            //converting it to int and asign it to userRespInt
            userRespInt=(int)Integer.parseInt(userChoice);
            
        }
        catch(Exception f)
        {
            //if exception found don't show the error message and keep userRespInt=-1
            System.out.print("enter an Integer Number please : ");
        }
                
        }while(userRespInt<0);
         //now we test if the user input is equal to the result
        if(userRespInt==(num1-num2))
        {
            System.out.println("GOOD ANSWER!!");   
        }
        else
        {
            System.out.println("WRONG ANSWER!!!");
        }
    }
    public static void multiply()
    {
        //giving a rendom number to num1 and num2
        int num1 = (int)(Math.random()*(9-0+1)+0);
        int num2 = (int)(Math.random()*(9-0+1)+0);
        //display question
        System.err.print("What is "+num1+ " * "+ num2+"? : ");
        int userRespInt=-1;
        do{
            //getting value from user
            String userChoice=sc.nextLine();
        try
        {
            //converting it to int and asign it to userRespInt
            userRespInt=(int)Integer.parseInt(userChoice);
            
        }
        catch(Exception f)
        {
            //if exception found don't show the error message and keep userRespInt=-1
            System.out.print("enter an Integer Number please : ");
        }
                
        }while(userRespInt<0);
         //now we test if the user input is equal to the result
        if(userRespInt==(num1*num2))
        {
            System.out.println("GOOD ANSWER!!");   
        }
        else
        {
            System.out.println("WRONG ANSWER!!!");
        }
    }
    public static void division()
    {   //giving a rendom number to num1 and num2  
        int num1 = (int)(Math.random()*(9-0+1)+0);
        int num2 = (int)(Math.random()*(9-0+1)+0);
        //check that num2 is equal to 0 then re-asign radom value
        while(num2==0)
        {         
            num2 = (int)(Math.random()*(9-0+1)+0);
        }
        //display question
        System.err.print("What is "+num1+ " / "+ num2+"? : ");
        int userRespInt=-1;
        do{
            //get user value as string
            String userChoice=sc.nextLine();
        try
        {
            //converting it to int and asign it to userRespInt
            userRespInt=(int)Integer.parseInt(userChoice);
            
        }
        catch(Exception f)
        {
            //if exception found don't show the error message and keep userRespInt=-1
            System.out.print("enter an Integer Number please : ");
        }
                
        }while(userRespInt<0);
        //now we test if the user input is equal to the result
        if(userRespInt==(num1/num2))
        {
            System.out.println("GOOD ANSWER!!");   
        }
        else
        {
            System.out.println("WRONG ANSWER!!!");
        }
    }
    public static void exit()
    {
        //the mothod do nothing cause the user choice will be 5
        //the program exit
    }
}
