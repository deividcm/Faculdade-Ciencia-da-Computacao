package com.graduacao.exercicios_2_5.classes;

import java.util.Objects;

public class Cliente {
    private String nome;
    private String cpf;
    private ContaBancaria conta;
    
    public Cliente(){
        this.nome = "";
        this.cpf = "";
        this.conta = new ContaBancaria();
    }
    public Cliente(String nome, String cpf, ContaBancaria conta) {
        this.nome = nome;
        this.cpf = cpf;
        this.conta = conta;
    }
    public Cliente(Cliente outro){
        this.nome = outro.getNome();
        this.cpf = outro.getCpf();
        this.conta = new ContaBancaria(outro.getConta());
    }
    public void copiar(Cliente outro){
        this.nome = outro.getNome();
        this.cpf = outro.getCpf();
        this.conta.copiar(outro.getConta());
    }
    
    public void depositar(double valor){
        this.conta.depositar(valor);
    }
    public void sacar(double valor){
        this.conta.sacar(valor);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.cpf);
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        return Objects.equals(this.conta, other.conta);
    }
    
    @Override
    public String toString(){
        return "--- Cliente ---\n " +
               "Nome: " + this.nome + "\n " +
               "CPF: " + this.cpf + "\n " +
               this.conta.toString();
    }
    
    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ContaBancaria getConta() {
        return this.conta;
    }
    public void setConta(ContaBancaria conta) {
        this.conta = conta;
    }
    
    
}
