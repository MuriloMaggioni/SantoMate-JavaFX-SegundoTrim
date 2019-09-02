/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package santomate1;

import java.util.Date;

/**
 *
 * @author 05200251
 */
public class Comprador {

    private String cpf;
    private String nome;
    private int telefone;
    private int cep;
    
    public Comprador(){}

    public Comprador(String cpf, String nome, int telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
    }

    public Comprador(String cpf, String nome, int idade, int cep) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = idade;
        this.cep = cep;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int idade) {
        this.telefone = idade;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Comprador{" + "cpf=" + cpf + ", nome="
                + nome + ", idade=" + telefone + ", cep=" + cep + '}';
    }

}
