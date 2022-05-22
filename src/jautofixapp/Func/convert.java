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
public class convert {
	public convert() {
	}
public String IntStr (int x) {
		
		String ss=String.valueOf(x);
		return ss;
	}
public String DobStr (double d) {
		
		String ss=String.valueOf(d);
		return ss;
	}
public int StrInt(String s2) {
	int oo=Integer.parseInt(s2);
	return oo;
}
public static double StrDob(String s2) {
	double dd = Double.parseDouble(s2);
	return dd;
}
	}

