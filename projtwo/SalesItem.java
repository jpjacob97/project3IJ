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
    private Date date;

    public SalesItem(BikePart b, int q, Date d) {
        bp = b;
        quantity = q;
        date=d;
    }

    public int getQuantity(){
        return quantity;
    }

    public Date getDate() {
        return date;
    }

    public BikePart getBp() {
        return bp;
    }
    
}
