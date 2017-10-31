package projtwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * This class is meant to hold all of the operations for the User Interface.
 * @author jacobpetersen
 */
public class UI {
    
    
    // User input field
    Scanner input =new Scanner(System.in);
    String ui="";
    /**
     * Walks the user through the reading in of a file, either for the first
     * time or as an update to the existing database.
     */
    public ArrayList<BikePart> listAll(){
        try {
            ArrayList<BikePart> bps=new ArrayList<>();
            File file=new File("vans.txt");
            Scanner fileRead=new Scanner(file);
            while(fileRead.hasNextLine()){
                String dbName=fileRead.nextLine();
                ArrayList<BikePart>current=new ArrayList<>(Reader.readFile(dbName));
                for(BikePart bp:current){
                    bps.add(bp);
                    System.out.println(bp);
                }
            }
            return bps;
        } catch (FileNotFoundException ex) {
            ArrayList<BikePart> bps=new ArrayList<>();
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
            return bps;
        }
    }
    /**
     * swaps parts between warehouses based on the file.
     * @param fileName
     * @return 
     */
    public String swap(String fileName){
        try {
            File file = new File(fileName);
            Scanner fileRead=new Scanner(file);
            String whs=fileRead.nextLine();
            List<String> whl = Arrays.asList(whs.split(","));
            System.out.println(whl);
            String loser=whl.get(0);
            String gainer=whl.get(1);
            WareHouse l=new WareHouse(loser);
            WareHouse g=new WareHouse(gainer);
            ArrayList<BikePart> lose=new ArrayList<>(l.getList());
            ArrayList<BikePart> gain=new ArrayList<>(g.getList());
            while (fileRead.hasNextLine()){
                boolean found=false;
                String namePart=fileRead.nextLine();
                List<String> nameNum = Arrays.asList(namePart.split(","));
                String partName=nameNum.get(0);
                Integer num= Integer.parseInt(nameNum.get(1));
                for(BikePart bp:gain){
                    if (partName.equals(bp.getName())){
                        bp.setQuantity(bp.getQuantity()+num);
                        found=true;
                        System.out.println("here1");
                    }

                    
                }
                for(BikePart bp:lose){
                    
                    if (partName.equals(bp.getName())){
                        bp.setQuantity(bp.getQuantity()-num);
                        System.out.println("here2");

                    }
                    if (found==false && (partName.equals(bp.getName()))){
                        BikePart x= new BikePart(bp.getName(),bp.getNum(),bp.getListPrice(), bp.getSalePrice(),bp.isOnSale(),num);
                        gain.add(x);
                        System.out.println("here");
                        found=true;
                    }

                    
                }

            }
            l.setList(lose);
            g.setList(gain);
            l.updateFile();
            g.updateFile();
            
            return "seven";
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
            return "other";
        }
    }
    
