
package jautofixapp.Model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author shammakh
 */
public class StackFull {
    private IntegerProperty ID_Stack;
	
	private IntegerProperty QtyStack;
	private DoubleProperty PriceP;
	private DoubleProperty PriceST;
	private BooleanProperty Avaliable_Items;
        
        private IntegerProperty DP;
        private IntegerProperty Code ;
       private StringProperty Title ;
      private  StringProperty ID_Unit ;

    public StackFull() {
        this.ID_Stack=new SimpleIntegerProperty(0);
       this.DP=new SimpleIntegerProperty(0);
        
        this.Code = new SimpleIntegerProperty(0);
        this.Title = new SimpleStringProperty("");
        this.ID_Unit =  new SimpleStringProperty("");
        
        this.QtyStack=new SimpleIntegerProperty(0);
        this.PriceP=new SimpleDoubleProperty(0.0);
        this.PriceST=new SimpleDoubleProperty(0.0);
    //    this.Avaliable_Items=new SimpleBooleanProperty();
        
    }
  /*  public StackFull(double PriceP ,double PriceST) {
        this.ID_Stack=ID_Stack;
       this.DP=DP;
        
        this.Code =Code;
        this.Title = Title;
        this.ID_Unit = ID_Unit;
        
        this.QtyStack=QtyStack;
        this.PriceP=new SimpleDoubleProperty(PriceP);
        this.PriceST=new SimpleDoubleProperty(PriceST);
    //    this.Avaliable_Items=new SimpleBooleanProperty();
        
    }*/
     public StackFull(int ID_Stack,int code,String tit,String unt,int QtyStack,double PriceP ,double PriceST,int DP ) {
        this.ID_Stack=new SimpleIntegerProperty(ID_Stack);
       this.DP=new SimpleIntegerProperty(DP);
        
        this.Code = new SimpleIntegerProperty(code);
        this.Title = new SimpleStringProperty(tit);
        this.ID_Unit =  new SimpleStringProperty(unt);
        
        this.QtyStack=new SimpleIntegerProperty(QtyStack);
        this.PriceP=new SimpleDoubleProperty(PriceP);
        this.PriceST=new SimpleDoubleProperty(PriceST);
      //  this.Avaliable_Items=new SimpleBooleanProperty(Av);
      // ,boolean Av }
     }
     public StackFull(int ID_Stack,int code,String tit,String unt,int QtyStack ,double PriceST ) {
        this.ID_Stack=new SimpleIntegerProperty(ID_Stack);
     //  this.DP=new SimpleIntegerProperty(DP);
        
        this.Code = new SimpleIntegerProperty(code);
        this.Title = new SimpleStringProperty(tit);
        this.ID_Unit =  new SimpleStringProperty(unt);
        
        this.QtyStack=new SimpleIntegerProperty(QtyStack);
      //  this.PriceP=new SimpleDoubleProperty(PriceP);
        this.PriceST=new SimpleDoubleProperty(PriceST);
      //  this.Avaliable_Items=new SimpleBooleanProperty(Av);
      // ,boolean Av 
    }
     public StackFull(int ID_Stack,int code,String tit,String unt,int QtyStack,double PriceP ,double PriceST) {
        this.ID_Stack=new SimpleIntegerProperty(ID_Stack);
       
        
        this.Code = new SimpleIntegerProperty(code);
        this.Title = new SimpleStringProperty(tit);
        this.ID_Unit =  new SimpleStringProperty(unt);
        
        this.QtyStack=new SimpleIntegerProperty(QtyStack);
        this.PriceP=new SimpleDoubleProperty(PriceP);
        this.PriceST=new SimpleDoubleProperty(PriceST);
     
    }

     //
     public IntegerProperty ID_Property(){
        return ID_Stack;
    }
     public IntegerProperty Code_Property(){
        return Code;
    }
 public StringProperty Title_Property(){
        return Title;
    }
 public StringProperty Unit_Property(){
        return ID_Unit;
    }
    
 public DoubleProperty PriceST_Property(){
        return PriceST;
    }
 public DoubleProperty PriceP_Property(){
        return PriceP;
    }

 public IntegerProperty QtyStack_Property(){
        return QtyStack;
    }
 public IntegerProperty DP_Property(){
        return DP;
    }
     public BooleanProperty Avaliable_Items_Property(){
        return Avaliable_Items;
    } 
     
     //getter
    public int getID_Stack() {
        return ID_Stack.getValue();
    }
    public int getCode() {
        return Code.getValue();
    }
    public String getTitle() {
        return Title.getValue();
    }
    public String getUnit() {
        return ID_Unit.getValue();
    }



  
    public int getQtyStack() {
        return QtyStack.getValue();
    }

   
    public double getPriceP() {
        return PriceP.getValue();
    }
 

    public double getPriceST() {
        return PriceST.getValue();
    }

    public int getDP() {
        return DP.getValue();
    }   

    public boolean isAvaliable_Items() {
        return Avaliable_Items.getValue();
    }

    
    //setter 
    public void setID_Stack(int ID_Stack) {
        this.ID_Stack =  new SimpleIntegerProperty(ID_Stack);
    }

 public void setCode(int code) {
        this.Code =  new SimpleIntegerProperty(code);
    }
 public void setTitle(String tit) {
        this.Title =  new SimpleStringProperty(tit);
    }
 public void setUnit(String Un) {
        this.ID_Unit =  new SimpleStringProperty(Un);
    }
  public void setQtyStock(int QtyStack) {
        this.QtyStack =  new SimpleIntegerProperty(QtyStack);
    }
 
    public void setPriceP(double PriceP) {
        this.PriceP = new SimpleDoubleProperty(PriceP);
    }   
    public void setPriceST(double PriceST) {
        this.PriceST = new SimpleDoubleProperty(PriceST);
    } 
  public void setDP(int DP) {
        this.DP =  new SimpleIntegerProperty(DP);
    }
    public void setAvaliable_Items(boolean Avaliable_Items) {
        this.Avaliable_Items = new SimpleBooleanProperty(Avaliable_Items);
    }
    
    
    
    
    
    
    
    
    //////check
 //*
/*
 * public boolean Avaliable_Items() {
        return getQtyStack() > 0;
	}
	
    
    
	public boolean CheckPrice() {
        return getPriceP() < getPriceST();
	}
		

	public BooleanProperty UpdataStateOfItems() {
           if( CheckPrice()&&Avaliable_Items()==true){
              Avaliable_Items=new SimpleBooleanProperty(true);
           }
           else { Avaliable_Items=new SimpleBooleanProperty(false );}
           return Avaliable_Items;
		
        
 
}
        
 */
   
}