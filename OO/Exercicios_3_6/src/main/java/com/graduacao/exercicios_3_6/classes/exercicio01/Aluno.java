package com.graduacao.exercicios_3_6.classes.exercicio01;

import java.util.Objects;



public class Aluno {
    private String matricula;
    private String nome;
    private char sexo;
    private int idade;
    private int anoIngresso;
    
    public Aluno(){
        this.matricula = "";
        this.nome = "";
        this.sexo = 'N';
        this.idade = 0;
        this.anoIngresso = 0;
    }
    public Aluno(String matricula, String nome, char sexo, int idade, int anoIngresso) {
        this.matricula = matricula;
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.anoIngresso = anoIngresso;
    }
    public Aluno(Aluno outro){
        this.matricula = outro.getMatricula();
        this.nome = outro.getNome();
        this.sexo = outro.getSexo();
        this.idade = outro.getIdade();
        this.anoIngresso = outro.getAnoIngresso();
    }

    @Override
    public int hashCode(){
        int hash = 7;
        hash += 13 * Objects.hashCode(this.matricula);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(obj.getClass() != this.getClass()){
            return false;
        }
        
        final Aluno outro = (Aluno) obj;
        
        if(outro.getSexo() != this.sexo){
            return false;
        }
        if(outro.getIdade() != this.idade){
            return false;
        }
        if(outro.getAnoIngresso() != this.anoIngresso){
            return false;
        }
        if(Objects.equals(outro.getMatricula(), this.matricula)){
            return false;
        }
        
        return Objects.equals(outro.getNome(), this.nome);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Aluno ---\n ");
        sb.append("Matrícula: ").append(this.matricula).append("\n ");
        sb.append("Nome: ").append(this.nome).append("\n ");
        sb.append("Sexo: ").append(this.sexo).append("\n ");
        sb.append("Idade: ").append(this.idade).append("\n ");
        sb.append("Ano de Ingresso: ").append(this.anoIngresso).append("\n ");

        return sb.toString();
    }

    public String getMatricula() {
        return this.matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
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

    public int getAnoIngresso() {
        return this.anoIngresso;
    }
    public void setAnoIngresso(int anoIngresso) {
        this.anoIngresso = anoIngresso;
    }
}
