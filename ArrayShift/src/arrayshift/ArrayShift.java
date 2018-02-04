/*
 * the program allows users to input an integer for the size of an array. 
 * the generate integers value randomly for each index of the array. after that the user has
 * the option to chose wich direction to rotate the array and for how many index away
 */
package arrayshift;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Kapanga David 
 */
public class ArrayShift {
    //static scanner to be used for input
    static Scanner sc=new Scanner(System.in);
    //main method
    public static void main(String[] args) {
        //ask for array index to user and store it in the variable a
        System.out.print("Enter the number of slots needs in the array: ");
        int a=getInt();
        //calling creatArray()with integer parameter that represent the size of the array to be created
        // it return an array that is asign to the array initialArray.
        int[] initialArray =createArray(a);
        //calling display() that takes an array as parameter and show elements of that array
        display(initialArray);
        System.out.println();
        //ask user for rotation direction by calling getDir(). it return "r" or "l" and asign the value 
        //into the variable direction
        System.out.print("Which direction to shift R/L : ");
        String direction=getdir();
        //asign the number of time in the var a
        System.out.print("How many times: ");
        a=getInt();
        //rotateArray() takes 3 param (the array to be rotated, the direction of rotation, and the number of time)
        //it returns a rotated array that is asign into the array rotatedArray[]
        int[] rotatedArray=rotateArray(initialArray,direction,a);
        //display the new array by calling the display method 
        System.out.println("the array after rotation is : ");
        display(rotatedArray);        
        System.out.println();
    }
    public static int[] rotateArray(int[] arr,String dir,int xtime)
    {
        //array will contain the new rotated array
        int[]rotatedArray=new int[arr.length];
        //if "l" is found in direction parameter
        if(dir.equalsIgnoreCase("l"))
        {
            for(int i=0;i<arr.length;i++)
            {
                //if i-xtime>=0 means we still have a correct index
                if((i-xtime)>=0)
                {
                    //take the value in the index i of arr and asign it into the array rotatedArray
                    // at the index i-xtime
                rotatedArray[i-xtime]=arr[i];       
                }
                //else the index is <0  the value has to be send at the end side
                else
                {
                    //take the value in the index i of arr and asign it into the array rotatedArray
                    // at the index (i-xtime)+(arr.length)
                    //example if i=0 array size=4, i-1=-1(invalid index) so will move it to end side
                    //(i-1)+(4)=3
                   rotatedArray[((i-xtime)+(arr.length))]=arr[i];
                }
            }
        }
        //if different then l found, means r
        else
        {
            for(int i=0;i<arr.length;i++)
            {
                //if i+xtime<=size of array means we still have a correct index
                if(i+xtime<=arr.length-1)
                {
                    //take the value in the index i of arr and asign it into the array rotatedArray
                    // at the index i+xtime
                rotatedArray[i+xtime]=arr[i];       
                }
                //else the index is >size of array  the value has to be send at the beganing side
                else
                {
                    //take the value in the index i of arr and asign it into the array rotatedArray
                    // at the index (i+xtime)-(arr.length)
                    //example if i=3 array size=4, 3+1=4(invalid index) so will move it to beganing side
                    //(i+1)-(4)=0
                   rotatedArray[((i+xtime)-(arr.length))]=arr[i];
                }
            }
        }
        //return the rotated array
        return rotatedArray;
    }
    public static void display(int[] arr)
    {
        //using a loop with the size of arr parameter and display the array passed
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" | ");
        } 
    }
    public static int[] createArray(int indx)
    {
        //creat an array with the size of parameter sent
        int[] generatedArray=new int[indx];
        //generate random numbers and insertion of those number in the array
        for(int i=0;i<generatedArray.length;i++)
        {
            int num = (int)(Math.random()*(100-0+1)+0);
            generatedArray[i]=num;
        }
        //return the array with generated numbers
        return generatedArray;
    }
    public static int getInt()
    {
        String userInput;//will contain a string input that will be convert to integer       
        Exception exc1=new Exception(),exc2=new Exception();//will use it for condition once user //enter a string that can't be convert to no integer 
        int intValue=0;//will contain the converted string that will be return by the method        
        do{
            //assign user input to variable userInput
            userInput=sc.nextLine();
        try
        {
            //try to convert it to int
            intValue=(int)Integer.parseInt(userInput);
            //assign a null value to one of exception variable so we can get off the loop
            exc1=null;
        }
        catch(Exception f)
        {
            System.out.print("wrong input, your choice must be an Integer value. Try again : ");
            exc1=f;exc2=f;//assign the same value to both exception variable 
            //so we can remain in the loop while an exception is found
        }
        //while both excption object have same value(means exception found)
        //remain in the loop       
        }while(exc1==exc2);
        //return the int value between
        return intValue;
    }
    public static String getdir()
    {
        String userInput;//string will store user input
        do{
            //assign user input to variable userInput
            userInput=sc.nextLine();
            //if the user pres r,R,l or L return it otherwise asign "error" to userInput
            // and ask user to re-enter value
            if(userInput.equalsIgnoreCase("r")||userInput.equalsIgnoreCase("l"))
            {
                return userInput;
            }
            else
            {
                System.out.print("wrong action. Chose r(R) for right or l(L) for left : ");
                userInput="error";
            }      
        }while(userInput.equals("error"));//do it while error is found in userInput
        return userInput;//return the direction
    }    
}
