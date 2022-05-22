
package jautofixapp;

import jautofixapp.Model.StackFull;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author shammakh
 */
public class StockController implements Initializable {
     private ObservableList<StackFull> DataStack1 = FXCollections.observableArrayList();
     private final ObservableList<StackFull> Data = FXCollections.observableArrayList();
    private final ObservableList<StackFull> DataStack2 = FXCollections.observableArrayList();
  //  private final ObservableList<String> DataUnit = FXCollections.observableArrayList();
  //  private final ObservableList<String> DataSppleir = FXCollections.observableArrayList();
    
    
     @FXML
    private TableView<StackFull> table1;

    @FXML
    private TableColumn<StackFull, Integer> cl1;

    @FXML
    private TableColumn<StackFull, Integer> cl2;

    @FXML
    private TableColumn<StackFull, String> cl3;

    @FXML
    private TableColumn<StackFull, String> cl4;

    @FXML
    private TableColumn<StackFull, Integer> cl5;

    @FXML
    private TableColumn<StackFull, Double> cl6;
    @FXML
    private TableColumn<StackFull, Double> cl7;

    //-------------------------
   
    @FXML
    private TableView<StackFull> table2;
    @FXML
    private TableColumn<StackFull, Integer> clv1;
    @FXML
    private TableColumn<StackFull, Integer> clv2;
    @FXML
    private TableColumn<StackFull, String> clv3;
    @FXML
    private TableColumn<StackFull, String> clv4;
    @FXML
    private TableColumn<StackFull, Integer> clv5;
    @FXML
    private TableColumn<StackFull, Double> clv6;
     @FXML
    private TableView<StackFull> table3;
    @FXML
    private TableColumn<StackFull, Integer> cc1;
    @FXML
    private TableColumn<StackFull, Integer> cc2;
    @FXML
    private TableColumn<StackFull, String> cc3;
    @FXML
    private TableColumn<StackFull, String> cc4;
    @FXML
    private TableColumn<StackFull, Integer> cc5;
    @FXML
    private TableColumn<StackFull, Double> cc6;
    @FXML
    private TableColumn<StackFull, Double> cc7;
    @FXML
    private Label L1;
    @FXML
    private Label L2;
    @FXML
    private Label L3;
    @FXML
    private Label L4;
    @FXML
    private TextField L5;
    @FXML
    private TextField L6;
  
    @FXML
    private Label L0;
    @FXML
    private Button Ed_bt;
    @FXML
    private Button S_bt;
     
    private int index ; 
/**
     *
     * @param e
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException    
     */
   
    
   
    @FXML
    public void view_table1(ActionEvent e) throws SQLException,ClassNotFoundException  {
        
       DataStack1.clear(); 
        DataStack1= DataToStk();
        table1.setItems(DataStack1);     
    }
    public void view_table3(ActionEvent e) throws SQLException,ClassNotFoundException  {
        
       DataStack1.clear(); 
        DataStack1= DataToStk();
        table3.setItems(DataStack1);     
    }
    public void view_table2(ActionEvent e) throws SQLException{
        DataStack2.clear();
       
        DAO_Stack Stq2 =new DAO_Stack();
   
         try (ResultSet rs2 = Stq2.getStackAv()) {
             while(rs2.next()){
                 StackFull ful=new StackFull();
                 
                 ful.setID_Stack(rs2.getInt(1));
              ful.setCode(rs2.getInt(2));
               ful.setTitle( rs2.getString(3));
              ful.setUnit(rs2.getString(4));
                ful.setQtyStock(rs2.getInt(5));
              // ful.setPriceP(rs2.getDouble(6));
             ful.setPriceST(rs2.getDouble(6));
                 
                 DataStack1.add(ful);
                 
             }
         }
                     table2.setItems(DataStack2);  
    }
    public void editPrice(ActionEvent e){
        S_bt.setDisable(false);
        L5.setDisable(false);
        L6.setDisable(false);
        Ed_bt.setDisable(true);
        L5.setText(cc6.getCellData(index).toString());
        L6.setText(cc7.getCellData(index).toString());
        
    } 
    public void SaveEditPrice(ActionEvent e) throws SQLException{
       String s1=L5.getText();
       String s2=L6.getText();
        Double d1=Double.parseDouble(s1);
        Double d2=Double.parseDouble(s2);
        Updata_Db(d1,d2);
   
    
    
        System.out.println("ok  ");
       
        table3.autosize();
     
        Ed_bt.setDisable(false);
        S_bt.setDisable(true);
        L5.setDisable(true);
        L6.setDisable(true);
    } 
    public void SelectionFromTable3(){
    index=table3.getSelectionModel().getSelectedIndex();
        
        if(index<=-1){
            Ed_bt.setDisable(true);
            return;
        }  
        L0.setText(cc1.getCellData(index).toString());
        L1.setText(cc2.getCellData(index).toString());
        L2.setText(cc3.getCellData(index));
        L3.setText(cc4.getCellData(index));
        L4.setText(cc5.getCellData(index).toString());
        L5.setText(cc6.getCellData(index).toString());
        L6.setText(cc7.getCellData(index).toString());
        
    } 
    public void Updata_Db(double x1,double x2) throws SQLException{
        System.out.println("jautofixapp.StockController.Updata_Db()");
        
          DataStack1.get(index).setPriceP(x1);
        DataStack1.get(index).setPriceST(x2);
        table3.refresh();
         DAO_Stack sss= new DAO_Stack();
    int in = cc1.getCellData(index);
        System.out.println(in);
    sss.updatePrices(x1, x2, in); 
    
        table3.setItems(DataStack1); 
      SpecialAlert alert = new SpecialAlert();
      
      alert.show("Enter Values; ", x1+"  \n  "+ x2, Alert.AlertType.INFORMATION);
       
      
    }
    
