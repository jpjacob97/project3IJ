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
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public String toString(Date d1,Date d2){
        ArrayList<SalesItem> invoiceList = null;
        for(SalesItem s: sList){
            if(s.getDate().after(d1)&&s.getDate().before(d2))
                invoiceList.add(s);
        }
        String firstLine = "**************************************************************************************";
        Date now = new Date();
        String secondLine = "Sales Invoice for: "+saName+now+"\n";
        String thirdLine = String.format("|%-25d|", "Part Name")+String.format("|10d|", "Part Number")+String.format("|8d|", "Price")+String.format("|15d|", "Sales Price")+String.format("|5d|", "Qnty")+String.format("|10d|", "Total Cost");
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
                Date dt=stringToDate(pv[2]);
                BikePart bp = new BikePart(pv1[0],Integer.parseInt(pv1[1]),Double.parseDouble(pv1[2]),Double.parseDouble(pv1[3]),pv1[4].equals("true"),Integer.parseInt(pv1[5]));
                SalesItem si = new SalesItem(bp,Integer.parseInt(pv[1]),dt);
                retList.add(si);
            }    
    }
    public void writeIFile() throws FileNotFoundException, UnsupportedEncodingException{
        PrintWriter writer = new PrintWriter(filename, "UTF-8");
        for (SalesItem si : sList)
            writer.println(si); // uses SAlesItem toString()
        writer.close();
    }
    public Date stringToDate(String s){
        Date result=null;
        try{
            SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            result= dateFormat.parse(s);
        }
        catch(ParseException e){
            e.printStackTrace();
        }
        return result;
    }
    
    public double total(ArrayList<SalesItem> si){
        
    }
}
