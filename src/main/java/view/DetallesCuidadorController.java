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

/**
 * FXML Controller class
 *
 * @author Kenneth
 */
public class DetallesCuidadorController implements Initializable {

    @FXML
    private Button btn_AtrasDetallesCuidador;
    @FXML
    private Label label_nombreCuidador;
    @FXML
    private Label label_emailCuidador;
    @FXML
    private Label label_categoriaCuidador;
    @FXML
    private Label label_evaluacionCuidador;
    @FXML
    private Label label_cantidadCuidador;
    @FXML
    private Label label_DisponibleCuidador;

    @FXML
    private void handler_btn_AtrasDetallesCuidador(ActionEvent event) {
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
