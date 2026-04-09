package com.graduacao.exercicios_2_5.classes;

import java.util.Objects;


public class Carro {
    private String modelo;
    private String cor;
    private int ano;
    
    
    public Carro(){
        this.modelo = "";
        this.cor = "";
        this.ano = 0;
    }
    public Carro(String modelo, String cor, int ano) {
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
    }
    public Carro(Carro outro){
        this.modelo = outro.getModelo();
        this.cor = outro.getCor();
        this.ano = outro.getAno();
    }
    
    public void copiar(Carro outro){
        this.modelo = outro.getModelo();
        this.cor = outro.getCor();
        this.ano = outro.getAno();
    }
    
    public void buzinar(){
        System.out.println(this.modelo + " esta buzinando!");
        System.out.println("PAMMMMMMM!");
    }
    public void abrirPorta(String nome){
        System.out.println(nome + " abriu a porta de " + this.modelo);
    }
    
    @Override
    public String toString(){
        return "--- Carro --- \n " + 
               "Modelo: " + this.modelo + "\n " +
               "Cor: " + this.cor + "\n " +
               "Ano: " + this.ano + "\n";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.modelo);
        hash = 79 * hash + Objects.hashCode(this.cor);
        hash = 79 * hash + this.ano;
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
        final Carro other = (Carro) obj;
        if (this.ano != other.ano) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        return Objects.equals(this.cor, other.cor);
    }
    
    
    
    public String getModelo() {
        return this.modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return this.cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getAno() {
        return this.ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    
    
    
}
