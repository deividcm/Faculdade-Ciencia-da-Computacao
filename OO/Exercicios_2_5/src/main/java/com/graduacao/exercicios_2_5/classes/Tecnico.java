package com.graduacao.exercicios_2_5.classes;

import java.util.Objects;


public class Tecnico {
    private String nome;
    private String nacionalidade;
    private String anoNascimento;
    
    public Tecnico(){
        this.nome = "";
        this.nacionalidade = "";
        this.anoNascimento = "";
    }
    public Tecnico(String nome, String nacionalidade, String anoNascimento) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.anoNascimento = anoNascimento;
    }

    public Tecnico(Tecnico outro){
        this.nome = outro.getNome();
        this.nacionalidade = outro.getNacionalidade();
        this.anoNascimento = outro.getAnoNascimento();
    }
    public void copiar(Tecnico outro){
        this.nome = outro.getNome();
        this.nacionalidade = outro.getNacionalidade();
        this.anoNascimento = outro.getAnoNascimento();
    }
    
    
    @Override
    public String toString(){
        return "--- Tecnico ---\n " +
               "Nome: " + this.nome + "\n " +
               "Nacionalidade: " + this.nacionalidade + "\n " +
               "Ano de nascimento: " + this.anoNascimento + "\n";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.nome);
        hash = 71 * hash + Objects.hashCode(this.nacionalidade);
        hash = 71 * hash + Objects.hashCode(this.anoNascimento);
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
        final Tecnico other = (Tecnico) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.nacionalidade, other.nacionalidade)) {
            return false;
        }
        return Objects.equals(this.anoNascimento, other.anoNascimento);
    }
    
    
    
    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return this.nacionalidade;
    }
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getAnoNascimento() {
        return this.anoNascimento;
    }
    public void setAnoNascimento(String anoNascimento) {
        this.anoNascimento = anoNascimento;
    }
}
