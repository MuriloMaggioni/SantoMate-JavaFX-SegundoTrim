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
public class Venda {
    private int cpf;
    private String nome;
    private Date idade;
    private int cep;
    private Float salario;
    private boolean ehGerente;

    public Venda(int cpf, String nome, Date idade, int cep, Float salario, boolean ehGerente) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.cep = cep;
        this.salario = salario;
        this.ehGerente = ehGerente;
    }
    
    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getIdade() {
        return idade;
    }

    public void setIdade(Date idade) {
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

    public boolean isEhGerente() {
        return ehGerente;
    }

    public void setEhGerente(boolean ehGerente) {
        this.ehGerente = ehGerente;
    }

    @Override
    public String toString() {
        return "Venda{" + "cpf=" + cpf + ", nome=" + nome +
                ", idade=" + idade + ", cep=" + cep + ", ehGerente=" + ehGerente + '}';
    }
    
    
}
