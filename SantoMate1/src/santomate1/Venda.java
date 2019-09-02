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

    private IntegerProperty estoqueID;
    private final StringProperty vendedorCPF;
    private final StringProperty compradorCPF;
    private final IntegerProperty quant;
    private final StringProperty tipo;
    private final DoubleProperty peso;
    private final StringProperty marca;

    public Venda(int estoqueID, String vendedorCPF, String compradorCPF, int quant, String tipo, double peso, String marca) {
        this.estoqueID = new SimpleIntegerProperty(estoqueID);
        this.vendedorCPF = new SimpleStringProperty(vendedorCPF);
        this.compradorCPF = new SimpleStringProperty(compradorCPF);
        this.quant = new SimpleIntegerProperty(quant);
        this.tipo = new SimpleStringProperty(tipo);
        this.peso = new SimpleDoubleProperty(peso);
        this.marca = new SimpleStringProperty(marca);
    }

    public Venda(int quant, String tipo, String marca, double peso, String vendedorCPF, String compradorCPF) {
        this.quant = new SimpleIntegerProperty(quant);
        this.tipo = new SimpleStringProperty(tipo);
        this.marca = new SimpleStringProperty(marca);
        this.peso = new SimpleDoubleProperty(peso);
        this.vendedorCPF = new SimpleStringProperty(vendedorCPF);
        this.compradorCPF = new SimpleStringProperty(compradorCPF);
    }

    public IntegerProperty getEstoqueID() {
        return estoqueID;
    }

    public void setEstoqueID(int estoqueID) {
        this.estoqueID.set(estoqueID);
    }

    public StringProperty getVendedorCPF() {
        return vendedorCPF;
    }

    public void setVendedorCPF(String vendedorCPF) {
        this.vendedorCPF.set(vendedorCPF);
    }

    public StringProperty getCompradorCPF() {
        return compradorCPF;
    }

    public void setCompradorCPF(String compradorCPF) {
        this.compradorCPF.set(compradorCPF);
    }

    public IntegerProperty getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant.set(quant);
    }

    public StringProperty getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo.set(tipo);
    }

    public DoubleProperty getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso.set(peso);
    }

    public StringProperty getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca.set(marca);
    }

    @Override
    public String toString() {
        return "Venda{" + "estoqueID=" + estoqueID
                + ", vendedorCPF=" + vendedorCPF + ", compradorCPF=" + compradorCPF + ", quant=" + quant
                + ", tipo=" + tipo + ", peso=" + peso + ", marca=" + marca + '}';
    }
}
