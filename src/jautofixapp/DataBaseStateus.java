/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jautofixapp;

/**
 *
 * @author shammakh
 */
public  class DataBaseStateus {
   
     
  
 private boolean state=false;
   // public DataBaseStateus() {
   // }
    
    public boolean StateUs(){
       
        state = DBconnection.getCon() != null;
          return state;
    }
     
    
}
