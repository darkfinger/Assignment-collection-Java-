
package project_1_datastructure;

import java.util.ArrayList;


public class CategoryTable {
    private ArrayList<Category> mCategories;
    private int mTotalNumberOfCategorie;

    public CategoryTable(ArrayList<Category> Categories) {
        this.mCategories = Categories;
        int size=Categories.size();
        this.setmTotalNumberOfCategorie(size);
    }
    
    

    public ArrayList<Category> getmCategories() {
        return mCategories;
    }

    public void setmCategories(ArrayList<Category> mCategories) {
        this.mCategories = mCategories;
    }

    public void setmTotalNumberOfCategorie(int num) {
        this.mTotalNumberOfCategorie = num;
    }


public void addCategory( String name, String criteria)
{
    Category cat=new Category(name,criteria);
    mCategories.add(cat);
}
public void processString(String data)
{
     char dataChar[]=data.toCharArray();
     for(int i=0;i<data.length();i++)
        {
             for(int j=0;j<Project_1_dataStructure.fileHandler.getmTable().getmCategories().size();j++)
                {
                    if(Project_1_dataStructure.fileHandler.getmTable().getCategory(j).characterMatchesCriteria(dataChar[i]))
                    {
                        Project_1_dataStructure.fileHandler.getmTable().getCategory(j).incrementHowMany();
                    }                        
                } 
        }
}
public void clearAllCategories()
{
    mCategories.clear();
}

public int getTotalNumberOfCategories()
{
    this.mTotalNumberOfCategorie=mCategories.size();
    return mTotalNumberOfCategorie;
}
public Category getCategory(int i)
{
    Category cat=new Category();
    cat=mCategories.get(i);    
    return cat;
}
    
}
