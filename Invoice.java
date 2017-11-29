/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projtwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author jacobpetersen
 */
public class Invoice {
    private ArrayList<SalesItem> sList;
    private String saName;
    File file= new File("iFile"+saName+".txt");
    private String filename="iFile"+saName+".txt";
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
    public void readIFile() throws FileNotFoundException{
        ArrayList<SalesItem> retList=new ArrayList();
        Scanner read = new Scanner(file);
            while (read.hasNextLine()) {
                String line = read.nextLine();
                
                String[] pv = line.split(",");
                String regExp = "\\s*(\\s|,)\\s*";
                String[] pv1 = line.split(regExp);
                BikePart bp = new BikePart(pv1[0],Integer.parseInt(pv1[1]),Double.parseDouble(pv1[2]),Double.parseDouble(pv1[3]),pv1[4].equals("true"),Integer.parseInt(pv1[5]));
                SalesItem si = new SalesItem(bp,Integer.parseInt(pv[1]),pv[2]);
                retList.add(si);
            }    
    }
    public void writeIFile() throws FileNotFoundException, UnsupportedEncodingException{
        PrintWriter writer = new PrintWriter(filename, "UTF-8");
        for (SalesItem si : sList)
            writer.println(si); // uses SAlesItem toString()
        writer.close();
    }
    
}
