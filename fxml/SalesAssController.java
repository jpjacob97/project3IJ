package projtwo.fxml;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import projtwo.Employee;
import projtwo.Fleet;
import projtwo.SalesAss;
import projtwo.SalesItem;
import projtwo.WHManager;
import projtwo.WareHouse;
import static projtwo.fxml.loginController.usernametext;

public class SalesAssController {

    @FXML
    private TextField partNameSell;

    @FXML
    private Button vanExchangeButton;

    @FXML
    private Button displayByName;

    @FXML
    private Button displayByNum;

    @FXML
    private TextField partName;

    @FXML
    private TextField partNum;

    @FXML
    private Button sortName;

    @FXML
    private Button sortNum;

    @FXML
    private Button sellButton;

    @FXML
    private TextField quantity;

    @FXML
    private TextArea output;

    @FXML
    private TextField fileName;
    
    @FXML
    private TextField whuName;

    
    @FXML
    void handleDisplayByNum(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException {
        WHManager whm = new WHManager("s","s","s",whuName.getText()+".txt", "s","s");
        output.appendText(whm.displayByNum(Integer.parseInt(partNum.getText())).toString()+"\n");
    }

    @FXML
    void HandleDisplayByName(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException {
          WHManager whm = new WHManager("s","s","s",whuName.getText()+".txt", "s","s");
          output.appendText(whm.displayByName(partName.getText()).toString()+"\n");
    }

    @FXML
    void handleSell(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException {
        SalesAss sa = new SalesAss("f","s","e",whuName.getText()+".txt","s","s");
        sa.sell(partNameSell.getText(),Integer.parseInt(quantity.getText()));
        SalesItem safound = sa.findSItem(partNameSell.getText());
        output.appendText(safound.sellToString());
        
    }

    @FXML
    void handleSortName(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException {
         SalesAss sa = new SalesAss("f","s","e",whuName.getText()+".txt","s","s");
         sa.getWH().sortByName();
         output.appendText(sa.getWH().printWH());
        
    }

    @FXML
    void handleSortNum(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException {
        SalesAss sa = new SalesAss("f","s","e",whuName.getText()+".txt","s","s");
        sa.getWH().sortByNum();
        output.appendText(sa.getWH().printWH());
    }

    @FXML
    void handleVanExchange(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException {
        Fleet fleet = new Fleet();
        fleet.swap(fileName.getText());
        output.appendText("Successful Swap Matey");
    }

}
