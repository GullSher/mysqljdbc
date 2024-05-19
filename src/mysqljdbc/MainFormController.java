package mysqljdbc;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class MainFormController implements Initializable {

    public TextField usernameField1;
    public PasswordField passwordField1;
    
    private Connection connection1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/wgcsite2", "gullsite2", "yes");
            String dbName1 = connection1.getCatalog();
            System.out.println("Database connection established with database: " + dbName1);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MainFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void OpenFactory2() {
        System.out.println("Code to Open Factory 2 From MainFormController.java.");
        
        System.out.println("\n\nNow on the MainForm \n" +
"mainform.fxml shows and requires to input the username and password,\n"
                + " and at the backend it already has connected with mysql database name wgcsite2,\n"
                + " => in which from table named =loginsite2 => textfiled named =textfiled and passwordfiled named password\n"
                + " is requireing to input user name and password if matched it go to wgcsite2form.\n\n\n" +
"Well Done  .");
        System.out.println("Code to Open Factory 2 From MainFormController.java.");
        System.out.println("Code to Open Factory 2 From MainFormController.java.");
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
