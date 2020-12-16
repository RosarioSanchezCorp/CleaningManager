package com.mycompany;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Hello world!
 *
 */
public class App extends Application{
    public static void main( String[] args ){
        
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/FXMLprincipalQA.fxml"));
        Scene scene = new Scene(root,1500,900);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Quality Analyst");
        primaryStage.show();
        
        primaryStage.setOnCloseRequest(new EventHandler <WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }
        });
    }
}
