/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jautofixapp.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author shammakh
 */
public class Sppleir {
	private IntegerProperty ID_Suppleir;
	private StringProperty FN;
	private StringProperty Address;
	private StringProperty Phone;

	public Sppleir() {
		this.ID_Suppleir=new SimpleIntegerProperty();
                this.FN=new SimpleStringProperty("");
                this.Address=new SimpleStringProperty("");
                this.Phone=new SimpleStringProperty("");
	}
public Sppleir(int ID_Suppleir,String FN,String Address,String Phone) {
		this.ID_Suppleir=new SimpleIntegerProperty(ID_Suppleir);
                this.FN=new SimpleStringProperty(FN);
                this.Address=new SimpleStringProperty(Address);
                this.Phone=new SimpleStringProperty(Phone);
	}

    public IntegerProperty getID_SuppleirProperty() {
        return ID_Suppleir;
    }

    public StringProperty getFNProperty() {
        return FN;
    }

    public StringProperty getAddressProperty() {
        return Address;
    }

    public StringProperty getPhoneProperty() {
        return Phone;
    }
	

     //setter

    public void setFN(String FN) {
        this.FN = new SimpleStringProperty(FN);
    }

    public void setID_Suppleir(int ID_Suppleir) {
        this.ID_Suppleir = new SimpleIntegerProperty(ID_Suppleir);
    }

    public void setAddress(String Address) {
        this.Address = new SimpleStringProperty(Address);
    }

    public void setPhone(String Phone) {
        this.Phone = new SimpleStringProperty(Phone);
    }

    public String getAddress() {
        return Address.getValue();
    }

    public String getFN() {
        return FN.getValue();
    }

    public int getID_Suppleir() {
        return ID_Suppleir.getValue();
    }

    public String getPhone() {
        return Phone.getValue();
    }
    
    



}
