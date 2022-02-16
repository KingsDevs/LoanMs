package controllers;

import java.sql.SQLException;

import connect.net.sqlite.Connect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
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

    @FXML
    void loginBtnClicked(ActionEvent event) throws SQLException 
    {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username != "" && password != "") 
        {
            Connect connect = new Connect();
            User user = connect.getData();

            if (user.getUsername() == username && user.getPassword() == password) 
            {
                validationText.setTextFill(Color.GREEN);
                validationText.setText("You are login!");
            }
            else
            {
                validationText.setTextFill(Color.RED);
                validationText.setText("Your username or password is not correct!");
            }

            System.out.println(username);
            System.out.println(password);
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
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
