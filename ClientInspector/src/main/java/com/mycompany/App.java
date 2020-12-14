package com.mycompany;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    
    public static void main( String[] args ){
        launch(args);
        
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/FXMLprincipalCI.fxml"));
        Scene scene = new Scene(root,700,800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Inpector Form");
        primaryStage.show();
    }

    
}
