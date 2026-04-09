package com.graduacao.exercicios_2_5.classes;

import java.util.Objects;


public class Produto {
    
    private String nome;
    private String categoria;
    private double preco;
    
    public Produto(){
        this.nome = "";
        this.categoria = "";
        this.preco = 0.0;
    }
    public Produto(String nome, String categoria, double preco) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
    }
    public Produto(Produto outro){
        this.nome = outro.getNome();
        this.categoria = outro.getCategoria();
        this.preco = outro.getPreco();
    }

    public void copiar(Produto outro){
        this.nome = outro.getNome();
        this.categoria = outro.getCategoria();
        this.preco = outro.getPreco();
    }
    
    @Override
    public String toString(){
        return "--- Produto ---\n "  +
               "Nome: " + this.nome + "\n " +
               "Categoria: " + this.categoria + "\n " +
               "Preco unitario: " + this.preco + "\n";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + Objects.hashCode(this.categoria);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.preco) ^ (Double.doubleToLongBits(this.preco) >>> 32));
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
        final Produto other = (Produto) obj;
        if (Double.doubleToLongBits(this.preco) != Double.doubleToLongBits(other.preco)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.categoria, other.categoria);
    }
    
    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return this.categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPreco() {
        return this.preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
}
