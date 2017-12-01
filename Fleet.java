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
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jacobpetersen
 */
public class Fleet {
       private ArrayList<WareHouse> fleet;
       private File file=new File("fleet.txt");
       public Fleet() throws FileNotFoundException{
           readFFile();
       }
       public WareHouse findwh(String n){
           for(WareHouse wh: fleet){
               if(wh.getName().equals(n)){
                   return wh;
               }
           }
           return null;
       }
       public ArrayList<WareHouse> getFleet(){
           return fleet;
       }
       public void addWH(WareHouse wh){
           fleet.add(wh);
       }
      public void swap(String fileName){
          Scanner read =new Scanner(fileName);
        
          while (read.hasNextLine()){
              String line=read.nextLine();
             
              String firstline[] =line.split(",");
              
              WareHouse fromWH= findwh(firstline[0]);
              WareHouse toWH= findwh(firstline[1]);
              while(read.hasNextLine()){
                String l=read.nextLine();
                String whArray[] =line.split(",");
                String bpName=whArray[0];
                int quan=Integer.parseInt(whArray[1]);

                
                
                if(toWH.hasPart(fromWH.findPartName(bpName))){
                    toWH.findPartName(bpName).setQuantity(toWH.findPartName(bpName).getQuantity()+quan);
                    
                }
                else{
                    BikePart bp1 = fromWH.findPartName(bpName);
                    
                    
                    bp1.setQuantity(bp1.getQuantity()+quan);
                    toWH.addPart(bp1);
                    
                }
                
                
                fromWH.findPartName(bpName).setQuantity(fromWH.findPartName(bpName).getQuantity()-quan);
              }
              fromWH.updateFile();
              toWH.updateFile();
              
              
              
          }
      }
    public void readFFile() throws FileNotFoundException{
            Scanner read = new Scanner(file);

            while (read.hasNextLine()) {
                String line = read.nextLine();
                WareHouse wh=new WareHouse(line);
                fleet.add(wh);
            }    
    }

    public void update() throws FileNotFoundException{
        try {
            PrintWriter writer = new PrintWriter("fleet.txt", "UTF-8");
            for(WareHouse wh: fleet){
                writer.println(wh.getName());
             }
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Fleet.class.getName()).log(Level.SEVERE, null, ex);
     }
    }
       
      
}
