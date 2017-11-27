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
    
    
    public SalesAss(String f, String l, String e, String u, String p){
        super(f,l,e,u,p);
    }
    public void loadWH(String fileName){
        
    }

        public void fillWH(String WHName) throws FileNotFoundException{
        saWH=new WareHouse(WHName);
        //call this every time you open a warehouse manager window
    }
    public void vanSwap(String fileName){
        fleet.swap(fileName);
    }
    public String genInvoice(Date d1,Date d2){
        return sold.toString(d1,d2);
    }
    public BikePart Sell(int num, int quan){
        for(int i=0;i<quan;i++ ){
            saWH.findPartNum(num).setQuantity(saWH.findPartNum(num).getQuantity()-1);
            
        }
        return saWH.findPartNum(num);
    }
}
