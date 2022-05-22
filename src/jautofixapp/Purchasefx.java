
package jautofixapp;

//import jautofixapp.DBconnection;
//import static jautofixapp.DBconnection.con;
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
import jautofixapp.Model.PurchaseWithSppleir;
import javafx.scene.input.MouseEvent;
//import org.controlsfx.validation.Severity;
//import org.controlsfx.validation.ValidationSupport;
//import org.controlsfx.validation.Validator;

/**
 * FXML Controller class
 *
 * @author shammakh
 */
public class Purchasefx implements Initializable {

    private final ObservableList<DetailsPurchase> Data = FXCollections.observableArrayList();
    private final ObservableList<DetailsPurchase1> Data1 = FXCollections.observableArrayList();
    private final ObservableList<PurchaseWithSppleir> Data2 = FXCollections.observableArrayList();
 
    private final ObservableList<String> DataUnit = FXCollections.observableArrayList();
    private final ObservableList<String> DataSppleir = FXCollections.observableArrayList();
    
    private int index;
  //  ValidationSupport VS=new ValidationSupport();
 
   


 private TableView <DetailsPurchase> ta1;
 

//

   // @FXML // fx:id="zzz1"
  //  private Label zzz1; // Value injected by FXMLLoader
    private Label zzz2; // Value injected by FXMLLoader
    //@FXML
   // private Label zzz21;
    @FXML
    private Label Lspp;
    @FXML
    private Button bshow;
    @FXML
    private TableView<PurchaseWithSppleir> taIv;//taIv->Data2
    @FXML
    private TableColumn<PurchaseWithSppleir, Integer> d1;
    @FXML
    private TableColumn<PurchaseWithSppleir, Double> d2;
    @FXML
    private TableColumn<PurchaseWithSppleir, String> d3;
    @FXML
    private TableColumn<PurchaseWithSppleir, Integer> d4;
    @FXML
    private TableColumn<PurchaseWithSppleir, String> d5;
    @FXML
    private TableView<DetailsPurchase1> taD; /// taD -> Data1
    @FXML
    private TableColumn<DetailsPurchase1, Integer> e1;
    @FXML
    private TableColumn<DetailsPurchase1, String> e2;
    @FXML
    private TableColumn<DetailsPurchase1, String> e3;
    @FXML
    private TableColumn<DetailsPurchase1, Integer> e4;
    @FXML
    private TableColumn<DetailsPurchase1, Double> e5;
    @FXML
    private TableColumn<DetailsPurchase1,Double> e6;
    @FXML
    private Label zzz1;
    @FXML
    private Label GnAct;
    @FXML
    private Label LtotalInv1;
    @FXML
    private TextField Lcode1;
    @FXML
    private TextField Ltitle1;
    @FXML
    private TextField Lqty1;
    @FXML
    private TextField Lprice1;
    @FXML
    private ComboBox<String> cxu;
    @FXML
    private Label Lcxt1;
    @FXML
    private Label Ltotal1;
    @FXML
    private Button T1;
    @FXML
    private Button T2;
    @FXML
    private Button AddP1;
    @FXML
    private Button DeletP1;
    @FXML
    private Button savepi1;
    @FXML
    private Button newpi1;
    @FXML
    private TableView<DetailsPurchase1> tableP;
    @FXML
    private TableColumn<DetailsPurchase1, Integer> clp1;
    @FXML
    private TableColumn<DetailsPurchase1, String> clp2;
    @FXML
    private TableColumn<DetailsPurchase1, String> clp3;
    @FXML
    private TableColumn<DetailsPurchase1, Integer> clp4;
    @FXML
    private TableColumn<DetailsPurchase1, Double> clp5;
    @FXML
    private TableColumn<DetailsPurchase1, Double> clp6;
    
    @FXML // fx:id="cx2"
    private ComboBox<String> cx2; // Value injected by FXMLLoader  
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
        
           Ltitle1.setText("");
         Lcode1.setText("");
         Lqty1.setText("");
         Lprice1.setText("");
         Ltotal1.setText(""); 
   
