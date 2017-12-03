package projtwo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * This class performs the write function for the bike part file I/O
 * @author jacobpetersen
 */
public class Writer {
    /**
     * Writes a new file with the bike parts in the array
     * @param fileName the name of the file it should be written to
     * @param bpArray the array of bike parts
     */
    public static  void writeFile(String fileName, ArrayList<BikePart> bpArray){
        try{
            
            // Print to the file
            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
            for (BikePart bp : bpArray)
                writer.println(bp); // uses BikePart toString()
            writer.close();
            
            // Success message
            System.out.println(fileName+" successfully created!***********");            
        } 
        
        // Catch the file not found exception
        catch (IOException e) {
            System.out.println("file error!");
            e.printStackTrace();
        }  
    }
    
    /**
     * Writes the bike parts in the array to a file while not overwriting older
     * parts that are in the file
     * @param fileName the name of the file you are writing to
     * @param bpArray the bike parts to be written
     */
    public static  void updateFile(String fileName, ArrayList<BikePart> bpArray){
        try{
            
            // Read in the old filres parts
            ArrayList<BikePart> parts= new ArrayList(Reader.readFile(fileName));
            
            // Compare the new parts and the old parts
            for (BikePart bp : parts){
                boolean match=false;
                for (BikePart bpNew : bpArray){
                    // Update the quantity
                    if (bpNew.getNum()==(bp.getNum())){
                        bpNew.setQuantity(bp.getQuantity()+bpNew.getQuantity());
                        match=true;                      
                    }
                }
                
                // Add the not found old parts to the array
                if (match==false){
                    bpArray.add(bp);
                }
            }
            
            // Write all of the parts to the file
            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
            for (BikePart bpNew : bpArray)
                writer.println(bpNew); // uses BikePart toString()
            writer.close();
            
            // Success message
            System.out.println(fileName+" successfully updated!");
        } 
        
        // Catch file not found exception
        catch (IOException e) {
            System.out.println("file error!");
            e.printStackTrace();
        }
    }
    public void vanWriter(ArrayList<BikePart> bpArray, String fileName, String vanName){
        try{
            
            // Read in the old filres parts
            ArrayList<BikePart> parts= new ArrayList(Reader.readFile(fileName));
            
            // Write all of the parts to the file
            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
            writer.println();
            writer.println(vanName);
            
            for (BikePart bpNew : bpArray)
                writer.println(bpNew); // uses BikePart toString()
            writer.close();
            
            // Success message
            System.out.println(fileName+" successfully updated!");
        } 
        
        // Catch file not found exception
        catch (IOException e) {
            System.out.println("file error!");
            e.printStackTrace();
        }
    }
}


