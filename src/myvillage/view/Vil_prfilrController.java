/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myvillage.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import myvillage.Utility.DataBase;
import myvillage.Utility.Misc;
import myvillage.data.VillagerDao;
import myvillage.model.Villager;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Vil_prfilrController implements Initializable {

    @FXML
    private ImageView villagerImageView;
    @FXML
    private JFXButton deleteButton;
    @FXML
    private JFXButton editButton;
    @FXML
    private JFXButton applyButton;
    @FXML
    private JFXButton cancelButton;
    @FXML
    private Label villagerNameLabel;
    @FXML
    private Label dobLabel;
    @FXML
    private Label occLabel;
    @FXML
    private Label mincomeLabel;
    @FXML
    private Label houseNoLabel;
    @FXML
    private Label addressLabel;
    @FXML
    private Label educationalStatusLabel;
    @FXML
    private Label workPlaceLabel;
    @FXML
    private Label genderLabel;
    @FXML
    private Label bloodgroupLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label cellLabel;
    @FXML
    private Label maritialStatusLAbel;
    @FXML
    private Label healthStatusLabel;
    @FXML
    private JFXDatePicker editDob;
    @FXML
    private JFXTextField editOcc;
    @FXML
    private JFXComboBox<String> editMaritialStatus;
     @FXML
    private JFXTextField editName;
    @FXML
    private JFXTextField editMincome;
    @FXML
    private JFXComboBox<String> editHouseNo;
    @FXML
    private JFXTextField editEmail;
    @FXML
    private JFXTextField editCell;
    @FXML
    private JFXComboBox<String> editGender;
    @FXML
    private JFXTextField editWorkPlace;
    @FXML
    private JFXComboBox<String> editHealthStatus;
    @FXML
    private JFXComboBox<String> editEduStat;
    @FXML
    private JFXComboBox<String> editBloodgroup;
    @FXML
    private TextField editImagePath;
    @FXML
    private Button photoUploadButton;

    private Villager ent = null;

    VillagerDao vDao = new VillagerDao();
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        editName.setVisible(false);
        editMaritialStatus.setVisible(false);
        editBloodgroup.setVisible(false);
        editCell.setVisible(false);
        editDob.setVisible(false);
        editEduStat.setVisible(false);
        editEmail.setVisible(false);
        editGender.setVisible(false);
        editHealthStatus.setVisible(false);
        editHouseNo.setVisible(false);
        editImagePath.setVisible(false);
        editMaritialStatus.setVisible(false);
        editMincome.setVisible(false);
        editOcc.setVisible(false);
        editWorkPlace.setVisible(false);
        applyButton.setVisible(false);
        cancelButton.setVisible(false);
        photoUploadButton.setVisible(false);

        initGender();
        initHealthStat();
        initMaritialStat();
        initBloodgroup();
        initEduState();
        try {
            initHouseNumber();
        } catch (Exception ex) {
            Logger.getLogger(Vil_prfilrController.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    @FXML
    private void deleteVillager(ActionEvent event) {
    }

    @FXML
    private void enterEditor(ActionEvent event) {

        
        
        
        
        villagerNameLabel.setVisible(false);
        addressLabel.setVisible(false);
        maritialStatusLAbel.setVisible(false);
        bloodgroupLabel.setVisible(false);
        editButton.setVisible(false);
        cellLabel.setVisible(false);
        dobLabel.setVisible(false);
        educationalStatusLabel.setVisible(false);
        emailLabel.setVisible(false);
        genderLabel.setVisible(false);
        healthStatusLabel.setVisible(false);
        houseNoLabel.setVisible(false);
        maritialStatusLAbel.setVisible(false);
        mincomeLabel.setVisible(false);
        occLabel.setVisible(false);
        workPlaceLabel.setVisible(false);

        cancelButton.setVisible(true);
        applyButton.setVisible(true);
        deleteButton.setVisible(false);
        editButton.setVisible(false);

        editName.setVisible(true);
        editMaritialStatus.setVisible(true);
        editBloodgroup.setVisible(true);
        editCell.setVisible(true);
        editDob.setVisible(true);
        editEduStat.setVisible(true);
        editEmail.setVisible(true);
        editGender.setVisible(true);
        editHealthStatus.setVisible(true);
        editHouseNo.setVisible(true);
        editImagePath.setVisible(true);
        editMaritialStatus.setVisible(true);
        editMincome.setVisible(true);
        editOcc.setVisible(true);
        editWorkPlace.setVisible(true);
        photoUploadButton.setVisible(true);

    }

    @FXML
    private void applyChanges(ActionEvent event) {
    }

    @FXML
    private void cancelEdit(ActionEvent event) {

        villagerNameLabel.setVisible(true);
        addressLabel.setVisible(true);
        maritialStatusLAbel.setVisible(true);
        bloodgroupLabel.setVisible(true);
        editButton.setVisible(true);
        cellLabel.setVisible(true);
        dobLabel.setVisible(true);
        educationalStatusLabel.setVisible(true);
        emailLabel.setVisible(true);
        genderLabel.setVisible(true);
        healthStatusLabel.setVisible(true);
        houseNoLabel.setVisible(true);
        maritialStatusLAbel.setVisible(true);
        mincomeLabel.setVisible(true);
        occLabel.setVisible(true);
        workPlaceLabel.setVisible(true);

        deleteButton.setVisible(true);
        editButton.setVisible(true);
        cancelButton.setVisible(false);
        applyButton.setVisible(false);

        editName.setVisible(false);
        editMaritialStatus.setVisible(false);
        editBloodgroup.setVisible(false);
        editCell.setVisible(false);
        editDob.setVisible(false);
        editEduStat.setVisible(false);
        editEmail.setVisible(false);
        editGender.setVisible(false);
        editHealthStatus.setVisible(false);
        editHouseNo.setVisible(false);
        editImagePath.setVisible(false);
        editMaritialStatus.setVisible(false);
        editMincome.setVisible(false);
        editOcc.setVisible(false);
        editWorkPlace.setVisible(false);
        applyButton.setVisible(false);
        cancelButton.setVisible(false);
        photoUploadButton.setVisible(false);

        initGender();
        initHealthStat();
        initMaritialStat();
        initBloodgroup();

    }

    @FXML
    private void openFileExp(ActionEvent event) {
    }

    private void initGender() {

        String[] choice = {"Male", "Female"};
        editGender.getItems().addAll(choice);
        editGender.setValue("Male");

    }

    private void initHealthStat() {
        String[] choice = {"Healthy", "Dieseased", "Dead"};
        editHealthStatus.getItems().addAll(choice);
        editHealthStatus.setValue("Healthy");

    }

    private void initMaritialStat() {
        String[] choice = {"Married", "Unmarried"};
        editMaritialStatus.getItems().addAll(choice);
        editMaritialStatus.setValue("Unmarried");
    }

    private void initBloodgroup() {
        String[] choice = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
        editBloodgroup.getItems().addAll(choice);
        editBloodgroup.setValue("Unmarried");
    }
    
    
    private void initHouseNumber() throws SQLException, ClassNotFoundException {
        ArrayList<String> choice = DataBase.getSingleColumnDataList("", "Number", "Houses");
        editHouseNo.getItems().addAll(choice);
    }


    
    
    
    private void initEduState() {
        String[] choice = {"PSC","JSC","SSC","HSC","University Graduate"};
        editEduStat.getItems().addAll(choice);
        editEduStat.setValue("PSC");
    }
    
    
    void setData(Villager t) throws MalformedURLException {
        ent = t;
        
        villagerNameLabel.setText((String) t.getName());
        addressLabel.setText("");
        maritialStatusLAbel.setText((String) t.getMaritalStat());
        bloodgroupLabel.setText((String) t.getBloodgroup());
        cellLabel.setText((String) t.getCell());
        dobLabel.setText((String) t.getDob());
        educationalStatusLabel.setText((String) t.getEduStat());
        emailLabel.setText((String) t.getEmail());
        genderLabel.setText(t.getGender().toString());
        healthStatusLabel.setText(t.getHealthStat().toString());
        houseNoLabel.setText(t.getHouseNo().toString());
        mincomeLabel.setText((String) t.getMincome());
        occLabel.setText((String) t.getOccupation());
        workPlaceLabel.setText("");
        Path imageFile = Paths.get(t.getImagePath().toString());
        villagerImageView.setImage(new Image(imageFile.toUri().toURL().toExternalForm()));

        editName.setText((String) t.getName());
        editMaritialStatus.setValue((String) t.getMaritalStat());
        editBloodgroup.setValue((String) t.getBloodgroup());
        editCell.setText((String) t.getCell());
        editDob.setValue(Misc.strToDate((String) t.getDob()));
        editEduStat.setValue((String) t.getEduStat());
        editEmail.setText((String) t.getEmail());
        editGender.setValue(t.getGender().toString());
        editHealthStatus.setValue(t.getHealthStat().toString());
        editHouseNo.setValue(t.getHouseNo().toString());
        editImagePath.setText("");
       
        editMincome.setText((String) t.getMincome());
        editOcc.setText((String) t.getOccupation());
        editWorkPlace.setText("");
        
        
        
    }

}
