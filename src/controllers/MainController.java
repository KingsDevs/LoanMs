package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class MainController 
{
    private Statement statement;
    private Button currBtnActive = null;

    @FXML
    private Button addLoanBtn;

    @FXML
    private Button addMemberBtn;

    @FXML
    private Button homeBtn;

    @FXML
    private BorderPane mainPane;

    @FXML
    private Button settingsBtn;

    @FXML
    void addLoanAction(ActionEvent event) 
    {
        
    }

    @FXML
    void addMemberAction(ActionEvent event) 
    {
        
    }

    @FXML
    void homeAction(ActionEvent event) 
    {
        
    }

    @FXML
    void settingsAction(ActionEvent event) 
    {
        
    }

    

    public void setStatement(Statement stmnt)
    {
        statement = stmnt;
    }

    private Pane getPane(String paneName) throws IOException
    {
        Pane viewPane = null;

        URL fileURL = getClass().getResource("/fxml/" + paneName +".fxml");
        viewPane = FXMLLoader.load(fileURL);

        return viewPane;
    }
}
