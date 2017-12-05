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
 * creates a sales associate who has the ability to sell from a warehouse
 * and swap parts in a fleet.
 * @author jariv
 */
public class SalesAss extends User {

    private Invoice sold;
    private WareHouse saWH;
    private Fleet fleet = new Fleet(); //singlton get instance
    /**
     * creates a sales Associate object
     * @param f ALL THE FIELDS OF A USER
     * @param l
     * @param e
     * @param u
     * @param p
     * @param t
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException 
     */
    public SalesAss(String f, String l, String e, String u, String p, String t) throws FileNotFoundException, UnsupportedEncodingException {
        super(f, l, e, u, p, t);
        fillWH(u);

        sold = new Invoice(u);

    }
    /**
     * alternate constructor that takes a user and makes them a sales associate
     * @param u user
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException 
     */
    public SalesAss(User u) throws FileNotFoundException, UnsupportedEncodingException {
        super(u.getFirstName(), u.getLastName(), u.getEmail(), u.getUserName(), u.getPass(), u.getType());
        fillWH(saWH.getName());
    }
    
    /**
     * returns the Warehouse of the sales associate
     * @return warehouse object
     */
    public WareHouse getWH() {
        return saWH;
    }
    
    /**
     * fills the warehouse with the warehouse file info by constructing a warehouse
     * @param WHName
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException 
     */
    public void fillWH(String WHName) throws FileNotFoundException, UnsupportedEncodingException {
        saWH = new WareHouse(WHName);
        //call this every time you open a warehouse manager window
    }
    
//    public void vanSwap(String fileName){
//        fleet.swap(fileName);
//    }

    /**
     * generates an invoice for the sales associate.
     * @param d1 start date
     * @param d2 end date
     * @return String output of invoice
     * @throws FileNotFoundException 
     */
    public String genInvoice(Date d1, Date d2) throws FileNotFoundException {
        return sold.toString(d1, d2);
    }

    /**
     * sells a part from this wareHouse.
     * 
     * @param name
     * @return the part sold.
     */
    public BikePart sell(String pn, int quan) throws FileNotFoundException, UnsupportedEncodingException {
        for (BikePart bp : saWH.getList()) {
            if (bp.getName().equals(pn)) {
                bp.setQuantity(bp.getQuantity() - quan);
                saWH.updateFile();
                //make a new sales item
                Date now = new Date();
                SalesItem newItem = new SalesItem(bp, quan, now);
                sold.add(newItem);
                sold.writeIFile();

                return bp;
            }

        }
        return null;
    }
    
    /**
     * Finds a sales Item in the Sales associates arrayList of items
     * @param sname
     * @return a Sales Item that matches the name passed.
     */
    public SalesItem findSItem(String sname) {
        for (SalesItem s : sold.getSList()) {
            if (s.getBp().getName().equals(sname)) {
                return s;
            }
        }
        return null;
    }
}
