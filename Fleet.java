/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projtwo;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author jacobpetersen
 */
public class Fleet {
       private ArrayList<WareHouse> fleet;
       private File file;
       public Fleet(ArrayList l, String filename){
           
       }
       public WareHouse findwh(){
           return null;
       }
       public ArrayList getFleet(){
           return fleet;
       }
       public void addWH(WareHouse wh){
           fleet.add(wh);
       }
       public void swap(String fileName){
           //tons of code
       }
       public void update(){
           //update the file
       }
}
