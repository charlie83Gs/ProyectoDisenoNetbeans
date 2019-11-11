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
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Kenneth
 */
public class DetallesEmpleadoController implements Initializable {

    @FXML
    private Button btn_AtrasDetallesEmpleado;
    @FXML
    private TableView<?> table_DetallesDetallesEmpleado;
    @FXML
    private Label label_nombreDetallesEmpleado;
    @FXML
    private Label label_emailDetallesEmpleado;
    @FXML
    private Label label_categoriaDetallesEmpleado;
    @FXML
    private Label label_evaluacionDetallesEmpleado;

    @FXML
    private void handler_btn_AtrasDetallesEmpleado(ActionEvent event) {
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
