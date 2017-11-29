/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projtwo;

import java.io.FileNotFoundException;

/**
 *
 * @author jariv
 */
public class Admin extends User {
    Employee employed= null;
    
    public Admin(String f, String l, String e, String u, String p) throws FileNotFoundException{
        super(f,l,e,u,p);
        final Employee employed=new Employee();

    }
    
    public void createUser(String f, String l, String e, String u, String p) throws FileNotFoundException{
        User newUser=new User( f,  l,  e,  u,  p);
        employed.addUser(newUser);
        
    }
    public void delUser(User u){
        employed.remUser(u);
        
    }
    public void changeUserPass(User u, String p){
        employed.findUser(u).changePass(p);
    }
    
}
