/*
 * the program determine how many time each letter is repeated in a sentence gives by the user
 */
package catchletter;
import java.lang.reflect.Array;
import java.util.Scanner;

/**
 * @author Kapanga David 
 */
public class CatchLetter {
    //scanner variable to get the input from user
    static Scanner sc=new Scanner(System.in);
    static int c=0,i,j,k,l;//c used for counting and ijkl for loops
    static int [] upper=new int[26];//array will countain upper case counting
    static int [] lower=new int[26];//array will countain lower case counting
    
    public static void main(String[] args) {
        //uper and lower array that will display letters
        String [] upperAlphabet={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        String [] lowerAlphabet={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        //getting string from user
        System.out.print("Input string is : ");
        String string =sc.nextLine();
        //calling the method countletter() with a string as parameter, it will count letter and asign the
        // number into the apropriate arrsy (upper or lower)
        countletter(string);
        //display both alphabet array and counting array corresponding
        for(int d=0;d<26;d++)
        {
        System.out.print(upperAlphabet[d]+":"+upper[d]+" ");        
        }
        System.out.println();
        for(int d=0;d<upper.length;d++)
        {       
        System.out.print(lowerAlphabet[d]+":"+ lower[d]+" ");
        }
        System.out.println();
    }
    
    //this methode has 2 param(the letter and the number of time it has been reapeted)
    static void putInUpper(char letter, int num)
    {
        //assign value of num in the corresponding index in the upper array
        switch(letter)
        {
            case 'A':
                upper[0]=num;
                break;
            case 'B':
                upper[1]=num;break;
            case 'C':
                upper[2]=num;break;
            case 'D':
                upper[3]=num;break;
            case 'E':
                upper[4]=num;break;
            case 'F':
                upper[5]=num;break;
            case 'G':
                upper[6]=num;break;
            case 'H':
                upper[7]=num;break;
            case 'I':
                upper[8]=num;break;
            case 'J':
                upper[9]=num;break;
            case 'K':
                upper[10]=num;break;
            case 'L':
                upper[11]=num;break;
            case 'M':
                upper[12]=num;break;
            case 'N':
                upper[13]=num;break;
            case 'O':
                upper[14]=num;break;
            case 'P':
                upper[15]=num;break;
            case 'Q':
                upper[16]=num;break;
            case 'R':
                upper[17]=num;break;
            case 'S':
                upper[18]=num;break;
            case 'T':
                upper[19]=num;break;
            case 'U':
                upper[20]=num;break;
            case 'V':
                upper[21]=num;break;
            case 'W':
                upper[22]=num;break;
            case 'X':
                upper[23]=num;break;
            case 'Y':
                upper[24]=num;break;
            case 'Z':
                upper[25]=num;break;
        }
    }
    //this methode has 2 param(the letter and the number of time it has been reapeted)
    static void putInLower(char letter, int num)
    {
        //assign value of num in the corresponding index in the lower array
        switch(letter)
        {
            case 'a':
                lower[0]=num;
                break;
            case 'b':
                lower[1]=num;break;
            case 'c':
                lower[2]=num;break;
            case 'd':
                lower[3]=num;break;
            case 'e':
                lower[4]=num;break;
            case 'f':
                lower[5]=num;break;
            case 'g':
                lower[6]=num;break;
            case 'h':
                lower[7]=num;break;
            case 'i':
                lower[8]=num;break;
            case 'j':
                lower[9]=num;break;
            case 'k':
                lower[10]=num;break;
            case 'l':
                lower[11]=num;break;
            case 'm':
                lower[12]=num;break;
            case 'n':
                lower[13]=num;break;
            case 'o':
                lower[14]=num;break;
            case 'p':
                lower[15]=num;break;
            case 'q':
                lower[16]=num;break;
            case 'r':
                lower[17]=num;break;
            case 's':
                lower[18]=num;break;
            case 't':
                lower[19]=num;break;
            case 'u':
                lower[20]=num;break;
            case 'v':
                lower[21]=num;break;
            case 'w':
                lower[22]=num;break;
            case 'x':
                lower[23]=num;break;
            case 'y':
                lower[24]=num;break;
            case 'z':
                lower[25]=num;break;
        }
    }
    
    static void countletter(String str)
    {        
        //creating a char array that will contain the same letter inside the string given by the user
        char[] charArray=new char[str.length()];
        //assigning letters of the given string to the char array
        for(l=0;l<str.length();l++)
        charArray[l]=str.charAt(l);
        //now we remove every reapeted letter from the char array
        //we will keep unique letters, so each of those letter will be compare to the string and 
        //count how many time each is reapeted
        for(i=0;i<l;i++)
        {
            char ch=charArray[i];
            for(j=i+1;j<l;j++)
            {
                if(charArray[j]==ch)
                {
                    for(k=j;k<(l-1);k++)
                    charArray[k]=charArray[k+1];
                    l--;
                    j=i;
                }
            }
        }
        //now comparing the char array of unique character to the string given letters
       for(i=0;i<l;i++)
        {
            for(j=0,c=0;j<str.length();j++)
            {
                //if letter in index i of char array is found in index j of the String, incriment by 1
                if(charArray[i]==str.charAt(j))
                c++;
            }
            //and if the letter in index i of char array is uppercase 
            if(Character.isUpperCase(charArray[i]))
            {
                //call putInUpper() with the letter and the total time found
                putInUpper(charArray[i],c);
            }
            //if is lower
            else
            {
                //call putInLower() with the letter and the total time found
                putInLower(charArray[i],c);
            }
        }
        
    }   
}