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

public class GenS {
	private int GenS;
	public GenS() {
		Random random = new Random();
		setGenS(random.nextInt(1000000000));//10
	}
	public int getGenS() {
		return GenS;
	}
	public void setGenS(int genS) {
		this.GenS = genS;
	}

}
