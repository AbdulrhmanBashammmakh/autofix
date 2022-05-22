/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jautofixapp.Model;

/**
 *
 * @author shammakh
 */
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PurchaseWithSppleir {
	private IntegerProperty PI;
	private DoubleProperty TotalOfAll;
	private StringProperty ID_Sppleir;
	private IntegerProperty GnP;
	private StringProperty Cdate;
	
	

public PurchaseWithSppleir() {
	 this.PI=new SimpleIntegerProperty();
	this.TotalOfAll=new SimpleDoubleProperty(0.0);
	 this.ID_Sppleir=new SimpleStringProperty("");
	 this. GnP=new SimpleIntegerProperty(0);
	 this.Cdate=new SimpleStringProperty("");
	}
public PurchaseWithSppleir(int PI,double TotalOfAll,String ID_Sppleir,int GnP,String Cdate) {
		this.PI=new SimpleIntegerProperty(PI);
	this.TotalOfAll=new SimpleDoubleProperty(TotalOfAll);
	 this.ID_Sppleir=new SimpleStringProperty(ID_Sppleir);
	 this. GnP=new SimpleIntegerProperty(GnP);
	 this.Cdate=new SimpleStringProperty(Cdate);
	}

    public PurchaseWithSppleir(IntegerProperty PI, DoubleProperty TotalOfAll, StringProperty ID_Sppleir, IntegerProperty GnP, StringProperty Cdate) {
        this.PI = PI;
        this.TotalOfAll = TotalOfAll;
        this.ID_Sppleir = ID_Sppleir;
        this.GnP = GnP;
        this.Cdate = Cdate;
    }

public IntegerProperty PI_Property(){
        return PI;
    }

public StringProperty CdateProperty() {
        return Cdate;
    }
public DoubleProperty TotalInvoicProperty() {
        return TotalOfAll;
    }
public StringProperty ID_SppleirProperty(){
        return ID_Sppleir;
    }
public IntegerProperty GnP_Property(){
        return GnP;
    }
	

	public int getPI() {
		return PI.getValue();
	}

public double getTotalOfAll() {
		return TotalOfAll.getValue();
	}
public String getID_Sppleir() {
		return ID_Sppleir.getValue();
	}
public int getGnP() {
		return GnP.getValue();
	}
public String getCdate() {
		return Cdate.getValue();
	}



//setter


	public void setPI(int pI) {
		this.PI 
                        = new SimpleIntegerProperty(pI);
	}


	public void setTotalOfAll(double totalOfAll) {
		this.TotalOfAll = new SimpleDoubleProperty(totalOfAll);
	}


	public void setID_Sppleir(String iD_Sppleir) {
		this.ID_Sppleir 
                 = new SimpleStringProperty(iD_Sppleir);
	}


	public void setGnP(int gnP) {
		this.GnP 
                         = new SimpleIntegerProperty(gnP);
	}


	public void setCdate(String cdate) {
		this.Cdate 
                        =new SimpleStringProperty(cdate);
	}


}
