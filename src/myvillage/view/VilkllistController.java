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
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import myvillage.data.VillagerDao;
import myvillage.model.Villager;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class VilkllistController implements Initializable {

    @FXML
    private TextField serchTextField;
 
    @FXML
    private JFXButton searchButton;
    @FXML
    private JFXButton filterOptionButton;
    @FXML
    private JFXListView<String> villagerListView;
    @FXML
    private JFXButton addNewButton;
   

    private List<Villager> store = null;

    VillagerDao vdao = new VillagerDao();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {

           


            loadAvaliableData();
            villagerListView.setExpanded(true);
            villagerListView.depthProperty().set(10);

            villagerListView.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {
                    try {
                        loadVillProfile();
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }

                private void loadVillProfile() throws IOException, Exception {
                    FXMLLoader loader = new FXMLLoader(
                            getClass().getResource(
                                    "vil_prfilr.fxml"
                            ));
                    Parent root = loader.load();
                    Vil_prfilrController ctrl = loader.getController();
                    ctrl.setData(store.get(villagerListView.getSelectionModel().getSelectedIndex()));
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                }
            });

        } catch (Exception ex) {
            Logger.getLogger(VilkllistController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void searchVillager(ActionEvent event) throws Exception {

    }

    @FXML
    private void filterSettings(ActionEvent event) throws Exception {

        
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "filter.fxml"
                ));
        Parent root = loader.load();
        FilterController ctrl = loader.getController();
        
        
        
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        
        
        
        
        
        
        
        
        
        
    }



    @FXML
    private void toAddNewView(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "addNewVillager.fxml"
                ));
        Parent root = loader.load();
        AddNewVillagerController ctrl = loader.getController();

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    private void loadAvaliableData(String condition) throws Exception {

        List<Villager> avail = vdao.getAll(condition, "Villagers");
        store = avail;
        if (avail == null) {

            System.out.println("null");

            villagerListView.getItems().add("No villagers to show");
            villagerListView.setMouseTransparent(true);
            villagerListView.setFocusTraversable(false);
        } else {
            villagerListView.setMouseTransparent(false);
            villagerListView.setFocusTraversable(true);

            ArrayList<String> list = new ArrayList();

            for (int i = 0; i < avail.size(); i++) {
                System.out.println(avail.get(i).getName().toString());
                list.add(avail.get(i).getName().toString());
            }
            villagerListView.getItems().addAll(list);
        }

    }

    private void loadAvaliableData() throws Exception {
        VillagerDao vdao = new VillagerDao();

        List<Villager> avail = vdao.getAll("", "Villagers");
        store = avail;
        if (avail == null) {

            System.out.println("null");

            villagerListView.getItems().add("No villagers to show");
            villagerListView.setMouseTransparent(true);
            villagerListView.setFocusTraversable(false);
        } else {
            villagerListView.setMouseTransparent(false);
            villagerListView.setFocusTraversable(true);

            ArrayList<String> list = new ArrayList();

            for (int i = 0; i < avail.size(); i++) {
                System.out.println(avail.get(i).getName().toString());
                list.add(avail.get(i).getName().toString());
            }
            villagerListView.getItems().addAll(list);
        }

    }

}
