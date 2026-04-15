package com.graduacao.exercicios_2_5.classes;

import java.util.Objects;

public class Professor {
    private String nome;
    private String cpf;
    private int idade;
    private char sexo;
    
    public Professor(){
        this. nome = "";
        this.cpf = "";
        this.idade = 0;
        this.sexo = 'N';
    }
    public Professor(String nome, String cpf, int idade, char sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.sexo = sexo;
    }
    public Professor(Professor outro){
        this.nome = outro.getNome();
        this.cpf = outro.getCpf();
        this.idade = outro.getIdade();
        this.sexo = outro.getSexo();
    }
    
    public void copiar(Professor outro){
        this.nome = outro.getNome();
        this.cpf = outro.getCpf();
        this.idade = outro.getIdade();
        this.sexo = outro.getSexo();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.cpf);
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
        final Professor other = (Professor) obj;
        if (this.idade != other.idade) {
            return false;
        }
        if (this.sexo != other.sexo) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.cpf, other.cpf);
    }
    
    @Override
    public String toString(){
        return "--- Professor ---\n " +
               "Nome: " + this.nome + "\n "+
               "CPF: " + this.cpf + "\n " + 
               "Idade: " + this.idade + "\n " +
               "Sexo: " + this.sexo + "\n ";
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

    public int getIdade() {
        return this.idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return this.sexo;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
}
