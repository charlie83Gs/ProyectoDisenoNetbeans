/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.diseno.proyecto1diseno.model.AttentionCenter;
import com.diseno.proyecto1diseno.model.Client;
import com.diseno.proyecto1diseno.model.Employee;
import com.diseno.proyecto1diseno.model.Service;
import com.diseno.proyecto1diseno.model.ServiceContract;
import controller.Payload;
import controller.command.GetAllCommand;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kenneth
 */
public class AdminMainController implements Initializable {

    @FXML
    private TableView<ServiceContract> table_ReportesAdmin;
    @FXML
    private TableColumn<?, ?> table_CuidadorAdmin;
    @FXML
    private ChoiceBox<?> combo_TipoServicio;
    @FXML
    private ChoiceBox<?> combo_Cuidador;
    @FXML
    private ChoiceBox<?> combo_Cliente;
    @FXML
    private ChoiceBox<?> combo_CentrosReportes;
    @FXML
    private DatePicker combo_fecha1;
    @FXML
    private DatePicker combo_fecha2;
    @FXML
    private ChoiceBox<?> combo_CentrosCuidador;
    @FXML
    private Button btn_VerClientesAdmin;
    @FXML
    private Button btn_VerEmpleadosAdmin;
    @FXML
    private Button btn_AtrasAdmin;
    @FXML
    private TableColumn<ServiceContract, Service> column_tipoServicio;
    @FXML
    private TableColumn<ServiceContract, Employee> column_cuidador;
    @FXML
    private TableColumn<ServiceContract, Client> column_cliente;
    @FXML
    private TableColumn<ServiceContract, Date> column_fecha;
    @FXML
    private TableColumn<ServiceContract, AttentionCenter> column_centro;
    @FXML
    private TableColumn<ServiceContract, Float> column_monto;

    
    @FXML
    private void handler_btn_VerClientesAdmin(ActionEvent event) {
        System.out.println("You clicked me!");
        
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/GUI/ClienteCRUD.fxml"));
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
    private void verEmpleadosAdminBtnPressed(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    private void atrasAdminBtnPressed(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<ServiceContract> services = null;
        try {
            // TODO
            Payload payload = new Payload();
            payload.addContent("class", ServiceContract.class);
            GetAllCommand<ServiceContract> get = new GetAllCommand(payload);
            
            services= get.execute();
            System.out.println(services.size());
            System.out.println("Datos cargados.");
        } catch (Exception ex) {
            Logger.getLogger(AdminMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        column_tipoServicio.setCellValueFactory(new PropertyValueFactory<>("service"));
        column_cuidador.setCellValueFactory(new PropertyValueFactory<>("employee"));
        column_cliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        column_fecha.setCellValueFactory(new PropertyValueFactory<>("dateStart"));
        column_centro.setCellValueFactory(new PropertyValueFactory<>("attentionCenter"));
        column_monto.setCellValueFactory(new PropertyValueFactory<>("cost"));
        
        ObservableList<ServiceContract> observable = FXCollections.observableArrayList(services);
        
        table_ReportesAdmin.getItems().setAll(observable);
        //table_ReportesAdmin.set

    }    
    
}
