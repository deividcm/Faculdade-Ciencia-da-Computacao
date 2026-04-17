package com.graduacao.exercicios_2_6.gerentes;

import com.graduacao.exercicios_2_6.classes.Album;
import java.util.ArrayList;
import java.util.List;

public class GerenteAlbuns {
    private List<Album> albuns;
    
    public GerenteAlbuns(){
        this.albuns = new ArrayList<>();
    }
    public GerenteAlbuns(GerenteAlbuns outro){
        this.albuns = new ArrayList<>();
        
        for(Album a: outro.getAlbuns()){
            Album album = new Album(a);
            this.albuns.add(album);
        }
    }
    
    public void copiar(GerenteAlbuns outro){
        this.albuns.clear();
        
        for(Album a: outro.getAlbuns()){
            Album album = new Album();
            album.copiar(a);
            this.albuns.add(album);
        }
    }
    
    public void addAlbum(Album album){
        this.albuns.add(album);
    }
    public void removerAlbum(int index){
        this.albuns.remove(index);
    }
    
    public Album getMaiorAlbum(){
        Album maior = new Album();
        
        for(int i = 0; i < this.size(); ){
            Album album = this.getAlbum(i);
            if(i == 0){
                maior = album;
            }
            else if(album.getGerente().size() > maior.getGerente().size()){
                maior = album;
            }
        }
        return maior;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Albuns[").append(this.size()).append("]:\n ");
        
        for(Album album: this.albuns){
            sb.append(album.toString());
        }
        
        return sb.toString();
    }
    
    public int size(){
        return this.albuns.size();
    }
    public Album getAlbum(int index){
        return albuns.get(index);
    }
    
    public List<Album> getAlbuns() {
        return albuns;
    }
}
