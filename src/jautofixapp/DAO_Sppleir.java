/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jautofixapp;




import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * 
 *
 * @author shammakh
 */
public class DAO_Sppleir {
   	
	static  private String query;
	private Statement stmt ;
         private   ResultSet rs ;	
    private  PreparedStatement pstmt;
    
    
    
     public ResultSet getSppleirInfo(){
         Connection  con= DBconnection.getCon();
	        try{
	            query="SELECT * FROM `sppleir` ";
                                stmt = (Statement) con.createStatement();
	            rs=stmt.executeQuery(query);
                    System.out.println("ResultSet");
                //    con.close();
	        }catch(SQLException e){
	        }
	        return rs;
}
     
     public void InsertNewSppleir(String x,String y,String z) throws SQLException{
            try (Connection con = DBconnection.getCon()) {
                query="INSERT INTO`sppleir`(`ID_Suppleir`, `FN`, `Address`, `phone`)VALUES (null,?,?,?)";
                //    stmt = (Statement) con.createStatement();
                pstmt = (PreparedStatement) con.prepareStatement(query);
                //
              
                pstmt.setString (1, x);
                pstmt.setString (1, y);
                pstmt.setString (1, z);
               
                // execute the preparedstatement
                pstmt.executeUpdate();
                System.out.println("inserted");
                
            }
     
     }
     public void UpdateSppleir(String x,String y,String z,int i) throws SQLException{
            try (Connection con = DBconnection.getCon()) {
                query="UPDATE `sppleir` SET `FN`='?',`Address`='?',`phone`='?' WHERE `ID_Suppleir`='?'";
                //    stmt = (Statement) con.createStatement();
                pstmt = (PreparedStatement) con.prepareStatement(query);
                //
              
                pstmt.setString (1, x);
                pstmt.setString (2, y);
                pstmt.setString (3, z);
                pstmt.setInt(4, i);
               
                // execute the preparedstatement
                pstmt.executeUpdate();
                System.out.println("inserted");
                
            }
            
            catch(SQLException e){
                //worning masegge
            }
     
     }
     
     
     private void DeleteSppleir(int del) throws SQLException{
            try (Connection con = DBconnection.getCon()) {
                query="DELETE FROM `sppleir` WHERE `ID_Suppleir`="+ del;
                //    stmt = (Statement) con.createStatement();
                pstmt = (PreparedStatement) con.prepareStatement(query);
                //
            
               
                // execute the preparedstatement
                pstmt.executeUpdate();
                System.out.println("deleting...");
                
            }
     
     }

 public ResultSet getSppleirForCombobox(){
         Connection  con= DBconnection.getCon();
	        try{
	            query="SELECT  `FN` FROM `sppleir`";
                    stmt = (Statement) con.createStatement();
                    
                    
	            rs=stmt.executeQuery(query);
                    System.out.println("ResultSet sppleir");
              
	        }catch(SQLException e){
                    
                    //massage
	        }
	        return rs;
}
 }