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
    private ArrayList<User> users;
    public Employee() throws FileNotFoundException{
        readEFile();
        
    }
    public void addUser(User u) throws FileNotFoundException{
        users.add(u);
        write(u.toString());
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
            if(pv[5].equals("1")){
                Admin a=new Admin(pv[0],pv[1],pv[2],pv[3],pv[4]);
                users.add(a);
            }
            if(pv[5].equals("2")){
                OfficeManager o=new OfficeManager(pv[0],pv[1],pv[2],pv[3],pv[4]);
                users.add( o);            
            }
            if(pv[5].equals("3")){
                WHManager w=new WHManager(pv[0],pv[1],pv[2],pv[3],pv[4]);
                users.add(w);            
            }
            if(pv[5].equals("4")){
                SalesAss s=new SalesAss(pv[0],pv[1],pv[2],pv[3],pv[4]);
                users.add(s);            
            }
        }
    }
    public void write() throws FileNotFoundException{
            PrintWriter writer;
        try {
            writer = new PrintWriter("employedPersons.txt", "UTF-8");
            for (User u : users){
                if(u instanceof Admin)
                    writer.println(u+","+1); // uses User toString()
                //admin 1
                if(u instanceof OfficeManager)
                    writer.println(u+","+2);
                //officeManager==2
                if(u instanceof WHManager)
                    writer.println(u+","+3);
                //WHMan==3
                if(u instanceof SalesAss)
                    writer.println(u+","+4);
            }
            writer.close();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
}
