/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projtwo;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author jacobpetersen
 */
public class Employee {
    File file=new File("employedPersons.txt");
    private ArrayList<User> users;
    public Employee(){
        
        
    }
    public void addUser(User u){
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
    public User findUser(User u){
        for (User x: users){
            if(u.getUserName().equals(x.getUserName())){
                return x;
            }
        }
        return null;
        //iterate through match the user and and return it.
    }
    public void fillUsers(){
        //iterate through the file and add the users to the list
    }
    public String read(){
        //reads a line of the file
        return null;
    }
    public void write(String s){
        //writes a line of the file
    }

    
}
