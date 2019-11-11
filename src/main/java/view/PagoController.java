/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.diseno.proyecto1diseno.model.Client;
import com.diseno.proyecto1diseno.model.Employee;
import com.diseno.proyecto1diseno.model.Public;
import com.diseno.proyecto1diseno.model.Service;
import com.diseno.proyecto1diseno.model.ServiceContract;
import com.diseno.proyecto1diseno.model.Study;
import controller.LocalSession;
import controller.Payload;
import controller.command.AddCommand;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class PagoController implements Initializable {

    @FXML
    private TextField text_numeroTarjetaPago;
    @FXML
    private TextField text_nombrePersonaPago;
    @FXML
    private TextField text_Direccion1Pago;
    @FXML
    private TextField text_Direccion2Pago;
    @FXML
    private PasswordField text_CiudadPago;
    @FXML
    private TextArea text_EmailPago;
    @FXML
    private TextArea text_telefonoPago;
    @FXML
    private TextArea text_EstadoPago;
    @FXML
    private TextArea text_CodigoPostal;
    @FXML
    private Button btn_PagoPago;
    @FXML
    private Button btn_AtrasPago;
    @FXML
    private TextField text_MMYY;
    @FXML
    private TextField text_CVC;
    @FXML
    private TextField text_PaisPago;

    @FXML
    private void handler_btn_PagoPago(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    @FXML
    private void handler_btn_AtrasPago(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    
    @FXML private void onRegisterServiceContract(ActionEvent event){
        
        System.out.println("Registering payment");
        LocalSession session = LocalSession.getInstance();
        Employee emp = (Employee)session.getData("employee");
        Client clt = (Client)session.getData("sessionClient");
        Service serv = (Service)session.getData("service");
        
        Date currentDate = new Date();
        Date endDate = new Date();
        
        float cost = 0;
       
        if(serv.getTargetPublic() != null){
            Public pub = serv.getTargetPublic();
            //System.out.println(pub.getName());
            //cost += pub.getCost();
        }
        ArrayList<Study> studies = new ArrayList<>();
        
        for (Study study : emp.getStudies()) {
            cost += study.getCost();
        }
        
        
        
        ServiceContract contract = new ServiceContract(serv,emp,currentDate,endDate,emp.getAttentionCenter(),cost);
        Payload payload = new Payload();
        payload.addContent("object", contract);
        try {
            AddCommand<ServiceContract> contractCommand = new AddCommand<>(payload);
            contractCommand.execute();
        } catch (Exception ex) {
            Logger.getLogger(PagoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        gotToMainClient();
        
    }
    
    void gotToMainClient() {
        System.out.println("You clicked me!");
        
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/GUI/ClienteMain.fxml"));
            Stage stage = new Stage();
            stage.setTitle("My New Stage Title");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            // Hide this current window (if this is what you want)
            btn_PagoPago.getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
