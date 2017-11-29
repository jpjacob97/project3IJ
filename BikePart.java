
package projtwo;


/**
 * This class stores and manipulates the data needed for a bike part.
 * @author jacobpetersen
 */
public class BikePart implements Comparable<BikePart> {
    private String partName;
    private int partNum;
    private double listPrice;
    private double salePrice;
    private boolean isOnSale;
    private int quantity;
    
/**
 * Sets all of the fields for this class.
 * 
    * @param name
    * @param num
    * @param lp
    * @param sp
    * @param sale
    * @param q
 */
    public BikePart(String name, int num, double lp, double sp, boolean sale, int q){
        partName= name;
        partNum=num;
        listPrice=lp;
        salePrice=sp;
        isOnSale=sale;
        quantity=q;
    }
    
    /**
     * Sets name
     * @param name set name of the part
     */
    public void setName(String name){
        partName=name;
    }
    
    /**
     * Sets part number
     * @param num set part number
     */
    public void setNum(int num){
        partNum=num;
    }
    
    /**
     * 
     * @param lp sets list price
     */
    public void setListPrice(double lp){
        listPrice=lp;
    }
    
    /**
     * Sets sales price
     * @param sp sets the sale prices
     */
    public void setSalePrice(double sp){
        salePrice=sp;
    }
    
    /**
     * Puts on sale or takes off sale
     * @param sale sets part on sale
     */
    public void setOnSale(boolean sale){
        isOnSale=sale;
    }
    
    /**
     * Sets the quantity of a product
     * @param q sets the quantity of the part
     */
    public void setQuantity(int q){
        quantity=q;
    }
    
    /**
     * Get part number
     * @return part number
     */
    public int getNum(){
        return partNum;
    }
    
    /**
     * Get the the quantity
     * @return quantity
     */
    public int getQuantity(){
        return quantity;
    }
    /**
     * GEt list price.
     * @return listPrice
     */
    public double getListPrice(){
        return listPrice;
    }
    /**
     * get whether or not it is on sale.
     * @return t/f depending isOnsale
     */
    public boolean isOnSale(){
        return isOnSale;
    }
    
    /**
     * Get sale price
     * @return the sale prices
     */
    public double getSalePrice(){
        return salePrice;
    }
    
    /**
     * Get the name
     * @return the name of the part
     */
    public String getName(){
        return partName;
    }
    
    /**
     * Returns the preferred string
     * @return the entire line of info for the part.
     */
    @Override
    public String toString(){
        return (partName+", "+partNum+", "+listPrice+", "+salePrice+", "+isOnSale+", "+quantity);
    }
    
    /**
     * Returns the price of the part
     * @return the price of the part.
     */
    public double getPrice(){
        if (isOnSale==true){
            return salePrice;
        }
        else
            return listPrice;
    }
    
    @Override
    public int compareTo(BikePart bp1) {
        if(this.partNum == bp1.partNum){
            return 0;
        }
        if(this.partNum > bp1.partNum){
            return 1;
        }
        else
            return -1;
    }
    
}