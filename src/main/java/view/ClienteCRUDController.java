/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Kenneth
 */
public class ClienteCRUDController implements Initializable {

    @FXML
    private TableView<?> table_ClienteCRUD;
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
    private TableColumn<?, ?> column_nombre;
    @FXML
    private TableColumn<?, ?> column_email;
    @FXML
    private TableColumn<?, ?> column_telefono;

    
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
        // TODO
    }    
    
}
