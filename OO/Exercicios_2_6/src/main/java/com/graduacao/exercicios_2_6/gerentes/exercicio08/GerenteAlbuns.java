package com.graduacao.exercicios_2_6.gerentes.exercicio08;

import com.graduacao.exercicios_2_6.classes.exercicio08.Album;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GerenteAlbuns {
    private final List<Album> albuns;
    
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
    public boolean removerAlbum(int index){
        if(index < this.size() && index >= 0){
            this.albuns.remove(index);
            return true;
        }
        return false;
    }
    public boolean removerAlbum(String nome){
        for(Album album : this.albuns){
            if(nome.equals(album.getNome())){
                this.albuns.remove(album);
                return true;
            }
        }
        return false;
    }
    
    public Album getMaiorAlbum(){
        Album maior = null;
        
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
    
    public String toStringResumido(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Albuns ---\n ");
        
        for(Album album : this.albuns){
            sb.append(album.toStringResumido());
        }
        
        return sb.toString();
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.albuns);
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
        final GerenteAlbuns other = (GerenteAlbuns) obj;
        return Objects.equals(this.albuns, other.albuns);
    }
    
    
    
    public int size(){
        return this.albuns.size();
    }
    
    public Album getAlbum(int index){
        return albuns.get(index);
    }
    public Album getAlbum(String nome){
        for(Album album : this.albuns){
            if(nome.equals(album.getNome())){
                return album;
            }
        }
        return null;
    }
    public List<Album> getAlbuns() {
        return albuns;
    }
}
