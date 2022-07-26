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
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import myvillage.Utility.DataBase;
import myvillage.Utility.Misc;
import myvillage.data.VillagerDao;
import myvillage.model.Villager;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AddNewVillagerController extends DashController implements Initializable {

    @FXML
    private ImageView villagerImageView;
    @FXML
    private JFXButton addNewButton;
    @FXML
    private JFXButton cancelButton;
    @FXML
    private JFXDatePicker editDob;
    @FXML
    private JFXTextField editOcc;
    @FXML
    private JFXComboBox<String> editMaritialStatus;
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
    @FXML
    private JFXTextField editVillagerName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initGender();
        initHealthStat();
        initMaritialStat();
        initBloodgroup();
        initEduState();
        try {
            initHouseNumber();
        } catch (Exception ex) {
            Logger.getLogger(AddNewVillagerController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void addNewvVillager(ActionEvent event) throws IOException, Exception {

        File source = new File(editImagePath.getText());
        File dest = new File("src/myvillage/images/" + editEmail.getText().split("@")[0] + "." + Misc.getFileExt(editImagePath.getText()));

        Files.copy(source.toPath(), dest.toPath());
        
        
        Villager newVillager = new Villager(
                editVillagerName.getText(),
                "src/myvillage/images/" + editEmail.getText().split("@")[0] + "." + Misc.getFileExt(editImagePath.getText()),
                editDob.getValue(),
                Integer.parseInt(editMincome.getText()),
                editOcc.getText(),
                editEduStat.getValue(),
                editGender.getValue(),
                editBloodgroup.getValue(),
                editEmail.getText(),
                editCell.getText(),
                editMaritialStatus.getValue(),
                editHealthStatus.getValue(),
                editHouseNo.getValue()
        
        );

        VillagerDao vdao = new VillagerDao();
        vdao.save(newVillager);
        
        
        int result = Integer.parseInt(Misc.readFileAsString("src/set/population.txt"));
        result++;
        tempLabel.setText(String.valueOf(result));
        Misc.dataIn("peep+1", "src/set/population.txt", String.valueOf(result));
        tempLabel.setText(String.valueOf(result));

        

    }

    @FXML
    private void cancelCreation(ActionEvent event) {
        Misc.closeWindowOnButton(cancelButton);
    }

    @FXML
    private void openFileExp(ActionEvent event) throws MalformedURLException, IOException {
        FileChooser file = new FileChooser();
        file.setTitle("Open File");
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        File selectedFile = file.showOpenDialog(stage);

        editImagePath.setText(selectedFile.getAbsolutePath());

        Path imageFile = Paths.get(editImagePath.getText());
        villagerImageView.setImage(new Image(imageFile.toUri().toURL().toExternalForm()));

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
    
    
    private void initEduState() {
        String[] choice = {"PSC","JSC","SSC","HSC","University Graduate"};
        editEduStat.getItems().addAll(choice);
        editEduStat.setValue("PSC");
    }
    
    
    
    private void initHouseNumber() throws SQLException, ClassNotFoundException {
        ArrayList<String> choice = DataBase.getSingleColumnDataList("", "Number", "Houses");
        editHouseNo.getItems().addAll(choice);
    }

    
    
    
}
