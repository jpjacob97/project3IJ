/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projtwo;

/**
 * Holds all the properties of our user and allows them to be manipulated.
 * @author jariv
 */
public class User {

    private final String fName; //first name
    private final String lName; //last name
    private String email; //email
    private final String uName; //user name
    private String pass; //password
    private String type;

    /**
     * Constructs a user object.
     * @param f first name
     * @param l last name
     * @param e email
     * @param u user name
     * @param p password
     * @param t type of user
     */
    public User(String f, String l, String e, String u, String p, String t) {
        fName = f;
        lName = l;
        email = e;
        uName = u;
        pass = p;
        type= t;
    }

    /**
     * Returns the User name String
     * @return String uName
     */
    public String getUserName() {
        return uName;
    }

    /**
     * Returns the first name of the user in question.
     * @return String fName
     */
    public String getFirstName() {
        return fName;
    }

    /**
     * Returns the last Name of the user in question.
     * @return STring lName
     */
    public String getLastName() {
        return lName;
    }

    /**
     * Returns the name of the User.
     * @return String name.
     */
    public String getName() {
        return fName + " " + lName;
    }

    /**
     * Returns the Users Email.
     * @return 
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Returns the Users password.
     * @return 
     */
    public String getPass() {
        return pass;
    }

    /**
     * Checks the password.
     * @param check password to check
     * @return true if password matches.
     */
    public boolean checkPass(String check) {
        return check.equals(pass);
    }

    /**
     * Changes the password of a user.
     * @param nPass
     * @return whether or not the password is greater than 3 characters.
     */
    public boolean changePass(String nPass) {
        if (nPass.length() > 3) {
            pass = nPass;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Changes email.
     * @param e
     * @return 
     */
    public boolean changeEmail(String e) {
        if (e.matches("(.*)(@)(.*)\\.(.{3})")) {
            email = e;
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * String of a user for the purposes of printing them in employee.
     * @return 
     */
    @Override
    public String toString(){
        return fName+","+lName+","+email+","+uName+","+pass+","+type;
    }
    
    /**
     * Returns a String which is the type of the User.
     * @return 
     */
    public String getType(){
        return type;
    }
}
