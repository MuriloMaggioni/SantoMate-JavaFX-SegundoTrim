/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package santomate1;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 05200251
 */
public class EstoqueAddController implements Initializable {

    private Dao_Estoque dao_estoque;
    private ObservableList<ErvaMate> ervas;
    private ObservableList<Integer> quants;

    @FXML
    private Button add;

    @FXML
    private ComboBox<ErvaMate> cbxErva;
    private ObservableList<String> myComboBoxErva;

    @FXML
    private ComboBox<Integer> cbxQuant;
    private ObservableList<Integer> myComboBoxQuant;

    @FXML
    private Button Voltar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dao_estoque = new Dao_Estoque();
        ervas = FXCollections.observableArrayList();
        quants = FXCollections.observableArrayList();
        ervas.addAll(dao_estoque.PesquisaTodos());
        cbxErva.setItems(ervas);
        quants.add(1);
        quants.add(2);
        quants.add(3);
        quants.add(4);
        quants.add(5);

        cbxQuant.setItems(quants);
    }

    @FXML
    private void voltaMenu(ActionEvent event) {
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

    @FXML
    private void addEstoque(ActionEvent event) throws SQLException, ClassNotFoundException {
        Dao_Estoque de = new Dao_Estoque();
        if (!de.adiciona(cbxErva.getSelectionModel().getSelectedItem(), cbxQuant.getSelectionModel().getSelectedItem())) {
            if (!de.adicionaEstoque(cbxErva.getSelectionModel().getSelectedItem(), cbxQuant.getSelectionModel().getSelectedItem())) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Deu errado");
            } else {
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setTitle("Era pra funcionar");
            }
        }
    }

}
