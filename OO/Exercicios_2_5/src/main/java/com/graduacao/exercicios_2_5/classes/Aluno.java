package com.graduacao.exercicios_2_5.classes;

import java.util.Objects;

public class Aluno {
    private String nome;
    private String cpf;
    private String matricula;
    private int anoIngresso;
    private int idade;
    private char sexo;
    
    public Aluno(){
        this.nome = "";
        this.cpf = "";
        this.matricula = "";
        this.anoIngresso = 0;
        this.idade = 0;
        this.sexo = 'N';
    }
    public Aluno(String nome, String cpf, String matricula, int anoIngresso, int idade, char sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.anoIngresso = anoIngresso;
        this.idade = idade;
        this.sexo = sexo;
    }
    public Aluno(Aluno outro){
        this.nome = outro.getNome();
        this.cpf = outro.getCpf();
        this.matricula = outro.getMatricula();
        this.anoIngresso = outro.getAnoIngresso();
        this.idade = outro.getIdade();
        this.sexo = outro.getSexo();
    }
    public void copiar(Aluno outro){
        this.nome = outro.getNome();
        this.cpf = outro.getCpf();
        this.matricula = outro.getMatricula();
        this.anoIngresso = outro.getAnoIngresso();
        this.idade = outro.getIdade();
        this.sexo = outro.getSexo();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.cpf);
        hash = 23 * hash + Objects.hashCode(this.matricula);
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
        final Aluno other = (Aluno) obj;
        if (this.anoIngresso != other.anoIngresso) {
            return false;
        }
        if (this.idade != other.idade) {
            return false;
        }
        if (this.sexo != other.sexo) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        return Objects.equals(this.matricula, other.matricula);
    }
    
    @Override 
    public String toString(){
        return "--- Aluno ---\n " +
               "Nome: " + this.nome + "\n " +
               "CPF: " + this.cpf + "\n " + 
               "Matricula: " + this.matricula + "\n " +
               "Ano de Ingresso: " + this.anoIngresso + "\n " +
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

    public String getMatricula() {
        return this.matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getAnoIngresso() {
        return this.anoIngresso;
    }
    public void setAnoIngresso(int anoIngresso) {
        this.anoIngresso = anoIngresso;
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
