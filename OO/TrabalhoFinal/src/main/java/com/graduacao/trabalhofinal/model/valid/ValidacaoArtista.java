package com.graduacao.trabalhofinal.model.valid;

import com.graduacao.trabalhofinal.model.entities.Artista;
import com.graduacao.trabalhofinal.model.exceptions.ArtistaException;


public class ValidacaoArtista {
    public Artista validacao(String codArtista, String nome){
        Artista a = new Artista();
        if(codArtista.isEmpty()){
            throw new ArtistaException("Error - Campo vazio: 'codigo artista'");
        }
        a.setCodArtista(codArtista);
        if(nome.isEmpty()){
            throw new ArtistaException("Error - Campo vazio: 'nome'");
        }
        a.setNome(nome);
        
        return a;
    }
}
