/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.LocalSession;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kenneth
 */
public class LoginScreenController implements Initializable {

    @FXML
    private Button btn_AtrasLogin;
    @FXML
    private Button btn_registrarse;
    @FXML
    private Button btn_inicioSesion;
    @FXML
    private ComboBox<String> combo_tipousuario;
    
    @FXML private TextField textfieldUsuario;
    @FXML private TextField textfieldPassword;
    
    private void handler_btn_AtrasLogin(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    @FXML
    private void handler_btn_registrarse(ActionEvent event) {
        System.out.println("You clicked me!");
        
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/GUI/Registro.fxml"));
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
    private void handler_btn_inicioSesion(ActionEvent event) {
        
        String tipo = combo_tipousuario.getValue();
        Parent root;
        String usuario = textfieldUsuario.getText();
        String password = textfieldPassword.getText();
        boolean valid = false;
        if(null != tipo)switch (tipo) {
            case "Admin":
                valid = LocalSession.getInstance().loginEmployee(usuario,password);
                System.out.println("valid credentials: " + valid);
                if(!valid){
                    displayLoginError();
                    return;
                }
                try {
            root = FXMLLoader.load(getClass().getResource("/GUI/AdminMain.fxml"));
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
                break;
            case "Cliente":
                valid = LocalSession.getInstance().loginClient(usuario,password);
                System.out.println("valid credentials: " + valid);
                if(!valid){
                    displayLoginError();
                    return;
                }
                if(!valid) return;
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
                break;
            case "Empleado":
                valid = LocalSession.getInstance().loginEmployee(usuario,password);
                System.out.println("valid credentials: " + valid);
                if(!valid){
                    displayLoginError();
                    return;
                }
                if(!valid) return;
                try {
            root = FXMLLoader.load(getClass().getResource("/GUI/CuidadorMain.fxml"));
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
                break;
            default:
                break;
        }
                
        
        
        
    }
    
    
    private void displayLoginError(){
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Usuario o contrasena incorrecta");
        alert.setHeaderText("Usuario o contrasena incorrecta");
        alert.setContentText("Usuario o contrasena incorrecta \n\nPor favor asegiurate de haber seleccionado el tipo de usuario correcto");

        alert.showAndWait();

    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
            combo_tipousuario.getItems().addAll(
            "Cliente",
            "Admin",
            "Empleado" 
        );
        combo_tipousuario.setValue("Admin");
    }    
    
}
