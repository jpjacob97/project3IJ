/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projtwo;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 * Holds the information for a wareHouse Manager mainly a warehouse to use.
 * @author jacobpetersen
 */
public class WHManager extends User {

    private WareHouse manWH;

    /**
     * constructs a WareHouse object.
     * @param f USER INPUTS
     * @param l
     * @param e
     * @param u
     * @param p
     * @param t
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException 
     */
    public WHManager(String f, String l, String e, String u, String p, String t) throws FileNotFoundException, UnsupportedEncodingException {
        super(f, l, e, u, p, t);
        manWH = new WareHouse(u);

    }

    /**
     * fills the Warehouse based on the file of the warehouse
     * @param WHName
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException 
     */
    public void fillWH(String WHName) throws FileNotFoundException, UnsupportedEncodingException {
        manWH = new WareHouse(WHName);
        //call this every time you open a warehouse manager window
    }

    /**
     * updates the WH
     * @param fileName 
     */
    public void updateWH(String fileName) {
        manWH.read(fileName);
    }

    /**
     * returns the bikePart with the name s.
     * @param s
     * @return 
     */
    public BikePart displayByName(String s) {
        return manWH.findPartName(s);
    }

    /**
     * returns the part with the number n.
     * @param n
     * @return 
     */
    public BikePart displayByNum(int n) {
        return manWH.findPartNum(n);
    }

}
