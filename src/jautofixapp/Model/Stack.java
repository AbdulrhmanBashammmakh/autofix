/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jautofixapp.Model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author shammakh
 */
public class Stack {
    private IntegerProperty ID_Stack;
	private IntegerProperty DP;
	private IntegerProperty QtyStack;
	private DoubleProperty PriceP;
	private DoubleProperty PriceST;
	private BooleanProperty Avaliable_Items;

    public Stack() {
        this.ID_Stack=new SimpleIntegerProperty();
        this.DP=new SimpleIntegerProperty();
        this.QtyStack=new SimpleIntegerProperty();
        this.PriceP=new SimpleDoubleProperty(0.0);
        this.PriceST=new SimpleDoubleProperty(0.0);
        this.Avaliable_Items=new SimpleBooleanProperty(Boolean.FALSE);
        
    }
     public Stack(int ID_Stack,int DP ,int QtyStack,double PriceP ,double PriceST) {
        this.ID_Stack=new SimpleIntegerProperty(ID_Stack);
        this.DP=new SimpleIntegerProperty(DP);
        this.QtyStack=new SimpleIntegerProperty(QtyStack);
        this.PriceP=new SimpleDoubleProperty(PriceP);
        this.PriceST=new SimpleDoubleProperty(PriceST);
      //  this.Avaliable_Items=new SimpleBooleanProperty(Av);
      // ,boolean Av 
    }
//pr
         
     public BooleanProperty Avaliable_Items_Property(){
        return Avaliable_Items;
    }
 public DoubleProperty PriceST_Property(){
        return PriceST;
    }
 public DoubleProperty PriceP_Property(){
        return PriceP;
    }
     public IntegerProperty ID_Property(){
        return ID_Stack;
    }
 public IntegerProperty QtyStack_Property(){
        return QtyStack;
    }
 public IntegerProperty DP_Property(){
        return DP;
    }
     

//getter
    public int getID_Stack() {
        return ID_Stack.getValue();
    }

   

    public int getDP() {
        return DP.getValue();
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

   

    public boolean isAvaliable_Items() {
        return Avaliable_Items.getValue();
    }

    
    //setter 
 public void setQtyStock(int QtyStack) {
        this.QtyStack =  new SimpleIntegerProperty(QtyStack);
    }
  public void setDP(int DP) {
        this.DP =  new SimpleIntegerProperty(DP);
    }
 public void setID_Stack(int ID_Stack) {
        this.ID_Stack =  new SimpleIntegerProperty(ID_Stack);
    }
    public void setPriceP(double PriceP) {
        this.PriceP = new SimpleDoubleProperty(PriceP);
    }   
    public void setPriceST(double PriceST) {
        this.PriceST = new SimpleDoubleProperty(PriceST);
    } 
    
    
    public void setAvaliable_Items(boolean Avaliable_Items) {
        this.Avaliable_Items = new SimpleBooleanProperty(Avaliable_Items);
    }
    
    
    
    
    public boolean Avaliable_Items() {
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
        
}