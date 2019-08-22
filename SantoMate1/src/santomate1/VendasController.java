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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 05200256
 */
public class VendasController implements Initializable {

    @FXML
    private Button comeback;
    
    @FXML
    private ComboBox<String> marca;
    private ObservableList<String> myComboBoxMarca;
    @FXML
    private ComboBox<String> tipo;
    private ObservableList<String> myComboBoxTipo;
    @FXML
    private ComboBox<String> vendedor;
    private ObservableList<String> myComboBoxVendedor;
    @FXML
    private ComboBox<Integer> quant;
    private ObservableList<Integer> myComboBoxQuant;
    @FXML
    private ComboBox<Float> peso;
    private ObservableList<Float> myComboBoxPeso;
    @FXML
    private TextField NameInput;
    @FXML
    private TextField CPFInput;
    @FXML
    private Button venda;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        myComboBoxMarca = FXCollections.observableArrayList();
        myComboBoxTipo = FXCollections.observableArrayList();
        myComboBoxVendedor = FXCollections.observableArrayList();
        myComboBoxQuant = FXCollections.observableArrayList();
        myComboBoxPeso = FXCollections.observableArrayList();
        
        myComboBoxMarca.add("Ximango");
        myComboBoxMarca.add("Rei Verde");
        myComboBoxMarca.add("TerTúlia");
        myComboBoxMarca.add("Vier");
        myComboBoxMarca.add("Pastoreio");
        
        myComboBoxQuant.add(1);myComboBoxQuant.add(2);myComboBoxQuant.add(3);myComboBoxQuant.add(4);myComboBoxQuant.add(5);
        
        myComboBoxTipo.add("Trandicional");
        myComboBoxTipo.add("Moída Grossa");
        myComboBoxTipo.add("Pura Folha");
        myComboBoxTipo.add("Barbaquá");
        
        myComboBoxPeso.add(new Float(1.0));
        myComboBoxPeso.add(new Float(2.0));
        myComboBoxPeso.add(new Float(4.0));
        myComboBoxPeso.add(new Float(5.0));
        myComboBoxPeso.add(new Float(6.0));
        myComboBoxPeso.add(new Float(8.0));
        
        
        marca.setItems(myComboBoxMarca);
        quant.setItems(myComboBoxQuant);
        tipo.setItems(myComboBoxTipo);
        peso.setItems(myComboBoxPeso);
    }   

    @FXML
    private void fechaPorra(ActionEvent event) {
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
    private void insereNome(ActionEvent event) {
    }

    @FXML
    private void insereCPF(ActionEvent event) {
    }

    @FXML
    private void realizaVenda(ActionEvent event) {
    }
}
