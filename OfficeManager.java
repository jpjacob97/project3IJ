/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projtwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jacobpetersen
 */
public class OfficeManager extends User{
    private ArrayList<Invoice> iList;
    private File file = new File("iList");
    private int min=5;
    Fleet fleet;
    

    public OfficeManager(String f, String l, String e, String u, String p) throws FileNotFoundException {
        super(f, l, e, u, p);
        fleet= new Fleet(); //singlton get instance

    }
    public void fillInvoices(){
        //fill ilist by reading the contents of file and getting the invoice
        //info from the nvoice file
    }
    public void addInvoice(Invoice i){
        iList.add(i);
    }
    public BikePart displayByName(String pn){
        ArrayList<WareHouse> x=new ArrayList(fleet.getFleet());
        for(WareHouse wh: x){
            return wh.findPartName(pn);
        }
        return null;
    }
     public BikePart displayByNum(int pn){
        ArrayList<WareHouse> x=new ArrayList(fleet.getFleet());
        for(WareHouse wh: x){
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
    public String generateCommission(String name,Date date1, Date date2){
        //date stuff
        for (Invoice i:iList){
            if (i.getSA().equals(name)){
                return i.toString(date1,date2);
            }
     
        }
        return null;
    }
    

    
}
