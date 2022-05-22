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
public class Users {
private  IntegerProperty ID;
private  StringProperty username;
private  StringProperty password;



    public Users() {
        this.ID=new SimpleIntegerProperty();
        this.username=new SimpleStringProperty("");
        this.password=new SimpleStringProperty("");

        
    }
    public Users(int id , String usr ,String pw) {
        
         this.ID=new SimpleIntegerProperty(id);
        this.username=new SimpleStringProperty(usr);
        this.password=new SimpleStringProperty(pw);
        
    }

    public IntegerProperty getID() {
        return ID;
    }

    public StringProperty getUsername() {
        return username;
    }

    public StringProperty getPassword() {
        return password;
    }
    
    //setter

    public void setID(IntegerProperty ID) {
        this.ID = ID;
    }

    public void setUsername(StringProperty username) {
        this.username = username;
    }

    public void setPassword(StringProperty password) {
        this.password = password;
    }
    
    
    
   
    
}
