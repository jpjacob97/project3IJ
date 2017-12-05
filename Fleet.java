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
 * Aggregates the names of warehouses and writes them into an arrayList, 
 * constructing them based on the warehouse files.
 * 
 * @author jacobpetersen
 */
public class Fleet {

    private ArrayList<WareHouse> fleet = new ArrayList();
    private File file = new File("fleet.txt");
    
    /**
     * 'Creates the fleet object.
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException 
     */
    public Fleet() throws FileNotFoundException, UnsupportedEncodingException {
        readFFile();
    }
    
    /**
     * Finds a warehouse based on the string name passed.
     * @param n the name of the wh you are looking for.
     * @return the warehouse object.
     */
    public WareHouse findwh(String n) {
        for (WareHouse wh : fleet) {
            if (wh.getName().equals(n)) {
                return wh;
            }
        }
        return null;
    }
    
    /**
     * Returns the arrayList of warehouses.
     * @return fleet.
     */
    public ArrayList<WareHouse> getFleet() {
        return fleet;
    }

    /**
     * Adds the warehouse passed to the ArrayList of warehouses.
     * @param wh 
     */
    public void addWH(WareHouse wh) {
        fleet.add(wh);
    }
    
    /**
     * Swaps parts between two wareHouses based on the file passed.
     * @param fileName The name of the swap file
     * @throws FileNotFoundException 
     */
    public void swap(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner read = new Scanner(file);

        while (read.hasNextLine()) {
            String line = read.nextLine();

            String[] firstline = line.split(",");

            WareHouse fromWH = findwh(firstline[0]);
            System.out.println(line);
            System.out.println(firstline[0]);
            WareHouse toWH = findwh(firstline[1]);
            while (read.hasNextLine()) {
                String l = read.nextLine();
                String whArray[] = l.split(",");
                String bpName = whArray[0];
                int quan = Integer.parseInt(whArray[1]);
                System.out.println(quan);

                //updates part in toWH
                if (toWH.hasPart(bpName)) {
                    toWH.findPartName(bpName).setQuantity(toWH.findPartName(bpName).getQuantity() + quan);
                    System.out.println();

                } //makes part in toWH
                else {
                    BikePart bp1 = new BikePart(fromWH.findPartName(bpName).getName(), fromWH.findPartName(bpName).getNum(), fromWH.findPartName(bpName).getListPrice(), fromWH.findPartName(bpName).getSalePrice(), fromWH.findPartName(bpName).isOnSale(), quan);
                    System.out.println("thisq");
                    toWH.addPart(bp1);

                }

                //sets quantity of fromWH
                int oldquan = fromWH.findPartName(bpName).getQuantity();
                fromWH.findPartName(bpName).setQuantity(oldquan - quan);
                System.out.println("eleventyfour");
            }
            fromWH.updateFile();
            toWH.updateFile();

        }
    }

    /**
     * Reads the Fleet file into the ArrayList, and constructs all the wareHouses.
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException 
     */
    public void readFFile() throws FileNotFoundException, UnsupportedEncodingException {
        Scanner read = new Scanner(file);

        while (read.hasNextLine()) {
            String line = read.nextLine();
            WareHouse wh = new WareHouse(line);
            fleet.add(wh);
        }
    }

    /**
     * Updates the fleet file bases on the fleet ArrayList.
     * @throws FileNotFoundException 
     */
    public void update() throws FileNotFoundException {
        try {
            PrintWriter writer = new PrintWriter("fleet.txt", "UTF-8");
            for (WareHouse wh : fleet) {
                writer.println(wh.getName());
            }
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Fleet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
