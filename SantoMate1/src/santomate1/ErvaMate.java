/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package santomate1;

import java.util.Objects;

/**
 *
 * @author 05200251
 */
class ErvaMate {
    private String marca;
    private String tipo;
    private float peso;

    public ErvaMate(String marca, String tipo, float peso) {
        this.marca = marca;
        this.tipo = tipo;
        this.peso = peso;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.marca);
        hash = 67 * hash + Objects.hashCode(this.tipo);
        hash = 67 * hash + Float.floatToIntBits(this.peso);
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
