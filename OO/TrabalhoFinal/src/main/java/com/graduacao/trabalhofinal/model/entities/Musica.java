package com.graduacao.trabalhofinal.model.entities;

import java.util.Objects;


public class Musica {
    private String codMusica;
    private String titulo;
    private String codAlbum;
    private double duracao;

    public Musica() {
        this.codMusica = "";
        this.titulo = "";
        this.codAlbum = "";
        this.duracao = 0.0;
    }
    public Musica(String codMusica, String titulo, String codAlbum, double duracao) {
        this.codMusica = codMusica;
        this.titulo = titulo;
        this.codAlbum = codAlbum;
        this.duracao = duracao;
    }
    public Musica(Musica outra){
        this.codMusica = outra.getCodMusica();
        this.titulo = outra.getTitulo();
        this.codAlbum = outra.getCodAlbum();
        this.duracao = outra.getDuracao();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.codMusica);
        hash = 89 * hash + Objects.hashCode(this.codAlbum);
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
        if (Double.doubleToLongBits(this.duracao) != Double.doubleToLongBits(other.getDuracao())) {
            return false;
        }
        if (!Objects.equals(this.codMusica, other.getCodMusica())) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.getTitulo())) {
            return false;
        }
        return Objects.equals(this.codAlbum, other.getCodAlbum());
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Musica ---\n ");
        sb.append("Codigo: ").append(this.codMusica).append("\n ");
        sb.append("Titulo: ").append(this.titulo).append("\n ");
        sb.append("Duracao: ").append(this.duracao).append("\n ");
        return sb.toString();
    }

    public String getCodMusica() {
        return this.codMusica;
    }
    public void setCodMusica(String codMusica) {
        this.codMusica = codMusica;
    }
    
    public String getTitulo() {
        return this.titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCodAlbum() {
        return this.codAlbum;
    }
    public void setCodAlbum(String codAlbum) {
        this.codAlbum = codAlbum;
    }

    public double getDuracao() {
        return this.duracao;
    }
    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }
}
