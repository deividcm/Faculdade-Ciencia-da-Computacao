package com.graduacao.exercicios_2_6.classes;

import java.util.Objects;

public class Musica {
    private String titulo;
    private double duracao;
    
    public Musica(){
        this.titulo = "";
        this.duracao = 0.0;
    }
    public Musica(String titulo, double duracao) {
        this.titulo = titulo;
        this.duracao = duracao;
    }
    public Musica(Musica outra){
        this.titulo = outra.getTitulo();
        this.duracao = outra.getDuracao();
    }
    
    public void copiar(Musica outra){
        this.titulo = outra.getTitulo();
        this.duracao = outra.getDuracao();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.titulo);
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.duracao) ^ (Double.doubleToLongBits(this.duracao) >>> 32));
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
        final Musica other = (Musica) obj;
        if (Double.doubleToLongBits(this.duracao) != Double.doubleToLongBits(other.duracao)) {
            return false;
        }
        return Objects.equals(this.titulo, other.titulo);
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Musica ---\n ");
        sb.append("Titulo: ").append(this.titulo).append("\n ");
        sb.append("Duracao: ").append(this.duracao).append("\n ");
        
        return sb.toString();
    }
    
    public String getTitulo() {
        return this.titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getDuracao() {
        return this.duracao;
    }
    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }
}
