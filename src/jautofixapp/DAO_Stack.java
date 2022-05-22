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
 class DAO_Stack {
	static  private String query;
	private Statement stmt ;
        private   ResultSet rs ;	
        private  PreparedStatement pstmt;
    
        
        
     public ResultSet getStackAv(){
         Connection  con= DBconnection.getCon();
	        try{
	            query= "SELECT * FROM `stq`";
                    stmt = (Statement) con.createStatement();
	            rs=stmt.executeQuery(query);
                    System.out.println("ResultSet stack");
                //    con.close();
	        }catch(SQLException e){
                    
	        }
	        return rs;
}
    
 public ResultSet getStackUnAv(){
         Connection  con= DBconnection.getCon();
	        try{
	        query="SELECT * FROM `sqt2` ";
                      stmt = (Statement) con.createStatement();
	          rs=stmt.executeQuery(query);
                  System.out.println("ResultSet not avaliabe");
                //    con.close();
	        }catch(SQLException e){
	        }
	        return rs;
}
 
    public void updatePrices(double p,double s , int i)throws SQLException{
        
        
         try (Connection con = DBconnection.getCon()) {
                query="UPDATE stockmain SET PriceP =?, PriceST = ? WHERE ID_Stock = ?";
                //    stmt = (Statement) con.createStatement();
                pstmt = (PreparedStatement) con.prepareStatement(query);
                //
              
                pstmt.setDouble(1, p);
                pstmt.setDouble (2, s);
                pstmt.setInt(3, i);
               
               
                // execute the preparedstatement
                pstmt.executeUpdate();
                System.out.println("updating ...prices");
                con.close();
                
            }
            
            catch(SQLException e){
                //worning masegge
            }
     
     
     }
 
 }