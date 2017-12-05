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
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static projtwo.Reader.readFile;
import projtwo.BikePart;
import projtwo.Writer;


/**
 * This class creates and manages warehouses.
 * @author jacobpetersen
 */
public class WareHouse {
    private ArrayList<BikePart> bps=new ArrayList<BikePart>();
    private String wareHouseName;
    private File file;
    
    /**
     * Creates a warehouse object.
     * @param name
     * @throws FileNotFoundException 
     */
    public WareHouse(String name) throws FileNotFoundException, UnsupportedEncodingException{

        //create file object
        file= new File(name);
        wareHouseName=name;
        System.out.println(wareHouseName);
        
        //create file if not there
        if(!file.exists()){
           PrintWriter writer= new PrintWriter(name,"UTF-8");

        }
        //get the arraylist of parts from the existing file
        ArrayList<BikePart> p=readFile(name);
        System.out.println("stuff");
        //set the arraylist
        bps=p;
        System.out.println(bps);
        
    }
    
    /**
     * Adds a part to the arrayList.
     * @param partName 
     */
    public void addPart(BikePart partName){
        bps.add(partName);
        updateFile();
    }
    
    /**
     * Sets the name of the wareHouse.
     * @param n 
     */
    public void setName(String n){
        wareHouseName=n;
    }
    
    /**
     * Sets the arrayList to the list passed.
     * @param bps 
     */
    public void setList(ArrayList<BikePart> bps){
        this.bps=bps;
    }
    
    /**
     * Gets the name of the wareHouse.
     * @return the name
     */
    public String getName(){
        return wareHouseName;
    }
    
    
    /**
     * Gets the list of parts currently in the file.
     * @return  the arrayList of bike parts in the file
     */
    public ArrayList<BikePart> getList(){
        return bps;
    }
    
    /**
     * Updates the file to match the current arrayList.
     */
    public void updateFile(){
        
        Writer.writeFile(wareHouseName,bps);
    }
    
    /**
     * Returns the part that matches the name passed.
     * @param s name of the part you are looking for.
     * @return BikePart
     */
    public BikePart findPartName(String s){
        for(BikePart bp: bps){
            if(bp.getName().equals(s))
                return bp;
        }
        return null;
    }
    
    /**
     * Returns the part that matches the number passed.
     * @param n number of the part you are looking for.
     * @return BikePart that matches number.
     */
    public BikePart findPartNum(int n){
        for(BikePart bp: bps){
            if(bp.getNum()==n)
                return bp;
        }
        return null;
    }
    
    /**
     * Performs the reading function for an inventory file.
     * @param fileName name of an inventory file
     * @return String success message.
     */
    public String read(String fileName){
        String out="";
        ArrayList<BikePart> bps= new ArrayList(Reader.readFile(wareHouseName));
        ArrayList<BikePart> parts= new ArrayList(Reader.readFile(fileName));
        System.out.println(parts);
        System.out.println(bps);
        if(bps.isEmpty()){
            Writer.writeFile(wareHouseName, parts);
            return("successfully created");
        }
        else{
            Writer.updateFile(wareHouseName, parts);
            return("successfully updated");
        }

    }
    
    /**
     * Sorts the parts in the arrayList by name using lambda expression.
     */
    public void sortByName(){
        Collections.sort(bps, (BikePart bp1, BikePart bp2) -> bp1.getName().compareToIgnoreCase(bp2.getName()));
    }
    
    /**
     * Sorts parts by number
     */
    public void sortByNum(){
        Collections.sort(bps);
    }
    
    /**
     * Returns true if the part is in the arrayList
     * @param bp part you are looking for
     * @return boolean
     */
    public boolean hasPart(BikePart bp){
        if (bps.contains(bp))
            return true;
        return false;
    }  
    
    /**
     * Returns true if the part with that name is in the list.
     * @param bpname name of part you are looking for
     * @return  boolean.
     */
    public boolean hasPart(String bpname){
        for(BikePart bp: bps){
            if(bp.getName().equals(bpname)){
                return true;
            }
        }
        
        return false;
    } 
    
    /**
     * Returns true if the part is in the list
     * @param bpname the part number
     * @return 
     */
    public boolean hasPart(int num){
        for(BikePart bp: bps){
            if(bp.getNum()==(num)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Returns the string that is used to output the warehouse and it's parts.
     * @return 
     */    
    public String printWH(){
        String out = "WareHouse Name: "+ wareHouseName+"\n";
        for(BikePart bp: bps){
            out+= bp.toString()+"\n";
        }
        return out;
    }
    
    /**
     * Writes the name of the wh to the fleet file.
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException 
     */
    public void writeToFleet() throws FileNotFoundException, UnsupportedEncodingException{

        ArrayList<String> retList = new ArrayList();
        File f= new File("fleet.txt");
        Scanner read = new Scanner(f);
        System.out.println(f.getName());
        
        while (read.hasNextLine()) {
            retList.add(read.nextLine());
        }
        PrintWriter p= new PrintWriter("fleet.txt","UTF-8");
        for(String s:retList){
            p.println(s);
        }
        p.println(wareHouseName);
        p.close();
    }
                    
}

    
