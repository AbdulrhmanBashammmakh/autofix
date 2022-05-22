/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jautofixapp.Model;

import jautofixapp.DAOInvoiceP;
import jautofixapp.DAO_Sppleir;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

/**
 *
 * @author shammakh
 */
public class ChElement {
     private  ArrayList <Unit>listUnit =new ArrayList <>();
     private ArrayList<GenP>listGenP =new ArrayList <>();
     private ArrayList<Sppleir>listSpp =new ArrayList <>();
    
    
    
     public int intGene() throws SQLException{
        GenP gg=   new GenP();
        if(!GenerChK(gg.getGenP())){
             intGene();
        }
        System.out.println("intGene()");
  return gg.getGenP();
   }
   
    public ArrayList<GenP> GenPlistcheck() throws SQLException{
         ArrayList <GenP>AB =new ArrayList <>();
         AB.clear();
         DAOInvoiceP Du=new DAOInvoiceP();
        ResultSet rrs = Du.getUnitInfo();
         while(rrs.next())
         {
           GenP Ls=new GenP();
           Ls.setGenP(rrs.getInt(1));
          
           AB.add(Ls);
         }
         System.out.println("GenPlistcheck()");
       return AB;
    }
   
   public boolean GenerChK(int gp) throws SQLException{
       listGenP.clear();
       listGenP=GenPlistcheck();
       System.out.println("GenerChK()");
        Iterator<GenP> itr2=listGenP.iterator();
         while(itr2.hasNext()){
             GenP Git=itr2.next();
       if(gp==Git.getGenP()){
           return false; 
       }
         }
   return true;
   }
   
   
    public ArrayList<Unit> UnitlistFromDB() throws SQLException{
         ArrayList <Unit>AB =new ArrayList <>();
         AB.clear();
         DAOInvoiceP Du=new DAOInvoiceP();
        ResultSet rrso = Du.getUnitInfo();
   
         while(rrso.next())
         {
           Unit Ls=new Unit();
           Ls.setID_Unit(rrso.getInt(1));
           Ls.setUnit(rrso.getString(2));
           AB.add(Ls);
         }
         
       return AB;
    }
    
    private void UnitGetFromList() throws SQLException{
      listUnit=  UnitlistFromDB();
     /*   System.out.println(listUnit);
        Iterator<Unit> itr=listUnit.iterator();
         while(itr.hasNext()){
             Unit itu=itr.next();
             System.out.println(itu.getID_Unit());
         }*/
    }
    public int CHkU(String s ) throws SQLException {
        UnitGetFromList();
        
        Iterator<Unit> itr=listUnit.iterator();
         while(itr.hasNext()){
             Unit itu=itr.next();
         if( s == null ? itu.getUnit() == null : s.equals(itu.getUnit())){
             System.out.println("CHkU()" + "  "+itu.getID_Unit());
             return itu.getID_Unit();    
         }
         }
        
   return 0;
 }
    
    // sppleir part 
    
    public ArrayList<Sppleir> SpplistDB() throws SQLException{
         ArrayList <Sppleir>AB =new ArrayList <>();
         AB.clear();
         DAO_Sppleir Du=new DAO_Sppleir();
        ResultSet rrs = Du.getSppleirInfo();
         while(rrs.next())
         {
           Sppleir Ls=new Sppleir();
           Ls.setID_Suppleir(rrs.getInt(1));
           Ls.setFN(rrs.getString(2));
           Ls.setAddress(rrs.getString(3));
           Ls.setPhone(rrs.getString(4));
          
           AB.add(Ls);
         }
         
       return AB;
    }
    
    private void SppOnList() throws SQLException{
      listSpp=  SpplistDB();
      /*  System.out.println(listSpp);
        Iterator<Sppleir> itr=listSpp.iterator();
         while(itr.hasNext()){
            Sppleir itu=itr.next();
            System.out.println(itu.getFN());
         }*/
    }
    public int CHkSpp(String s ) throws SQLException {
        SppOnList();
        Iterator<Sppleir> itr3=listSpp.iterator();
         while(itr3.hasNext()){
             Sppleir its=itr3.next();
         if( s == null ? its.getFN() == null : s.equals(its.getFN())){
             System.out.println("CHkS()" + "  "+its.getID_Suppleir());
             return its.getID_Suppleir();
         }
         }
        
   return 0;
 }
    
     @SuppressWarnings("unchecked")
    public void DeletObsv(TableView<DetailsPurchase1> table ){
         TableView.TableViewSelectionModel tsm;
        tsm = table.getSelectionModel();
         
        // Check, if any rows are selected
        if (tsm.isEmpty()) 
        {
            System.out.println("Please select a row to delete.");
            return;
        }
    // Get all selected row indices in an array
    ObservableList list;
        list = tsm.getSelectedIndices();
 
    Integer[] selectedIndices = new Integer[list.size()];
    selectedIndices = (Integer[]) list.toArray(selectedIndices);
 
    // Sort the array
    Arrays.sort(selectedIndices);
 
    // Delete rows (last to first)
    for(int i = selectedIndices.length - 1; i >= 0; i--) 
    {
        tsm.clearSelection(selectedIndices[i]);
        table.getItems().remove(selectedIndices[i].intValue());
    }
    }
    
     @SuppressWarnings("unchecked")
    public void DeletObsvSale(TableView<ordersaleFull> table ){
         TableView.TableViewSelectionModel tsm;
        tsm = table.getSelectionModel();
         
        // Check, if any rows are selected
        if (tsm.isEmpty()) 
        {
            System.out.println("Please select a row to delete.");
            return;
        }
    // Get all selected row indices in an array
    ObservableList list;
        list = tsm.getSelectedIndices();
 
    Integer[] selectedIndices = new Integer[list.size()];
    selectedIndices = (Integer[]) list.toArray(selectedIndices);
 
    // Sort the array
    Arrays.sort(selectedIndices);
 
    // Delete rows (last to first)
    for(int i = selectedIndices.length - 1; i >= 0; i--) 
    {
        tsm.clearSelection(selectedIndices[i]);
        table.getItems().remove(selectedIndices[i].intValue());
    }
    }
}
