/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myvillage.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import myvillage.Utility.Misc;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FilterController implements Initializable {

    @FXML
    private JFXCheckBox occupationFilterCheckBox;
    @FXML
    private JFXComboBox<?> occupationOptionComboBox;
    @FXML
    private JFXCheckBox workPlaceFilterCheckBox;
    @FXML
    private JFXCheckBox eduFilterCheckBox;
    @FXML
    private JFXCheckBox cellFilterCheckBox;
    @FXML
    private JFXComboBox<?> eduOptionComboBox;
    @FXML
    private JFXCheckBox ownsLandsFilterCheckBox;
    @FXML
    private JFXComboBox<?> workplaceOptionComboBox;
    @FXML
    private JFXCheckBox birthdayRangeCheckBox;
    @FXML
    private JFXComboBox<?> bloodgroupOptionComboBox;
    @FXML
    private JFXCheckBox incomeRangeCheckBox;
    @FXML
    private JFXComboBox<?> genderOptionComboBox;
    @FXML
    private JFXCheckBox bloodGroupFilterCheckBox;
    @FXML
    private JFXCheckBox genderFilterCheckBox;
    @FXML
    private JFXCheckBox houseNoFilterCheckBox;
    @FXML
    private JFXCheckBox emailFilterCheckBox;
    @FXML
    private TextField minRangeTextField;
    @FXML
    private TextField maxRangeTextField;
    @FXML
    private TextField cellTextField;
    @FXML
    private JFXButton cancelButton;
    @FXML
    private JFXButton applyButton;
    @FXML
    private JFXDatePicker startRangeTextField;
    @FXML
    private JFXDatePicker endRangeTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cancelFilterActionEvent(ActionEvent event) {
        Misc.closeWindowOnButton(applyButton);
    }

    @FXML
    private void applyFilterActionEvent(ActionEvent event) {
    }
    
}
