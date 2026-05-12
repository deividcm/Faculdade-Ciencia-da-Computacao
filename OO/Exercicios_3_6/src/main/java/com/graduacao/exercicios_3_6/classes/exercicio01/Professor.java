package com.graduacao.exercicios_3_6.classes.exercicio01;

import java.util.Objects;


public class Professor {
    private String cpf;
    private String nome;
    private char sexo;
    private int idade;
    
    public Professor(){
        this.cpf = "";
        this.nome = "";
        this.sexo = 'N';
        this.idade = 0;
    }
    public Professor(String cpf, String nome, char sexo, int idade) {
        this.cpf = cpf;
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
    }
    public Professor(Professor outro){
        this.cpf = outro.getCpf();
        this.nome = outro.getNome();
        this.sexo = outro.getSexo();
        this.idade = outro.getIdade();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.cpf);
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
        if (this.sexo != other.sexo) {
            return false;
        }
        if (this.idade != other.idade) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        return Objects.equals(this.nome, other.nome);
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Professor ---\n ");
        sb.append("CPF: ").append(this.cpf).append("\n ");
        sb.append("Nome: ").append(this.nome).append("\n ");
        sb.append("Sexo: ").append(this.sexo).append("\n ");
        sb.append("Idade: ").append(this.idade).append("\n ");
        
        return sb.toString();
    }
    
    public String getCpf() {
        return this.cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return this.sexo;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return this.idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
}
