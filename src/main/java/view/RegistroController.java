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
public class RegistroController implements Initializable {

    @FXML
    private TextField text_nombreRegistro;
    @FXML
    private TextField text_CorreoRegistro;
    @FXML
    private TextField text_TelefonoRegistro;
    @FXML
    private TextField text_EdadRegistro;
    @FXML
    private PasswordField text_PasswordRegistro;
    @FXML
    private TextArea text_tratadoRegistro;
    @FXML
    private TextArea text_carcelRegistro;
    @FXML
    private TextArea text_pagarRegistro;
    @FXML
    private TextArea text_solosola;
    @FXML
    private Button btn_RegistratseRegistro;
    @FXML
    private Button btn_AtrasRegistro;

    @FXML
    private void handler_btn_RegistratseRegistro(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    @FXML
    private void handler_btn_AtrasRegistro(ActionEvent event) {
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
