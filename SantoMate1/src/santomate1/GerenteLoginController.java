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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 05200251
 */
public class GerenteLoginController implements Initializable {

    @FXML
    private PasswordField insert;
    @FXML
    private Button voltar;
    @FXML
    private Button inserir;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int senhaGerente = 1235;
        
    }    

    @FXML
    private void voltaMenu(ActionEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
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
    
    
    //NÂO FUNCIONA A SENHA, SÓ REDIRICIONA!!!!!!!!!!!!!!!!!!!!!!!
    @FXML
    private void insereSenha(ActionEvent event) {
        String senhaInser = insert.getText();
        String senhaGerente = "123";
        if(senhaInser.equals(senhaGerente)){
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
        }else{
            Alert alertaSenha = new Alert(Alert.AlertType.WARNING);
            alertaSenha.setTitle("Erro 404");
            alertaSenha.setHeaderText("Senha Incorreta");
            alertaSenha.setContentText("Tente Novamente");
            alertaSenha.showAndWait();
        }
        
    }

}
