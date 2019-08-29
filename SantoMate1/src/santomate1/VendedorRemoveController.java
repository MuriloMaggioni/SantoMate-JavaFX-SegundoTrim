/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package santomate1;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 05200251
 */
public class VendedorRemoveController implements Initializable {
    private ObservableList<Vendedor> Vendedores;
    

    @FXML
    private Button voltar;
    @FXML
    private Button Remove;
    @FXML
    private ComboBox<?> Vendedor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void voltarMenu(ActionEvent event) {
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
    private void demitidoOMerda(ActionEvent event) {
        if (Vendedor.getSelectionModel().getSelectedItem() != null) {

            Vendedor c = ComandosSQL.buscaCPFVend(Vendedor.getSelectionModel().getSelectedItem().getNome());

            if (c != null && ComandosSQL.remove(c)) {
                    Alert alertaSenha = new Alert(Alert.AlertType.INFORMATION);
                    alertaSenha.setTitle("PARABÈNS");
                    alertaSenha.setHeaderText("Vendedor Removido Com Sucesso!");
                    alertaSenha.setContentText("CONGRATULATIONS!!!!");
                    alertaSenha.showAndWait();
                for (Iterator<Vendedor> iterator = Vendedores.iterator(); iterator.hasNext();) {
                    Vendedor next = iterator.next();

                    if (next.getCpf() == c.getCpf()) {
                        iterator.remove();
                    }
                }
            } else {
                    Alert alertaSenha = new Alert(Alert.AlertType.ERROR);
                    alertaSenha.setTitle("PARABÈNS");
                    alertaSenha.setHeaderText("Vendedor Removido Com Sucesso!");
                    alertaSenha.setContentText("CONGRATULATIONS!!!!");
                    alertaSenha.showAndWait();
            }
        } else {
                    Alert alertaSenha = new Alert(Alert.AlertType.WARNING);
                    alertaSenha.setTitle("PARABÈNS");
                    alertaSenha.setHeaderText("Vendedor Removido Com Sucesso!");
                    alertaSenha.setContentText("CONGRATULATIONS!!!!");
                    alertaSenha.showAndWait();
        }
    }
    }
    
}
