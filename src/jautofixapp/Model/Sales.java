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
public class Sales {
    
    
    private IntegerProperty SI;
    private DoubleProperty TotalOfAll;
    private DoubleProperty Discount;
    private DoubleProperty TotalAfterDiscount;
    private StringProperty NameCust;
    private IntegerProperty GnS;
    private StringProperty Cdate;
        
       
	 
         
	
	
public  Sales(){
   
      this.SI=new SimpleIntegerProperty();
 this.TotalOfAll=new SimpleDoubleProperty();
 this.Discount=new SimpleDoubleProperty();
 this.TotalAfterDiscount=new SimpleDoubleProperty();
 this.NameCust=new SimpleStringProperty("");
  this.GnS=new SimpleIntegerProperty();
 this.Cdate=new SimpleStringProperty(""); 
                                        
}
public  Sales(int SI,String NameCust,double TotalOfAll,double Discount,double totAd, int GnS, String Cdate){
     this.SI=new SimpleIntegerProperty(SI);
 this.TotalOfAll=new SimpleDoubleProperty(TotalOfAll);
 this.Discount=new SimpleDoubleProperty(Discount);
 this.NameCust=new SimpleStringProperty(NameCust);
  this.GnS=new SimpleIntegerProperty(GnS);
 this.Cdate=new SimpleStringProperty(Cdate);
 this.TotalAfterDiscount=new SimpleDoubleProperty(totAd);
}
public  Sales(int GnS,String NameCust,double TotalOfAll,double Discount,String Cdate){
    //for explore sales invoice in clicked the table 
    
   //  this.SI=new SimpleIntegerProperty(SI);
 this.TotalOfAll=new SimpleDoubleProperty(TotalOfAll);
 this.Discount=new SimpleDoubleProperty(Discount);
 this.NameCust=new SimpleStringProperty(NameCust);
  this.GnS=new SimpleIntegerProperty(GnS);
this.Cdate=new SimpleStringProperty(Cdate);
 //this.TotalAfterDiscount=new SimpleDoubleProperty(totAd);
}



    public int getSI() {
        return SI.getValue();
    }

    public void setSI(int SI) {
        this.SI = new SimpleIntegerProperty(SI);
    }

    public double getTotalOfAll() {
        return TotalOfAll.getValue();
    }

    public void setTotalOfAll(double TotalOfAll) {
        this.TotalOfAll = new SimpleDoubleProperty(TotalOfAll);
    }

    public double getDiscount() {
        return Discount.getValue();
    }

    public void setDiscount(double Discount) {
        this.Discount =  new SimpleDoubleProperty(Discount);
    }
    public double getTotDiscount() {
        return TotalAfterDiscount.getValue();
    }

    public void setTotDiscount(double totd) {
        this.TotalAfterDiscount =  new SimpleDoubleProperty(totd);
    }

    public String getNameCust() {
        return NameCust.getValue();
    }

    public void setNameCust(String NameCust) {
        this.NameCust = new SimpleStringProperty(NameCust);
    }

    public int getGnS() {
        return GnS.getValue();
    }

    public void setGnS(int GnS) {
        this.GnS = new SimpleIntegerProperty(GnS);
    }

    public String getCdate() {
        return Cdate.getValue();
    }

    public void setCdate(String Cdate) {
        this.Cdate = new SimpleStringProperty(Cdate);
    }
    
    
    
    
    
public IntegerProperty SI_Property(){
        return SI;
    }
public StringProperty NameCustProperty() {
        return NameCust;
    }

public StringProperty CdateProperty() {
        return Cdate;
    }
public DoubleProperty TotalInvoicProperty() {
        return TotalOfAll;
    }
public DoubleProperty DicuntInvoicProperty() {
        return Discount;
    }
public DoubleProperty TotalafterDiscountProperty() {
        return TotalAfterDiscount;
    }
public IntegerProperty GnS_Property(){
        return GnS;
    }

   


}
