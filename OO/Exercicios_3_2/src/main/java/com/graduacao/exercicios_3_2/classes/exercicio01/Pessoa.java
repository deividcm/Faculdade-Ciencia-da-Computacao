package com.graduacao.exercicios_3_2.classes.exercicio01;

import java.util.Objects;


public class Pessoa {
    private String nome;
    private String CPF;
    private int idade;
    private char sexo;
    
    public Pessoa(){
        this.nome = "";
        this.CPF = "";
        this.idade = 0;
        this.sexo = 'N';
    }
    public Pessoa(String nome, String CPF, int idade, char sexo) {
        this.nome = nome;
        this.CPF = CPF;
        this.idade = idade;
        this.sexo = sexo;
    }
    public Pessoa(Pessoa outra){
        this.nome = outra.getNome();
        this.CPF = outra.getCPF();
        this.idade = outra.getIdade();
        this.sexo = outra.getSexo();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.CPF);
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
        final Pessoa other = (Pessoa) obj;
        if (this.idade != other.getIdade()) {
            return false;
        }
        if (this.sexo != other.getSexo()) {
            return false;
        }
        if (!Objects.equals(this.nome, other.getNome())) {
            return false;
        }
        return Objects.equals(this.CPF, other.getCPF());
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Pessoa ---\n ");
        sb.append("Nome: ").append(this.nome).append("\n ");
        sb.append("CPF: ").append(this.CPF).append("\n ");
        sb.append("Idade: ").append(this.idade).append("\n ");
        sb.append("Sexo: ").append(this.sexo).append("\n ");
        
        return sb.toString();
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return this.CPF;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
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
