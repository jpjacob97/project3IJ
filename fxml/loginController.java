package projtwo.fxml;

import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projtwo.Admin;
import projtwo.Employee;
import projtwo.OfficeManager;
import projtwo.SalesAss;
import projtwo.User;
import projtwo.WHManager;

public class loginController {
    public static String usernametext;

    @FXML
    private TextField password;

    @FXML
    private TextField userName;

    @FXML
    private Button login;

    @FXML
    void handleLoginButton(ActionEvent event) throws FileNotFoundException, IOException {
//        Employee employed=new Employee();
//        employed.findUser(userName.getText());
//        
        Employee employed= new Employee();
        User logged=employed.findUser(userName.getText());
        

        if(logged.getUserName().equalsIgnoreCase(userName.getText())&&logged.checkPass(password.getText())){
            if(employed.findUser(userName.getText()) instanceof Admin ){
                usernametext=userName.getText();
                Parent homePageParent= FXMLLoader.load(getClass().getResource("Admin.fxml"));
                Scene homePageScene = new Scene(homePageParent);
                Stage projectStage=(Stage) ((Node) event.getSource()).getScene().getWindow();
                projectStage.setScene(homePageScene);
                projectStage.show();                
                
            }
            
            if(employed.findUser(userName.getText()) instanceof OfficeManager ){
                usernametext=userName.getText();
                Parent homePageParent= FXMLLoader.load(getClass().getResource("OfficeManager.fxml"));
                Scene homePageScene = new Scene(homePageParent);
                Stage projectStage=(Stage) ((Node) event.getSource()).getScene().getWindow();
                projectStage.setScene(homePageScene);
                projectStage.show();                
                
            }
            if(employed.findUser(userName.getText()) instanceof WHManager ){
                usernametext=userName.getText();
                Parent homePageParent= FXMLLoader.load(getClass().getResource("WareHouseManagerController.fxml"));
                Scene homePageScene = new Scene(homePageParent);
                Stage projectStage=(Stage) ((Node) event.getSource()).getScene().getWindow();
                projectStage.setScene(homePageScene);
                projectStage.show();                
                
            }
            if(employed.findUser(userName.getText()) instanceof SalesAss ){
                usernametext=userName.getText();
                Parent homePageParent= FXMLLoader.load(getClass().getResource("salesAss.fxml"));
                Scene homePageScene = new Scene(homePageParent);
                Stage projectStage=(Stage) ((Node) event.getSource()).getScene().getWindow();
                projectStage.setScene(homePageScene);
                projectStage.show();                
                
            }
        }
        
        
        
        
        
        
        
        
        
        
        
    }
}