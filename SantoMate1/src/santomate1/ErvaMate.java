/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package santomate1;

import java.util.Objects;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author 05200251
 */
class ErvaMate {
    private final StringProperty marca;
    private final StringProperty tipo;
    private final FloatProperty peso;

    public ErvaMate(String marca, String tipo, float peso) {
        this.marca = new SimpleStringProperty(marca);
        this.tipo = new SimpleStringProperty(tipo);
        this.peso = new SimpleFloatProperty(peso);
    }

    public StringProperty getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca.set(marca);
    }

    public StringProperty getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo.set(tipo);
    }

    public FloatProperty getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso.set(peso);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.marca);
        hash = 67 * hash + Objects.hashCode(this.tipo);
        hash = 67 * hash + Float.floatToIntBits(this.peso.get());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ErvaMate other = (ErvaMate) obj;
        return true;
    }
    
    
}
