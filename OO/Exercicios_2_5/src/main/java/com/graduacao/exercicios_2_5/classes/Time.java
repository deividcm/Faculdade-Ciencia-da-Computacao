package com.graduacao.exercicios_2_5.classes;

import java.util.Objects;


public class Time {
    private String nome;
    private String cidade;
    private String anoFundacao;
    private Tecnico tecnico;
    
    public Time(){
        this.nome = "";
        this.cidade = "";
        this.anoFundacao = "";
        this.tecnico = new Tecnico();
    }

    public Time(String nome, String cidade, String anoFundacao) {
        this.nome = nome;
        this.cidade = cidade;
        this.anoFundacao = anoFundacao;
        this.tecnico = new Tecnico();
    }
    
    
    public void escalonarTecnico(Tecnico tecnico){
        this.tecnico = tecnico;
    }
    
    @Override
    public String toString(){
        return "--- Time ---\n " +
               "Nome: " + this.nome + "\n " + 
               "Cidade: " + this.cidade + "\n " +
               "Ano de fundacao: " + this.anoFundacao + "\n " +
               this.tecnico;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.nome);
        hash = 37 * hash + Objects.hashCode(this.cidade);
        hash = 37 * hash + Objects.hashCode(this.anoFundacao);
        hash = 37 * hash + Objects.hashCode(this.tecnico);
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
        final Time other = (Time) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.anoFundacao, other.anoFundacao)) {
            return false;
        }
        return Objects.equals(this.tecnico, other.tecnico);
    }
    
    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return this.cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getAnoFundacao() {
        return this.anoFundacao;
    }
    public void setAnoFundacao(String anoFundacao) {
        this.anoFundacao = anoFundacao;
    }
    public Tecnico getTecnico() {
        return this.tecnico;
    }
    
    
    
    
}
