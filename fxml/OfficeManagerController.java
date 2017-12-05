package fxml;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projtwo.BikePart;
import projtwo.Employee;
import projtwo.Fleet;
import projtwo.OfficeManager;
import projtwo.SalesAss;
import projtwo.WareHouse;

public class OfficeManagerController {

    @FXML
    private Button displayByNameButton;

    @FXML
    private Button displayByNumButton;

    @FXML
    private Button checkMinButton;

    @FXML
    private Button genCommissionButton;

    @FXML
    private TextField displayByNameField;

    @FXML
    private TextField displayByNumField;

    @FXML
    private TextField genComField;
    
    @FXML
    private TextField minimumField;

    @FXML
    private TextArea output;

    @FXML
    private DatePicker startDate;

    @FXML
    private DatePicker endDate;
    

    @FXML
    void handleCheckMin(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException {
        int min=Integer.parseInt(minimumField.getText());
        Fleet fleet=new Fleet();
        ArrayList<WareHouse> fleetlist = fleet.getFleet();
        for(WareHouse wh: fleetlist){
            output.appendText(wh.getName()+"\n");
            for(BikePart bp: wh.getList()){
                if (bp.getQuantity() < min){
                    output.appendText("Part:"+bp.getName()+"   Quantity:"+bp.getQuantity()+"\n");
                }
            }
            output.appendText("--------------------------------\n");
                
        }
        
    }

    @FXML
    void handleDisplayByName(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException {
        Fleet fleet = new Fleet();
        ArrayList<WareHouse> fleetlist = fleet.getFleet();
        for(WareHouse wh: fleetlist){
            if(wh.hasPart(displayByNameField.getText())){
                output.appendText("WareHouse: "+wh.getName()+"\n BikePart: "+wh.findPartName(displayByNameField.getText()).toString()+"\n");
            }
        }
        
    }

    @FXML
    void handleDisplayByNum(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException {
        Fleet fleet = new Fleet();
        ArrayList<WareHouse> fleetlist = fleet.getFleet();
        for(WareHouse wh: fleetlist){
            if(wh.hasPart(displayByNameField.getText())){
                output.appendText("WareHouse: "+wh.getName()+"\n BikePart: "+wh.findPartName(displayByNameField.getText()).toString()+"\n");
            }
        }
    }

    @FXML
    void handleGenCommission(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException {
        //creates localdate object to then be converted to date
        LocalDate dh1=startDate.getValue();
        Date date1= java.sql.Date.valueOf(dh1);
        
        LocalDate dh2=endDate.getValue();        
        Date date2= java.sql.Date.valueOf(dh2);
        
        
        OfficeManager om = new OfficeManager("f","l","n","a","a","i");
        output.appendText(om.generateCommission(genComField.getText(), date1, date2));
        
        
    }


}
