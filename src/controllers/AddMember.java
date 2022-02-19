package controllers;

import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import objects.CoopMember;
import tools.FormValidation;

public class AddMember 
{

    @FXML
    private Button addMemberBtn;

    @FXML
    private Label addressValidation;

    @FXML
    private TextField addressVield;

    @FXML
    private TextField firstNameField;

    @FXML
    private Label firstNameValidation;

    @FXML
    private TextField lastnameField;

    @FXML
    private Label lastnameValidation;

    @FXML
    private Label mainFormValidationLabel;

    @FXML
    private TextField middleNameField;

    @FXML
    private Label middleNameValidation;

    @FXML
    private TextField positionField;

    @FXML
    private Label positionValidation;

    private AddMemberMainController addMemberMainController;

    public void setAddMemberMainController(AddMemberMainController addMemberMainController)
    {
        this.addMemberMainController = addMemberMainController;
    }

    @FXML
    void addMember(ActionEvent event) 
    {
        addMemberBtn.setDisable(true);

        String firstname = firstNameField.getText();
        String middlename = middleNameField.getText();
        String lastName = lastnameField.getText();
        String address = addressVield.getText();
        String position = positionField.getText();

        boolean isCleared = true;

        firstNameValidation.setText("");
        lastnameValidation.setText("");
        middleNameValidation.setText("");
        addressValidation.setText("");
        positionValidation.setText("");
        mainFormValidationLabel.setText("");

        if(firstname.isEmpty())
        {
            firstNameValidation.setText(FormValidation.emptyField("First Name"));
            isCleared = false;
        }

        if(middlename.isEmpty())
        {
            middleNameValidation.setText(FormValidation.emptyField("Middle Name"));
            isCleared = false;
        }

        if(lastName.isEmpty())
        {
            lastnameValidation.setText(FormValidation.emptyField("Last Name"));
            isCleared = false;
        }

        if(address.isEmpty())
        {
            addressValidation.setText(FormValidation.emptyField("Address"));
            isCleared = false;
        }

        if(position.isEmpty())
        {
            positionValidation.setText(FormValidation.emptyField("Position"));
            isCleared = false;
        }

        try {
            if (CoopMember.isExist(firstname, middlename, lastName)) 
            {
                mainFormValidationLabel.setText("Coop Member Already Exist!");
                isCleared = false;
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }

        if (isCleared) 
        {
            System.out.println("Lesgaw");

            Scene currScene = addMemberBtn.getScene();
            Stage currStage = (Stage)currScene.getWindow();

            currStage.close();
        }
        else
        {
            addMemberBtn.setDisable(false);
        }


    }

}
