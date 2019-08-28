/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package santomate1;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.paint.Color;
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
    
    public HistoricoVendasController(){
        historico.add(new Venda(8, "Moída Grossa", "Ximango", 4.0, "03848937085", "Pedro José de Antilha"));
        historico.add(new Venda(18, "Pura Folha", "Rei Verde", 6.0, "27764598308", "Roberto Feliz da Silva"));
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vendasTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        // Initialize the columns.
        Quantidade.setCellValueFactory(cellData -> cellData.getValue().getQuant().asString());
        Tipo.setCellValueFactory(cellData -> cellData.getValue().getTipo());
        Marca.setCellValueFactory(cellData -> cellData.getValue().getMarca());
        Peso.setCellValueFactory(cellData -> cellData.getValue().getPeso().asString());
        Vendedor.setCellValueFactory(cellData -> cellData.getValue().getVendedorCPF());
        Comprador.setCellValueFactory(cellData -> cellData.getValue().getCompradorNome());
        

        // Add data to the table
        vendasTable.setItems(historico);
    }

    @FXML
    private void voltaMerda(ActionEvent event) {
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
