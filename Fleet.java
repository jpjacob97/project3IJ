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
       public ArrayList getFleet(){
           return fleet;
       }
       public void addWH(WareHouse wh){
           fleet.add(wh);
       }
       public void swap(String fileName){
        try {
            File file = new File(fileName);
            Scanner fileRead=new Scanner(file);
            String whs=fileRead.nextLine();
            List<String> whl = Arrays.asList(whs.split(","));
            System.out.println(whl);
            String loser=whl.get(0);
            String gainer=whl.get(1);
            WareHouse l=new WareHouse(loser);
            WareHouse g=new WareHouse(gainer);
            ArrayList<BikePart> lose=new ArrayList<>(l.getList());
            ArrayList<BikePart> gain=new ArrayList<>(g.getList());
            while (fileRead.hasNextLine()){
                boolean found=false;
                String namePart=fileRead.nextLine();
                List<String> nameNum = Arrays.asList(namePart.split(","));
                String partName=nameNum.get(0);
                Integer num= Integer.parseInt(nameNum.get(1));
                for(BikePart bp:gain){
                    if (partName.equals(bp.getName())){
                        bp.setQuantity(bp.getQuantity()+num);
                        found=true;
                    }

                    
                }
                for(BikePart bp:lose){
                    
                    if (partName.equals(bp.getName())){
                        bp.setQuantity(bp.getQuantity()-num);

                    }
                    if (found==false && (partName.equals(bp.getName()))){
                        BikePart x= new BikePart(bp.getName(),bp.getNum(),bp.getListPrice(), bp.getSalePrice(),bp.isOnSale(),num);
                        gain.add(x);
                        found=true;
                    }

                    
                }

            }
            l.setList(lose);
            g.setList(gain);
            l.updateFile();
            g.updateFile();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
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
