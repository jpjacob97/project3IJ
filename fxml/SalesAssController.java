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
    void HandleDisplayByName(ActionEvent event) throws FileNotFoundException {
        Fleet fleet = new Fleet();
        ArrayList<WareHouse> fleetlist = fleet.getFleet();
        for(WareHouse wh: fleetlist){
            if(wh.hasPart(partName.getText())&&wh.getName().equals(usernametext)){
                output.appendText("WareHouse: "+wh.getName()+"\n BikePart: "+wh.findPartName(partName.getText()).toString());
            }
        }
    }

    @FXML
    void handleDisplayByNum(ActionEvent event) throws FileNotFoundException {
        Fleet fleet = new Fleet();
        ArrayList<WareHouse> fleetlist = fleet.getFleet();
        for(WareHouse wh: fleetlist){
            if(wh.hasPart(Integer.parseInt(partNum.getText()))&&wh.getName().equals(usernametext)){
                output.appendText("WareHouse: "+wh.getName()+"\n BikePart: "+wh.findPartName(partNum.getText()).toString());
            }
        }
    }

    @FXML
    void handleSell(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException {
        Employee employed = new Employee();
        SalesAss sa = new SalesAss(employed.findUser(usernametext));
        sa.sell(partNameSell.getText(),Integer.parseInt(quantity.getText()));
        SalesItem safound = sa.findSItem(partNameSell.getText());
        output.appendText(safound.sellToString());
        
    }

    @FXML
    void handleSortName(ActionEvent event) throws FileNotFoundException {
        Fleet fleet = new Fleet();
        ArrayList<WareHouse> fleetlist = fleet.getFleet();
        for(WareHouse wh: fleetlist){
            if(wh.getName().equals(usernametext)){
                wh.sortByName();
                output.appendText(wh.printWH());
            }
        }
    }

    @FXML
    void handleSortNum(ActionEvent event) throws FileNotFoundException {
        Fleet fleet = new Fleet();
        ArrayList<WareHouse> fleetlist = fleet.getFleet();
        for(WareHouse wh: fleetlist){
            if(wh.getName().equals(usernametext)){
                wh.sortByNum();
                output.appendText(wh.printWH());
            }
        }
    }

    @FXML
    void handleVanExchange(ActionEvent event) throws FileNotFoundException {
        Fleet fleet = new Fleet();
        fleet.swap(fileName.getText());
        output.appendText("Successful Swap Matey");
    }

}
