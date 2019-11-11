/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.diseno.proyecto1diseno.model.Client;
import com.diseno.proyecto1diseno.model.ServiceContract;
import controller.Payload;
import controller.command.GetAllCommand;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Kenneth
 */
public class ClienteCRUDController implements Initializable {

    @FXML
    private TableView<Client> table_ClienteCRUD;
    @FXML
    private Button btn_CrearActualizarClienteCRUD;
    @FXML
    private Button btn_AtrasClienteCRUD;
    @FXML
    private Button btn_EliminarCliente;
    @FXML
    private Button btn_VerCliente;
    @FXML
    private Button btn_ModificarCliente;
    @FXML
    private TextField text_nombreClienteCRUD;
    @FXML
    private TextField text_emailClienteCRUD;
    @FXML
    private TextField text_telefonoClienteCRUD;
    @FXML
    private TextField text_edadClienteCRUD;
    @FXML
    private TableColumn<Client, String> column_nombre;
    @FXML
    private TableColumn<Client, String> column_email;
    @FXML
    private TableColumn<Client, String> column_telefono;

    
    private void handler_btn_CrearActualizarClienteCRUD(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    private void handler_btn_EliminarCliente(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    private void handler_btn_AtrasClienteCRUD(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    private void handler_btn_VerCliente(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    private void handler_btn_ModificarCliente(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        column_nombre.setCellValueFactory(new PropertyValueFactory<>("Name"));
        column_email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        column_telefono.setCellValueFactory(new PropertyValueFactory<>("StudentId"));
        
        table_ClienteCRUD.setItems(clients());
    }    
    
    private ObservableList<Client> clients() {
        Payload payload = new Payload();
        payload.addContent("class", Client.class);
        ArrayList<Client> clients;
        
        try {
            GetAllCommand<Client> getClients = new GetAllCommand(payload);
            clients = getClients.execute();
        } catch (Exception ex) {
            Logger.getLogger(ClienteCRUDController.class.getName()).log(Level.SEVERE, null, ex);
            return FXCollections.observableArrayList();
        }
        return FXCollections.observableArrayList(clients);
    } 
            
}
