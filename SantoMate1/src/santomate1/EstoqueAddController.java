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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 05200251
 */
public class EstoqueAddController implements Initializable {

    @FXML
    private Button voltar;
    @FXML
    private Button add;
    
    @FXML
    private ComboBox<String> marca;
    private final ObservableList<String> myComboBoxMarca = FXCollections.observableArrayList();
    
    @FXML
    private ComboBox<Integer> quant;
    private final ObservableList<Integer> myComboBoxQuant = FXCollections.observableArrayList();
    
    @FXML
    private ComboBox<String> tipo;
    private final ObservableList<String> myComboBoxTipo = FXCollections.observableArrayList();
    
    @FXML
    private ComboBox<Float> peso;
    private final ObservableList<Float> myComboBoxPeso = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
}
