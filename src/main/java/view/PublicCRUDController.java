/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.diseno.proyecto1diseno.model.Public;
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
public class PublicCRUDController implements Initializable {

    @FXML
    private TableView<Public> table_PublicCRUD;
    @FXML
    private TableColumn<Public, String> column_id;
    @FXML
    private TableColumn<Public, String> column_nombre;
    @FXML
    private TableColumn<Public, String> column_costo;
    @FXML
    private TableColumn<Public, String> column_pago;
    @FXML
    private Button btn_CrearActualizarCategoriaCRUD;
    @FXML
    private Button btn_AtrasCategoriaCRUD;
    @FXML
    private Button btn_EliminarCategoriaCRUD;
    @FXML
    private Button btn_VerCategoriaCRUD;
    @FXML
    private Button btn_ModificarCategoriaCRUD;
    @FXML
    private TextField text_nombreCategoriaCRUD;
    @FXML
    private TextField text_costoCategoriaCRUD;
    @FXML
    private TextField text_pagoCategoriaCRUD;

    private Public tempPublic;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        column_id.setCellValueFactory(new PropertyValueFactory<>("ID"));
        column_nombre.setCellValueFactory(new PropertyValueFactory<>("Name"));
        column_costo.setCellValueFactory(new PropertyValueFactory<>("Cost"));
        column_pago.setCellValueFactory(new PropertyValueFactory<>("Payment"));
        
        
        table_PublicCRUD.setItems(publics());
    }    

    @FXML
    private void handlebtn_CrearActualizarCategoriaCRUD(ActionEvent event) {
        if(tempPublic != null){
            Payload payload = new Payload();
            
            try {
                tempPublic.setName(text_nombreCategoriaCRUD.getText());
                tempPublic.setCost((float) Double.parseDouble(text_costoCategoriaCRUD.getText()));
                tempPublic.setPayment((float) Double.parseDouble(text_pagoCategoriaCRUD.getText()));
                
                payload.addContent("object", tempPublic);
                
                UpdateCommand command = new UpdateCommand(payload);
                command.execute();
            } catch (Exception ex) {
                Logger.getLogger(PublicCRUDController.class.getName()).log(Level.SEVERE, null, ex);
            }
            text_nombreCategoriaCRUD.clear();
            text_costoCategoriaCRUD.clear();
            text_pagoCategoriaCRUD.clear();
        } else {
            tempPublic = new Public(text_nombreCategoriaCRUD.getText());
            
            Payload payload = new Payload();

            try {
                tempPublic.setName(text_nombreCategoriaCRUD.getText());
                tempPublic.setCost((float) Double.parseDouble(text_costoCategoriaCRUD.getText()));
                tempPublic.setPayment((float) Double.parseDouble(text_pagoCategoriaCRUD.getText()));
                
                payload.addContent("object", tempPublic);
                
                AddCommand command = new AddCommand(payload);
                command.execute();
            } catch (Exception ex) {
                Logger.getLogger(PublicCRUDController.class.getName()).log(Level.SEVERE, null, ex);
            }
            text_nombreCategoriaCRUD.clear();
            text_costoCategoriaCRUD.clear();
            text_pagoCategoriaCRUD.clear();
        }
        
        tempPublic = null;
        table_PublicCRUD.setItems(publics());
    }

    @FXML
    private void handlebtn_AtrasCategoriaCRUD(ActionEvent event) {
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
    private void handlebtn_EliminarCategoriaCRUD(ActionEvent event) {
        tempPublic = table_PublicCRUD.getSelectionModel().getSelectedItem();
        if(tempPublic == null)
            return;
        Payload payload = new Payload();
        payload.addContent("id", tempPublic.getId());
        payload.addContent("class", Public.class);
        
        try {
            DeleteCommand<Public> delete = new DeleteCommand(payload);
            delete.execute();
        } catch (Exception ex) {
            Logger.getLogger(PublicCRUDController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tempPublic = null;
        table_PublicCRUD.setItems(publics());
    }

    @FXML
    private void handlebtn_VerCategoriaCRUD(ActionEvent event) {
    }

    @FXML
    private void handlebtn_ModificarCategoriaCRUD(ActionEvent event) {
        tempPublic = table_PublicCRUD.getSelectionModel().getSelectedItem();
        if(tempPublic != null){
            text_nombreCategoriaCRUD.setText(tempPublic.getName());
            text_costoCategoriaCRUD.setText(String.valueOf(tempPublic.getCost()));
            text_pagoCategoriaCRUD.setText(String.valueOf(tempPublic.getPayment()));
        }
        
    }
    
    private ObservableList<Public> publics() {
        Payload payload = new Payload();
        payload.addContent("class", Public.class);
        ArrayList<Public> publics;
        
        try {
            GetAllCommand<Public> command = new GetAllCommand(payload);
            publics = command.execute();
        } catch (Exception ex) {
            Logger.getLogger(PublicCRUDController.class.getName()).log(Level.SEVERE, null, ex);
            return FXCollections.observableArrayList();
        }
        return FXCollections.observableArrayList(publics);
    }
    
}
