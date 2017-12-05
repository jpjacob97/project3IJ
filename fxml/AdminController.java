package projtwo;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class AdminController {

    @FXML
    private Button CreateUserButton;

    @FXML
    private Button deleteUserButton;

    @FXML
    private Button changeUserPass;

    @FXML
    private TextField userNameField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField delUserField;
    
    @FXML
    private CheckBox OfficeManagerCheck;

    @FXML
    private CheckBox WHManagerCheck;

    @FXML
    private CheckBox SalesAssociateCheck;

    @FXML
    private CheckBox AdminCheck;

    @FXML
    private TextField chanUser;

    @FXML
    private TextField newPass;
    
    @FXML
    private TextArea output;

    @FXML
    void HandleChangeUserPass(ActionEvent event) throws FileNotFoundException {
        Employee employed= new Employee();
        User user= employed.findUser(chanUser.getText());
        user.changePass(newPass.getText());
        employed.write();
        output.appendText(user.toString()+"\n");
    }

    @FXML
    void handleCreateUserButton(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException {
         Employee employed= new Employee();
         if(WHManagerCheck.isSelected()){
             User uh = new User(firstNameField.getText(),lastNameField.getText(),emailField.getText(),userNameField.getText(),passwordField.getText(),"WHManager");    
             employed.addUser(uh);
             Fleet f = new Fleet();
             WareHouse wh=new WareHouse(userNameField.getText()+".txt");
             f.addWH(wh);
             wh.writeToFleet();
             output.appendText("Created: "+uh.toString()+"\n");
         }
         if(OfficeManagerCheck.isSelected()){
            User uh = new User(firstNameField.getText(),lastNameField.getText(),emailField.getText(),userNameField.getText(),passwordField.getText(),"OfficeManager");    
             employed.addUser(uh);
             output.appendText("Created: "+uh.toString()+"\n");             
         }
         if(AdminCheck.isSelected()){
            User uh = new User(firstNameField.getText(),lastNameField.getText(),emailField.getText(),userNameField.getText(),passwordField.getText(),"Admin");    
             employed.addUser(uh);
             output.appendText("Created: "+uh.toString()+"\n");             
         }
         if(SalesAssociateCheck.isSelected()){
            User uh = new User(firstNameField.getText(),lastNameField.getText(),emailField.getText(),userNameField.getText(),passwordField.getText(),"SalesAss");    
             employed.addUser(uh);
             output.appendText("Created: "+uh.toString()+"\n");             
         }


    }

    @FXML
    void handleDeleteUserButton(ActionEvent event) throws FileNotFoundException {
        Employee employed= new Employee();
        User user= employed.findUser(delUserField.getText());
        employed.remUser(user);
        employed.write();
        output.appendText(user.toString()+"\n");
        
    }

}
