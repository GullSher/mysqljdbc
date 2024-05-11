/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mysqljdbc;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.io.IOException;

import java.net.URL;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.fxml.Initializable;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author GULL SHER
 */
public class MainFormController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                 
        
    }    
    
    public void OpenFactory2(){
    // Your method implementation here

    System.out.println("Code to Open Factory 2.");
    // Here  i want to close 

        
 try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Factory2.fxml"));
//            Parent root = loader.load();
              Parent gullsher =loader.load();

            Scene scene1 = new Scene(gullsher);

            Stage stage1 = new Stage();
            stage1.setScene(scene1);
            stage1.show();
            stage1.setTitle("Factory 2");
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
           
   }
}


