package com.graduacao.exercicios_2_4.classes;

import java.util.Objects;

public class Livro {
    
    private String titulo;
    private String autor;
    private int paginas;
    public static String nomeBiblioteca;
    
    public Livro() {
        this.titulo = "";
        this.autor = "";
        this.paginas = 0;
    }
    
    public Livro(String titulo, String autor, int paginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
    }

    public void trocarNomeBBT(String nome){
        nomeBiblioteca = nome;
    }
    public void imprimirNomeBBT(){
        System.out.println(nomeBiblioteca);
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.titulo);
        hash = 17 * hash + Objects.hashCode(this.autor);
        hash = 17 * hash + this.paginas;
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
        if (this.paginas != other.paginas) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        return Objects.equals(this.autor, other.autor);
    }
    
    @Override
    public String toString() {
        return "Livro{" + "Titulo: " + titulo + 
               " - Autor: " + autor + 
               " - Paginas: " + paginas + '}';
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

    public int getPaginas() {
        return this.paginas;
    }
    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }
    
    
    
    
}