   //--------------------------
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        init1();
        init2();
        init3();
           
         
    }   
    
    private void init1(){
          cl1.setCellValueFactory(cellData -> cellData.getValue().ID_Property().asObject());
            cl2.setCellValueFactory(cellData -> cellData.getValue().Code_Property().asObject());
            cl3.setCellValueFactory(cellData -> cellData.getValue().Title_Property());
            cl4.setCellValueFactory(cellData -> cellData.getValue().Unit_Property());
            cl5.setCellValueFactory(cellData -> cellData.getValue().QtyStack_Property().asObject());
            cl6.setCellValueFactory(cellData -> cellData.getValue().PriceP_Property().asObject());
            cl7.setCellValueFactory(cellData -> cellData.getValue().PriceST_Property().asObject());
    }
    private void init2(){
          clv1.setCellValueFactory(cellData -> cellData.getValue().ID_Property().asObject());
            clv2.setCellValueFactory(cellData -> cellData.getValue().Code_Property().asObject());
            clv3.setCellValueFactory(cellData -> cellData.getValue().Title_Property());
            clv4.setCellValueFactory(cellData -> cellData.getValue().Unit_Property());
            clv5.setCellValueFactory(cellData -> cellData.getValue().QtyStack_Property().asObject());
           // cl6.setCellValueFactory(cellData -> cellData.getValue().PriceP_Property().asObject());
            clv6.setCellValueFactory(cellData -> cellData.getValue().PriceST_Property().asObject());
    }
    private void init3(){
          cc1.setCellValueFactory(cellData -> cellData.getValue().ID_Property().asObject());
            cc2.setCellValueFactory(cellData -> cellData.getValue().Code_Property().asObject());
            cc3.setCellValueFactory(cellData -> cellData.getValue().Title_Property());
            cc4.setCellValueFactory(cellData -> cellData.getValue().Unit_Property());
            cc5.setCellValueFactory(cellData -> cellData.getValue().QtyStack_Property().asObject());
            cc6.setCellValueFactory(cellData -> cellData.getValue().PriceP_Property().asObject());
            cc7.setCellValueFactory(cellData -> cellData.getValue().PriceST_Property().asObject());
            L1.setText(" ");
            L2.setText(" ");
            L3.setText(" ");
            L4.setText(" ");
            L5.setText("0.00 ");
            L6.setText("0.00 ");
             L0.setText("");
    }
    private ObservableList<StackFull> DataToStk () throws SQLException{
        
        Data.clear(); 
        DAO_Stack Stq =new DAO_Stack();
    
         try (ResultSet rs2 = Stq.getStackAv()) {
             while(rs2.next()){
                 StackFull full=new StackFull();
                 
                 full.setID_Stack(rs2.getInt(1));
              full.setCode(rs2.getInt(2));
               full.setTitle( rs2.getString(3));
              full.setUnit(rs2.getString(4));
                full.setQtyStock(rs2.getInt(5));
               full.setPriceP(rs2.getDouble(6));
              full.setPriceST(rs2.getDouble(7));
              Data.add(full);
             }
    }
         return Data;
    }
     
}


   


