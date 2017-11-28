/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projtwo;

/**
 *
 * @author jariv
 */
public class Admin extends User{
    private Employee employed=new Employee();
    
    public Admin(String f, String l, String e, String u, String p){
        super(f,l,e,u,p);
    }
    
    public void createUser(String f, String l, String e, String u, String p){
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
