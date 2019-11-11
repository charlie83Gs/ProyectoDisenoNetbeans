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
 * @author Bryan Hernandez
 */
public class PublicCRUDController implements Initializable {

    @FXML
    private TableView<?> table_AttentionCRUD;
    @FXML
    private TableColumn<?, ?> column_id;
    @FXML
    private TableColumn<?, ?> column_nombre;
    @FXML
    private TableColumn<?, ?> column_nombre1;
    @FXML
    private TableColumn<?, ?> column_nombre2;
    @FXML
    private Button btn_CrearActualizarCategoriaCRUD;
    @FXML
    private Button btn_AtrasCategoriaCRUD;
    @FXML
    private Button btn_EliminarCategoriaCRUD;
    @FXML
    private Button btn_VerCategoriaCRUD;
    @FXML
    private Button btn_ModificarCategoriaCRUD;
    @FXML
    private TextField text_nombreCategoriaCRUD;
    @FXML
    private TextField text_costCategoriaCRUD;
    @FXML
    private TextField text_paymentCategoriaCRUD;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handlebtn_CrearActualizarCategoriaCRUD(ActionEvent event) {
    }

    @FXML
    private void handlebtn_AtrasCategoriaCRUD(ActionEvent event) {
    }

    @FXML
    private void handlebtn_EliminarCategoriaCRUD(ActionEvent event) {
    }

    @FXML
    private void handlebtn_VerCategoriaCRUD(ActionEvent event) {
    }

    @FXML
    private void handlebtn_ModificarCategoriaCRUD(ActionEvent event) {
    }
    
}
