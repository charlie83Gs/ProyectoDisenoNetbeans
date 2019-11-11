/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Bryan Hernandez
 */
public class AttentionCRUDController implements Initializable {

    @FXML
    private TableView<?> table_AttentionCRUD;
    @FXML
    private TableColumn<?, ?> column_id;
    @FXML
    private TableColumn<?, ?> column_nombre;
    @FXML
    private Button btn_CrearActualizarAttentionCRUD;
    @FXML
    private Button btn_AtrasAttentionCRUD;
    @FXML
    private Button btn_EliminarAttentionCRUD;
    @FXML
    private Button btn_VerAttentionCRUD;
    @FXML
    private Button btn_ModificarAttentionCRUD;
    @FXML
    private TextField text_nombreAttentionCRUD;

    /**
     * Initializes the controller class.
     */
    public void handlebtn_CrearActualizarAttentionCRUD(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    public void handlebtn_AtrasAttentionCRUD(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    public void handlebtn_EliminarAttentionCRUD(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    public void handlebtn_VerAttentionCRUD(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    public void handlebtn_ModificarAttentionCRUD(URL url, ResourceBundle rb) {
        // TODO
    } 

    
}
