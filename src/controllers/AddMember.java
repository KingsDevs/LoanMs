package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class AddMember 
{

    @FXML
    private Button addMemberBtn;

    @FXML
    private HBox addressValidation;

    @FXML
    private TextField addressVield;

    @FXML
    private TextField firstNameField;

    @FXML
    private HBox firstNameValidation;

    @FXML
    private TextField lastnameField;

    @FXML
    private HBox lastnameValidation;

    @FXML
    private Label mainFormValidationLabel;

    @FXML
    private TextField middleNameField;

    @FXML
    private HBox middleNameValidation;

    @FXML
    private TextField positionField;

    @FXML
    private HBox positionValidation;

    @FXML
    void addMember(ActionEvent event) 
    {

    }

}
