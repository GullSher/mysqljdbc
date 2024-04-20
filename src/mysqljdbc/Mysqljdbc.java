/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mysqljdbc;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;





/**
 *
 * @author GULL SHER
 */
public class Mysqljdbc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      /**
        try 
        {
      
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wgcsite1","root","");
            System.out.println(con);
            System.out.println("Database connection established");
        }
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(Mysqljdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
            Logger.getLogger(Mysqljdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
// Launch JavaFX application
        Application.launch(Main.class, args);
        
        
    }
    
}
