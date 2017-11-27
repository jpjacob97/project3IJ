/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projtwo;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jacobpetersen
 */
public class Invoice {
    private ArrayList<SalesItem> sList;
    private String saName;
    File file;
    public String getSA(){
        return saName;
    }
    public String toString(String d1,String d2){
        //make the dates.
        return null;
        // the project.
    }    
    public void add(SalesItem s){
        sList.add(s);
    }
    public void readIFile(){
        //reading the file
    }
    public void writeIFile(){
        //updating the file after sales
    }
    
}
