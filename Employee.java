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
 *
 * @author jacobpetersen
 */
public class Employee {
    File file=new File("employedPersons.txt");
    private ArrayList<User> users = new ArrayList<User>();
    public Employee() throws FileNotFoundException{
        readEFile();
        
    }
    public void addUser(User u) throws FileNotFoundException{
        users.add(u);
        write();
    }

    
    public ArrayList<User> getList(){
        return users;
    }
    public void remUser(User u){
        users.remove(u);
        //iterate through and pop the user passed
        
    }
    public User findUser(String uName){
        for (User x: users){
            if(uName.equals(x.getUserName())){
                return x;
            }
        }
        return null;
        //iterate through match the user and and return it.
    }
    public void fillUsers(){
        //iterate through the file and add the users to the list
    }
    public void readEFile() throws FileNotFoundException{
        Scanner read = new Scanner(file);

        while(read.hasNext()){
            String line = read.nextLine();
            String[] pv = line.split(",");
            User o=new User(pv[0],pv[1],pv[2],pv[3],pv[4],pv[5]);
            users.add(o);   
        }
    }
    public void write() throws FileNotFoundException{
            PrintWriter writer;
        try {
            writer = new PrintWriter("employedPersons.txt", "UTF-8");
            for (User u : users){
            writer.println(u.toString()); // uses User toString()
 
            }
            writer.close();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
}
