/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.diseno.proyecto1diseno.model.AttentionCenter;
import com.diseno.proyecto1diseno.model.Client;
import com.diseno.proyecto1diseno.model.Employee;
import com.diseno.proyecto1diseno.model.Public;
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
import javafx.util.StringConverter;

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
    private ChoiceBox<Public> combo_TipoServicio;
    @FXML
    private ChoiceBox<Employee> combo_Cuidador;
    @FXML
    private ChoiceBox<Client> combo_Cliente;
    @FXML
    private ChoiceBox<AttentionCenter> combo_CentrosReportes;
    @FXML
    private DatePicker combo_fecha1;
    @FXML
    private DatePicker combo_fecha2;

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
    private Button btn_Categorias;
    @FXML
    private Button btn_verCentros;

    
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
    private void verCategoriasBtnPressed(ActionEvent event) {
        System.out.println("You clicked me!");
        
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/GUI/PublicCRUD.fxml"));
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
        
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/GUI/EmpleadoCRUD.fxml"));
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
    private void atrasAdminBtnPressed(ActionEvent event) {
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
    
    @FXML
    private void handle_btn_verCentros(ActionEvent event) {
                System.out.println("You clicked me!");
        
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/GUI/AttentionCRUD.fxml"));
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
        
        
        try {
            
            Payload catPayload = new Payload();
            catPayload.addContent("class",Public.class);
            GetAllCommand<Public> getPublic = new GetAllCommand<>(catPayload);
            ArrayList<Public> categories = new ArrayList<>(getPublic.execute());
            
            combo_TipoServicio.getItems().addAll(categories);
            combo_TipoServicio.setConverter(new StringConverter<Public>() {
            @Override
            public String toString(Public std) {
                return std == null ? "" : std.getName();
            }

            @Override
            public Public fromString(String s) {
                Public usr = new Public(s, 0,0);
                return usr;
            }
            });
            
            
            Payload empPayload = new Payload();
            empPayload.addContent("class",Employee.class);
            GetAllCommand<Employee> getEmp = new GetAllCommand<>(empPayload);
            ArrayList<Employee> employees = new ArrayList<>(getEmp.execute());
            
            combo_Cuidador.getItems().addAll(employees);
            combo_Cuidador.setConverter(new StringConverter<Employee>() {
            @Override
            public String toString(Employee std) {
                return std == null ? "" : std.getName();
            }

            @Override
            public Employee fromString(String s) {
                Employee usr = new Employee(s,"","","");

                return usr;
            }
            });
            
            
            Payload cliPayload = new Payload();
            cliPayload.addContent("class",Client.class);
            GetAllCommand<Client> getCli = new GetAllCommand<>(cliPayload);
            ArrayList<Client> clients = new ArrayList<>(getCli.execute());
            
            
            combo_Cliente.getItems().addAll(clients);
            combo_Cliente.setConverter(new StringConverter<Client>() {
            @Override
            public String toString(Client std) {
                return std == null ? "" : std.getName();
            }

            @Override
            public Client fromString(String s) {
                Client usr = new Client(s,"","","");

                return usr;
            }
            });
            
            
            Payload attPayload = new Payload();
            attPayload.addContent("class",AttentionCenter.class);
            GetAllCommand<AttentionCenter> getAtt = new GetAllCommand<>(attPayload);
            ArrayList<AttentionCenter> centers = new ArrayList<>(getAtt.execute());
            
            
            combo_CentrosReportes.getItems().addAll(centers);
            combo_CentrosReportes.setConverter(new StringConverter<AttentionCenter>() {
            @Override
            public String toString(AttentionCenter std) {
                return std == null ? "" : std.getName();
            }

            @Override
            public AttentionCenter fromString(String s) {
                AttentionCenter usr = new AttentionCenter(s);

                return usr;
            }
            });
            
            
        } catch (Exception ex) {
            Logger.getLogger(AdminMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
         
    }    
    
    @FXML
    public void filterByPublic(ActionEvent event){
        try {
            Public category = combo_TipoServicio.getValue();
            
            Payload payload = new Payload();
            payload.addContent("class", ServiceContract.class);
            GetAllCommand<ServiceContract> get = new GetAllCommand(payload);
            ArrayList<ServiceContract> services = new ArrayList(get.execute());
            ArrayList<ServiceContract> filtered = new ArrayList<>();
            
            for (ServiceContract service : services) {
                if(service.getService().getTargetPublic() != null && service.getService().getTargetPublic().getId() == category.getId())
                    filtered.add(service);
            }
            
            table_ReportesAdmin.getItems().setAll(filtered);
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(AdminMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @FXML
    public void filterByEmployee(ActionEvent event){
        try {
            Employee emp = combo_Cuidador.getValue();
            
            Payload payload = new Payload();
            payload.addContent("class", ServiceContract.class);
            GetAllCommand<ServiceContract> get = new GetAllCommand(payload);
            ArrayList<ServiceContract> services = new ArrayList(get.execute());
            ArrayList<ServiceContract> filtered = new ArrayList<>();
            
            for (ServiceContract service : services) {
                if(service.getEmployee() != null && service.getEmployee().getId() == emp.getId())
                    filtered.add(service);
            }
            
            table_ReportesAdmin.getItems().setAll(filtered);
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(AdminMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void filterByClient(ActionEvent event){
        try {
            Client clt = combo_Cliente.getValue();
            
            Payload payload = new Payload();
            payload.addContent("class", ServiceContract.class);
            GetAllCommand<ServiceContract> get = new GetAllCommand(payload);
            ArrayList<ServiceContract> services = new ArrayList(get.execute());
            ArrayList<ServiceContract> filtered = new ArrayList<>();
            
            for (ServiceContract service : services) {
                if(service.getCliente() != null && service.getCliente().getId() == clt.getId())
                    filtered.add(service);
            }
            
            table_ReportesAdmin.getItems().setAll(filtered);
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(AdminMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @FXML
    public void filterByAttentionCenter(ActionEvent event){
        try {
            AttentionCenter center = combo_CentrosReportes.getValue();
            
            Payload payload = new Payload();
            payload.addContent("class", ServiceContract.class);
            GetAllCommand<ServiceContract> get = new GetAllCommand(payload);
            ArrayList<ServiceContract> services = new ArrayList(get.execute());
            ArrayList<ServiceContract> filtered = new ArrayList<>();
            
            for (ServiceContract service : services) {
                if(service.getAttentionCenter() != null && service.getAttentionCenter().getId() == center.getId())
                    filtered.add(service);
            }
            
            table_ReportesAdmin.getItems().setAll(filtered);
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(AdminMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
