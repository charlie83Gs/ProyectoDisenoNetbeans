/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.diseno.proyecto1diseno.model.Client;
import com.diseno.proyecto1diseno.model.Employee;
import com.diseno.proyecto1diseno.model.Study;
import com.diseno.proyecto1diseno.model.Task;
import controller.Payload;
import controller.command.GetAllCommand;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author Kenneth
 */
public class ClienteMainController implements Initializable {

    @FXML
    private TableView<Employee> tableCuidador;
    @FXML
    private TableColumn<Employee, String> columEvaluacion;
    @FXML
    private TableColumn<Employee, String> columNombre;
    @FXML
    private TableColumn<Employee, String> columCategoria;
    
    @FXML
    private Button btn_AtrasCliente;
    @FXML
    private ComboBox<Study> combo_CategoriaCliente;

    @FXML
    private void handler_btn_AtrasCliente(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            columNombre.setCellValueFactory(new PropertyValueFactory<>("name"));
            columCategoria.setCellValueFactory(new PropertyValueFactory<>("studies"));
            
            Payload payload = new Payload();
            payload.addContent("class", Employee.class);
            GetAllCommand<Employee> getEmployes = new GetAllCommand<>(payload);
            ArrayList<Employee> list = getEmployes.execute();
            
            ObservableList<Employee> oListEmployee = FXCollections.observableArrayList(list);
            
            setEmployees(oListEmployee);
            //tableCuidador.getItems().addAll(oListEmployee);
            
            
            //load categories
            Payload studyPayload = new Payload();
            studyPayload.addContent("class", Study.class);
            GetAllCommand<Study> getCategories = new GetAllCommand<>(studyPayload);
            ArrayList<Study> studys = new ArrayList<>(getCategories.execute());
            
            ObservableList<Study> oListStudy = FXCollections.observableArrayList(studys);
            System.out.println("cat: " + studys.size());
            
            //load categories to combobox
            combo_CategoriaCliente.getItems().addAll(oListStudy);
            combo_CategoriaCliente.setConverter(new StringConverter<Study>() {
            @Override
            public String toString(Study std) {
                return std == null ? "" : std.getStudy();
            }

            @Override
            public Study fromString(String s) {
                Study usr = new Study(s, 0,0);
                return usr;
            }
            });
            

            
        } catch (Exception ex) {
            Logger.getLogger(ClienteMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }  
    private void setEmployees(ObservableList<Employee> oListEmployee){
        
        tableCuidador.getItems().setAll(oListEmployee);
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
    
    public void onCategoryHandle(ActionEvent event){
        try {
            System.out.println("Category: " + combo_CategoriaCliente.getValue().getStudy());
            Study std = combo_CategoriaCliente.getValue();
            
            Payload payload = new Payload();
            payload.addContent("class", Employee.class);
            GetAllCommand<Employee> getEmployes = new GetAllCommand<>(payload);
            ArrayList<Employee> list = getEmployes.execute();
            
            ArrayList<Employee> filtered = new ArrayList<>();
            
            for (Employee employee : list) {
                ArrayList<Study> studys = new ArrayList<>(employee.getStudies());
                boolean isValid = false;
                for (Study study : studys) {
                    if(study.getId() == std.getId()){
                        isValid = true;
                        break;
                    }
                }
                
                if(isValid){
                    filtered.add(employee);
                }
                
            }
            ObservableList<Employee> oListEmployee = FXCollections.observableArrayList(filtered);

            setEmployees(oListEmployee);
            
        } catch (Exception ex) {
            Logger.getLogger(ClienteMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
