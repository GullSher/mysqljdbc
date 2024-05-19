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

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wgcsite1", "gullsher", "allah@199");
            String dbName = connection.getCatalog();
            System.out.println("Database connection established with database: " + dbName);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
    public void login() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        
        try {
            String query = "SELECT * FROM login WHERE username=? AND password=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                showAlert("Login Successful", "Welcome, " + username + " !" + 
                        
                        " in the start a login.fxml shows and requires \n\n to input the username and password,"
                        + 
                "and at the backend it already has connected with mysql database name wgcsite1, \n\n"
                + " => in which from table named =login  in which \n\n textfiled named =textfiled and passwordfiled named password \n"
                + " is requireing to input user name and password if matched it go to mainform.\n\n" +
"Well Done "
                
                
                );
                
                
                
                openMainForm();
                
                showAlert("Next Requirements", "Task is, " 
                        //+ username + " !" + 
                        +
                        
                        " I have to Enter UserName and Password and on clicking Btn it should check in the database named wgcsote2 => table named => "
                        + ""
                        + "Now on the MainForm \n" +
"mainform.fxml shows and requires to input the username and password , and at the backend it already has connected with mysql database name wgcsite2, => in which from table named =loginsite2 => textfiled named =textfiled and passwordfiled named password is requireing to input user name and password if matched it go to wgcsite2form.\n" +
"Well Done  "                        + "             in the start a login.fxml shows and requires \n\n to input the username and password,"
                        + 
                "and at the backend it already has connected with mysql database name wgcsite1, \n\n"
                + " => in which from table named =login  in which \n\n textfiled named =textfiled and passwordfiled named password \n"
                + " is requireing to input user name and password if matched it go to mainform.\n\n" +
"Well Done "
                
                
                );
                
                
            } else {
                showAlert("Login Failed", "Invalid username or password.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Error", "An error occurred while trying to log in: " + e.getMessage());
        }
    }
    
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    private void openMainForm() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainForm.fxml"));
            Parent root = loader.load();
            
            Scene scene = new Scene(root);
            Stage stage = (Stage) usernameField.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Main Form");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "An error occurred while opening the Main Form: " + e.getMessage());
        }
    }
}
