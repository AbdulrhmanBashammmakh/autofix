
package jautofixapp;

import static jautofixapp.DBconnection.con;
import jautofixapp.Func.convert;
import jautofixapp.Model.ChElement;
import jautofixapp.Model.DetailsPurchase;
import jautofixapp.Model.DetailsPurchase1;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.controlsfx.validation.Severity;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

/**
 * FXML Controller class
 *
 * @author shammakh
 */
public class PurchController implements Initializable {

    private final ObservableList<DetailsPurchase> Data = FXCollections.observableArrayList();
 
    private final ObservableList<String> DataUnit = FXCollections.observableArrayList();
    private final ObservableList<String> DataSppleir = FXCollections.observableArrayList();
    
    ValidationSupport VS=new ValidationSupport();
 
   


  
    private TableView <DetailsPurchase> ta1;
 

//


    @FXML // fx:id="table"
    private TableView<DetailsPurchase1> table; // Value injected by FXMLLoader

    @FXML // fx:id="cl1"
    private TableColumn<DetailsPurchase1, Integer> cl1; // Value injected by FXMLLoader

    @FXML // fx:id="cl2"
    private TableColumn<DetailsPurchase1, String> cl2; // Value injected by FXMLLoader

    @FXML // fx:id="cl3"
    private TableColumn<DetailsPurchase1, String> cl3; // Value injected by FXMLLoader

    @FXML // fx:id="cl4"
    private TableColumn<DetailsPurchase1, Integer> cl4; // Value injected by FXMLLoader

    @FXML // fx:id="cl5"
    private TableColumn<DetailsPurchase1, Double> cl5; // Value injected by FXMLLoader

    @FXML // fx:id="cl6"
    private TableColumn<DetailsPurchase1, Double> cl6; // Value injected by FXMLLoader

    @FXML // fx:id="Lcode"
    private TextField Lcode; // Value injected by FXMLLoader

    @FXML // fx:id="Ltitle"
    private TextField Ltitle; // Value injected by FXMLLoader

    @FXML // fx:id="Lqty"
    private TextField Lqty; // Value injected by FXMLLoader

    @FXML // fx:id="Lprice"
    private TextField Lprice; // Value injected by FXMLLoader

    @FXML // fx:id="cx1"
    private ComboBox<String> cx1; // Value injected by FXMLLoader

    @FXML // fx:id="Ltotal"
    private Label Ltotal; // Value injected by FXMLLoader
    @FXML //
    private Label LtotalInv ;// Value injected by FXMLLoader

    @FXML // fx:id="ttt"
    private Button ttt; // Value injected by FXMLLoader

    @FXML // fx:id="ttt1"
    private Button ttt1; // Value injected by FXMLLoader

    @FXML // fx:id="AddP"
    private Button AddP; // Value injected by FXMLLoader

    @FXML // fx:id="cx2"
    private ComboBox<String> cx2; // Value injected by FXMLLoader
    @FXML
    private TextField Rand; // Value injected by FXMLLoader

    @FXML // fx:id="DeletP"
    private Button DeletP; // Value injected by FXMLLoader

    @FXML // fx:id="savepi"
    private Button savepi; // Value injected by FXMLLoader

    @FXML // fx:id="newpi"
    private Button newpi; // Value injected by FXMLLoader

    @FXML // fx:id="hm"
    private Button hm; // Value injected by FXMLLoader

    @FXML // fx:id="zzz"
    private Label zzz; // Value injected by FXMLLoader

    @FXML // fx:id="zzz1"
    private Label zzz1; // Value injected by FXMLLoader
    @FXML 
    private Label zzz2; // Value injected by FXMLLoader
    @FXML
    private Button editP;

