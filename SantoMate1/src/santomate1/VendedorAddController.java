/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package santomate1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author 05200251
 */
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
    private TextField inserCEP;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    public void txtAll(){
        System.out.println(insertName.getText());
        System.out.println(inserCPF.getText());
        System.out.println(inserTel.getText());
        System.out.println(inserSal.getText());
        System.out.println(inserCEP.getText());
        
    }
}
