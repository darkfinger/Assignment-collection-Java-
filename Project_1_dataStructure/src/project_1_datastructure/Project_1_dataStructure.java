
package project_1_datastructure;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Project_1_dataStructure {

    /**
     * @param args the command line arguments
     */
        static FileHandler fileHandler=new FileHandler();
    public static void main(String[] args) {
        
        Category letters=new Category("Letters","qwertyuioplkjhgfdsazxcvbnm");
        Category white=new Category("Space  "," ");
        Category digits=new Category("Digits ","0123456789");
        Category other=new Category("Other  ","!@#$%^&*()_-+=~`<,>.?/:;{[}]|\'\"\\");
        
        ArrayList<Category> cat=new ArrayList();
        cat.add(letters);
        cat.add(white);
        cat.add(digits);
        cat.add(other);
        
        CategoryTable catTable=new CategoryTable(cat);
        
        //static FileHandler fileHandler=new FileHandler();
        fileHandler.setmTable(catTable);
        
        Scanner in =new Scanner(System.in);
        System.out.print("Give the full path and name of the file to read : ");
        String fileName=in.nextLine();
        
        //fileHandler.setmFile(fileName);
        fileHandler.readFile(fileName);
        String[] part=fileName.split(Pattern.quote("\\"));
        String nameOfTheFile=part[(part.length)-1];
        System.out.println("Statistic of the file : "+nameOfTheFile);
        System.out.println("----------------------------------------------------");
        System.out.println(fileHandler.dumpResults());
        
        
    }
}
