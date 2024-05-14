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

    public TextField usernameField1; //usernameField
    public PasswordField passwordField1;  //passwordField
    
    private Connection connection1;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
       //tried to change to password for=root ,"", to username-gullsher and password=allah@199
        //
//connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wgcsite1", "root", "");
//
        
        connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/wgcsite2", "gullsher", "allah@199");
        String dbName1 = connection1.getCatalog(); // Get the name of the connected database
        System.out.println("Database connection established with database: " + dbName1);
        System.out.println("From LoginController.java Databased Connected  "+ dbName1);
    } catch (ClassNotFoundException | SQLException ex) {
        
//Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
  Logger.getLogger(MainFormController.class.getName()).log(Level.SEVERE, null, ex);

}
}
       
// Initialize your database connection here
        
    public void login() {
        String username1=usernameField1.getText();
        String password1=passwordField1.getText();
        
        try {
            // Prepare SQL statement
            String query = "SELECT * FROM login2 WHERE username=? AND password=?";
            PreparedStatement statement = connection1.prepareStatement(query);
            statement.setString(1, username1);
            statement.setString(2, password1);
            
            // Execute query
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                // Login successful
//                showAlert("Login Successful", "Welcome, " + username + "!");
                  showAlert("Login Successful", "Welcome, " + username1 + "!");
                //show1();
                //openMainForm(); // On succefull login Open Main Form from where i can use One of the Factories.
                OpenFactory2();

            } else {
                // Login failed
                showAlert("Login Failed", "Invalid username or password.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Error", "An error occurred while trying to log in." +  e.getMessage());

        }
    }
    
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
        
        
        
           
   }
        
        
   //}    
    
    public void OpenFactory2(){
    // Your method implementation here

    System.out.println("Code to Open Factory 2 From MainFormController.java .");
    System.out.println("form MainformController here i shold be connected to database wgcsite3.");
    System.out.println("Here  i want to close "+ "MainForm.fxml" );
            


    
    
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Factory2.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Factory 2");
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

  
    
    }
    


