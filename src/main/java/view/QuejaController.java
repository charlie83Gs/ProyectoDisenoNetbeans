/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.diseno.proyecto1diseno.model.AttentionCenter;
import com.diseno.proyecto1diseno.model.Complain;
import controller.Payload;
import controller.command.AddCommand;
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
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Bryan Hernandez
 */
public class QuejaController implements Initializable {

    @FXML
    private Button btn_AtrasQueja;
    @FXML
    private TextArea text_queja;
    @FXML
    private Button btn_addQueja;
    @FXML
    private TextField text_name;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onAtrasButton(ActionEvent event) {
        
        System.out.println("You clicked me!");
        
        Parent root;
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
    }
    
    @FXML
    private void onbtn_addQueja(ActionEvent event) throws Exception {
        Complain complain;
        complain = new Complain(text_name.getText(), text_queja.getText());
        Payload pAddComplain = new Payload();
                pAddComplain.addContent("object", complain);
                AddCommand<AttentionCenter> addComplain = new AddCommand<>(pAddComplain);
                addComplain.execute();
    }
    
}
