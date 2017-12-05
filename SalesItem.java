/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projtwo;

import java.util.Date;

/**
 * Holds the information about a sale
 * @author jariv
 */
public class SalesItem {

    private BikePart bp;
    private int quantity;
    private Date date;

    /**
     * Creates the sales Item object.
     * @param b the part
     * @param q the quantity sold
     * @param d the date of sale
     */
    public SalesItem(BikePart b, int q, Date d) {
        bp = b;
        quantity = q;
        date=d;
    }

    /**
     * Returns how many parts were sold
     * @return int quantity
     */
    public int getQuantity(){
        return quantity;
    }

    /**
     * Returns the date of the sale
     * @return Date date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Returns the part that was sold
     * @return Bike part bp
     */
    public BikePart getBp() {
        return bp;
    }
    
    /**
     * The toString used in the sale output
     * @return 
     */
    public String sellToString(){
        return "Sold Item = "+bp.toString()+"\n"+"Quantity Sold: "+quantity+"\n"+"Total Price= $"+totalCost();
    }

    /**
     * The toString used in writing to the file.
     * @return a string of info about the sale
     */
    @Override
    public String toString() {
        return bp + ","+ quantity + "," + date;
    }
    
    /**
     * Returns the string of a sales Item for the purpose of writing it
     * in the invoice toString
     * @return String line of sales Item info
     */
    public String invoiceToString(){
        String timesnewroman = String.format("|%-15s|", bp.getName())+String.format("%11d|", bp.getNum())+String.format("%8.2f|", bp.getListPrice())+String.format("%15.2f|", bp.getPrice())+String.format("%5d|", quantity)+String.format("%10.2f|", totalCost())+"\n";
        return timesnewroman;        
    }
    
    /**
     * Returns the total cost of the sale.
     * @return double total cost.
     */
    public double totalCost(){
        return bp.getPrice()*quantity;
    }
}
