/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package santomate1;

import java.util.Date;
import java.util.List;

/**
 *
 * @author 05200251
 */
public class Vendedor {

    private String cpf;
    private String nome;
    private int idade;
    private int cep;
    private Float salario;
    private int telefone;

    public Vendedor() {
    }

    public Vendedor(String cpf, String nome, int idade, int tell, Float salario) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.telefone = tell;
        this.salario = salario;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public int getTelef() {
        return telefone;
    }

    public void setTelef(int tell) {
        this.telefone = tell;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nCPF: " + cpf + "!";
    }

}
