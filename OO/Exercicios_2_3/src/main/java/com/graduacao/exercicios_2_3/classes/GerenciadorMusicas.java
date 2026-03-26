package com.graduacao.exercicios_2_3.classes;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorMusicas {
    private List<Musica> musicas;
    
    public GerenciadorMusicas(){
        musicas = new ArrayList<>();
    }
    
    public void adicionarMusica(Musica musica){
        musicas.add(musica);
    }
    
    public boolean removerMusica(String titulo){
        
        
        for(Musica musica: musicas){
            if(titulo.equals(musica.getTitulo())){
                musicas.remove(musica);
                
                return true;
            }
        }
        
        return false;
        
    }
    
    
    public Musica pesquisarMusicaTitulo(String titulo){
        for(Musica musica: musicas){
            if(titulo.equals(musica.getTitulo())){
                return musica;
            }
        }
        return null;
    }
    public Musica pesquisarMusicaArtista(String artista){
        for(Musica musica: musicas){
            if(artista.equals(musica.getArtista())){
                return musica;
            }
        }
        return null;
    }
    
}
