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
    
    public String sellToString(){
        return "Sold Item = "+bp.toString()+"\n"+"Quantity Sold: "+quantity+"\n"+"Total Price= $"+totalCost();
    }

    @Override
    public String toString() {
        return bp + ","+ quantity + "," + date;
    }
    
    public String invoiceToString(){
        String timesnewroman = String.format("|%-15s|", bp.getName())+String.format("%11d|", bp.getNum())+String.format("%8.2f|", bp.getListPrice())+String.format("%15.2f|", bp.getPrice())+String.format("%5d|", quantity)+String.format("%10.2f|", totalCost())+"\n";
        return timesnewroman;        
    }
    
    public double totalCost(){
        return bp.getPrice()*quantity;
    }
}
