package com.mycompany;

import com.mycompany.clientServices.Requester;
import com.mycompany.enums.Method;
import com.mycompany.enums.Service;
import com.mycompany.supports.Registry;
import java.util.List;
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
        
        /*Requester requester = new Requester();
        List<Registry> registryList = requester.getObjectList(Service.QANALYST, Method.GET_REGISTRY_LIST);
        for(Registry r: registryList){
            System.out.println(r.getId()+" "+r.getInspectorName()+" "+r.getInspectorPhoneNumber()+" "+r.getInspectionTime()+" "+r.getIdFoodTruck()+
                    " "+r.getCleaningStatus()+" "+r.getOperatorName()+" "+r.getOperatorPhoneNumber()+" "+r.getDescription());
        }
        Registry r = (Registry) requester.getObject(Service.QANALYST, Method.GET_LAST_REGISTRY);
        System.out.println("Lastone: "+r.getId()+" "+r.getInspectorName()+" "+r.getInspectorPhoneNumber()+" "+r.getInspectionTime()+" "+r.getIdFoodTruck()+
                    " "+r.getCleaningStatus()+" "+r.getOperatorName()+" "+r.getOperatorPhoneNumber()+" "+r.getDescription());*/
        
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
