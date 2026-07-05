package com.graduacao.trabalhofinal.model.entities;

import java.util.Objects;


public class Album {
    private String codAlbum;
    private String nome;
    private String codArtista;
    private int anoLancamento;

    public Album() {
        this.codAlbum = "";
        this.nome = "";
        this.codArtista = "";
        this.anoLancamento = 0;
    }
    public Album(String codAlbum, String nome, String codArtista, int anoLancamento) {
        this.codAlbum = codAlbum;
        this.nome = nome;
        this.codArtista = codArtista;
        this.anoLancamento = anoLancamento;
    }
    public Album(Album outro){
        this.codAlbum = outro.getCodAlbum();
        this.nome = outro.getNome();
        this.codArtista = outro.getCodArtista();
        this.anoLancamento = outro.getAnoLancamento();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.codAlbum);
        hash = 89 * hash + Objects.hashCode(this.codArtista);
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
        final Album other = (Album) obj;
        if (this.anoLancamento != other.getAnoLancamento()) {
            return false;
        }
        if (!Objects.equals(this.codAlbum, other.getCodAlbum())) {
            return false;
        }
        if (!Objects.equals(this.nome, other.getNome())) {
            return false;
        }
        return Objects.equals(this.codArtista, other.getCodArtista());
    }
    
    
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Album ---\n ");
        sb.append("Codigo: ").append(this.codAlbum).append("\n ");
        sb.append("Nome: ").append(this.nome).append("\n ");
        sb.append("Ano de Lancamento: ").append(this.anoLancamento).append("\n ");
        return sb.toString();
    }

    public String getCodAlbum() {
        return this.codAlbum;
    }
    public void setCodAlbum(String codAlbum) {
        this.codAlbum = codAlbum;
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodArtista() {
        return this.codArtista;
    }
    public void setCodArtista(String codArtista) {
        this.codArtista = codArtista;
    }

    public int getAnoLancamento() {
        return this.anoLancamento;
    }
    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
}
