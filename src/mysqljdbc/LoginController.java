package mysqljdbc;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class LoginController implements Initializable {
    
    public TextField usernameField; //usernameField
    public PasswordField passwordField;  //passwordField
    
    private Connection connection;

    //@Override
    //public void initialize(URL url, ResourceBundle rb) {
        //connection = 
@Override
public void initialize(URL url, ResourceBundle rb) {
/*        // Initialize database connection  */
try {
        Class.forName("com.mysql.cj.jdbc.Driver");
       //tried to change to password for=root ,"", to username-gullsher and password=allah@199
        //
//connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wgcsite1", "root", "");
//
        
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wgcsite1", "gullsher", "allah@199");
        String dbName = connection.getCatalog(); // Get the name of the connected database
        System.out.println("Database connection established with database: " + dbName);
//        System.out.println("Database connection established with database named "+);
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
    }
}
       
// Initialize your database connection here
        
    public void login() {
        String username=usernameField.getText();
        String password =passwordField.getText();
        
        try {
            // Prepare SQL statement
            String query = "SELECT * FROM login WHERE username=? AND password=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            
            // Execute query
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                // Login successful
//                showAlert("Login Successful", "Welcome, " + username + "!");
                  showAlert("Login Successful", "Welcome, " + username + "!");
                show1();
                openMainForm(); // On succefull login Open Main Form from where i can use One of the Factories.
                
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
    
    public void show1(){
        System.out.println(" this is from show1 of LoginController.java method.");

        
         
        
    }
    

    private void openMainForm(){
        try {
        // Load the MainForm.fxml file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainForm.fxml"));

        Parent root = loader.load();

        // Create a new scene with the loaded MainForm.fxml
        Scene scene = new Scene(root);

        // Get the current stage (from any UI element)
        Stage stage = (Stage) usernameField.getScene().getWindow();

        // Set the scene to the stage
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Main Form");
    } catch (IOException e) {
        e.printStackTrace();
        showAlert("Error", "An error occurred while opening the Factory2 form." + e.getMessage());
    }
    }
    
}

    
