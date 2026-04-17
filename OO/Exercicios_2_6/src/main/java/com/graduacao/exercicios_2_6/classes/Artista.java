package com.graduacao.exercicios_2_6.classes;

import com.graduacao.exercicios_2_6.gerentes.GerenteAlbuns;
import java.util.Objects;


public class Artista {
    private String nome;
    private GerenteAlbuns gerente;
    
    public Artista(){
        this.nome = "";
        this.gerente = new GerenteAlbuns();
    }
    public Artista(String nome) {
        this.nome = nome;
        this.gerente = new GerenteAlbuns();
    }
    public Artista(Artista outro){
        this.nome = outro.getNome();
        this.gerente = new GerenteAlbuns(outro.getGerente());
    }
    public void copiar(Artista outro){
        this.nome = outro.getNome();
        this.gerente.copiar(outro.getGerente());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.nome);
        hash = 47 * hash + Objects.hashCode(this.gerente);
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
        final Artista other = (Artista) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.gerente, other.gerente);
    }
    
    
    public String toStringResumido(){
        return this.nome + ": " + this.gerente.size() + " Albuns\n ";
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Artista ---\n ");
        sb.append("Nome: ").append(this.nome).append("\n ");
        sb.append(this.gerente.toString());
        return sb.toString();
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public GerenteAlbuns getGerente() {
        return gerente;
    }
}