    /**
     * adds a warehouse.
     * @param name
     * @return returns success message.
     */
    public String addWareHouse(String name){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(name, "UTF-8");
            System.out.println("warehouse successfully created");
            WareHouse x=new WareHouse(name);

            ArrayList<String> retList = new ArrayList<>();
            File file = new File("vans.txt");

            Scanner read = new Scanner(file);
            while (read.hasNextLine()) {
                String line = read.nextLine();
                retList.add(line);
            }
            retList.add(name);
            PrintWriter w = new PrintWriter(file, "UTF-8");
            for (String s:retList)
                w.println(s);
            w.close();
            return "warehouse file created";
            
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
            return"file error";
        } 
        catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
            return"file error";
        } 
        finally {
            writer.close();
        }
    }
    /**
     * reads a file into the main warehouse file.
     * @param fileName
     * @return 
     */
    public String read(String fileName){
        String out="";
        System.out.print("Enter the name of the file you would like to read:");
        ArrayList<BikePart> bps= new ArrayList(Reader.readFile("warehouseDB.txt"));
        ArrayList<BikePart> parts= new ArrayList(Reader.readFile(fileName));
        if(bps.isEmpty()){
            Writer.writeFile("warehouseDB.txt", parts);
            return("successfully created");
        }
        else{
            Writer.updateFile("warehouseDB.txt", parts);
            return("successfully updated");
        }
        
    }
    /**
     * Enters an individual part into the database, it will be added to the
     * beginning of the file.
     */
    public void enter(String part){
        //format the
        String regExp = "\\s*(\\s|,)\\s*";
        String[] pv = part.split(regExp);
        BikePart bp = new BikePart(pv[0],Integer.parseInt(pv[1]),Double.parseDouble(pv[2]),Double.parseDouble(pv[3]),pv[4].equals("true"),Integer.parseInt(pv[5]));
        
  
        
        // Update the database
        ArrayList<BikePart> bps= new ArrayList();
        bps.add(bp);
        Writer.updateFile("warehouseDB.txt",bps);
    }
    
    /**
     * Sells one of the product selected, this method will also subtract from
     * the database as necessary.
     */
    public void sell(){
        
        // Get part number from user
        System.out.println("Enter the part number:");
        int num=input.nextInt();
        
        // Read the parts from the database
        ArrayList<BikePart> parts= new ArrayList(Reader.readFile("warehouseDB.txt"));
        boolean found = false;
        
        // Check each part to see if its number matches
        for(BikePart bp:parts){
            if (bp.getNum()==num){
                
                // Print the name and price of the part
                System.out.println(bp.getName()+", $"+bp.getPrice());
                
                // Print whether or not it is on sale
                if(bp.getPrice()==bp.getSalePrice()){
                    System.out.println("Not on sale.");
                }
                else if(bp.getPrice()!=bp.getPrice()){
                    System.out.println("On sale.");
                }
                
                // Print the date and time
                Date date = new Date();
                System.out.println(date.toString()); 
                
                // Set the quantity of the part to -1 so that it will update correctly
                bp.setQuantity(-1);
                
                // Set found to true
                found= true;
                
                // Update the database
                ArrayList<BikePart> part= new ArrayList();
                part.add(bp);
                Writer.updateFile("warehouseDB.txt",part);
            }
        }
        
        // Print an error if need be
        if (found==false)
            System.out.println("Part not found, try again.");
    }
    
    /**
     * Displays basic information about the part the user chooses.
     */
    public void display(){
        
        // Read all the parts from the file
        ArrayList<BikePart> parts= new ArrayList(Reader.readFile("warehouseDB.txt"));
        
        // Get the name from the user
        System.out.println("Enter the part name:");
        ui=input.next();
        
        // This bool is for a later error message
        boolean found=false;
        
        // Loop through and compare input to partnames
        for(BikePart bp:parts){
            if (bp.getName().equals(ui)){
                
                // Print the part name and the price
                System.out.println(bp.getName()+", $"+bp.getPrice());  
                found=true;
            }

        }
        
        // Print an error message if no such part is found
        if (found==false)
            System.out.println("Could not find part try again.");
        
    }
    
    /**
     * Prints the bike parts sorted by alphabetically by name, also sorts them
     * by name within the database.
     */
    public ArrayList<BikePart> SortName(ArrayList<BikePart> bps){
        
        // Create three arraylists needed for this impromptuve algorithm
        ArrayList<BikePart> parts= new ArrayList(bps);
        ArrayList<String> partNames= new ArrayList();
        ArrayList<BikePart> sorted=new ArrayList();
        
        // Add all the part names to an arraylist
        for(BikePart bp: parts){
            partNames.add(bp.getName());
        }
        
        // Sort the part names alphebetically disregarding case        
        Collections.sort(partNames, String.CASE_INSENSITIVE_ORDER);
        
        // For each part name find the cooresponding part and add them in order
        for(int i=0; i<partNames.size();i++){
            
            for(BikePart bp: parts){
                if (partNames.get(i).equals(bp.getName()))
                    sorted.add(bp);                               
            }
        }

        // Print the list with a space beneath each part for readability
        for(BikePart bp: sorted){
            System.out.println(bp);
            System.out.println();
        }
        return sorted;

    }
    
    /**
     * Sorts by part number, prints the parts in order and changes the
     * database accordingly.
     */
    public ArrayList<BikePart> SortNum(ArrayList<BikePart> bps){
        
        // create three arraylists needed for this impromptuve algorithm
        ArrayList<BikePart> parts= new ArrayList(bps);
        ArrayList<Integer> partNums= new ArrayList();
        ArrayList<BikePart> sorted=new ArrayList();
        
        // Add all the part numbers to an arraylist
        for(BikePart bp: parts){
            partNums.add(bp.getNum());
        }
        
        // Sort the part numbers
        Collections.sort(partNums);
        
        // For each part number find the cooresponding part and add them in order
        for(int i=0; i<partNums.size();i++){
            for(BikePart bp: parts){
                if (partNums.get(i)==(bp.getNum()))
                    sorted.add(bp);  
                
            }
        }
        
        // Print the list with a space beneath each part for readability
        for(BikePart bp: sorted){
            System.out.println(bp);
            System.out.println();
        }
        return sorted;
    }
    /**
     * prints the information the user needs to start using the system.
     */
    public void printUI(){
        // Printing the commands for user reference. 
        System.out.println("Please select your option from the following menu: ");
        System.out.println("Read: Read an inventory delivery file");
        System.out.println("Enter: Enter a part");
        System.out.println("Sell: Sell a part");
        System.out.println("Display: Display a part");
        System.out.println("SortName: Sort parts by part name");
        System.out.println("SortNumber: Sort parts by part number");
        System.out.println("Quit: ");
    }
}
                
    
