package com.graduacao.trabalhofinal.model.entities;


public class Artista {
    private String codArtista;
    private String nome;

    public Artista() {
        this.codArtista = "";
        this.nome = "";
    }
    public Artista(String codArtista, String nome) {
        this.codArtista = codArtista;
        this.nome = nome;
    }
    public Artista(Artista outro){
        this.codArtista = outro.getCodArtista();
        this.nome = outro.getNome();
    }
    
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Artista ---\n ");
        sb.append("Codigo: ").append(this.codArtista).append("\n ");
        sb.append("Nome: ").append(this.nome).append("\n ");
        return sb.toString();
    }

    public String getCodArtista() {
        return this.codArtista;
    }
    public void setCodArtista(String codArtista) {
        this.codArtista = codArtista;
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
