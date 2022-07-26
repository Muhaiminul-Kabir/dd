/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myvillage;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import myvillage.Utility.Misc;

/**
 *
 * @author ASUS
 */
public class MyVillage extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
         Parent root1 ;
         
         if(Misc.isDir()){
             root1 = FXMLLoader.load(getClass().getResource("view/dash.fxml"));
         }else{
             root1 = FXMLLoader.load(getClass().getResource("view/welcome.fxml"));
         }
         
         
         
         Misc.changeTo(root1);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
