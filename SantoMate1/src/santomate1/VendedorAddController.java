/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package santomate1;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class VendedorAddController implements Initializable {

    @FXML
    private TextField insertName;
    @FXML
    private TextField inserCPF;
    @FXML
    private TextField inserTel;
    @FXML
    private TextField inserSal;
    @FXML
    private TextField inserIdade;
    @FXML
    private Button voltar;
    @FXML
    private Button add;
    public ArrayList<Vendedor> vendedores;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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

    @FXML
    private void addVendedor(ActionEvent event) throws IOException, Exception {
        boolean temp = true;
        Vendedor vendedor = new Vendedor();

                    vendedor.setCpf(inserCPF.getText());
                    vendedor.setNome(insertName.getText());
                    vendedor.setIdade(Date.valueOf(inserIdade.getText()));
                    vendedor.setSalario(Float.parseFloat(inserSal.getText()));
                    vendedor.setTelef(Integer.parseInt(inserTel.getText()));
                    boolean ok = ComandosSQL.addVend(vendedor);

                    if (ok) {
                        vendedor.setCpf(String.valueOf(ComandosSQL.buscaCPFVend(vendedor)));
                        vendedores.add(vendedor);
                        Alert alertaSenha = new Alert(Alert.AlertType.INFORMATION);
                        alertaSenha.setTitle("PARABÈNS!");
                        alertaSenha.setHeaderText("Vendedor Cadastrado Com Sucesso!");
                        alertaSenha.setContentText("");
                        alertaSenha.showAndWait();
                        limpaCamposInserção();
                    } else {
                        Alert alertaSenha = new Alert(Alert.AlertType.ERROR);
                        alertaSenha.setTitle("OPS!");
                        alertaSenha.setHeaderText("Erro ao Cadastrar Vendedor!");
                        alertaSenha.setContentText("Tente Novamente!");
                        alertaSenha.showAndWait();
                    }
    }

    private void registrarVendedor(Vendedor vend) throws Exception {
        SantoMate1.conexaobd.addVend(vend);
    }
    
    private void setVendedores() throws Exception {
        vendedores = SantoMate1.conexaobd.vendedoresCarreg();
    }
    
        private void limpaCamposInserção() {
        inserCPF.setText("");
        insertName.setText("");
        inserIdade.setText("");
        inserSal.setText("");
        inserTel.setText("");
    }
    
}
