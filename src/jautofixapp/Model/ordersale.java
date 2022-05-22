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

/**
 *
 * @author shammakh
 */
public class ordersale {
    
    private IntegerProperty SIo;
    private IntegerProperty QtySales;
    private DoubleProperty PriceSales;
    private DoubleProperty Total;
    private IntegerProperty ID_Stack;
    private IntegerProperty GnS;

    public ordersale(IntegerProperty SIo, IntegerProperty QtySales, DoubleProperty PriceSales, DoubleProperty Total, IntegerProperty ID_Stack, IntegerProperty GnS) {
        this.SIo = SIo;
        this.QtySales = QtySales;
        this.PriceSales = PriceSales;
        this.Total = Total;
        this.ID_Stack = ID_Stack;
        this.GnS = GnS;
    }
		
         
    public ordersale() {
        this.SIo=new SimpleIntegerProperty();
        this.QtySales=new SimpleIntegerProperty();
        this.PriceSales=new SimpleDoubleProperty();
        this.Total=new SimpleDoubleProperty();
        this.GnS=new SimpleIntegerProperty();
        this.ID_Stack=new SimpleIntegerProperty();               
    }
    public ordersale(int SIo,int QtySales,double PriceSales,double Total,int ID_Stack,int GnS) {
        this.SIo=new SimpleIntegerProperty(SIo);
        this.QtySales=new SimpleIntegerProperty(QtySales);
        this.PriceSales=new SimpleDoubleProperty(PriceSales);
        this.Total=new SimpleDoubleProperty(Total);
        this.GnS=new SimpleIntegerProperty(GnS);
        this.ID_Stack=new SimpleIntegerProperty(ID_Stack); 
    } 

    public IntegerProperty getSIoProperty() {
        return SIo;
    }

    public IntegerProperty getQtySalesProperty() {
        return QtySales;
    }

    public DoubleProperty getPriceSalesProperty() {
        return PriceSales;
    }

    public DoubleProperty getTotalProperty() {
        return Total;
    }

    public IntegerProperty getID_StackProperty() {
        return ID_Stack;
    }

    public IntegerProperty getGnSProperty() {
        return GnS;
    }
    
    
    
    //setter

    public void setSIo(int SIo) {
        this.SIo = new SimpleIntegerProperty(SIo);
    }

    public void setQtySales(int QtySales) {
        this.QtySales = new SimpleIntegerProperty(QtySales);
    }

    public void setPriceSales(double PriceSales) {
        this.PriceSales = new SimpleDoubleProperty(PriceSales);
    }

    public void setTotal(double Total) {
        this.Total = new SimpleDoubleProperty(Total);
    }

    public void setID_Stack(int ID_Stack) {
        this.ID_Stack = new SimpleIntegerProperty(ID_Stack);
    }

    public void setGnS(int GnS) {
        this.GnS = new SimpleIntegerProperty(GnS);
    }

    public int getGnS() {
        return GnS.getValue();
    }

    public int getID_Stack() {
        return ID_Stack.getValue();
    }

    public double getPriceSales() {
        return PriceSales.getValue();
    }

    public int getQtySales() {
        return QtySales.getValue();
    }

    public int getSIo() {
        return SIo.getValue();
    }

    public double getTotal() {
        return Total.getValue();
    }
     
    
    
    
    
    
}
