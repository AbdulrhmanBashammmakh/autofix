/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jautofixapp;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import jautofixapp.Model.Sales;
import jautofixapp.Model.ordersale;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author shammakh
 */
public class DAO_salesOrder {
    
    
  	
	static  private String query;
	private Statement stmt ;
   private ResultSet rs ;
     private  PreparedStatement pstmt;
    
    
     public ResultSet OrderselesInfo(){
            Connection  con= DBconnection.getCon();
	        try{
                  
	             query="SELECT * FROM ordersales WHERE 1";
                     stmt = (Statement) con.createStatement();
	            rs=stmt.executeQuery(query);
	        }catch(SQLException e){
	        }
	        return rs;
	    }
     public ResultSet InvoicSales(){
            Connection  con= DBconnection.getCon();
	        try{
                  
	          //   query="SELECT * FROM `sales` WHERE 1";
                  query=   "SELECT * FROM `sales` ORDER by Cdate DESC";
                     stmt = (Statement) con.createStatement();
	            rs=stmt.executeQuery(query);
	        }catch(SQLException e){
	        }
	        return rs;
	    }
     
     
     public void InsertOrder(ordersale x) throws SQLException{
            try (com.mysql.jdbc.Connection con = DBconnection.getCon()) {
                query="INSERT INTO `ordersales`(`SIo`, `QtySales`, `PriceSales`, `Total`, `ID_Stock`, `GnS`) VALUES (null,'?','?','?','?','?')";
                //    stmt = (Statement) con.createStatement();
                pstmt = (PreparedStatement) con.prepareStatement(query);
                //
                 //  System.out.println(x.toString());
                
                pstmt.setInt    (2, x.getQtySales());
                 pstmt.setDouble(3, x.getPriceSales());
                pstmt.setDouble(4, x.getTotal());
                pstmt.setInt    (5, x.getID_Stack());
                pstmt.setInt    (6, x.getGnS());
               
                // pstmt.setString (2, "Rubble");
              
                // execute the preparedstatement
                pstmt.executeUpdate();
                System.out.println("inserted");
                
            }
     }
    /**
     *
     * @param s
     * @param g
     * @throws SQLException
     */
    public void UpdateSalesInv(Sales s, int g) throws SQLException{
            try (com.mysql.jdbc.Connection con = DBconnection.getCon()) {
                query="UPDATE `sales` SET `clintname`='?',`TotalOfAll`='?',`Discount`='?',`afterDiscount`='?' WHERE `GnS`='?'";
                /*sales*/          //    stmt = (Statement) con.createStatement();
                pstmt = (PreparedStatement) con.prepareStatement(query);
                //
                 //  System.out.println(x.toString());
                 pstmt.setString (1, s.getNameCust());
 
                 pstmt.setDouble(2, s.getTotalOfAll());
                pstmt.setDouble(3, s.getDiscount());
                pstmt.setDouble(4, s.getTotDiscount());
                   pstmt.setInt    (5, g);
              
              
                // execute the preparedstatement
                pstmt.executeUpdate();
                System.out.println("Updating...");
                
            }
     
     }
    
    public void insGns(int gnss)throws SQLException {
         try (com.mysql.jdbc.Connection con = DBconnection.getCon()) {
             query="INSERT INTO `gens`(`GnS`) VALUES ('?')";
              
                pstmt = (PreparedStatement) con.prepareStatement(query);
                  pstmt.setInt    (1, gnss);
               
                // execute the preparedstatement
                pstmt.executeUpdate();
             
         }
        
    }
}
