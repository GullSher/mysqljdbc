/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mysqljdbc;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;


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
        //1.  Establish connection to wgcsite2 database and retrieve data from table1
       //2.  insert a menubar at top
       
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //tried to change to password for=root ,"", to username-gullsher and password=allah@199
        //
//connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wgcsite1", "root", "");
  
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
      // Menu item action handlers
    @FXML
    private void handleNewAction(ActionEvent event) {
        showAlert("New Action", "New action triggered");
    }

    @FXML
    private void handleOpenAction(ActionEvent event) {
        showAlert("Open Action", "Open action triggered");
    }

    @FXML
    private void handleSaveAction(ActionEvent event) {
        showAlert("Save Action", "Save action triggered");
    }

    @FXML
    private void handleExitAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void handleCutAction(ActionEvent event) {
        showAlert("Cut Action", "Cut action triggered");
    }

    @FXML
    private void handleCopyAction(ActionEvent event) {
        showAlert("Copy Action", "Copy action triggered");
    }

    @FXML
    private void handlePasteAction(ActionEvent event) {
        showAlert("Paste Action", "Paste action triggered");
    }

    @FXML
    private void handleAboutAction(ActionEvent event) {
        showAlert("About", "About action triggered");
    }

    @FXML
    private void handleHelpAction(ActionEvent event) {
        showAlert("Help", "Help action triggered");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    } 
       
    
}
        
