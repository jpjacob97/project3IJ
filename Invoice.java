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
    private ArrayList<Sale> sList;
    private String saName;
    File file;
    public String getSA(){
        return saName;
    }
    public String toString(Date d1,Date d2){
        return null;
        // the project.
    }    
    public void add(Sale s){
        sList.add(s);
    }
    public void readIFile(){
        //reading the file
    }
    public void writeIFile(){
        //updating the file after sales
    }
}
