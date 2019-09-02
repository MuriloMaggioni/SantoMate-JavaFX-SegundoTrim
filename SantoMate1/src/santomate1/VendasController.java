/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package santomate1;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 05200256
 */
public class VendasController implements Initializable {

    private Dao_Estoque dao_estoque;
    private ObservableList<ErvaMate> ervas;
    private ObservableList<Integer> quants;
    private Dao_Comprador dao_comprador;
    private ArrayList<Comprador> compradores;

    @FXML
    private Button comeback;
    @FXML
    private ComboBox<Integer> cbxQuant;
    private ObservableList<Integer> myComboBoxQuant;
    @FXML
    private ComboBox<ErvaMate> cbxErva;
    private ObservableList<Float> myComboBoxErva;
    @FXML
    private Button venda;
    @FXML
    private TextField insertName;
    @FXML
    private TextField inserCPF;
    @FXML
    private TextField insertTelefone;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        compradores = new ArrayList();
        dao_comprador = new Dao_Comprador();
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
    private void fechaPorra(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
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
    private void realizaVenda(ActionEvent event) throws SQLException, ClassNotFoundException {
        if (!dao_estoque.removeEstoque(cbxErva.getSelectionModel().getSelectedItem(), cbxQuant.getSelectionModel().getSelectedItem())) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Erro ao remover ERVA!");
        } else {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("ERA PRA FUNCIONAR 1!");
        }
        Comprador c = new Comprador();
        c.setNome(insertName.getText());
        c.setCpf(inserCPF.getText());
        c.setTelefone(Integer.parseInt(insertTelefone.getText()));
        boolean ok = dao_comprador.adiciona(c);

        if (ok) {
            c.setCpf(String.valueOf(dao_comprador.bucaCPFComprador(c)));
            compradores.add(c);
            Alert alertaSuscesso = new Alert(Alert.AlertType.INFORMATION);
            alertaSuscesso.setTitle("PARABÈNS!");
            alertaSuscesso.setHeaderText("Vendedor Realizou a Venda!");
            alertaSuscesso.setContentText("");
            alertaSuscesso.showAndWait();
            limpaCamposInserção();
        } else {
            Alert alertaSuscesso = new Alert(Alert.AlertType.ERROR);
            alertaSuscesso.setTitle("OPS!");
            alertaSuscesso.setHeaderText("Erro ao Cadastrar Comprador!");
            alertaSuscesso.setContentText("Tente Novamente!");
            alertaSuscesso.showAndWait();
            limpaCamposInserção();
        }
    }

    private void limpaCamposInserção() {
        inserCPF.setText("");
        insertName.setText("");
        insertTelefone.setText("");
    }
}

