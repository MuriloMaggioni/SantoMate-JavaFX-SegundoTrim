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
    public void txtAll(){
        System.out.println(insertName.getText());
        System.out.println(inserCPF.getText());
        System.out.println(inserTel.getText());
        System.out.println(inserSal.getText());
        System.out.println(inserIdade.getText());
        
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
        for(Vendedor vend : vendedores){
            if (insertName.getText().equals(vend.getNome())) {
                temp = false;
                Alert dialogoInfo = new Alert(Alert.AlertType.ERROR);
                dialogoInfo.setTitle("Falha no registro!");
                dialogoInfo.setHeaderText("Nome ja Existente");
                dialogoInfo.setContentText("Tente Novamente!");
                dialogoInfo.showAndWait();
                break;
            }
        }
        if(temp){
            Vendedor novovend = new Vendedor(inserCPF.getText(), insertName.getText(), inserIdade.getText(), inserTel.getText(), inserSal.getText());
            registrarVendedor(novovend);
            Parent proxTelaParent = FXMLLoader.load(getClass().getResource("GerenteMenu.fxml"));
            Scene proxTelaScene = new Scene(proxTelaParent);
            Stage tela = (Stage)((Node)event.getSource()).getScene().getWindow();
            tela.setScene(proxTelaScene);
            tela.show();    
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("Parabéns Gerente!");
            dialogoInfo.setHeaderText("Vendedor Registrado com Sucesso!");
            dialogoInfo.setContentText("Não atrase os salários em!");
            dialogoInfo.showAndWait();
        }
    }

    private void registrarVendedor(Vendedor vend) throws Exception {
        SantoMate1.conexaobd.addVend(vend);
    }
    
    private void setVendedores() throws Exception {
        vendedores = SantoMate1.conexaobd.vendedoresCarreg();
    }
}
