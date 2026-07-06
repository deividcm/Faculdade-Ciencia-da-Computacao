package com.graduacao.trabalhofinal.model.valid;

import com.graduacao.trabalhofinal.model.entities.Musica;
import com.graduacao.trabalhofinal.model.exceptions.MusicaException;


public class ValidacaoMusica {
    
    public Musica validacao(String codMusica, String titulo, String codAlbum, String duracao){
        Musica m = new Musica();
        if(codMusica.isEmpty()){
            throw new MusicaException("Error - Campo vazio: 'codigo musica'");
        }
        m.setCodMusica(codMusica);
        if(titulo.isEmpty()){
            throw new MusicaException("Error - Campo vazio: 'titulo'");
        }
        m.setTitulo(titulo);
        if(codAlbum.isEmpty()){
            throw new MusicaException("Error - Campo vazio: 'codigo album'");
        }
        m.setCodAlbum(codAlbum);
        if(duracao.isEmpty()){
            throw new MusicaException("Error - Campo vazio: 'duracao'");
        }
        if(duracao.matches("[A-Za-z]*")){
            throw new MusicaException("Error - Valor invalido no campo 'duracao'");
        }
        m.setDuracao(Double.parseDouble(duracao));
        
        return m;
    }
    
}
