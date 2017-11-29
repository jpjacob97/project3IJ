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
public class User {

    private final String fName; //first name
    private final String lName; //last name
    private String email; //email
    private final String uName; //user name
    private String pass; //password

    public User(String f, String l, String e, String u, String p) {
        fName = f;
        lName = l;
        email = e;
        uName = u;
        pass = p;
    }

    public String getUserName() {
        return uName;
    }

    public String getFirstName() {
        return fName;
    }

    public String getLastName() {
        return lName;
    }

    public String getName() {
        return fName + " " + lName;
    }

    public String getEmail() {
        return email;
    }

    public boolean checkPass(String check) {
        return check.equals(pass);
    }

    public boolean changePass(String nPass) {
        if (nPass.length() > 3) {
            pass = nPass;
            return true;
        } else {
            return false;
        }
    }

    public boolean changeEmail(String e) {
        if (e.matches("(.*)(@)(.*)\\.(.{3})")) {
            email = e;
            return true;
        } else {
            return false;
        }
    }
    @Override
    public String toString(){
        return fName+","+lName+","+email+","+uName+","+pass;
    }
}
