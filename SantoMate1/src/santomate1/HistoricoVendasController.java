/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package santomate1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 05200256
 */
public class HistoricoVendasController implements Initializable {

    @FXML
    private TableColumn<Venda, String> Quantidade;
    @FXML
    private TableColumn<Venda, String> Tipo;
    @FXML
    private TableColumn<Venda, String> Marca;
    @FXML
    private TableColumn<Venda, String> Peso;
    @FXML
    private TableColumn<Venda, String> Vendedor;
    @FXML
    private TableColumn<Venda, String> Comprador;
    @FXML
    private Button voltar;
    @FXML
    private TableView<Venda> vendasTable;

    private final ObservableList<Venda> historico = FXCollections.observableArrayList();

    public HistoricoVendasController() {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Não Deu Tempo De Fazer!!!!!!!!!
    }

    @FXML
    private void voltaMerda(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GerenteMenu.fxml"));
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

}
