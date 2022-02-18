package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import connect.net.sqlite.Connect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;
import objects.User;

public class LoginController 
{

    @FXML
    private Button loginBtn;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    private Label validationText;

    private Statement userStmt;



    public LoginController()
    {

        Connection conn = Connect.getConnection();
        try {
            userStmt  = conn.createStatement();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    void handle(KeyEvent keyEvent) throws SQLException, IOException 
    {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) 
        {
           loginBtnClicked(new ActionEvent());
        }
        
    }

    @FXML
    void loginBtnClicked(ActionEvent event) throws SQLException, IOException 
    {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (!(username.isEmpty() && password.isEmpty())) 
        {
            loginBtn.setDisable(true);            

            Connect connect = new Connect();
            User user = connect.getUserData(userStmt);

            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) 
            {
                validationText.setTextFill(Color.GREEN);
                validationText.setText("You are login!");

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
                Parent root = loader.load();

                MainController mainController = loader.getController();
                mainController.setStatement(userStmt);
                mainController.setHome();
                //Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
                
                Scene scene = loginBtn.getScene();
                Window window = scene.getWindow();
                Stage stage = (Stage)window;

                Scene mainScene = new Scene(root);
                mainScene.getStylesheets().add(getClass().getResource("/css/main.css").toExternalForm());
                stage.setScene(mainScene);
                stage.show();
            }
            else
            {
                validationText.setTextFill(Color.RED);
                validationText.setText("Your username or password is not correct!");

                loginBtn.setDisable(false);
            }

        }
        else
        {
            validationText.setTextFill(Color.RED);
            validationText.setText("Username field or password field are empty!");
        }
        
        // System.out.println(username);
        // System.out.println(password);

        // Connect connect = new Connect();
        // User user = connect.getData();

        // System.out.println(user.getUsername());
        // System.out.println(user.getPassword());

    }

}
