/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    
    @FXML
    void onAtrasButton(ActionEvent event) {
        System.out.println("You clicked me!");
        
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/GUI/ClienteMain.fxml"));
            Stage stage = new Stage();
            stage.setTitle("My New Stage Title");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
