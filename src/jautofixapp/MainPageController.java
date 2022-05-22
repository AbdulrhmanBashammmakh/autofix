/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jautofixapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author shammakh
 */
public class MainPageController implements Initializable {

    /**
     * Initializes the controller class.
     */
   @FXML
   private Button pr;
   @FXML
   private Button stk;
   @FXML
   private Button sa;
   @FXML
   private Button ba;
    @FXML
    private Button su;
    @FXML
    private Button cu;
   
    
    

   
   
    public void Go_Unit(ActionEvent e) throws IOException{
        System.out.println("go to unit");
    ba.setText("cliked");
     Showus show;
     show =new Showus("unit.fxml");
    }

    public void Go_stPurchase(ActionEvent e) throws IOException{
        System.out.println("go to Main Purchase ");
  //  ba.setText("cliked");
    System.out.println("go to purchase stand by");
         Stage stage ;
        stage = new Stage();
     
    Parent root;
        root = FXMLLoader.load(getClass().getResource("Purchasefx.fxml"));
         Scene scene = new Scene(root);
        stage.setTitle("ABDU");
        stage.setScene(scene);
        stage.show();
        
    
    }
    

    public void Go_Stack(ActionEvent e) throws IOException{
            System.out.println("go to Stack");
     stk.setText("cliked");
     
     Showus show;
        show = new Showus("Stock.fxml");
    }
    
    
    public void Go_Sales(ActionEvent e) throws IOException{
            System.out.println("go to sales");
     sa.setText("cliked");
     Showus show;
      show =new Showus("sales.fxml");
    
    }
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        //label.setText("Hello World!");
       // bt1.get
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     public void Go_Purchase(ActionEvent e) throws IOException{
        System.out.println("go to purchase");
         Stage stage ;
        stage = new Stage();
     pr.setText("cliked");
    Parent root;
        root = FXMLLoader.load(getClass().getResource("purch.fxml"));
         Scene scene = new Scene(root);
        stage.setTitle("ABDU");
        stage.setScene(scene);
        stage.show();
    }
    
    
}
