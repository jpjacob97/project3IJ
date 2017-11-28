/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projtwo;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author jacobpetersen
 */
public class OfficeManager extends User{
    private ArrayList<Invoice> iList;
    private File file = new File("iList");
    private int min=5;
    private Fleet fleet= new Fleet(); //singlton get instance
    

    public OfficeManager(String f, String l, String e, String u, String p) {
        super(f, l, e, u, p);
    }
    public void fillInvoices(){
        //fill ilist by reading the contents of file and getting the invoice
        //info from the nvoice file
    }
    public void addInvoice(Invoice i){
        iList.add(i);
    }
    public BikePart displayByName(String pn){
       
        for(WareHouse wh: fleet){
            return wh.findPartName(pn);
        }
        return null;
    }
     public BikePart displayByName(int pn){
       
        for(WareHouse wh: fleet){
            return wh.findPartNum(pn);
        }
        return null;
    }   
     public void setMin(){
         
     }
    public Boolean checkWHMIn(){ return null;
        //in controller if true
    }
    public WareHouse findLow(){return null;
        //return the warehouse that needs more stuff.
    }
    public String generateCommission(String name,String date1, String date2){
        //date stuff
        for (Invoice i:iList){
            if (i.getSA().equals(name)){
                i.toString();
            }
        }
    }

    
}
