package projtwo;

import java.io.FileNotFoundException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    private RadioButton AdminRadio;

    @FXML
    private ToggleGroup radiobuttons;

    @FXML
    private RadioButton oManRadio;

    @FXML
    private RadioButton WHManRadio;

    @FXML
    private RadioButton salesAssRadio;

    @FXML
    private TextField delUserField;

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
    void handleCreateUserButton(ActionEvent event) throws FileNotFoundException {
         Employee employed= new Employee();
         

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