    /**
     *
     * @param e
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException    
     */
//------------------------------------------------------------------------     
    public void View_Detials(ActionEvent e) throws SQLException, ClassNotFoundException{
    DAOInvoiceP DPS= new DAOInvoiceP();
    Data.clear();
    ResultSet  rs1;
    rs1=DPS.DetialsPurchaseInfo();
    while(rs1.next()){
        DetailsPurchase Dp=new DetailsPurchase();
     
         Dp.setDP(rs1.getInt(1));
          Dp.setCode(rs1.getInt(2));
           Dp.setTitle(rs1.getString(3));
           Dp.setID_Unit(rs1.getInt(4));
            Dp.setQty(rs1.getInt(5));
             Dp.setPriceP(rs1.getDouble(6));
              Dp.setTotal(rs1.getDouble(7));
                  Data.add(Dp);
        
    }
    
            ta1.setItems(Data);
    }
    //------------------------------------------------------------
    private void Emptyfile(){
       
           Ltitle.setText("");
         Lcode.setText("");
         Lqty.setText("");
         Lprice.setText("");
         Ltotal.setText(""); 
         zzz2.setText(" ");
         cx1.setValue("الوحدات");
        
      //   LtotalInv.setText("");
    }
    
    
    @FXML 
     public void PutOnTable(ActionEvent e){
       // check the empty field 
       //code here ....
      if(Ltitle.getText().isEmpty() || Lcode.getText().isEmpty() || Lqty.getText().isEmpty()|| Lprice.getText().isEmpty() )
 { 
      // AddP.setDisable (false);
     Emptyfile();
     return;
      }
      
       
       //
         String s= Ltitle.getText();
         String z= zzz2.getText();
         int c =Integer.parseInt(Lcode.getText());
                  int q =Integer.parseInt(Lqty.getText());
                   double p =Double.parseDouble(Lprice.getText());
                    double totalrow=q*p;
                    

         table.getItems().add(new DetailsPurchase1(c,s , z, q, p, totalrow));
       Emptyfile();
         System.out.println("table laoded");
      invTotal(); 
        }  
     
      @FXML
     public void New_Inv(ActionEvent e) throws SQLException{
         
         forNew();
     }
     private void forNew() throws SQLException{
         table.getItems().clear();
         Emptyfile();
          LtotalInv.setText("0.0");
           cx2.setValue("موردين");
          Generation();
     }
     
     
     
   private void  invTotal(){
         double Tot=0.0;
            for(DetailsPurchase1 i:table.getItems())
   {  
       System.out.println(cl6.getCellData(i));
       Tot += cl6.getCellData(i);
       System.out.println(Tot);
        LtotalInv.setText(String.valueOf(Tot));
       //  System.out.println(A);
   }   
       }

   
   
   private void Generation() throws SQLException{
        ChElement che=new ChElement();
        
       int  gs=che.intGene();
         String s;
        s = new convert().IntStr(gs);
         
            zzz.setText(s);
            Rand.setText(s);
            System.out.println(s);
   }
       
    
     @FXML
    public void putG(ActionEvent e){
        // Generation();
           Emptyfile();
        }
    
    
    @FXML
    public void culc(ActionEvent e){
         if( Lqty.getText().isEmpty()|| Lprice.getText().isEmpty() )
 {
     Emptyfile();
     System.out.println("enter both ");
     return;
      }
         int q =Integer.parseInt(Lqty.getText());
                   double p =Double.parseDouble(Lprice.getText());
                    double totalrow=q*p;
                 Ltotal.setText(String.valueOf(totalrow));     
    }
    
     @FXML
    public void deletePurchaseRow() 
    {
         LtotalInv.setText("0.0");
       ChElement cc=new ChElement();
       cc.DeletObsv(table);
         invTotal();   
    }
  
    
//combo box unit
    public void UnitCombo() throws SQLException{
      DataUnit.clear();
      
        DAOunit dao=new DAOunit();
        try (ResultSet rs = dao.getUnitForCombobox()) {
            while (rs.next())
            { DataUnit.add(rs.getString("Unit"));
            }
             
            cx1.setItems(DataUnit);
          cx1.getItems().add("");
        }
     // 
      
    }
    
