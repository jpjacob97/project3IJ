/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projtwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is designed to aggregate users, write them to a file and
 * manipulate the file to keep the user info up to date.
 *
 * @author jacobpetersen
 */
public class Employee {

    File file = new File("employedPersons.txt");
    private ArrayList<User> users = new ArrayList<User>();

    /**
     * Creates an employee object.
     * @throws FileNotFoundException 
     */
    public Employee() throws FileNotFoundException {
        readEFile();

    }
    
    /**
     * writes the users toString to the file by adding it to the users array.
     * @param u
     * @throws FileNotFoundException 
     */
    public void addUser(User u) throws FileNotFoundException {
        users.add(u);
        write();
    }
    
    /**
     * Returns the arrayList of Users.
     * @return the arrayList user.
     */
    public ArrayList<User> getList() {
        return users;
    }

    /**
     * Removes the user from the list of users.
     * @param u the user you would like to remove
     */
    public void remUser(User u) {
        users.remove(u);
        //iterate through and pop the user passed

    }
    
    /**
     * Returns the user of the user name passed.
     * @param uName the name of the user you are looking for.
     * @return the user of the proper name.
     */
    public User findUser(String uName) {
        for (User x : users) {
            if (uName.equals(x.getUserName())) {
                return x;
            }
        }
        return null;
        //iterate through match the user and and return it.
    }

    /**
     * Reads the employed persons file and writes the users within
     * it to the arrayList of users.
     * @throws FileNotFoundException 
     */
    public void readEFile() throws FileNotFoundException {
        Scanner read = new Scanner(file);

        while (read.hasNext()) {
            String line = read.nextLine();
            String[] pv = line.split(",");
            User o = new User(pv[0], pv[1], pv[2], pv[3], pv[4], pv[5]);
            users.add(o);
        }
    }
    
    /**
     * Writes the ArrayList to the emplyedPersons file.
     * @throws FileNotFoundException 
     */
    public void write() throws FileNotFoundException {
        PrintWriter writer;
        try {
            writer = new PrintWriter("employedPersons.txt", "UTF-8");
            for (User u : users) {
                writer.println(u.toString()); // uses User toString()

            }
            writer.close();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
