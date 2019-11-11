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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Kenneth
 */
public class EmpleadoCRUDController implements Initializable {

    @FXML
    private TableView<?> table_EmpleadoCRUD;
    @FXML
    private Button btn_CrearActualizarEmpleadoCRUD;
    @FXML
    private Button btn_AtrasEmpleadoCRUD;
    @FXML
    private Button btn_EliminarEmpleadoCRUD;
    @FXML
    private Button btn_VerEmpleadoCRUD;
    @FXML
    private Button btn_ModificarEmpleadoCRUD;
    @FXML
    private TextField text_nombreEmpleadoCRUD;
    @FXML
    private TextField text_emailEmpleadoCRUD;
    @FXML
    private TextField text_telefonoEmpleadoCRUD;
    @FXML
    private TextField text_edadEmpleadoCRUD;

    @FXML
    private void handler_btn_CrearActualizarEmpleadoCRUD(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    @FXML
    private void handler_btn_AtrasEmpleadoCRUD(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    @FXML
    private void handler_btn_EliminarEmpleadoCRUD(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    @FXML
    private void handler_btn_VerEmpleadoCRUD(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    @FXML
    private void handler_btn_ModificarEmpleadoCRUD(ActionEvent event) {
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
