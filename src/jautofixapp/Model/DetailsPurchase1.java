/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jautofixapp.Model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/**
 *
 * @author shammakh
 */
public class DetailsPurchase1 {
	private  IntegerProperty DP;
	private  IntegerProperty Code;
	private  StringProperty Title;
	private  StringProperty ID_Unit;
	private  IntegerProperty Qty;
	private  DoubleProperty PriceP;
	private  DoubleProperty Total;
	private  IntegerProperty GnP;

public DetailsPurchase1(){
    
    this.DP=new SimpleIntegerProperty();
    this.Code=new SimpleIntegerProperty();
    this.Title=new SimpleStringProperty("");
    this.ID_Unit=new SimpleStringProperty();
    this.Qty=new SimpleIntegerProperty(0);
    
    this.PriceP= new SimpleDoubleProperty(0.0); 
    this.Total= new SimpleDoubleProperty(0.0); 
    this.GnP=new SimpleIntegerProperty(0);
}
public DetailsPurchase1(int DP ,int Code ,String Title ,String ID_Unit ,int Qty,double PriceP,double Total,int GnP){
    
    this.DP=new SimpleIntegerProperty(0);
    this.Code=new SimpleIntegerProperty(Code);
     this.Title=new SimpleStringProperty(Title);
    this.ID_Unit=new SimpleStringProperty(ID_Unit);
    this.Qty=new SimpleIntegerProperty(Qty);
    this.PriceP= new SimpleDoubleProperty(PriceP); 
    this.Total= new SimpleDoubleProperty(Total); 
    this.GnP=new SimpleIntegerProperty(GnP);
}
public DetailsPurchase1(int Code ,String Title ,String ID_Unit ,int Qty,double PriceP,double Total,int GnP){
    
   // this.DP=new SimpleIntegerProperty(0);
    this.Code=new SimpleIntegerProperty(Code);
     this.Title=new SimpleStringProperty(Title);
    this.ID_Unit=new SimpleStringProperty(ID_Unit);
    this.Qty=new SimpleIntegerProperty(Qty);
    this.PriceP= new SimpleDoubleProperty(PriceP); 
    this.Total= new SimpleDoubleProperty(Total); 
   this.GnP=new SimpleIntegerProperty(GnP);
}
public DetailsPurchase1(int Code ,String Title ,String ID_Unit ,int Qty,double PriceP,double Total){
    
   // this.DP=new SimpleIntegerProperty(0);
    this.Code=new SimpleIntegerProperty(Code);
     this.Title=new SimpleStringProperty(Title);
    this.ID_Unit=new SimpleStringProperty(ID_Unit);
    this.Qty=new SimpleIntegerProperty(Qty);
    this.PriceP= new SimpleDoubleProperty(PriceP); 
    this.Total= new SimpleDoubleProperty(Total); 
   //this.GnP=new SimpleIntegerProperty(GnP);
}

 //Property
        

 public IntegerProperty DP_Property(){
        return DP;
    }
 public IntegerProperty Qty_Property(){
        return Qty;
    }
 public StringProperty Unit_Property(){
        return ID_Unit;
    }
 public IntegerProperty Code_Property(){
        return Code;
    }
public StringProperty TitleProperty() {
        return Title;
    }
public DoubleProperty PriceProperty() {
        return PriceP;
    }
public DoubleProperty TotalProperty() {
        return Total;
    }
       //getter
        
public int getDP() {
	return DP.getValue();
}

    public String getTitle() {
        return Title.getValue();
    }

    public int getCode() {
        return Code.getValue();
    }

    public String getID_Unit() {
        return ID_Unit.getValue();
    }

    public int getGnP() {
        return GnP.getValue();
    }

    public double getPriceP() {
        return PriceP.getValue();
    }

    public int getQty() {
        return Qty.getValue();
    }

    public double getTotal() {
        return Total.getValue();
    }

    
    
    //setter
    public void setCode(int Code) {
        this.Code = new SimpleIntegerProperty(Code);
    }

    public void setDP(int DP) {
        this.DP = new SimpleIntegerProperty(DP);
    }

    public void setGnP(int GnP) {
        this.GnP = new SimpleIntegerProperty(GnP);
    }

    public void setID_Unit(String ID_Unit) {
        this.ID_Unit = new SimpleStringProperty(ID_Unit);
    }

    public void setPriceP(double PriceP) {
        this.PriceP = new SimpleDoubleProperty(PriceP);
    }

    public void setTitle(String Title) {
        this.Title = new SimpleStringProperty(Title);
    }

    public void setQty(int Qty) {
        this.Qty = new SimpleIntegerProperty(Qty);
    }

    public void setTotal(double Total) {
        this.Total = new SimpleDoubleProperty(Total);
    }

    public DetailsPurchase1(IntegerProperty DP, IntegerProperty Code, StringProperty Title, StringProperty ID_Unit, IntegerProperty Qty, DoubleProperty PriceP, DoubleProperty Total, IntegerProperty GnP) {
        this.DP = DP;
        this.Code = Code;
        this.Title = Title;
        this.ID_Unit = ID_Unit;
        this.Qty = Qty;
        this.PriceP = PriceP;
        this.Total = Total;
        this.GnP = GnP;
    }

   
   

 

   

}

