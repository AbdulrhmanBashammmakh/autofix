/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jautofixapp.DataAccess;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import jautofixapp.DBconnection;

import jautofixapp.Model.DetailsPurchase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author shammakh
 */
public class DAOpurchase {
    static Connection con= DBconnection.getCon();	
	static  private String query;
	Statement stmt = null;
    ResultSet rs = null;	
    
    
	public static void ArrTblStrDB(Object[][] A,int y){
				
		try {
			 PreparedStatement preparedStmt =
			   		  (PreparedStatement) con.prepareStatement(query);
			for (int row = 0; row < A.length; row++) {
		       	
				query = " insert into DetailPurchase (code, title, iD_Unit, qty, priceP,total,gnP)"
				        + " values (?, ?, ?, ?, ?,?,?)";

				      // create the mysql insert preparedstatement
				          
						  preparedStmt.setInt (1, (int) A[row][0]);
					      preparedStmt.setString (2, (String) A[row][1]);
					      preparedStmt.setInt  (3, (int) A[row][2]);
					      preparedStmt.setInt(4, (int) A[row][3]);
					      preparedStmt.setDouble(5, (double) A[row][4]);
					      preparedStmt.setDouble(6, (double) A[row][5]);
					      preparedStmt.setInt    (7, (int) A[row][6]);
						  int row1=row+1;
					  preparedStmt.execute();
     con.close();
			}
		 			      
			 
	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
         public void editDetailDAO(DetailsPurchase Dp ) {
		 try {
			 query="UPDATE DetailPurchase SET"; //complete
				PreparedStatement preparedStmt =
				   		  (PreparedStatement) con.prepareStatement(query);
		//		preparedStmt.setInt(1, Dp.getCode());
		//		preparedStmt.setString(2, Dp.getTitle());
		//		preparedStmt.setInt(3, Dp.getCode());
		//		preparedStmt.setInt(4, Dp.getQty());
		//		preparedStmt.setDouble(5, Dp.getPriceP());
		//		preparedStmt.setDouble(6, Dp.getTotal());
		//		preparedStmt.setInt(7, Dp.getGnP());
			
				preparedStmt.executeUpdate();
              //  JOptionPane.showMessageDialog(null, "Updated Successfully!"); 	
                con.close();
				
				
				
			} catch (SQLException e) {
                     // TODO Auto-generated catch block

			}	
	 }
          public void DeleteDetailDAO(int xyz) {
		 try {
			 query="delete from DetailPurchase where DP = ? "; //complete
				PreparedStatement preparedStmt =
				    (PreparedStatement) con.prepareStatement(query);
				preparedStmt.setInt(1, xyz);
				//preparedStmt.setString(2, Dp.getTitle());
			//	preparedStmt.setInt(3, Dp.getCode());
			//	preparedStmt.setInt(4, Dp.getQty());
			//	preparedStmt.setDouble(5, Dp.getPriceP());
			//	preparedStmt.setDouble(6, Dp.getTotal());
			//	preparedStmt.setInt(7, Dp.getGnP());
			
				preparedStmt.executeUpdate();
				// JOptionPane.showMessageDialog(null, "Deleted..");	
				 con.close();
						
			} catch (SQLException e) {
                     // TODO Auto-generated catch block

			}	
	 }
	 public ResultSet getSearchResult(String searchTxt) {
	        try {
	            String qu = "SELECT * FROM <> WHERE <> LIKE"
	            		+ " '%"+searchTxt+"%' OR <> LIKE '%"+searchTxt+"%' OR <> LIKE "
	            				+ "'%"+searchTxt+"%' OR <> LIKE '%"+searchTxt+"%'";
	            rs = stmt.executeQuery(qu);
	        } catch (SQLException e) {
	        }
	        return rs;
	    }
	 public ResultSet getSuppliersInfo(){
	        try{
	            String qu="SELECT * FROM suppliers";
	            rs=stmt.executeQuery(qu);
	        }catch(SQLException e){
	        }
	        return rs;
	    }
	 public ResultSet getUnitInfo(){
	        try{
	            String qu="SELECT * FROM Unit";
	            rs=stmt.executeQuery(qu);
	        }catch(SQLException e){
	        }
	        return rs;
	    }
	  public ResultSet DetialsPurchaseInfo(){
	        try{
	            String qu="SELECT * FROM `detailspurchase` WHERE 1";
	            rs=stmt.executeQuery(qu);
	        }catch(SQLException e){
	        }
	        return rs;
	    }
}
