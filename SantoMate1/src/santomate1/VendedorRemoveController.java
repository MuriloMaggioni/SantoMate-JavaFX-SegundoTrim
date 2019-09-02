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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 05200251
 */
public class VendedorRemoveController implements Initializable {
    private Dao_Vendedor dao_vendedor;
    private ObservableList<Vendedor> Vendedores;
    

    @FXML
    private Button voltar;
    @FXML
    private Button Remove;
    @FXML
    private ComboBox<Vendedor> cbxVendedor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dao_vendedor = new Dao_Vendedor();
        Vendedores = FXCollections.observableArrayList();
        Vendedores.addAll(dao_vendedor.pesquisaTodos());
        cbxVendedor.setItems(Vendedores);
        
        
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
        if (cbxVendedor.getSelectionModel().getSelectedItem() != null) {

            Vendedor c = dao_vendedor.pesquisaVend((String) cbxVendedor.getSelectionModel().getSelectedItem().getNome());

            if (c != null && dao_vendedor.remove(c)) {
                Alert alertaSuscesso = new Alert(Alert.AlertType.INFORMATION);
                        alertaSuscesso.setTitle("PARABÉNS!");
                        alertaSuscesso.setHeaderText("Vendedor REMOVIDO com sucesso");
                        alertaSuscesso.setContentText("SHOW DE BOLA!");
                        alertaSuscesso.showAndWait();
                for (Iterator<Vendedor> iterator = Vendedores.iterator(); iterator.hasNext();) {
                    Vendedor next = iterator.next();

                    if (next.getCpf() == c.getCpf()) {
                        iterator.remove();
                    }
                }
            } else {
                Alert alertaSuscesso = new Alert(Alert.AlertType.ERROR);
                        alertaSuscesso.setTitle("OPS!");
                        alertaSuscesso.setHeaderText("Erro durante a remoção do" + c.getNome());
                        alertaSuscesso.setContentText("Tente Novamente!");
                        alertaSuscesso.showAndWait();

            }
        } else {
            Alert alertaSuscesso = new Alert(Alert.AlertType.WARNING);
                        alertaSuscesso.setTitle("OPS!");
                        alertaSuscesso.setHeaderText("Você deve escolher um professor!");
                        alertaSuscesso.setContentText("Tente Novamente!");
                        alertaSuscesso.showAndWait();
        }
    }
}
