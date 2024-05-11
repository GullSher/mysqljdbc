/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mysqljdbc;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * FXML Controller class
 *
 * @author GULL SHER
 */
public class Factory2Controller implements Initializable {

/**
     * Initializes the controller class.
     */
    private Connection connection;

@Override
    public void initialize(URL url, ResourceBundle rb1) {
        // TODO
        
        // Establish connection to wgcsite2 database and retrieve data from table1
       
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //tried to change to password for=root ,"", to username-gullsher and password=allah@199
        //
//connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wgcsite1", "root", "");
//
        
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wgcsite2", "gullsher", "allah@199");
        //connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/wgcsite2", "root", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM table1");

            // Process ResultSet and populate UI elements

            while (resultSet.next()) {
                // Retrieve data from ResultSet and populate UI elements

    }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }

    }    
    
}
        
