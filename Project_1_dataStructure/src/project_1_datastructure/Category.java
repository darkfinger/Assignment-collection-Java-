
package project_1_datastructure;

import static project_1_datastructure.Project_1_dataStructure.fileHandler;


public class Category {
    
    private String mName;
 private int mHowMany;
private String mCriteriaMatch;

public Category(){}

public Category(String Name, String CriteriaMatch)
{
    this.setmName(Name);
    this.setmCriteriaMatch(CriteriaMatch);
}
    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmHowMany() {
        return mHowMany;
    }

    public void setmHowMany(int mHowMany) {
        this.mHowMany = mHowMany;
    }

    public String getmCriteriaMatch() {
        return mCriteriaMatch;
    }

    public void setmCriteriaMatch(String mCriteriaMatch) {
        this.mCriteriaMatch = mCriteriaMatch;
    }

public boolean characterMatchesCriteria(char ac)
{
    boolean criteriaMatch=false;
    char[] criteria=this.getmCriteriaMatch().toCharArray();
        
    for(int k=0;k<this.getmCriteriaMatch().length();k++)
    {
        if(String.valueOf(ac).equalsIgnoreCase(String.valueOf(criteria[k])))
        {
            criteriaMatch=true;
            break;
        }
        else
        {          
            criteriaMatch=false;
        }
    } 
    return criteriaMatch;
}
public void incrementHowMany()
{
    int hm=this.getmHowMany();
    hm++;
    this.setmHowMany(hm);
}
public void clearHowMany()
{
    this.setmHowMany(0);
}
}
