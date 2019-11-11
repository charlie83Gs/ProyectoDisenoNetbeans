/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.diseno.proyecto1diseno.model.Employee;
import controller.Payload;
import controller.command.DeleteCommand;
import controller.command.GetAllCommand;
import controller.command.UpdateCommand;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kenneth
 */
public class EmpleadoCRUDController implements Initializable {

    @FXML
    private TableView<Employee> table_EmpleadoCRUD;
    @FXML
    private Button btn_ActualizarEmpleadoCRUD;
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
    private TableColumn<Employee, String> column_nombre;
    @FXML
    private TableColumn<Employee, String> column_email;
    @FXML
    private TableColumn<Employee, String> column_telefono;
    @FXML
    private TableColumn<Employee, String> column_id;
    
    private Employee tempEmployee;
    
    @FXML
    private void handler_btn_ActualizarEmpleadoCRUD(ActionEvent event) {
        if(tempEmployee != null){
            Payload payload = new Payload();
            
            tempEmployee.setName(text_nombreEmpleadoCRUD.getText());
            tempEmployee.setEmail(text_emailEmpleadoCRUD.getText());
            tempEmployee.setPhone(text_telefonoEmpleadoCRUD.getText());
            
            payload.addContent("object", tempEmployee);
            try {
                UpdateCommand command = new UpdateCommand(payload);
                command.execute();
            } catch (Exception ex) {
                Logger.getLogger(EmpleadoCRUDController.class.getName()).log(Level.SEVERE, null, ex);
            }
            text_nombreEmpleadoCRUD.clear();
            text_emailEmpleadoCRUD.clear();
            text_telefonoEmpleadoCRUD.clear();
        }
        
        tempEmployee = null;
        table_EmpleadoCRUD.setItems(employees());
    }
    
    @FXML
    private void handler_btn_AtrasEmpleadoCRUD(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/GUI/AdminMain.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Administración");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void handler_btn_EliminarEmpleadoCRUD(ActionEvent event) {
        tempEmployee = table_EmpleadoCRUD.getSelectionModel().getSelectedItem();
        
        Payload payload = new Payload();
        payload.addContent("id", tempEmployee.getId());
        payload.addContent("class", Employee.class);
        
        try {
            DeleteCommand<Employee> delete = new DeleteCommand(payload);
            delete.execute();
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoCRUDController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tempEmployee = null;
        table_EmpleadoCRUD.setItems(employees());
    }
    
    @FXML
    private void handler_btn_VerEmpleadoCRUD(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    @FXML
    private void handler_btn_ModificarEmpleadoCRUD(ActionEvent event) {
        tempEmployee = table_EmpleadoCRUD.getSelectionModel().getSelectedItem();
        
        text_nombreEmpleadoCRUD.setText(tempEmployee.getName());
        text_emailEmpleadoCRUD.setText(tempEmployee.getEmail());
        text_telefonoEmpleadoCRUD.setText(tempEmployee.getPhone());
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        column_nombre.setCellValueFactory(new PropertyValueFactory<>("Name"));
        column_email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        column_telefono.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        column_id.setCellValueFactory(new PropertyValueFactory<>("Id"));
        
        table_EmpleadoCRUD.setItems(employees());
    }    
    
    private ObservableList<Employee> employees() {
        Payload payload = new Payload();
        payload.addContent("class", Employee.class);
        ArrayList<Employee> employees;
        
        try {
            GetAllCommand<Employee> command = new GetAllCommand(payload);
            employees = command.execute();
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoCRUDController.class.getName()).log(Level.SEVERE, null, ex);
            return FXCollections.observableArrayList();
        }
        return FXCollections.observableArrayList(employees);
    }
}
