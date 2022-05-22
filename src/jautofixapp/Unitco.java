/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jautofixapp;

import jautofixapp.Model.Unit;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.TableColumn;

/**
 *
 * @author shammakh
 */
public class Unitco implements Initializable {

@FXML
private TableView <Unit>  tbv;  
@FXML
private  TableColumn <Unit,Integer>  cv1;  
@FXML
private TableColumn <Unit,String> cv2;
@FXML
private TableView <Unit>  tbv2;  
@FXML
private  TableColumn <Unit,Integer>  col_add1;  
@FXML
private TableColumn <Unit,String> col_add2;
@FXML
private TextField untxt;
@FXML
private Button viewbt;
@FXML
private TextField un_txt; // anthor page
@FXML
private Button bt_add;

SpecialAlert alert = new SpecialAlert();
 private final ObservableList<Unit> UnitData =  FXCollections.observableArrayList();
 private final ObservableList<Unit> Data = FXCollections.observableArrayList();
 private  final ObservableList<Unit> Data1 = FXCollections.observableArrayList();



 public void emptyobject() throws ClassNotFoundException{ 
 Unit EmptyU=new Unit();
   Data1.add(EmptyU);
   populateUnit2(Data1);
   
 }

 private void resetWindow()
    {
        un_txt.setText("");
       
    }
 private boolean checkInputs()
    {
        if (un_txt.getText().equals("") ) {
            alert.show("Required fields are missing", "fields cannot be empty!", AlertType.INFORMATION);
            return false;
        }
       
        else 
        try {
            un_txt.getText();
            System.out.println("its true");
            return true;
        }
        catch (NumberFormatException ex) {
            alert.show("Error", "Price should be a decimal number (eg: 40, 10.5)", AlertType.ERROR);
            return false;
        }
    }


    @FXML
    private void searchunit (ActionEvent e) throws ClassNotFoundException, SQLException {
       
            //Get Employee information
            DAOunit emp1 =new DAOunit();
              ResultSet  rs ;
            rs = emp1.getUnitInfo();
            while(rs.next()){
            Unit un=new Unit();
           
        un.setID_Unit(rs.getInt("ID_Unit"));
       
        un.setUnit(rs.getString("Unit"));
        
        UnitData.add(un);
        
        }
            
    populateUnit(UnitData);
    viewbt.setDisable(true);
   // viewbt.setVisible(false);
 //   viewbt.disableProperty();
    }    
        
    

    @FXML
    private void populateUnit (ObservableList<Unit> UnitData) throws ClassNotFoundException {
        //Set items to the employeeTable
        tbv.setItems(UnitData);
    }
    @FXML
    private void populateUnit2 (ObservableList<Unit> UnitData) throws ClassNotFoundException {
      col_add1.setCellValueFactory(cellData -> cellData.getValue().ID_UnitProperty().asObject());
     col_add2.setCellValueFactory(cellData -> cellData.getValue().UnitProperty()); 
        tbv2.setItems(UnitData);
    }
    
   
    
    @FXML
    public void Add_unit(ActionEvent e) throws SQLException, ClassNotFoundException{
if(checkInputs())  {
   
        DAOunit emp =new DAOunit();
    System.out.println(un_txt.getText());
        emp.InsertUnit(un_txt.getText());
   resetWindow()  ;
   tbv2.refresh();
   emptyobject();
   tbv2.getItems().clear();
  //  getMessage("Inserted");
    
    }   }
    @FXML
    public void V2_unit(ActionEvent e) throws SQLException, ClassNotFoundException{
   DAOunit emp =new DAOunit();
   Data.clear();
    ResultSet  rs1;
            rs1 = emp.getUnitInfo();
                     while(rs1.next()){
            Unit un2=new Unit();
           
        un2.setID_Unit(rs1.getInt("ID_Unit"));
       
        un2.setUnit(rs1.getString("Unit"));
        
        Data.add(un2);
  
}  rs1.close();
                   //  tbv2.getItems().clear();
populateUnit2(Data);
    }   


    
   
 
// table.getSelectionModel().setCellSelectionEnabled(true) ;


@FXML
    private void tabedit (ActionEvent e) throws SQLException {
       tbv.setEditable(true);
    }
     
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
 cv1.setCellValueFactory(cellData -> cellData.getValue().ID_UnitProperty().asObject());
 cv2.setCellValueFactory(cellData -> cellData.getValue().UnitProperty()); 
  tbv.setItems(UnitData);
  
  
  //col_add1.setCellValueFactory(cellData -> cellData.getValue().ID_UnitProperty().asObject());
// col_add2.setCellValueFactory(cellData -> cellData.getValue().UnitProperty()); 
 // tbv2.setItems(UnitData);
    
    }
    
}
