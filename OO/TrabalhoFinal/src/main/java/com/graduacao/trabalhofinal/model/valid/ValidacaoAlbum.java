package com.graduacao.trabalhofinal.model.valid;

import com.graduacao.trabalhofinal.model.entities.Album;
import com.graduacao.trabalhofinal.model.exceptions.AlbumException;


public class ValidacaoAlbum {
    public Album validacao(String codAlbum, String nome, String codArtista, String anoLancamento){
        Album a = new Album();
        
        if(codAlbum.isEmpty()){
            throw new AlbumException("Error - Campo vazio: 'codigo album'");
        }
        a.setCodAlbum(codAlbum);
        if(nome.isEmpty()){
            throw new AlbumException("Error - Campo vazio: 'nome'");
        }
        a.setNome(nome);
        if(codArtista.isEmpty()){
            throw new AlbumException("Error - Campo vazio: 'codigo artista'");
        }
        a.setCodArtista(codArtista);
        if(anoLancamento.isEmpty()){
            throw new AlbumException("Error - Campo vazio: 'ano lancamento'");
        }
        if(anoLancamento.matches("[A-Za-z]*")){
            throw new AlbumException("Error - Valor invalido no campo 'ano lancamento'");
        }
        a.setAnoLancamento(Integer.parseInt(anoLancamento));
        
        
        return a;
    }
}
