package mysqljdbc;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.DriverManager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;







public class LoginController implements Initializable {
    
    public TextField usernameField;
    public PasswordField passwordField;
    
    private Connection connection;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
/*        // Initialize database connection  */
        //connection = 

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
                
        
        
        
        


// Initialize your database connection here
    }    

    public void login() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        
        try {
            // Prepare SQL statement
            String query = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            
            // Execute query
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                // Login successful
                showAlert("Login Successful", "Welcome, " + username + "!");
            } else {
                // Login failed
                showAlert("Login Failed", "Invalid username or password.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Error", "An error occurred while trying to log in.");
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
