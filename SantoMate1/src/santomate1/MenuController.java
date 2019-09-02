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
public class MenuController implements Initializable {

    @FXML
    private Button logGerente;
    @FXML
    private Button logVendedor;
    @FXML
    private Button close;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void loginG(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GerenteLogin.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage pt1 = new Stage();
            pt1.setScene(scene);
            pt1.show();
        } catch (IOException ex) {
            System.err.println("DEU PAULERA!");
            ex.printStackTrace();
        }
    }

    @FXML
    private void loginV(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Vendas.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage pt1 = new Stage();
            pt1.setScene(scene);
            pt1.show();
        } catch (IOException ex) {
            System.err.println("DEU PAULERA!");
            ex.printStackTrace();
        }
    }

    @FXML
    private void fechaEssaMerda(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
