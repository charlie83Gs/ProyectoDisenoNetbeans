/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.diseno.proyecto1diseno.model.AttentionCenter;
import com.diseno.proyecto1diseno.model.Client;
import controller.Payload;
import controller.command.AddCommand;
import controller.command.DeleteCommand;
import controller.command.GetAllCommand;
import controller.command.UpdateCommand;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Bryan Hernandez
 */
public class AttentionCRUDController implements Initializable {

    @FXML
    private TableView<AttentionCenter> table_AttentionCRUD;
    @FXML
    private TableColumn<AttentionCenter, String> column_id;
    @FXML
    private TableColumn<AttentionCenter, String> column_nombre;
    @FXML
    private Button btn_CrearActualizarAttentionCRUD;
    @FXML
    private Button btn_AtrasAttentionCRUD;
    @FXML
    private Button btn_EliminarAttentionCRUD;
    @FXML
    private Button btn_VerAttentionCRUD;
    @FXML
    private Button btn_ModificarAttentionCRUD;
    @FXML
    private TextField text_nombreAttentionCRUD;

    AttentionCenter tempCenter;
    
    /**
     * Initializes the controller class.
     */
    @FXML
    public void handlebtn_CrearActualizarAttentionCRUD(ActionEvent event) {
        if(tempCenter != null){
            Payload payload = new Payload();
            
            tempCenter.setName(text_nombreAttentionCRUD.getText());
            
            payload.addContent("object", tempCenter);
            try {
                UpdateCommand command = new UpdateCommand(payload);
                command.execute();
            } catch (Exception ex) {
                Logger.getLogger(AttentionCRUDController.class.getName()).log(Level.SEVERE, null, ex);
            }
            text_nombreAttentionCRUD.clear();
        } else {
            tempCenter = new AttentionCenter(text_nombreAttentionCRUD.getText());
            
            Payload payload = new Payload();
            
            tempCenter.setName(text_nombreAttentionCRUD.getText());
            
            payload.addContent("object", tempCenter);
            try {
                AddCommand command = new AddCommand(payload);
                command.execute();
            } catch (Exception ex) {
                Logger.getLogger(AttentionCRUDController.class.getName()).log(Level.SEVERE, null, ex);
            }
            text_nombreAttentionCRUD.clear();
        }
        
        tempCenter = null;
        table_AttentionCRUD.setItems(centers());
    }  
    
    @FXML
    public void handlebtn_AtrasAttentionCRUD(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/GUI/AdminMain.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Administración");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void handlebtn_EliminarAttentionCRUD(ActionEvent event) {
        tempCenter = table_AttentionCRUD.getSelectionModel().getSelectedItem();
        if(tempCenter == null)
            return;
        Payload payload = new Payload();
        payload.addContent("id", tempCenter.getId());
        payload.addContent("class", AttentionCenter.class);
        
        try {
            DeleteCommand<AttentionCenter> delete = new DeleteCommand(payload);
            delete.execute();
        } catch (Exception ex) {
            Logger.getLogger(AttentionCRUDController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tempCenter = null;
        table_AttentionCRUD.setItems(centers());
    } 
    
    @FXML
    public void handlebtn_VerAttentionCRUD(ActionEvent event) {
        // TODO
    } 
    
    @FXML
    public void handlebtn_ModificarAttentionCRUD(ActionEvent event) {
        tempCenter = table_AttentionCRUD.getSelectionModel().getSelectedItem();
        if(tempCenter != null)
            text_nombreAttentionCRUD.setText(tempCenter.getName());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        column_nombre.setCellValueFactory(new PropertyValueFactory<>("Name"));
        
        table_AttentionCRUD.setItems(centers());
    }

    private ObservableList<AttentionCenter> centers() {
        Payload payload = new Payload();
        payload.addContent("class", AttentionCenter.class);
        ArrayList<AttentionCenter> centers;
        
        try {
            GetAllCommand<AttentionCenter> command = new GetAllCommand(payload);
            centers = command.execute();
        } catch (Exception ex) {
            Logger.getLogger(AttentionCRUDController.class.getName()).log(Level.SEVERE, null, ex);
            return FXCollections.observableArrayList();
        }
        return FXCollections.observableArrayList(centers);
    }
}
