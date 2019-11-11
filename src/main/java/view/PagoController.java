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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Kenneth
 */
public class PagoController implements Initializable {

    @FXML
    private TextField text_numeroTarjetaPago;
    @FXML
    private TextField text_nombrePersonaPago;
    @FXML
    private TextField text_Direccion1Pago;
    @FXML
    private TextField text_Direccion2Pago;
    @FXML
    private PasswordField text_CiudadPago;
    @FXML
    private TextArea text_EmailPago;
    @FXML
    private TextArea text_telefonoPago;
    @FXML
    private TextArea text_EstadoPago;
    @FXML
    private TextArea text_CodigoPostal;
    @FXML
    private Button btn_PagoPago;
    @FXML
    private Button btn_AtrasPago;
    @FXML
    private TextField text_MMYY;
    @FXML
    private TextField text_CVC;
    @FXML
    private TextField text_PaisPago;

    @FXML
    private void handler_btn_PagoPago(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    @FXML
    private void handler_btn_AtrasPago(ActionEvent event) {
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
