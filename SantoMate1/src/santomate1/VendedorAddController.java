/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package santomate1;

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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 05200251
 */
public class VendedorAddController implements Initializable {

    @FXML
    private TextField insertName;
    @FXML
    private TextField inserCPF;
    @FXML
    private TextField inserTel;
    @FXML
    private TextField inserSal;
    @FXML
    private TextField inserCEP;
    @FXML
    private Button voltar;
    @FXML
    private Button add;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    public void txtAll(){
        System.out.println(insertName.getText());
        System.out.println(inserCPF.getText());
        System.out.println(inserTel.getText());
        System.out.println(inserSal.getText());
        System.out.println(inserCEP.getText());
        
    }

    @FXML
    private void voltaMenu(ActionEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GerenteMenu.fxml"));
            Parent root = loader.load();
            
            Scene scene = new Scene(root);
            Stage pt1 = new Stage();
            pt1.setScene(scene);
            pt1.show();
        } catch (IOException ex){
            System.err.println("DEU PAULERA!");
            ex.printStackTrace();
        }
    }

    @FXML
    private void addVendedor(ActionEvent event) {
    }
}
