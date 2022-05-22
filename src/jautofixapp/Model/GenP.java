/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jautofixapp.Model;

/**
 *
 * @author shammakh
 */
import java.util.Random;

public class GenP {
private int GenP;
	public GenP() {
		Random random = new Random();
		GenP=random.nextInt(100000000);//9
	}
	public int getGenP() {
		return GenP;
	}
	public void setGenP(int genP) {
		this.GenP = genP;
	}
	
}