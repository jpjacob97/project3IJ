///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package projtwo.fxml;
//
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextArea;
//import javafx.scene.control.TextField;
//import projtwo.BikePart;
//import projtwo.UI;
//import projtwo.UI;
//import projtwo.WareHouse;
//
//public class FXMLDocumentController {
//
//    @FXML
//    private Button addPartButton;
//
//    @FXML
//    private Label label;
//
//    @FXML
//    private TextField addPartField;
//
//    @FXML
//    private TextField addWareHouseField;
//
//    @FXML
//    private Button AddWareHouse;
//
//    @FXML
//    private TextField inventoryFile;
//
//    @FXML
//    private TextField DisplayWareHouseField;
//
//    @FXML
//    private Button displayWareHouseButton;
//
//    @FXML
//    private TextField VanSwap;
//
//    @FXML
//    private TextField addVanField;
//
//    @FXML
//    private Button addVanButton;
//
//    @FXML
//    private Button addInventory;
//
//    @FXML
//    private TextField sellField;
//
//    @FXML
//    private Button sell;
//
//    @FXML
//    private TextArea displayTextArea1;
//    
//    @FXML
//    private TextField displayPartField;
//
//    @FXML
//    private Button displayPart;  
//    private UI ui=new UI();
//    
//    /**
//     * does the van adding.
//     * @param event 
//     */
//    @FXML
//    void handleAddVan(ActionEvent event) {
//        String name=addVanField.getText();
//        String out =ui.addWareHouse(name);
//        displayTextArea1.appendText(out+"\n");
//    }
//    
//    /**
//     * does the wareHouse adding.
//     * @param event 
//     */
//    @FXML
//    void handleAddWareHouse(ActionEvent event) {
//        String name=addVanField.getText();
//        String out =ui.addWareHouse(name);
//        displayTextArea1.appendText(out+"\n");
//    }
//    
//    /**
//     * adds a part to the main warehouse.
//     * @param event 
//     */
//    @FXML
//    void handleButtonAction(ActionEvent event) {
//        String part=addPartField.getText();
//        System.out.println(part);
//        ui.enter(part);
//        displayTextArea1.appendText("Added to wareHouseDB.txt"+"\n");
//    }
//    
//    /**
//     * prints the parts in a warehouse as requested.
//     * @param event 
//     */
//    @FXML
//    void handleDisplayWareHouse(ActionEvent event) {
//        String input=DisplayWareHouseField.getText();
//        List<String> nameType = Arrays.asList(input.split(","));
//        if(nameType.get(0).equals("all")){
//            ArrayList<BikePart> all=new ArrayList<>(ui.listAll());
//            if(nameType.get(1).equals("Name")){
//                ArrayList<BikePart> sorted=new ArrayList<>(ui.SortName(all));
//                all.clear();
//                for(BikePart bp:sorted){
//                    displayTextArea1.appendText(bp+"\n");
//                }            
//            }
//        }
//        else{
//            try {
//                String ware=nameType.get(0);
//                WareHouse parts=new WareHouse(ware);
//                ArrayList<BikePart> unSorted=new ArrayList<>(parts.getList());
//                if(nameType.get(1).equals("Name")){
//                    
//                    ArrayList<BikePart> sorted=new ArrayList<>(ui.SortName(unSorted));
//                    unSorted.clear();
//                    for(BikePart bp:sorted){
//                        displayTextArea1.appendText(bp+"\n");
//                    }            
//                }
//                else{
//                    ArrayList<BikePart> sorted=new ArrayList<>(ui.SortNum(unSorted));
//                    unSorted.clear();
//                    for(BikePart bp:sorted){
//                        displayTextArea1.appendText(bp+"\n");
//                    }                    
//                    
//                }
//            } 
//            catch (FileNotFoundException ex) {
//                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
//    
//    /**
//     * reads an inventory file to the main warehouse.
//     * @param event 
//     */
//    @FXML
//    void handleInventoryFile(ActionEvent event) {
//        String fileName= inventoryFile.getText();
//        displayTextArea1.appendText(ui.read(fileName)+"\n");
//    }
//    
//    /**
//     * sells a part from a specific warehouse.
//     * @param event 
//     */
//    @FXML
//    void handleSell(ActionEvent event) {
//        try {
//            String input=sellField.getText();
//            List<String> namePlace = Arrays.asList(input.split(","));
//            WareHouse wh=new WareHouse(namePlace.get(1));
//            int x= Integer.parseInt(namePlace.get(0));
//            BikePart part= wh.sell(x);
//            displayTextArea1.appendText(part.getName()+" $"+part.getPrice()+"\n");
//            Date date = new Date();
//            displayTextArea1.appendText(date.toString()+"\n"); 
//            if(part.getPrice()==part.getSalePrice())
//                    displayTextArea1.appendText("On Sale."+"\n");                
//            else
//                    displayTextArea1.appendText("Not On Sale."+"\n");
//            
//            
//        } 
//        catch (FileNotFoundException ex) {
//            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    /**
//     * exchanges parts between warehouses based on the file input.
//     * @param event 
//     */
//    @FXML
//    void handleVanExchange(ActionEvent event) {
//        
//        String fileName=VanSwap.getText();
//        ui.swap(fileName);
//        displayTextArea1.appendText("Exchange Complete."+"\n");
//
//    }
//    
//    /**
//     * finds a part in all warehouses and displays it.
//     * @param event 
//     */
//    @FXML
//    void handleDisplayPart(ActionEvent event){
//        String part=displayPartField.getText();
//        ArrayList<BikePart> all= new ArrayList<>(ui.listAll());
//        boolean x= false;
//        for(BikePart bp: all){
//            if(bp.getName().equals(part)){
//                displayTextArea1.appendText(bp.toString()+"\n");
//                x=true;
//            }
//        }
//        if(x==false){
//            displayTextArea1.appendText("Part not found try again"+"\n");
//        }
//    }
//}
//
package projtwo.fxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FXMLDocumentController {

    @FXML
    private TextField password;

    @FXML
    private TextField userName;

    @FXML
    private Button login;

    @FXML
    void handleLoginButton(ActionEvent event) {
        
    }

    @FXML
    void handlePasswordIn(ActionEvent event) {

    }

    @FXML
    void handleUserNameInput(ActionEvent event) {

    }

}