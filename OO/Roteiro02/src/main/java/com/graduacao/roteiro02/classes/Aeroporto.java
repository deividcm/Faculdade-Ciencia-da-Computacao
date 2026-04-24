package com.graduacao.roteiro02.classes;

import com.graduacao.roteiro02.gerenciadores.GerenciadorVoos;

public class Aeroporto {
    private String nome;
    private String localizacao;
    private final GerenciadorVoos gerenciadorVoos;
    
    public Aeroporto(){
        this.nome = "";
        this.localizacao = "";
        this.gerenciadorVoos = new GerenciadorVoos();
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return this.localizacao;
    }
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public GerenciadorVoos getGerenciadorVoos() {
        return gerenciadorVoos;
    }
}
