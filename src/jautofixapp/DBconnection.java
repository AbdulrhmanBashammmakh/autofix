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
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;

public class DBconnection {

	private static final	String username = "root";
	private static final String password ="abba226529";
	private static final 	String con_string="jdbc:mysql://localhost/autofix";
	

	    static Connection con = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    
	    public DBconnection(){
	        try{
	            Class.forName("com.mysql.jdbc.Driver");
	            con= (Connection) DriverManager.getConnection(con_string, username, password);
	         if(con!=null){
                     System.out.println("open");
                 }else{
                      System.out.println("close");
                 }
	         
	           stmt=(Statement) con.createStatement();
	           System.out.println("Connected");
	        }catch(ClassNotFoundException | SQLException e){
	        }
	    }
	    
	    public static Connection getCon(){
	        try{
	            Class.forName("com.mysql.jdbc.Driver");
	            con= (Connection) DriverManager.getConnection(con_string, username, password);
	        }catch(ClassNotFoundException | SQLException e){
	        }
	        return con;
	    }
            
            
}




