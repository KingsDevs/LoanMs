package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import objects.CoopMember;

public class AddMemberMainController implements Initializable
{

    @FXML
    private Button addMemberBtn;

    @FXML
    private TableView<CoopMember> memberTableView;

    @FXML
    private TableColumn<CoopMember, String> addressCol;

    @FXML
    private TableColumn<CoopMember, String> firstNameCol;

    @FXML
    private TableColumn<CoopMember, String> lastNameCol;

    @FXML
    private TableColumn<CoopMember, String> middleNameCol;

    @FXML
    private TableColumn<CoopMember, String> positionCol;

    

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) 
    {
        firstNameCol.setCellValueFactory(new PropertyValueFactory<CoopMember, String>("firstname"));
        middleNameCol.setCellValueFactory(new PropertyValueFactory<CoopMember, String>("middlename"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<CoopMember, String>("lastname"));
        positionCol.setCellValueFactory(new PropertyValueFactory<CoopMember, String>("position"));
        addressCol.setCellValueFactory(new PropertyValueFactory<CoopMember, String>("address"));

        // try {
        //     ObservableList<CoopMember> observableList = FXCollections.observableList(CoopMember.getMembers());
        //     memberTableView.setItems(observableList);
        // } catch (SQLException e) {
        //     e.printStackTrace();
        // }
        
        updateTable();
        
    }

    @FXML
    void addMember(ActionEvent event) throws IOException 
    {
        Stage addMemberStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/addMembers.fxml"));

        // FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/addMembers.fxml"));
        // AddMember addMember = loader.getController();
        // addMember.setAddMemberMainController(this);

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/css/main.css").toExternalForm());
        addMemberStage.setTitle("Add Members");
        addMemberStage.alwaysOnTopProperty();
        addMemberStage.setScene(scene);
        addMemberStage.centerOnScreen();
        
        Scene currScene = addMemberBtn.getScene();
        Stage currStage = (Stage)currScene.getWindow();

        addMemberStage.initOwner(currStage);
        addMemberStage.initModality(Modality.WINDOW_MODAL);
        
        addMemberStage.show();

    }

    public void updateTable()
    {
        ObservableList<CoopMember> data = memberTableView.getItems();
        
        try (ResultSet resultSet = CoopMember.getMembers()) {

            while (resultSet.next()) 
            {
                data.add(new CoopMember(
                    resultSet.getString("firstname"), 
                    resultSet.getString("middlename"), 
                    resultSet.getString("lastname"), 
                    resultSet.getString("position"), 
                    resultSet.getString("address")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        memberTableView.setItems(data);
    }

    // public void addMemberInData(CoopMember coopMember)
    // {
    //     data.add(coopMember);
    //     memberTableView.setItems(data);
    // }
}