         cxu.setValue("الوحدات");
    
    }
    
    
    @FXML 
     public void PutOnTable(ActionEvent e){
       // check the empty field 
       //code here ....
      if(Ltitle1.getText().isEmpty() || Lcode1.getText().isEmpty() || Lqty1.getText().isEmpty()|| Lprice1.getText().isEmpty() )
 { 
      // AddP.setDisable (false);
     Emptyfile();
     return;
      }
         String s= Ltitle1.getText();
         String z= Lcxt1.getText();
         int c =Integer.parseInt(Lcode1.getText());
                  int q =Integer.parseInt(Lqty1.getText());
                   double p =Double.parseDouble(Lprice1.getText());
                    double totalrow=q*p;
                    

         tableP.getItems().add(new DetailsPurchase1(c,s , z, q, p, totalrow));
       Emptyfile();
         System.out.println("table laoded");
      invTotal(); 
        }  
     
      @FXML
     public void New_Inv(ActionEvent e) throws SQLException{
         
         forNew();
     }
     private void forNew() throws SQLException{
         tableP.getItems().clear();
         Emptyfile();
          LtotalInv1.setText("0.0");
           cx2.setValue("موردين");
          Generation();
     }
     
     
     
   private void  invTotal(){
         double Tot=0.0;
            for(DetailsPurchase1 i:tableP.getItems())
   {  
       System.out.println(clp6.getCellData(i));
       Tot += clp6.getCellData(i);
       System.out.println(Tot);
        LtotalInv1.setText(String.valueOf(Tot));
       //  System.out.println(A);
   }   
       }

   
   
   private void Generation() throws SQLException{
        ChElement che=new ChElement();
        
       int  gs=che.intGene();
         String s;
        s = new convert().IntStr(gs);
         
            GnAct.setText(s);
           // Rand.setText(s);
            System.out.println(s);
   }
       
    
     @FXML
    public void putG(ActionEvent e){
        // Generation();
           Emptyfile();
        }
    
    
    @FXML
    public void culc(ActionEvent e){
         if( Lqty1.getText().isEmpty()|| Lprice1.getText().isEmpty() )
 {
     Emptyfile();
     System.out.println("enter both ");
     return;
      }
         int q =Integer.parseInt(Lqty1.getText());
                   double p =Double.parseDouble(Lprice1.getText());
                    double totalrow=q*p;
                 Ltotal1.setText(String.valueOf(totalrow));     
    }
    
     @FXML
    public void deletePurchaseRow() 
    {
         LtotalInv1.setText("0.0");
       ChElement cc=new ChElement();
       cc.DeletObsv(tableP);
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
             
            cxu.setItems(DataUnit);
          cxu.getItems().add("");
        }
     // 
      
    }
    
     // 
      
    
    @FXML
    public void SelectUnitCombo(ActionEvent e) throws SQLException{
     
        Lcxt1.setText(cxu.getValue());
        if(cxu.getValue() != null){
        } else {
            return;
        }
        ChElement chk=new ChElement();
        chk.CHkU(cxu.getValue());
   
    }
    
    
    
    @FXML
    public void LoadToDB(ActionEvent e) throws SQLException{

         if(tableP.getItems().isEmpty()){
          System.out.println("Empty can not contiene");  
          return;
         }
         ChElement ele=new ChElement(); 
        int x= Integer.parseInt(GnAct.getText());
        DAOInvoiceP dod=new DAOInvoiceP();
        dod.InsertNewGenerationP(x); 
        System.out.println("done 1");
      
for(DetailsPurchase1 i:tableP.getItems())
   {  
     int c=  clp1.getCellData(i);//code
   
     String ss=   clp2.getCellData(i);//title
   
     int u= ele.CHkU(clp3.getCellData(i)); //unit

     int u2=   clp4.getCellData(i);//qty
    
     double z= clp5.getCellData(i);//price of purchse

     double z2 =clp6.getCellData(i);//total
  
    DAOInvoiceP dod2=new DAOInvoiceP();
     dod2.InsertNewPurchase(c, ss, u, u2, z, z2, x);
     
     System.out.println("done 2");
   }   
        int spp=ele.CHkSpp(cx2.getValue());
        System.out.println(spp + "  "+ x);
          dod.UpdatePurchase(spp ,x);
          
          System.out.println("done 3");

          
          //-----------------------
      forNew();

    }
    
    
    @FXML
    public void SelectSppleirCombo(ActionEvent e) throws SQLException{
     
      Lspp.setText(cx2.getValue());  
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
 /* VS.registerValidator(Lcode, Validator.createEmptyValidator("text is requ"));
  VS.registerValidator(Lqty, Validator.createEmptyValidator("text is requ"));
  VS.registerValidator(cx1, Validator.createEmptyValidator("choose it is nessesry", Severity.ERROR));
  VS.registerValidator(Lprice, Validator.createRegexValidator("ok", "[0-9]*{20}", Severity.WARNING));
  */
  
  
    }
    private void conDBchecking() throws SQLException{
        DataBaseStateus st=new DataBaseStateus();
        if(st.StateUs()==false){
            System.out.println("close database must be open it");
            return;
        }
        if(st.StateUs()==true){
            System.out.println("open");
            Generation();
          SppleirCombo();          
           UnitCombo(); 
        }
        
       
    }
    
    public void init() throws SQLException{
                conDBchecking();
              LtotalInv1.setText("0.0");
            clp1.setCellValueFactory(cellData -> cellData.getValue().Code_Property().asObject());
            clp2.setCellValueFactory(cellData -> cellData.getValue().TitleProperty());
            clp3.setCellValueFactory(cellData -> cellData.getValue().Unit_Property());
            clp4.setCellValueFactory(cellData -> cellData.getValue().Qty_Property().asObject());
            clp5.setCellValueFactory(cellData -> cellData.getValue().PriceProperty().asObject());
            clp6.setCellValueFactory(cellData -> cellData.getValue().TotalProperty().asObject());
            
            e1.setCellValueFactory(cellData -> cellData.getValue().Code_Property().asObject());
            e2.setCellValueFactory(cellData -> cellData.getValue().TitleProperty());
            e3.setCellValueFactory(cellData -> cellData.getValue().Unit_Property());
            e4.setCellValueFactory(cellData -> cellData.getValue().Qty_Property().asObject());
            e5.setCellValueFactory(cellData -> cellData.getValue().PriceProperty().asObject());
            e6.setCellValueFactory(cellData -> cellData.getValue().TotalProperty().asObject());
            
            d1.setCellValueFactory(cellData -> cellData.getValue().PI_Property().asObject());
            d2.setCellValueFactory(cellData -> cellData.getValue().TotalInvoicProperty().asObject());
            d3.setCellValueFactory(cellData -> cellData.getValue().ID_SppleirProperty());
            d4.setCellValueFactory(cellData -> cellData.getValue().GnP_Property().asObject());
            d5.setCellValueFactory(cellData -> cellData.getValue().CdateProperty());
          
            
    }
    // if database  is connection get inital , if not show notification <the database is not connected>
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    init2();
        try {
            init();
        } catch (SQLException ex) {
            Logger.getLogger(Purchasefx.class.getName()).log(Level.SEVERE, null, ex);
        }
          
}


    @FXML
    private void ShowMePur(ActionEvent event) throws SQLException {
        DAOInvoiceP Dip=new DAOInvoiceP();
        Data2.clear();
      ResultSet rs= Dip.Pur_Spp();
      
        while (rs.next()) {
            Data2.addAll(new PurchaseWithSppleir(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
            
        }
        System.out.println("jautofixapp.Purchasefx.ShowMePur()");
        taIv.setItems(Data2);
        
    }
    
    
    public void GetSelection() throws SQLException{
        Data1.clear();
        index=taIv.getSelectionModel().getSelectedIndex();
        
        if(index<=-1){
            return;
        }
        
       // d4.getCellObservableValue(index);
       
        int xyz=d4.getCellData(index);
        System.out.println(xyz);
        DAOInvoiceP divo=new DAOInvoiceP();
       ResultSet r= divo.PurchaseInfoByGnp(xyz);
       while (r.next()){
           Data1.addAll(new DetailsPurchase1(r.getInt(1), r.getString(2), r.getString(3), r.getInt(4), r.getDouble(5), r.getDouble(6)));
           
       }
        taD.setItems(Data1);
       
      /*  A1.setText(c1.getCellData(index).toString());
     A2.setText(c3.getCellData(index));
         A3.setText(c4.getCellData(index));
         A4.setText(c6.getCellData(index).toString());
      AAA.setText(c5.getCellData(index).toString());
      AAA2.setText(A4.getText());
      A11.setText(c2.getCellData(index).toString());*/
 
    }

   

   
}