/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myvillage.view;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import myvillage.Utility.Misc;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class DashController implements Initializable {

    @FXML
    private Label villageNameLabel;
    @FXML
    private Label villageAddressLabel;
    @FXML
    private Label totalPopulationLabel;
    @FXML
    private JFXButton dashBoardNav;
    @FXML
    private JFXButton infstructNav;
    @FXML
    private JFXButton villagersNav;
    @FXML
    private JFXButton landsNav;
    @FXML
    private Pane mainAppPane;

    private Pane tempPane;
    public static Label tempLabel;
    
    private String[] window = {
        "dashs.fxml", 
        "vilkllist.fxml"
    };

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            loadWindow(0);
            tempLabel = totalPopulationLabel;
            villageNameLabel.setText(Misc.readFileAsString("src/set/name.txt"));
            villageAddressLabel.setText(Misc.readFileAsString("src/set/address.txt"));
            totalPopulationLabel.setText(Misc.readFileAsString("src/set/population.txt"));
        
        } catch (Exception ex) {
            Logger.getLogger(DashController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void loadDashBoard(ActionEvent event) throws IOException {
        loadWindow(0);
    }

    @FXML
    private void loadInfStruct(ActionEvent event) {
    }

    @FXML
    private void loadVillagers(ActionEvent event) throws IOException {
        loadWindow(1);
    }

    @FXML

    private void loadLands(ActionEvent event) {
    }
    
    
    
    
     private void loadWindow(int index) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(window[index]));
        Pane newLoadedPane = loader.load();

        mainAppPane.getChildren().remove(tempPane);

        mainAppPane.getChildren().add(newLoadedPane);

        tempPane = newLoadedPane;

    }
    
    
    
    
}
