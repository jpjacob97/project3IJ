package fxml;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
    private TextArea output;

    @FXML
    private DatePicker startDate;

    @FXML
    private DatePicker endDate;

    @FXML
    void handleCheckMin(ActionEvent event) throws FileNotFoundException {
        int min=5;
        Fleet fleet=new Fleet();
        ArrayList<WareHouse> fleetlist = fleet.getFleet();
        for(WareHouse wh: fleetlist){
            for(BikePart bp: wh.getList()){
                if (bp.getQuantity() < min){
                    output.appendText(bp.getName()+","+wh.getName()+","+bp.getQuantity()+"\n");
                }
            }
                
        }
        
    }

    @FXML
    void handleDisplayByName(ActionEvent event) throws FileNotFoundException {
        Fleet fleet = new Fleet();
        ArrayList<WareHouse> fleetlist = fleet.getFleet();
        for(WareHouse wh: fleetlist){
            if(wh.hasPart(displayByNameField.getText())){
                output.appendText("WareHouse: "+wh.getName()+"\n BikePart: "+wh.findPartName(displayByNameField.getText()).toString());
            }
        }
        
    }

    @FXML
    void handleDisplayByNum(ActionEvent event) throws FileNotFoundException {
        Fleet fleet = new Fleet();
        ArrayList<WareHouse> fleetlist = fleet.getFleet();
        for(WareHouse wh: fleetlist){
            if(wh.hasPart(displayByNameField.getText())){
                output.appendText("WareHouse: "+wh.getName()+"\n BikePart: "+wh.findPartName(displayByNameField.getText()).toString());
            }
        }
    }

    @FXML
    void handleGenCommission(ActionEvent event) throws FileNotFoundException {
        //creates localdate object to then be converted to date
        LocalDate dh1=startDate.getValue();
        Date date1= java.sql.Date.valueOf(dh1);
        
        LocalDate dh2=endDate.getValue();        
        Date date2= java.sql.Date.valueOf(dh2);
        
        
        OfficeManager om = new OfficeManager("f","l","n","a","a");
        output.appendText(om.generateCommission(genComField.getText(), date1, date2));
        
        
    }

}
