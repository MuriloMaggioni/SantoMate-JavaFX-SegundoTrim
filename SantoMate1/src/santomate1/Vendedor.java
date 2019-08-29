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
public class Vendedor {
    private String cpf;
    private String nome;
    private Date idade;
    private int cep;
    private Float salario;
    private int telefone;
    
    public Vendedor(){}

    public Vendedor(String cpf, String nome, Date idade, int tell, Float salario) {
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
    
    public int getTelef() {
        return telefone;
    }

    public void setTelef(int tell) {
        this.telefone = tell;
    }

    @Override
    public String toString() {
        return "Venda{" + "cpf=" + cpf + ", nome=" + nome +
                ", idade=" + idade + ", cep=" + cep + ", ehGerente=" + '}';
    }
}
