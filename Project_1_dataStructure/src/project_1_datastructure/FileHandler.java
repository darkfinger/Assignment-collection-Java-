
package project_1_datastructure;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileHandler {
    
    private String mFile;
    private CategoryTable mTable;

    public String getmFile() {
        return mFile;
    }

    public void setmFile(String mFile) {
        this.mFile = mFile;
    }

    public CategoryTable getmTable() {
        return mTable;
    }

    public void setmTable(CategoryTable mTable) {
        this.mTable = mTable;
    }
    
    public void readFile( String filePath)
    {
        BufferedReader br = null;
	FileReader fr = null;

		try {

			//br = new BufferedReader(new FileReader(FILENAME));
			fr = new FileReader(filePath);
			br = new BufferedReader(fr);

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
                            
                            if(this.getmFile()==null)
                            {
                                this.mFile=sCurrentLine+"\n";
                            }
                            else{
                                this.mFile+=sCurrentLine+"\n";
                            }
				//System.out.println(sCurrentLine);
			}

                    } catch (IOException e) {

			e.printStackTrace();

                    } finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

                    }               

    }
    public String dumpResults()
    {
        String out;
        Project_1_dataStructure.fileHandler.getmTable().processString(this.getmFile());
        
        int numberOfChar=this.getmFile().length();
        out="Total # of characters in file: "+numberOfChar+"\n";
        out+="Category   "+"     "+"number      "+"     "+" % "+"\n";
        for(int i=0;i<Project_1_dataStructure.fileHandler.getmTable().getmCategories().size();i++)
        {
            out+=Project_1_dataStructure.fileHandler.getmTable().getCategory(i).getmName()
                    +"          "
                    +Project_1_dataStructure.fileHandler.getmTable().getCategory(i).getmHowMany()
                    +"               "
                    +(Project_1_dataStructure.fileHandler.getmTable().getCategory(i).getmHowMany()*100)/this.getmFile().length()+"%\n";
        
        }
        
        return out;
    }
}
