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
public class RegistroController implements Initializable {

    @FXML
    private TextField text_nombreRegistro;
    @FXML
    private TextField text_CorreoRegistro;
    @FXML
    private TextField text_TelefonoRegistro;
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
    private void handler_btn_RegistratseRegistro(ActionEvent event) throws Exception {
        System.out.println("You clicked me!");
        Client cliente;
        System.out.println(text_tratadoRegistro.getText());
        System.out.println(text_carcelRegistro.getText());
        System.out.println(text_pagarRegistro.getText());
        System.out.println(text_solosola.getText());
        if(     ((text_tratadoRegistro.getText() == "" || text_carcelRegistro.getText() == "") || text_pagarRegistro.getText() == "") ||
                text_solosola.getText() == "") {
                cliente = new Client(
                text_nombreRegistro.getText(),
                text_TelefonoRegistro.getText(),
                text_CorreoRegistro.getText(),
                text_PasswordRegistro.getText()
                );
                Payload pAddCliente = new Payload();
                pAddCliente.addContent("object", cliente);
                AddCommand<AttentionCenter> addCliente = new AddCommand<>(pAddCliente);
                addCliente.execute();
                
                System.out.println("Cliente agregado");
            
        } 
                
        
    }
    @FXML
    private void handler_btn_AtrasRegistro(ActionEvent event) {
        System.out.println("You clicked me!");
        
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/GUI/LoginScreen.fxml"));
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
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
