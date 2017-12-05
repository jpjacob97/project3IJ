/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projtwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Aggregates invoices in order to edit them and display the, performs all
 * functions of an office manager
 * @author jacobpetersen
 */
public class OfficeManager extends User{
    private ArrayList<Invoice> iList = new ArrayList();
    private File file = new File("iList");
    private int min=5;
    Fleet fleet;
    
    /**
     * Creates a fleet that can be used by the manager.
     * @param f firstName
     * @param l lastName
     * @param e Email
     * @param u UserNAme
     * @param p password
     * @param t type office Manager
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException 
     */
    public OfficeManager(String f, String l, String e, String u, String p,String t) throws FileNotFoundException, UnsupportedEncodingException {
        super(f, l, e, u, p,t);
        fleet= new Fleet(); //singlton get instance
    }

    /**
     * adds an invoice to the arrayList of Invoices
     * @param i Invoice to be added
     */
    public void addInvoice(Invoice i){
        iList.add(i);
    }
    
    /**
     * Returns the Bike Part from all the warehouses to be displayed in the controller
     * 
     * @param pn the name of the part to be found
     * @return the part found
     */
    public BikePart displayByName(String pn){
        ArrayList<WareHouse> x=new ArrayList(fleet.getFleet());
        for(WareHouse wh: x){
            return wh.findPartName(pn);
        }
        return null;
    }
    /**
     * Returns the bikePart that matches the number.
     * @param pn
     * @return 
     */
     public BikePart displayByNum(int pn){
        ArrayList<WareHouse> x=new ArrayList(fleet.getFleet());
        for(WareHouse wh: x){
            return wh.findPartNum(pn);
        }
        return null;
    }   

     /**
      * Generates a commission based on an invoice.
      * @param name Name of the SA invoice
      * @param date1 Start date 
      * @param date2 End Date
      * @return The String based on the dates.
      * @throws FileNotFoundException
      * @throws UnsupportedEncodingException 
      */
    public String generateCommission(String name,Date date1, Date date2) throws FileNotFoundException, UnsupportedEncodingException{
        //date stuf
        Invoice i = new Invoice(name);
        return i.toString(date1,date2);
   
    }
    

    
}
