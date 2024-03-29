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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 05200251
 */
public class GerenteMenuController implements Initializable {

    @FXML
    private Button voltar;
    @FXML
    private Button histVendas;
    @FXML
    private Button addE;
    @FXML
    private Button addV;
    @FXML
    private Button removV;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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

    @FXML
    private void verHistorico(ActionEvent event) {
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HistoricoVendas.fxml"));
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
    private void addEstoque(ActionEvent event) {
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EstoqueAdd.fxml"));
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
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VendedorAdd.fxml"));
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
    private void removeVendedor(ActionEvent event) {
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VendedorRemove.fxml"));
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
    
}
