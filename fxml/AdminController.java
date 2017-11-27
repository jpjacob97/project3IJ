package projtwo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
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
    void handleChangeUserPass(ActionEvent event) {

    }

    @FXML
    void handleCreateUserButton(ActionEvent event) {

    }

    @FXML
    void handleDeleteUserButton(ActionEvent event) {

    }

}
