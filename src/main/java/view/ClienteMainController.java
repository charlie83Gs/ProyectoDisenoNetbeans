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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;

/**
 * FXML Controller class
 *
 * @author Kenneth
 */
public class ClienteMainController implements Initializable {

    @FXML
    private TableColumn<?, ?> table_CuidadorCliente;
    @FXML
    private Button btn_AtrasCliente;
    @FXML
    private ComboBox<?> combo_CategoriaCliente;

    @FXML
    private void handler_btn_AtrasCliente(ActionEvent event) {
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
