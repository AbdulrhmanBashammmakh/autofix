/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jautofixapp.Func;

/**
 *
 * @author shammakh
 */
import java.util.ArrayList;
import java.util.Iterator;
import jautofixapp.Model.*;

public  class ObTableToArr {
	
	public static ArrayList<DetailsPurchase> ArrTbl(Object[][] A,int y){
		 ArrayList<DetailsPurchase> Ab =new ArrayList<>();
			System.out.println(Ab.size());
		
		try {
                     for (Object[] A1 : A) {
                //         Ab.add(new DetailsPurchase(A1[0], A1[1], A1[2], A1[3], A1[4], A1[5], y));
                         /*                    */                    System.out.printf(A1[0] + "   ");
                     }
		
		
		System.out.println("SIZE   "+Ab.size());
		Iterator<DetailsPurchase> itr=Ab.iterator();
		  double sum=0.0;
		  while(itr.hasNext()){  
			  DetailsPurchase st=(DetailsPurchase)itr.next(); 
			//  st.setTotal(st.getPriceP()*st.getQty());
			    System.out.println(st.getTotal()+"  "+st.getGnP());  
			//    sum=sum+st.getTotal();
			  }  
		  System.out.println(sum);
	} catch (Exception e) {
                     // TODO Auto-generated catch block

			}
		return Ab;
		
	}


}
