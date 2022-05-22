/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jautofixapp;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author shammakh
 */
public class DAO_detailpurchase {
    
    
  	
	static  private String query;
	private Statement stmt ;
   private ResultSet rs ;
    
    
    
     public ResultSet DetialsPurchaseInfo(){
            Connection  con= DBconnection.getCon();
	        try{
                  
	             query="SELECT * FROM `detailspurchase` WHERE 1";
                     stmt = (Statement) con.createStatement();
	            rs=stmt.executeQuery(query);
	        }catch(SQLException e){
	        }
	        return rs;
	    }
}
