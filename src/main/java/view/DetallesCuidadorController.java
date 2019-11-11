/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.diseno.proyecto1diseno.model.Calification;
import com.diseno.proyecto1diseno.model.Employee;
import com.diseno.proyecto1diseno.model.Service;
import com.diseno.proyecto1diseno.model.Study;
import controller.LocalSession;
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
import javafx.scene.control.Label;
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
public class DetallesCuidadorController implements Initializable {

    @FXML
    private Button btn_AtrasDetallesCuidador;
    @FXML
    private Button buttonSolicitar;
    @FXML
    private Label label_nombreCuidador;
    @FXML
    private Label label_emailCuidador;
    @FXML
    private Label label_categoriaCuidador;
    @FXML
    private Label label_evaluacionCuidador;
    
    @FXML private ComboBox<Service> comboService;
    
    @FXML TableColumn<Calification,String> columEvaluacion;
    @FXML TableColumn<Calification,String> columComentario;
    
    @FXML TableView<Calification> tableEvaluacion;
    
    @FXML
    private void handler_btn_AtrasDetallesCuidador(ActionEvent event) {
        
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        buttonSolicitar.setDisable(true);
        System.out.println("You clicked me!");
        LocalSession current_session = LocalSession.getInstance(); 
        if(current_session.contains("employee")){
            try {
                Employee emp = (Employee)current_session.getData("employee");
                
                label_nombreCuidador.setText(emp.getName());
                label_emailCuidador.setText(emp.getEmail());
                label_categoriaCuidador.setText(emp.getStudies().toString());
                int prom = 0;
                for (Calification calf : emp.getCalifications()) {
                    prom += calf.getValue();
                }
                
                if(prom > 0) prom = prom / emp.getCalifications().size();
                label_evaluacionCuidador.setText(String.valueOf(prom));
                
                columComentario.setCellValueFactory(new PropertyValueFactory<>("comment"));
                columEvaluacion.setCellValueFactory(new PropertyValueFactory<>("value"));
                
                
                tableEvaluacion.getItems().addAll(emp.getCalifications());
                
                //update combo box
                Payload servicePayload = new Payload();
                servicePayload.addContent("class", Service.class);
                GetAllCommand<Service> getcommad = new GetAllCommand(servicePayload);
                ArrayList<Service> service = new ArrayList<>(getcommad.execute());
                
                comboService.getItems().addAll(service);
                comboService.setConverter(new StringConverter<Service>() {
                    @Override
                    public String toString(Service std) {
                        return std == null ? "" : std.getName();
                    }
                    
                    @Override
                    public Service fromString(String s) {
                        Service serv = new Service(s, null, null);
                        return serv;
                    }
                });
                
                
                
            } catch (Exception ex) {
                Logger.getLogger(DetallesCuidadorController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }else{
            label_nombreCuidador.setText("Could not load employee");
        }
        
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
    
    
    @FXML
    public void onServiceHandle(ActionEvent event){
        System.out.println("Service combo box !! ---------------------------------------");
        try {
            System.out.println("Service -- : " + comboService.getValue().getName());
            Service serv = comboService.getValue();
            
            LocalSession.getInstance().addData("service", serv);
            buttonSolicitar.setDisable(false);
            
            
        } catch (Exception ex) {
            Logger.getLogger(ClienteMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @FXML
    void onSolicitarButton(ActionEvent event) {
        System.out.println("You clicked me!");
        
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/GUI/Pago.fxml"));
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
