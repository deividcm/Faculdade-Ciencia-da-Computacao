package com.graduacao.exercicios_3_2.classes.exercicio04;

import java.util.Objects;


public class Livro {
    private String cod;
    private String titulo;
    private String autor;
    private double preco;
    private int numPag;
    
    public Livro(){
        this.cod = "";
        this.titulo = "";
        this.autor = "";
        this.preco = 0.0;
        this.numPag = 0;
    } 
     public Livro(String cod, String titulo, String autor, double preco, int numPag) {
         this.cod = cod;
         this.titulo = titulo;
         this.autor = autor;
         this.preco = preco;
         this.numPag = numPag;
     }
     public Livro(Livro outro){
        this.cod = outro.getCod();
        this.titulo = outro.getTitulo();
        this.autor = outro.getAutor();
        this.preco = outro.getPreco();
        this.numPag = outro.getNumPag();
    } 

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.cod);
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
        final Livro other = (Livro) obj;
        if (Double.doubleToLongBits(this.preco) != Double.doubleToLongBits(other.preco)) {
            return false;
        }
        if (this.numPag != other.numPag) {
            return false;
        }
        if (!Objects.equals(this.cod, other.cod)) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        return Objects.equals(this.autor, other.autor);
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Livro ---\n ");
        sb.append("Código: ").append(this.cod).append("\n ");
        sb.append("Título: ").append(this.titulo).append("\n ");
        sb.append("Autor: ").append(this.autor).append("\n ");
        sb.append("Preço: ").append(this.preco).append("\n ");
        sb.append("Número de Páginas: ").append(this.numPag).append("\n ");
        
        return sb.toString();
    }

    public String getCod() {
        return this.cod;
    }
    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getTitulo() {
        return this.titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return this.autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPreco() {
        return this.preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getNumPag() {
        return this.numPag;
    }
    public void setNumPag(int numPag) {
        this.numPag = numPag;
    }
}
