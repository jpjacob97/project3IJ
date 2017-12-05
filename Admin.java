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
    /**
     * Creates an admin with an employed class to manipulate.
     * @param f first name
     * @param l last name
     * @param e email
     * @param u username
     * @param p password
     * @param t type
     * @throws FileNotFoundException 
     */
    public Admin(String f, String l, String e, String u, String p, String t) throws FileNotFoundException{
        super(f,l,e,u,p,t);
        final Employee employed=new Employee();

    }
    
    /**
     * creates a user and adds them to the employed class thereby writing them to the file.
     * 
     * @param f first name
     * @param l last name
     * @param e email
     * @param u userName
     * @param p password
     * @param t type of user
     * @throws FileNotFoundException 
     */
    public void createUser(String f, String l, String e, String u, String p,String t) throws FileNotFoundException{
        User newUser=new User( f,  l,  e,  u,  p,t);
        employed.addUser(newUser);
        
    }
    /**
     * Removes the user passed from the employed file and list.
     * @param u 
     */
    public void delUser(User u){
        employed.remUser(u);
        
    }
    /**
     * Changes the user passed password to the passed string
     * @param u The user you would like to edit
     * @param p The new password
     */
    public void changeUserPass(User u, String p){
        employed.findUser(u.getName()).changePass(p);
    }
    
}
