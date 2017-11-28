/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projtwo;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static projtwo.Reader.readFile;
import projtwo.BikePart;
import projtwo.Writer;


/**
 *This class creates and manages warehouses.
 * @author jacobpetersen
 */
public class WareHouse {
    private ArrayList<BikePart> bps=new ArrayList<BikePart>();
    private String wareHouseName;
    private File file;
    
    /**
     * creates a warehouse object.
     * @param name
     * @throws FileNotFoundException 
     */
    public WareHouse(String name) throws FileNotFoundException{
        //create file object
        file= new File(name);
        wareHouseName=name;
        //get the arraylist of parts from the existing file
        ArrayList<BikePart> p=new ArrayList<BikePart>(readFile(name));
        //set the arraylist
        bps=p;
        
    }
    
    /**
     * adds a part to the arrayList.
     * @param partName 
     */
    public void addPart(BikePart partName){
        bps.add(partName);
    }
    
    /**
     * sets the name of the wareHouse.
     * @param n 
     */
    public void setName(String n){
        wareHouseName=n;
    }
    
    /**
     * sets the arrayList to the list passed.
     * @param bps 
     */
    public void setList(ArrayList<BikePart> bps){
        this.bps=bps;
    }
    
    /**
     * gets the name of the wareHouse.
     * @return the name
     */
    public String getName(){
        return wareHouseName;
    }
    
    /**
     * sells a part from this wareHouse.
     * @param name
     * @return the part sold.
     */
    public BikePart sell(int num){
        BikePart x= new BikePart("this",10,10,10,true,10);
        for(BikePart bp:bps){
            if(num==bp.getNum()){
                bp.setQuantity(bp.getQuantity() -1);
                updateFile();
                return bp;
            }
            
        }
        return x;
    }
    
    /**
     * gets the list of parts currently in the file.
     * @return  the arrayList of bike parts in the file
     */
    public ArrayList<BikePart> getList(){
        return bps;
    }
    
    /**
     * updates the file to match the current arrayList.
     */
    public void updateFile(){
        
        Writer.writeFile(wareHouseName,bps);
    }
    public BikePart findPartName(String s){
        for(BikePart bp: bps){
            if(bp.getName().equals(s))
                return bp;
        }
        return null;
    }
    
    public BikePart findPartNum(int n){
        for(BikePart bp: bps){
            if(bp.getNum()==n)
                return bp;
        }
        return null;
    }
    public String read(String fileName){
    String out="";
    System.out.print("Enter the name of the file you would like to read:");
    ArrayList<BikePart> bps= new ArrayList(Reader.readFile(wareHouseName+".txt"));
    ArrayList<BikePart> parts= new ArrayList(Reader.readFile(fileName));
    if(bps.isEmpty()){
        Writer.writeFile("warehouseDB.txt", parts);
        return("successfully created");
    }
    else{
        Writer.updateFile("warehouseDB.txt", parts);
        return("successfully updated");
    }

    }
    
    public void sortByName(){
        Collections.sort(bps, new Comparator<BikePart>(){
                @Override
                public int compare(BikePart bp1, BikePart bp2) {
                    return bp1.getName().compareToIgnoreCase(bp2.getName());
                }
                });
    }
    
    public void sortByNum(){
        Collections.sort(bps);
    }
    
}

    

