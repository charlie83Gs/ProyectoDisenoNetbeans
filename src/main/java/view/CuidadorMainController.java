/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.diseno.proyecto1diseno.model.Employee;
import com.diseno.proyecto1diseno.model.Role;
import com.diseno.proyecto1diseno.model.Task;
import controller.LocalSession;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kenneth
 */
public class CuidadorMainController implements Initializable {

    @FXML
    private TableView<Task> table_CuidadorMain;
    @FXML
    private TableColumn<Task, String> columTarea;
    @FXML
    private TableColumn<Task, String> columDescripcion;
    @FXML
    private Button btn_AtrasCuidadorMain;

    @FXML
    private void handler_btn_AtrasCuidadorMain(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Employee emp = (Employee)LocalSession.getInstance().getData("employee");
        System.out.println(emp.getName());
        ArrayList<Role> roles = new ArrayList<>(emp.getRoles());
        ArrayList<Task> tasks = new ArrayList<Task>();
        
        for (Role role : roles) {
            if(! role.getTask().isEmpty())
            tasks.addAll( role.getTask());
        }
        
        System.out.println(tasks.size());
        // if there are tasks display them
        if(!tasks.isEmpty()){
            
 
            
            columTarea.setCellValueFactory(new PropertyValueFactory<>("name"));
            columDescripcion.setCellValueFactory(new PropertyValueFactory<>("description"));
            
            
            
            ObservableList<Task> oListTasks = FXCollections.observableArrayList(tasks);

            
            table_CuidadorMain.getItems().setAll(oListTasks);
            
        }else{
            System.out.println("no tasks");
        }
        
        
        
        
        
        
    } 
    
    @FXML
    void onAtrasButton(ActionEvent event) {
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
    
}
