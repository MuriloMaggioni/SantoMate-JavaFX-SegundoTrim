/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package santomate1;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Venda {

    private String compradorCPF;
    private int ervaId;
    private int quant;

    public Venda(String compradorCPF, int ervaId, int quant) {
        this.compradorCPF = compradorCPF;
        this.ervaId = ervaId;
        this.quant = quant;
    }

    public String getCompradorCPF() {
        return compradorCPF;
    }

    public int getErvaId() {
        return ervaId;
    }

    public int getQuant() {
        return quant;
    }

    public void setCompradorCPF(String compradorCPF) {
        this.compradorCPF = compradorCPF;
    }

    public void setErvaId(int ervaId) {
        this.ervaId = ervaId;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    @Override
    public String toString() {
        return "Comprador: " + compradorCPF + "\nervaId: " + ervaId + "\nquant: " + quant;
    }
    
    
}
