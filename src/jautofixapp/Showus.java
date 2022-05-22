/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jautofixapp;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author shammakh
 */
public class Showus {
    private String s=null;
  public  Showus(String s){
      Stage stage ;
        stage = new Stage();
      Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(s));
        } catch (IOException ex) {
            Logger.getLogger(Showus.class.getName()).log(Level.SEVERE, null, ex);
        }
         Scene scene = new Scene(root);
        stage.setTitle("ABDU");
        stage.setScene(scene);
      
        stage.show();
  }
  public String getSs() {
		return s;
	}
	public void setSs(String x) {
		s = x;
	}
}
