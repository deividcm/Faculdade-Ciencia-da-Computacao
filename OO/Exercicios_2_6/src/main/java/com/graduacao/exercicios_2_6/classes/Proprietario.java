package com.graduacao.exercicios_2_6.classes;

import com.graduacao.exercicios_2_6.gerentes.GerenteCarros;
import java.util.Objects;

public class Proprietario {
    private String nome;
    private String cpf;
    private String email;
    private GerenteCarros gerente;
    public Proprietario(){
        this.nome = "";
        this.cpf = "";
        this.email = "";
        this.gerente = new GerenteCarros();
    }
    public Proprietario(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.gerente = new GerenteCarros();
    }
    public Proprietario(Proprietario outro){
        this.nome = outro.getNome();
        this.cpf = outro.getCpf();
        this.email = outro.getEmail();
        this.gerente = new GerenteCarros(outro.getGerente());
    }
    public void copiar(Proprietario outro){
        this.nome = outro.getNome();
        this.cpf = outro.getCpf();
        this.email = outro.getEmail();
        this.gerente.copiar(outro.getGerente());
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.nome);
        hash = 89 * hash + Objects.hashCode(this.cpf);
        hash = 89 * hash + Objects.hashCode(this.email);
        hash = 89 * hash + Objects.hashCode(this.gerente);
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
        final Proprietario other = (Proprietario) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return Objects.equals(this.gerente, other.gerente);
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Proprietario ---\n ");
        sb.append("Nome: ").append(this.nome).append("\n ");
        sb.append("CPF: ").append(this.cpf).append("\n ");
        sb.append("Email: ").append(this.email).append("\n ");
        sb.append(this.gerente.toString());
        return sb.toString();
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

    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public GerenteCarros getGerente() {
        return this.gerente;
    }
    public void setGerente(GerenteCarros gerente) {
        this.gerente = gerente;
    }
}
