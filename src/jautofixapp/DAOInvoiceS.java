
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
public class DAOInvoiceS {
        static  private String query;
        private Statement stmt ;
        private   ResultSet rs ;	
        private  PreparedStatement pstmt;
    
   public void InsertNewGenerationS(int s) throws SQLException{
            try (Connection con = DBconnection.getCon()) {
             //   stmt=(Statement) con.createStatement();
                query="INSERT INTO `gens`(`GnS`) VALUES (?)";
                // 
                pstmt = (PreparedStatement) con.prepareStatement(query);
               pstmt.setInt(1, s); //Gnes
  
                // execute the preparedstatement
                pstmt.executeUpdate();
                System.out.println("inserted into gener");
                con.close();
                
            }catch(SQLException e){
                 System.out.println(e.getMessage());
            }
     
     }   
   
   public void InsertNewSales(int q,double p,double t,int c ,int gs) throws SQLException{
            try (Connection con = DBconnection.getCon()) {

query="INSERT INTO `ordersales`(`QtySales`, `PriceSales`, `Total`, `ID_Stock`, `GnS`) VALUES(?,?,?,?,?)";
     
// 

                pstmt = (PreparedStatement) con.prepareStatement(query);
                //
              
               pstmt.setInt(1, q); // qty
               pstmt.setDouble(2, p);//price
               pstmt.setDouble(3, t);//total
               pstmt.setInt(4, c); //id_stq
               pstmt.setInt(5, gs); //gen
               

                // execute the preparedstatement
                pstmt.executeUpdate();
                System.out.println("inserted in ordersSale ");
             //   con.close();
                
            }catch(SQLException e){
                 System.out.println(e.getMessage());
            }
     
     }
   
    public ResultSet getStackAv(){
         Connection  con= DBconnection.getCon();
	        try{
	            query= "SELECT * FROM `stq`";
                    stmt = (Statement) con.createStatement();
	            rs=stmt.executeQuery(query);
                    System.out.println("ResultSet stack");
                //    con.close();
	        }catch(SQLException e){
                           System.out.println(e.getMessage());
	        }
	        return rs;
}
    public ResultSet getMyInvSales(){
         Connection  con= DBconnection.getCon();
	        try{
	            query= "SELECT * FROM `salebydate` ";
                    stmt = (Statement) con.createStatement();
	            rs=stmt.executeQuery(query);
                    System.out.println("ResultSet stack");
                //    con.close();
	        }catch(SQLException e){
                           System.out.println(e.getMessage());
	        }
	        return rs;
}
    public ResultSet getMyOrderSalesInfo(int cvb){
         Connection  con= DBconnection.getCon();
	        try{
	            query= "SELECT * FROM `infosale` WHERE `GnS`="+cvb;
                    stmt = (Statement) con.createStatement();
	            rs=stmt.executeQuery(query);
                    System.out.println("ResultSet stack");
                //    con.close();
	        }catch(SQLException e){
                           System.out.println(e.getMessage());
	        }
	        return rs;
}
    

  
 
   

      public void UpdateSale(String clint,double t,double d,double ad ,int gs) throws SQLException{
            try (Connection con = DBconnection.getCon()) {
query="UPDATE `sales` SET `clintname`=?,`TotalOfAll`=?,`Discount`=?,`afterDiscount`=? WHERE `GnS`=?";
                // 
                pstmt = (PreparedStatement) con.prepareStatement(query);
                //
               pstmt.setString(1, clint);
                pstmt.setDouble(2, t);
                pstmt.setDouble(3,d);
                pstmt.setDouble(4, ad);
                pstmt.setInt(5, gs);

                // execute the preparedstatement
                pstmt.executeUpdate();
                System.out.println("Updating ..sale..");
                con.close();
                
            }catch(SQLException e){
                       System.out.println(e.getMessage());
            }
     
     }
    
    
}
//DELETE FROM `ordersales` WHERE `SIo`='?'
// UPDATE `ordersales` SET `QtySales`='?',`PriceSales`='?',`Total`='?' WHERE `SIo`='?'
/*  public boolean checkGns(int ggg){
         Connection  con= DBconnection.getCon();
	        try{
	            query= "SELECT `GnS` FROM `gens` WHERE GnS="+ggg+" ;";
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