package com.graduacao.exercicios_2_6.gerentes;

import com.graduacao.exercicios_2_6.classes.Artista;
import java.util.ArrayList;
import java.util.List;

public class GerenteArtistas {
    private List<Artista> artistas;
    
    public GerenteArtistas(){
        this.artistas = new ArrayList<>();
    }
    public GerenteArtistas(GerenteArtistas outro){
        this.artistas = new ArrayList<>();
        
        for(Artista a: outro.getArtistas()){
            Artista artista = new Artista(a);
            this.artistas.add(artista);
        }
    }
    public void copiar(GerenteArtistas outro){
        this.artistas.clear();
        
        for(Artista a: outro.getArtistas()){
            Artista artista = new Artista();
            artista.copiar(a);
            this.artistas.add(artista);
        }
    }
    public void addArtista(Artista artista){
        this.artistas.add(artista);
    }
    public void removerArtista(int index){
        this.artistas.remove(index);
    }
    public int size(){
        return this.artistas.size();
    }
    
    public Artista getMaiorArtista(){
        Artista maior = new Artista();
        for(int i = 0; i < this.size(); i++){
            Artista artista = this.getArtista(i);
            if(i == 0){
                maior = artista;
            }
            else if(artista.getGerente().size() > maior.getGerente().size()){
                maior = artista;
            }
        }
        return maior;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Artistas[").append(this.size()).append("]:\n ");
        
        for(Artista artista: this.artistas){
            sb.append(artista.toString());
        }
        
        
        return sb.toString();
    }
    
    public Artista getArtista(int index){
        return this.artistas.get(index);
    }
    
    public List<Artista> getArtistas() {
        return artistas;
    }
}
