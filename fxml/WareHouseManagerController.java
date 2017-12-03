package projtwo.fxml;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import projtwo.Fleet;
import projtwo.WHManager;
import projtwo.WareHouse;
import static projtwo.fxml.loginController.usernametext;

public class WareHouseManagerController {

    @FXML
    private TextField filename;

    @FXML
    private Button updateWareHouseButton;

    @FXML
    private Button displayByName;

    @FXML
    private Button displayByNum;

    @FXML
    private TextArea output;

    @FXML
    private TextField partName;

    @FXML
    private TextField partNum;

    @FXML
    void HandleDisplayByName(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException {
          WHManager whm = new WHManager("s","s","s",usernametext+".txt", "s","s");
          output.appendText(whm.displayByName(partName.getText()).toString()+"\n");
        
//        Fleet fleet = new Fleet();
//        ArrayList<WareHouse> fleetlist = fleet.getFleet();
//        for(WareHouse wh: fleetlist){
//            if(wh.hasPart(partName.getText())&&wh.getName().equals(usernametext)){
//                output.appendText("WareHouse: "+wh.getName()+"\n BikePart: "+wh.findPartName(partName.getText()).toString());
//            }   
//        //
//        output.appendText("WareHouse: "+wh.getName());
            
        //}
    }

    @FXML
    void handleDisplayByNum(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException {
        WHManager whm = new WHManager("s","s","s",usernametext+".txt", "s","s");
        output.appendText(whm.displayByNum(Integer.parseInt(partNum.getText())).toString()+"\n");
    }

    @FXML
    void handleUpdateWareHouse(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException {
        WareHouse wh= new WareHouse(usernametext+".txt");
        wh.read(filename.getText());
    }

}