     // 
      
    
    @FXML
    public void SelectUnitCombo(ActionEvent e) throws SQLException{
     
        zzz2.setText(cx1.getValue());
        if(cx1.getValue() != null){
        } else {
            return;
        }
        ChElement chk=new ChElement();
        chk.CHkU(cx1.getValue());
   
    }
    
    
    
    @FXML
    public void LoadToDB(ActionEvent e) throws SQLException{
   
       con.setAutoCommit(true); 
   
         if(table.getItems().isEmpty()){
          System.out.println("Empty can not contiene");  
          return;
         }
         ChElement ele=new ChElement(); 
        int x= Integer.parseInt(zzz.getText());
        DAOInvoiceP dod=new DAOInvoiceP();
        dod.InsertNewGenerationP(x); 
        System.out.println("done 1");
      
for(DetailsPurchase1 i:table.getItems())
   {  
     int c=  cl1.getCellData(i);//code
   
     String ss=   cl2.getCellData(i);//title
   
     int u= ele.CHkU(cl3.getCellData(i)); //unit

     int u2=   cl4.getCellData(i);//qty
    
     double z= cl5.getCellData(i);//price of purchse

     double z2 =cl6.getCellData(i);//total
  
    DAOInvoiceP dod2=new DAOInvoiceP();
     dod2.InsertNewPurchase(c, ss, u, u2, z, z2, x);
     
     System.out.println("done 2");
   }   
        int spp=ele.CHkSpp(cx2.getValue());
        System.out.println(spp + "  "+ x);
        //DAOInvoiceP dod3=new DAOInvoiceP();
          dod.UpdatePurchase(spp ,x);
          
          System.out.println("done 3");
        //  con.commit();
          con.close();
          
          //-----------------------
      forNew();
          // con.rollback();
    }
    
    
    @FXML
    public void SelectSppleirCombo(ActionEvent e) throws SQLException{
     
        cx2.getValue();
        if(cx2.getValue() != null){
        } else {
            return;
        }
         ChElement ch=new ChElement();
         ch.CHkSpp( cx2.getValue());
  
    }
      //combo box Sppleir
    
    public void SppleirCombo() throws SQLException{
        DataSppleir.clear();
      DAO_Sppleir dao=new DAO_Sppleir();
        try (ResultSet rs1 = dao.getSppleirForCombobox()) {
            while (rs1.next())
            { DataSppleir.add(rs1.getString("FN"));
            } }
           cx2.getItems().add("");
       cx2.setItems(DataSppleir);
      
    }
    
  
   
    
    public void init2() {
        // VS.errorDecorationEnabledProperty(false);
      //  VS.setErrorDecorationEnabled(false);
  VS.registerValidator(Lcode, Validator.createEmptyValidator("text is requ"));
  VS.registerValidator(Lqty, Validator.createEmptyValidator("text is requ"));
  VS.registerValidator(cx1, Validator.createEmptyValidator("choose it is nessesry", Severity.ERROR));
  VS.registerValidator(Lprice, Validator.createRegexValidator("ok", "[0-9]*{20}", Severity.WARNING));
  
  
  
    }
    public void init() throws SQLException{
         Generation();
          LtotalInv.setText("0.0");
          SppleirCombo();          
            UnitCombo();
            
            cl1.setCellValueFactory(cellData -> cellData.getValue().Code_Property().asObject());
            cl2.setCellValueFactory(cellData -> cellData.getValue().TitleProperty());
            cl3.setCellValueFactory(cellData -> cellData.getValue().Unit_Property());
            cl4.setCellValueFactory(cellData -> cellData.getValue().Qty_Property().asObject());
            cl5.setCellValueFactory(cellData -> cellData.getValue().PriceProperty().asObject());
            cl6.setCellValueFactory(cellData -> cellData.getValue().TotalProperty().asObject());
            
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    init2();
        try {
            init();
        } catch (SQLException ex) {
            Logger.getLogger(PurchController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
}

    @FXML
    private void putG(MouseEvent event) {
    }
}