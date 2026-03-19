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
        
        System.out.println("Musica adicionada");
    }
    
    public void removerMusica(String titulo){
        boolean encontrada = false;
        
        for(Musica musica: musicas){
            if(titulo.equals(musica.getTitulo())){
                encontrada = true;
                musicas.remove(musica);
                System.out.println("Musica removida");
                break;
            }
        }
        
        if(encontrada == false){
            System.out.println("Musica nao foi encontrada");
        }
        
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
