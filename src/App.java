import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
    
    @Override  
    public void start(Stage primaryStage) throws Exception {  
        
        
        Parent root = FXMLLoader.load(getClass().getResource("fxml/login.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("css/main.css").toExternalForm());
        primaryStage.setTitle("Loan Management System");
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
          
    }

    public static void main (String[] args) throws Exception  
    {  
        launch(args);
    
    }  
}
