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
public class Unit {
    
 private  IntegerProperty ID_Unit;
private  StringProperty Unit;



	public Unit() {
		this.ID_Unit=new SimpleIntegerProperty(0);
                 this.Unit=new SimpleStringProperty("");
	}
	public Unit(int ID_Unit,String Unit) {
		this.ID_Unit=new SimpleIntegerProperty(0);
                 this.Unit=new SimpleStringProperty(Unit);
	}
	public int getID_Unit() {
		return ID_Unit.get();
	}
        public String getUnit() {
		return Unit.get();
	}
        
        
	public void setID_Unit(int ID_Unit) {
            
             this.ID_Unit = new SimpleIntegerProperty(ID_Unit);
	}
	
	public void setUnit(String Unit) {
		this.Unit= new SimpleStringProperty(Unit);
	}
    public IntegerProperty ID_UnitProperty(){
        return ID_Unit;
    }
        public StringProperty UnitProperty() {
        return Unit;
    }
	
	
}

