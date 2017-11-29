/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projtwo;

import java.util.Date;

/**
 *
 * @author jariv
 */
public class SalesItem {

    private BikePart bp;
    private int quantity;
    private String date;

    public SalesItem(BikePart b, int q, String d) {
        bp = b;
        quantity = q;
        date=d;
    }

    public int getQuantity(){
        return quantity;
    }

    public String getDate() {
        return date;
    }

    public BikePart getBp() {
        return bp;
    }

    @Override
    public String toString() {
        return bp + ","+ quantity + "," + date;
    }
    
    
}
