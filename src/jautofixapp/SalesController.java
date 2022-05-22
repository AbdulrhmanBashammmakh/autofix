//re design UI sales

package jautofixapp;
import static jautofixapp.DBconnection.con;
import jautofixapp.Func.convert;
import jautofixapp.Model.ChElement;
import jautofixapp.Model.GenS;
import jautofixapp.Model.Sales;
import jautofixapp.Model.StackFull;
import jautofixapp.Model.ordersaleFull;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SalesController implements Initializable {
     private final ObservableList<StackFull> DataStq = FXCollections.observableArrayList();
     private final ObservableList<ordersaleFull> DataSales = FXCollections.observableArrayList();
     private final ObservableList<ordersaleFull> DataSales2 = FXCollections.observableArrayList();
     private final ObservableList<Sales> saleDils = FXCollections.observableArrayList();
    private int index;
    private  int index2;
    private  int index3;

    @FXML
    private Button rest;

    @FXML
    private TableColumn<ordersaleFull, Integer> cl1;

    @FXML
    private TableColumn<ordersaleFull, String> cl2;

    @FXML
    private TableColumn<ordersaleFull, String> cl3;

    @FXML
    private TableColumn<ordersaleFull, Integer> cl4;

    @FXML
    private TableColumn<ordersaleFull, Double> cl5;

    @FXML
    private TableColumn<ordersaleFull, Double> cl6;

    @FXML
    private TextField AAA2;

    @FXML
    private TextField gns;

    @FXML
    private TextField AAA;

    @FXML
    private TextField clint;

    @FXML
    private Label A1;

    @FXML
    private Label A2;

    @FXML
    private Label A4;

    @FXML
    private Label A3;
    
    @FXML
    private Label A11;

    @FXML
    private TableColumn<StackFull, Integer> c1;

    @FXML
    private TableColumn<StackFull, Integer> c2;

    @FXML
    private TableColumn<StackFull, String> c3;

    @FXML
    private TableColumn<StackFull, String> c4;

    @FXML
    private TableColumn<StackFull, Integer> c5;

    @FXML
    private TableColumn<StackFull, Double> c6;
    @FXML
    private TableView<ordersaleFull> salesOrdertable;
    @FXML
    private TableView<StackFull> stqTable;
    @FXML
    private Label totalofinv;
    @FXML
    private Button AddToSales;
    @FXML
    private Button saveBtInv;
    @FXML
    private Button delBut;
    @FXML
    private TableView<Sales> tab1;
    @FXML
    private TableColumn<Sales, Integer> n1;
    @FXML
    private TableColumn<Sales, String> n2;
    @FXML
    private TableColumn<Sales, Double> n3;
    @FXML
    private TableColumn<Sales, Double> n4;
    @FXML
    private TableColumn<Sales, String> n5;
    @FXML
    private TableView<ordersaleFull> tab2;
    @FXML
    private TableColumn<ordersaleFull, Integer>  m1;
    @FXML
    private TableColumn<ordersaleFull, String>  m2;
    @FXML
    private TableColumn<ordersaleFull, String>  m3;
    @FXML
    private TableColumn<ordersaleFull, Integer>  m4;
    @FXML
    private TableColumn<ordersaleFull, Double> m5;
    @FXML
    private TableColumn<ordersaleFull, Double>  m6;
    
    
    

   
      
    @FXML
      public void AddSales(ActionEvent e){
        delBut.setDisable(true);
         AddToSales.setDisable(true);
         if(Integer.parseInt(AAA.getText())<=0){
             resetRedy();
             AAA2.setDisable(true);
              
             //get massege 
             return;
         }
          orgSales();
         salesOrdertable.setItems(DataSales);
         invTotal();
           resetRedy();
         AAA2.setDisable(true);
         saveBtInv.setDisable(false);
// 
    }
   
      
    @FXML
      public void reset(ActionEvent e){
        resetRedy();
       // 
    }
     
    @FXML
    public void GetEnableForbutten(ActionEvent e){
     
    AAA2.setDisable(false);
}
    @FXML
    public void GetSelection(){
         index=stqTable.getSelectionModel().getSelectedIndex();
        
              if(index<=-1 ){
                          return;
                            }
        if(c5.getCellData(index)<=0 || c6.getCellData(index)<=0 ){
                         AddToSales.setDisable(true);
                        A1.setText(c1.getCellData(index).toString());
                        A2.setText(c3.getCellData(index));
                        A3.setText(c4.getCellData(index));
                        A4.setText(c6.getCellData(index).toString());
                        AAA.setText(c5.getCellData(index).toString());
                        AAA2.setText(A4.getText());
                        A11.setText(c2.getCellData(index).toString());
        }
        else{
                      AddToSales.setDisable(false);
                      A1.setText(c1.getCellData(index).toString());
                      A2.setText(c3.getCellData(index));
                      A3.setText(c4.getCellData(index));
                      A4.setText(c6.getCellData(index).toString());
                      AAA.setText(c5.getCellData(index).toString());
                      AAA2.setText(A4.getText());
                      A11.setText(c2.getCellData(index).toString());
      
        }
 
    }
    
    @FXML
    public void GetSelectionSaleTable(){
         index2=salesOrdertable.getSelectionModel().getSelectedIndex();
       
        if(index2<=-1){
         
            return;
        }
          saveBtInv.setDisable(false);
          delBut.setDisable(false);
          
  //
    }
  
    @FXML
    public void deletePurchaseRow() 
    {
    delBut.setDisable(true);
        saveBtInv.setDisable(true);
      System.out.println("delelting");
      
        for (int i = 0; i < DataStq.size(); i++) {
             if(cl1.getCellData(index2).equals(c1.getCellData(i))){
                         retBackValue(i);
                          System.out.println("returened");
                                 }
           
                                                    }
  
                      totalofinv.setText("0.0");
                      ChElement cc=new ChElement();
                        cc.DeletObsvSale(salesOrdertable);
                           invTotal(); 
    }
    
    @FXML
    public void sava_gotoDb(ActionEvent event)throws SQLException {
      
     //   con.setAutoCommit(true); 
        if(salesOrdertable.getItems().isEmpty()){
          System.out.println("Empty can not contiunse");  
          return;
         }
        DAOInvoiceS lod =new DAOInvoiceS();
         int gert= Integer.parseInt(gns.getText());
         lod.InsertNewGenerationS(gert);
         System.out.println("done 1");
         
         for (ordersaleFull item : salesOrdertable.getItems()) {
            int c=cl4.getCellData(item);
            double pp=cl5.getCellData(item);
            double tt=cl6.getCellData(item);
             int idsq=cl1.getCellData(item);
             DAOInvoiceS lod1 =new DAOInvoiceS();
             lod1.InsertNewSales(c, pp, tt, idsq, gert);
              System.out.println("done 2");
        }
         String clint2=clint.getText();
         if(clint2.isEmpty()){
             clint2="زبون عام";
         }
         double totallOfInvoice=Double.parseDouble(totalofinv.getText());
        lod.UpdateSale(clint2, totallOfInvoice, 0, 0, gert);
        System.out.println("done 3");
        con.close();
        ForNew();
        SpecialAlert sa=new SpecialAlert();
        sa.show(" تم الادخال بنجاح", " okay", Alert.AlertType.CONFIRMATION);
    } 
   //--------------------------------------// 
@Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
             init1();
         } catch (SQLException ex) {
             Logger.getLogger(SalesController.class.getName()).log(Level.SEVERE, null, ex);
         }
             init2();
             init3();
             init4();
    }
    
     //--------------------------------------// 
    
    private void init1() throws SQLException{
            conDBchecking();
            c1.setCellValueFactory(cellData -> cellData.getValue().ID_Property().asObject());
            c2.setCellValueFactory(cellData -> cellData.getValue().Code_Property().asObject());
            c3.setCellValueFactory(cellData -> cellData.getValue().Title_Property());
            c4.setCellValueFactory(cellData -> cellData.getValue().Unit_Property());
            c5.setCellValueFactory(cellData -> cellData.getValue().QtyStack_Property().asObject());
            c6.setCellValueFactory(cellData -> cellData.getValue().PriceST_Property().asObject());
           // c7.setCellValueFactory(cellData -> cellData.getValue().PriceP_Property().asObject());
          //  Pricechecking();
           //stqTable.setItems(DataStq);
           
    }
    
    private void init2(){
            delBut.setDisable(true);
            saveBtInv.setDisable(true);
            AddToSales.setDisable(true);
            cl1.setCellValueFactory(cellData -> cellData.getValue().getID_StackProperty().asObject());
            cl2.setCellValueFactory(cellData -> cellData.getValue().Title_Property());
            cl3.setCellValueFactory(cellData -> cellData.getValue().Unit_Property());
            cl4.setCellValueFactory(cellData -> cellData.getValue().getQtySalesProperty().asObject());
            cl5.setCellValueFactory(cellData -> cellData.getValue().getPriceSalesProperty().asObject());
            cl6.setCellValueFactory(cellData -> cellData.getValue().getTotalProperty().asObject());
            salesOrdertable.setItems(DataSales);
    } 
    private void init3(){
            n1.setCellValueFactory(cellData -> cellData.getValue().GnS_Property().asObject());
            n2.setCellValueFactory(cellData -> cellData.getValue().NameCustProperty());
            n3.setCellValueFactory(cellData -> cellData.getValue().TotalInvoicProperty().asObject());
            n4.setCellValueFactory(cellData -> cellData.getValue().DicuntInvoicProperty().asObject());
            n5.setCellValueFactory(cellData -> cellData.getValue().CdateProperty());
            tab1.setItems(saleDils);
    } 
    private void init4(){
            m1.setCellValueFactory(cellData -> cellData.getValue().getID_StackProperty().asObject());
            m2.setCellValueFactory(cellData -> cellData.getValue().Title_Property());
            m3.setCellValueFactory(cellData -> cellData.getValue().Unit_Property());
            m4.setCellValueFactory(cellData -> cellData.getValue().getQtySalesProperty().asObject());
            m5.setCellValueFactory(cellData -> cellData.getValue().getPriceSalesProperty().asObject());
            m6.setCellValueFactory(cellData -> cellData.getValue().getTotalProperty().asObject());
            tab2.setItems(DataSales2);
    } 
        
      private void orgSales(){
                  AAA2.setDisable(true);
              index=stqTable.getSelectionModel().getSelectedIndex();
               ordersaleFull orf=   new ordersaleFull();
               orf.setGnS(Integer.parseInt(gns.getText()));
               orf.setID_Stack( Integer.parseInt(A1.getText()));
              String s= A2.getText();
              String u= A3.getText();
              orf.setTitle(s);
               orf.setUnit(u);
             Double pr= Double.parseDouble(AAA2.getText());
             orf.setPriceSales(pr);
            Integer qtt=   Integer.parseInt(AAA.getText());
  
  
     orf.setQtySales(qtt);
     
     orf.setTotal(pr*qtt);
    int id=c1.getCellData(index);
    int codeid=c2.getCellData(index);
    int newQtt=0;
    newQtt=c5.getCellData(index)-qtt;
    double psq= c6.getCellData(index);
    DataStq.set(index, new StackFull(id, codeid, s, u, newQtt, psq));
   DataSales.add(orf);
       // 
    } 
     
    private void retBackValue(int i){
            String s,u;     
            int asd= cl4.getCellData(index2);
            s=c3.getCellData(i);
            u=c4.getCellData(i);
            int id=c1.getCellData(i);
            int codeid=c2.getCellData(i);
            int newQtt=0;
            newQtt=c5.getCellData(i)+asd;
            double psq= c6.getCellData(i);
            DataStq.set(i, new StackFull(id, codeid, s, u, newQtt, psq)); 
            System.out.println("X2");
      
    }
     private void conDBchecking() throws SQLException{
        DataBaseStateus st=new DataBaseStateus();
        if(st.StateUs()==false){
            System.out.println("close database must be open it");
            return;
        }
        if(st.StateUs()==true){
            System.out.println("open");
             Loadstack();
             Generation();
        }
    }
      private void resetRedy(){
        A1.setText("...");
        A2.setText("...");
        A3.setText("...");
        A4.setText("...");
        A11.setText("...");
        AAA.setText("");
        AAA2.setText("");
        clint.setText("");
       // 
    }
      private void ForNew(){
       resetRedy();
       Generation();
       salesOrdertable.getItems().clear();
       // 
    }
      private void  invTotal(){
                 double Tot=0.0;
                 for(ordersaleFull i:salesOrdertable.getItems())
                      {  
                      System.out.println(cl6.getCellData(i));
                      Tot += cl6.getCellData(i);
                        System.out.println(Tot);
                          totalofinv.setText(String.valueOf(Tot));
                          if(Tot!=0.0 ){
                           //     delBut.setDisable(true);
        
                                  }
                      }}
 
      private void Loadstack() throws SQLException{
                     DAO_Stack Stq =new DAO_Stack();
                     DataStq.clear();
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
                 
                                            DataStq.add(full);
                 
             }
         }
                                    stqTable.setItems(DataStq);  
       // 
    }
 private void Generation(){
         GenS SS=   new GenS();
         String s;
        s = new convert().IntStr(SS.getGenS());
            gns.setText(s);
            System.out.println(s);}
    
     private void ReadyToDataBase(){
         clint.getText();
         gns.getText();
         totalofinv.getText();
     
     
     }

    @FXML
    public void whenClickT1() throws SQLException {
       DataSales2.clear();
         index3=tab1.getSelectionModel().getSelectedIndex();
       
        if(index3<=-1){
         
            return;
        }
         int xyz=n1.getCellData(index3);
         DAOInvoiceS dox2=new DAOInvoiceS();
     ResultSet rs2=   dox2.getMyOrderSalesInfo(xyz);
      while(rs2.next()){
            ordersaleFull sz=new ordersaleFull();
            sz.setID_Stack(rs2.getInt(1));
            sz.setTitle(rs2.getString(2));
            sz.setUnit(rs2.getString(3));
            sz.setQtySales(rs2.getInt(4));
            sz.setPriceSales(rs2.getDouble(5));
            sz.setTotal(rs2.getDouble(6));
            DataSales2.add(sz);
        }
        tab2.setItems(DataSales2);
    }
        
    

    @FXML
    private void getMyInvoicSale(ActionEvent event) throws SQLException {
        
        DAOInvoiceS dox=new DAOInvoiceS();
    ResultSet rs=dox.getMyInvSales();
        while(rs.next()){
            Sales sz=new Sales();
            sz.setGnS(rs.getInt(1));
            sz.setNameCust(rs.getString(2));
            sz.setTotalOfAll(rs.getDouble(3));
            sz.setDiscount(rs.getDouble(4));
            sz.setCdate(rs.getString(5));
            saleDils.add(sz);
        }
        tab1.setItems(saleDils);
    }
    
}



/**
 * FXML Controller class
 *
 * @author shammakh
 */

    /**
     * Initializes the controller class.
     */
      
    

