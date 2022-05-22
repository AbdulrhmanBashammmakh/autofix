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
 public class   DAOunit {
   	
	static  private String query;
	private Statement stmt ;
         private   ResultSet rs ;	
    private  PreparedStatement pstmt;
    
     public ResultSet getUnitInfo(){
         Connection  con= DBconnection.getCon();
	        try{
	            query="SELECT * FROM Unit";
                                stmt = (Statement) con.createStatement();
	            rs=stmt.executeQuery(query);
                    System.out.println("ResultSet");
                //    con.close();
	        }catch(SQLException e){
	        }
	        return rs;
}
     
     public void InsertUnit(String x) throws SQLException{
            try (Connection con = DBconnection.getCon()) {
                query="INSERT INTO unit(ID_Unit, Unit) VALUES (null,?)";
                //    stmt = (Statement) con.createStatement();
                pstmt = (PreparedStatement) con.prepareStatement(query);
                //
                 //  System.out.println(x.toString());
                pstmt.setString (1, x);
                // pstmt.setString (2, "Rubble");
                //pstmt.setDate   (3, startDate);
                //pstmt.setBoolean(4, false);
                //pstmt.setInt    (5, 5000);
                // execute the preparedstatement
                pstmt.executeUpdate();
                System.out.println("inserted");
                // stmt = con.createStatement();
                //Run executeUpdate operation with given sql statement
                //stmt.executeUpdate(query);
            }
     
     }

     
 
public ResultSet getUnitForCombobox(){
         Connection  con= DBconnection.getCon();
	        try{
	            query="SELECT * FROM `unit` order by `ID_Unit`";
                                stmt = (Statement) con.createStatement();
	            rs=stmt.executeQuery(query);
                    System.out.println("ResultSet");
                //    con.close();
	        }catch(SQLException e){
	        }
	        return rs;
}
 }