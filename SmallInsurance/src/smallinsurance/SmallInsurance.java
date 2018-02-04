/*
* The program determine the cost of automobile insurance 
* premium for each family member, based on their ages. The basic insurance 
* price is $1,000 per year per person plus an additional amount based on age, 
* per the table below.
*/
/*
* this code use an extra API (Apache Commons Lang 3.5) for the NumberUtils.isDigits methode
* on line 124,153. if not present, the Apache Commons Lang 3.5 jar file must be imported to the lib.
*/
package smallinsurance;

import org.apache.commons.lang3.math.NumberUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * @author Kapanga David 
 * CS55 Asigment 
 * 
 */
public class SmallInsurance {

    static SmallInsurance a =new SmallInsurance();//object created to access field on each methode
    static Scanner sc=new Scanner(System.in);//scanner used in all methode
    private List<String> nameList=new ArrayList<String>();//ArrayList that contain names of family members
    private List<String> ageList=new ArrayList<String>();//ArrayList that contain ages of family members
    private List<String> priceList=new ArrayList<String>();//ArrayList that contain total amount of each family members
    private List<String> messageList=new ArrayList<String>();//ArrayList that contain specific message of each family members
    private int num2;//fied that contain the number of family member
    
    public static void main(String[] args) throws IOException{
            String rep; //this local variable will contain the answer for the do while loop 
                        // that restart the programme
        do{
            System.out.println("*************************************************");
            System.out.println("*     WELCOME TO SMALL INSURANCE CALCULATOR     *");
            System.out.println("*************************************************");
            System.out.println();
            //we set the variable num2, by giving the methode a.enterFamilyNumber()
            //as parameter, the methode return an int
            a.setNum2(a.enterFamilyNumber());
            //we call this methode to set family details (name and age), it takes one int param
            //that int represent the number of member, it will be use for the loop
            a.enterInfo(a.getNum2());
            //this methode calculate the amount for each member, it take one int param
            a.calculatePrice(a.getNum2());
            //this methode show each member's result on the screen 
            a.displayResult(a.getNum2());

            System.out.println();
            System.out.println("*****************************************************");
            System.out.println("*   Thank you for using Small Insurance Calculator  *");
            System.out.println("*****************************************************");
            System.out.println();
            System.out.print("do you want to try with diferent data ? press 'Y' to restart or any key to exit -->: ");
            //checkResp()methode return the user typped key that is use in the do while loop
            rep=a.checkResp();
            System.out.println();
            System.out.println();
        }while(rep.equals("Y")); //end of do while if key pressed was different then y or Y   
    }//end of main methode  
    //getter for name list field
    public List<String> getNameList() {
        return nameList;
    }
    //setter for name list field//
    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }
    //getter for age list field
    public List<String> getAgeList() {
        return ageList;
    }
    //setter for age list field
    public void setAgeList(List<String> ageList) {
        this.ageList = ageList;
    }
    //getter for total amount (price list) field
    public List<String> getPriceList() {
        return priceList;
    }
    //setter for total amount (price list) field
    public void setPriceList(List<String> priceList) {
        this.priceList = priceList;
    }
    //getter for message list field
    public List<String> getMessageList() {
        return messageList;
    }
    //setter for message list field
    public void setMessageList(List<String> messageList) {
        this.messageList = messageList;
    }
    //getter for num2 list field
    public int getNum2()
    {
        return num2;
    }
    //setter for num2 list field
    public void setNum2(int num2)
    {
        this.num2 = num2;
    }
    //enterFamilyNumber() return an integer value get from user
    public int enterFamilyNumber()
    {
        int numreturn=0;
        String num="";//local variable that contain a string value from user
        //a condition test to verify that the string value contain an integer value
        do {
            System.out.print("how many family's members do you have? : ");
            num=sc.nextLine();
            //converting to int value and catching exception if the string value is not int
            //exemple :  num="abc"; WRONG
                       //num="12"; CORRECT
            try {
                numreturn =(int) Integer.parseInt(num);
            } catch (Exception e) {
                //if num value cannot be converted to string exemple "abc", print:
                System.out.println("enter an Integer value for the number of your family's member. ");
            }
        }while(!NumberUtils.isDigits(num));//will ask for number as long as the user enter a string value that is not int
        return numreturn; //return the integer for the family's member number
    }
    public void enterInfo(int num2)
    {
        //creating local list that will contain info to be passed to the setter
        List<String> nameList2=new ArrayList<String>();
        List<String> ageList2=new ArrayList<String>();
        for(int i=0;i<num2;i++)
        {
            String ageString="";
            String name="";
            do {
                
                System.out.print("enter the name "+(i+1)+" : ");
                name=sc.nextLine();
                if(NumberUtils.isDigits(name))
                {
                    System.out.println("the name must be a string value. Please Try again");
                }
            }while(NumberUtils.isDigits(name));//ask for name while the user gives a integer
            nameList2.add(name);//add name to the local list
            do {
                System.out.print("enter " + nameList2.get(i) + "'s age : ");
                ageString = sc.nextLine();
                if(!NumberUtils.isDigits(ageString))
                {
                    System.out.println("age must be in Integer. Please Try again");
                }
            }while(!NumberUtils.isDigits(ageString));//ask for name while the user gives a String
            ageList2.add(ageString);//add age to the local list
        }
        a.setNameList(nameList2);//add local name list to the instance variable list
        a.setAgeList(ageList2);//add local age list to the instance variable list
    }
    public void calculatePrice(int num2)
    {
        //creating local list to perform calcul on it
        List<String> priceList2=new ArrayList<String>();
        List<String> messageList2=new ArrayList<String>();
        List<String> nameList2=new ArrayList<String>();
        List<String> ageList2=new ArrayList<String>();
        ageList2=a.getAgeList();//get the age instance var list to the local
        nameList2=a.getNameList();//get the name instance var list to the local
        for(int i=0;i<num2;i++)//read and calcul price for each index of the list
        {
            int age=(int)Integer.parseInt(ageList2.get(i));//age to be tested
            int additionalFee;//will contain pourcentege according to age range
            int totalAmount;//will contain the final amount
            //testing age, calculate the amount corresponding and setting a specific message
            if(age<16)
            {
                messageList2.add("(the minimun age required is 16. Sorry "+nameList2.get(i)+" you don't meet the requirement)");
                priceList2.add("not cover");
            }
            else if(age>=16 && age<=19)
            {
                additionalFee=15*1000/100;
                totalAmount=1000+additionalFee;
                messageList2.add("(additionnal charge of 15%)");
                priceList2.add(String.valueOf(totalAmount));
            }
            else if(age>=20 && age<=25)
            {
                additionalFee=5*1000/100;
                totalAmount=1000+additionalFee;
                messageList2.add("(additionnal charge of 5%)");
                priceList2.add(String.valueOf(totalAmount));
            }
            else
            {
                additionalFee=10*1000/100;
                totalAmount=1000-additionalFee;
                messageList2.add("(Discount of 10%)");
                priceList2.add(String.valueOf(totalAmount));
            }
        }
        a.setMessageList(messageList2);//add message local list to the instance variable list
        a.setPriceList(priceList2);//add amount local list to the instance variable list
    }
    //display data to screen
    public void displayResult(int num2)
    {
        for(int i=0;i<num2;i++)
        {
            System.out.println("---------------------------------------------------------------------------------------------------------------------");
            System.out.println(a.nameList.get(i)+" is "+ a.ageList.get(i)+" the price per year will be : "+a.priceList.get(i)+" "+a.messageList.get(i));
        }
    }
    //return a capital String 
    public String checkResp()
    {
        String rep=sc.nextLine();
        rep=rep.toUpperCase();
        return rep;
    }

    
}
