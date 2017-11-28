/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projtwo;

import java.io.FileNotFoundException;

/**
 *
 * @author jacobpetersen
 */
public class WHManager extends User {
    private WareHouse manWH;
    

    public WHManager(String f, String l, String e, String u, String p) {
        super(f, l, e, u, p);
        
    }
    public void fillWH(String WHName) throws FileNotFoundException{
        manWH=new WareHouse(WHName);
        //call this every time you open a warehouse manager window
    }
    public void updateWH(String fileName){
        manWH.read(fileName);
    }
    public BikePart displayByName(String s){
        return manWH.findPartName(s);
    }
    public BikePart displayByNum(int n){
        return manWH.findPartNum(n);
    }   
    
}
