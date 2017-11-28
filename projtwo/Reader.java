
package projtwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This file reads bike parts into the program from a file.
 * @author jacobpetersen
 */
public class Reader {
    /**
     * Reads the parts from a file into an array.
     * @param fileName the name of the file you are reading
     * @return an arrayList of bike parts
     */
    public static ArrayList<BikePart> readFile(String fileName) {
        
        // Check that the file was named
        ArrayList<BikePart> retList = null;
        if (fileName == null || fileName.equals(""))
            return retList;
        File file = new File(fileName);
        
        try {
            // Pull the strings from the file and turn them into bike parts.
            retList = new ArrayList<>();
            Scanner read = new Scanner(file);
            while (read.hasNextLine()) {
                String line = read.nextLine();
                String regExp = "\\s*(\\s|,)\\s*";
                String[] pv = line.split(regExp);
                BikePart bp = new BikePart(pv[0],Integer.parseInt(pv[1]),Double.parseDouble(pv[2]),Double.parseDouble(pv[3]),pv[4].equals("true"),Integer.parseInt(pv[5]));
                retList.add(bp);
            }
        }
            
        // Catch file not found exception
        catch (FileNotFoundException e) {
            System.out.println("file not found "+fileName);
            e.printStackTrace();
        }
        
        //return ArrayList of bike parts
        return retList;
    }
}
