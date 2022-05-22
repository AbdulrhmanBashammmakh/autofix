
package jautofixapp;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author shammakh
 */
public class DAOInvoiceP {
        static  private String query;
	private Statement stmt ;
        private   ResultSet rs ;	
        private  PreparedStatement pstmt;
   
   
 
    
    public ResultSet Pur_Spp(){
            Connection  con= DBconnection.getCon();
	        try{
                  
	        query="SELECT * FROM pur_spp";
                stmt = (Statement) con.createStatement();
	        rs=stmt.executeQuery(query);
	        }catch(SQLException e){
	        }
	        return rs;
    }
    
    public ResultSet PurchaseInfoByGnp(int gnpp){
            Connection  con= DBconnection.getCon();
	        try{
                  
	        query="SELECT * FROM `detials` where GnP ="+gnpp;
                
                stmt = (Statement) con.createStatement();
             
                
	        rs=stmt.executeQuery(query);
	        }catch(SQLException e){
	        }
	        return rs;
	    }
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
    
    
    
    public ResultSet IdUnitForPurchase(String s){
            Connection  con= DBconnection.getCon();
	        try{
                  
	             query="SELECT `ID_Unit` FROM `unit` WHERE `Unit`="+s;
                     stmt = (Statement) con.createStatement();
	            rs=stmt.executeQuery(query);
	        }catch(SQLException e){
	        }
	        return rs;
	    }
    
    public ResultSet IdSppleirForPurchase(String s){
            Connection  con= DBconnection.getCon();
	        try{
                  
	             query="SELECT `ID_Suppleir` FROM `sppleir` WHERE `FN`="+s;
                     stmt = (Statement) con.createStatement();
	            rs=stmt.executeQuery(query);
	        }catch(SQLException e){
	        }
	        return rs;
	    }
    
    
     public void InsertNewPurchase(int c,String s,int u,int q,double p,double t ,int g) throws SQLException{
            try (Connection con = DBconnection.getCon()) {
//query="INSERT INTO detailspurchase(ID_Dp,Code,Title,ID_Unit,Qty,PriceP,Total,GnP) VALUES (NULL,?,?,?,?,?,?,?)";
query="INSERT INTO detailspurchase(Code,Title,ID_Unit,Qty,PriceP,Total,GnP) VALUES (?,?,?,?,?,?,?)";
     
// 

                pstmt = (PreparedStatement) con.prepareStatement(query);
                //
              
               pstmt.setInt(1, c); //Code
               pstmt.setString(2, s);//Title
               pstmt.setInt(3, u);//ID_Unit
               pstmt.setInt(4, q); //Qty
               pstmt.setDouble(5, p); //PriceP
               pstmt.setDouble(6, t); //Total
               pstmt.setInt(7, g); //GnP

                // execute the preparedstatement
                pstmt.executeUpdate();
                System.out.println("inserted in detiales ");
             //   con.close();
                
            }catch(SQLException e){
                
            }
     
     }
     public void InsertNewGenerationP(int g) throws SQLException{
            try (Connection con = DBconnection.getCon()) {
             //   stmt=(Statement) con.createStatement();
                query="INSERT INTO genp(GenP) VALUES (?)";
                // 
                pstmt = (PreparedStatement) con.prepareStatement(query);
               pstmt.setInt(1, g); //Gnep
  
                // execute the preparedstatement
                pstmt.executeUpdate();
                System.out.println("inserted into gener");
                con.close();
                
            }catch(SQLException e){
                 System.out.println(e.getMessage());
            }
     
     }
    
     
     public void UpdatePurchase(int sp ,int gg) throws SQLException{
            try (Connection con = DBconnection.getCon()) {
query="UPDATE purchase SET ID_Sppleir= ? WHERE GnP = ?";
                // 
                pstmt = (PreparedStatement) con.prepareStatement(query);
                //
               pstmt.setInt(1, sp);
                pstmt.setInt(2, gg);

                // execute the preparedstatement
                pstmt.executeUpdate();
                System.out.println("Updating ....");
                con.close();
                
            }catch(SQLException e){
                
            }
     
     }
     
public ResultSet PurchaseInfo(){ 
            Connection  con= DBconnection.getCon();
	        try{
                  
query="SELECT * FROM `purchase` ORDER by `Cdate` DESC";
stmt = (Statement) con.createStatement();
rs=stmt.executeQuery(query);
	        }
                catch(SQLException e){
	        }
	        return rs;
	    }

 public ResultSet getUnitInfo(){
         Connection  con= DBconnection.getCon();
	        try{
query="SELECT * FROM Unit";
stmt = (Statement) con.createStatement();
rs=stmt.executeQuery(query);
System.out.println("ResultSet Unit info");
                //    con.close();
	        }
                catch(SQLException e){
	        }
	        return rs;
}
 
 /* public void InsertNewPurchaseObj(DetailsPurchase dp,int gx) throws SQLException{
            try (Connection con = DBconnection.getCon()) {
query="INSERT INTO detailspurchase(ID_Dp,Code,Title,ID_Unit,Qty,PriceP,Total,GnP) VALUES (NULL,?,?,?,?,?,?,?)";
                // 
                pstmt = (PreparedStatement) con.prepareStatement(query);
                //
              
               pstmt.setInt(1, dp.getCode()); //Code
               pstmt.setString(2, dp.getTitle());//Title
               pstmt.setInt(3, dp.getID_Unit());//ID_Unit
               pstmt.setInt(4, dp.getQty()); //Qty
               pstmt.setDouble(5, dp.getPriceP()); //PriceP
               pstmt.setDouble(6, dp.getTotal()); //Total
               pstmt.setInt(7, gx); //GnP

                // execute the preparedstatement
                pstmt.executeUpdate();
                System.out.println("inserted");
                
            }catch(SQLException e){
                
            }
     
     }
 */

/*   public boolean checkGnp(int ggg){
         Connection  con= DBconnection.getCon();
	        try{
	            query= "SELECT `GnS` FROM `genp` WHERE Gnp="+ggg+" ;";
                    stmt = (Statement) con.createStatement();
	            rs=stmt.executeQuery(query);
                 if(!rs.wasNull())
                 {
                      System.out.println("it is not  possible to set number ");
                    return false; 
                 }
                 
                 else return true ;
                //    con.close();
	        }catch(SQLException e){
                      System.out.println("can not achive ,ResultSet not Check");
	        }
       return true ;
}*/
}

