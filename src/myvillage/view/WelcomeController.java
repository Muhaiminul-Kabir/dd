/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myvillage.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import myvillage.Utility.Misc;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class WelcomeController implements Initializable {

    @FXML
    private JFXTextField editVillageName;
    @FXML
    private JFXTextField editAddress;
    @FXML
    private JFXButton startButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void startApp(ActionEvent event) throws IOException {
        Misc.mainDir(editVillageName.getText(), editAddress.getText());
        
        Misc.closeWindowOnButton(startButton);
        
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "dash.fxml"
                ));
        Parent root = loader.load();
        DashController ctrl = loader.getController();
        
        
        
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

}
