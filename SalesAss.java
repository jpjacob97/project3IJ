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
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jariv
 */
public class SalesAss extends User{
    
    private Invoice sold;
    private WareHouse saWH;
    private Fleet fleet= new Fleet(); //singlton get instance
    
    
    public SalesAss(String f, String l, String e, String u, String p) throws FileNotFoundException{
        super(f,l,e,u,p);
        fillWH(u);
        sold = new Invoice(u);
    }
    
    public SalesAss(User u) throws FileNotFoundException{
        super(u.getFirstName(),u.getLastName(),u.getEmail(),u.getUserName(),u.getPass());
        fillWH(saWH.getName());
    }
    
    
    
    
    
    public void loadWH(String fileName){
        
    }

    public void fillWH(String WHName) throws FileNotFoundException{
        saWH=new WareHouse(WHName);
        //call this every time you open a warehouse manager window
    }
//    public void vanSwap(String fileName){
//        fleet.swap(fileName);
//    }
    public String genInvoice(Date d1,Date d2){
        return sold.toString(d1,d2);
    }
    
    /**
     * sells a part from this wareHouse.
     * @param name
     * @return the part sold.
     */
    public BikePart sell(String pn, int quan) throws FileNotFoundException, UnsupportedEncodingException{
        for(BikePart bp:saWH.getList()){
            if(bp.getName().equals(pn)){
                bp.setQuantity(bp.getQuantity() -quan);
                saWH.updateFile();
                //make a new sales item
                Date now = new Date();
                SalesItem newItem = new SalesItem(bp,quan,now);
                sold.add(newItem);
                sold.writeIFile();
                
                return bp;
            }
            
        }
        return null;
    }
    
    public SalesItem findSItem(String sname){
        for(SalesItem s:sold.getSList()){
            if(s.getBp().getName().equals(sname)){
                return s;
            }
        }
        return null;
    }
}
