package com.graduacao.exercicios_2_6.gerentes;

import com.graduacao.exercicios_2_6.classes.Artista;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GerenteArtistas {
    private final List<Artista> artistas;
    
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
    public boolean removerArtista(int index){
        if(index < this.size() && index >= 0){
            this.artistas.remove(index);
            return true;
        }
        return false;
    }
    public boolean removerArtista(String nome){
        for(Artista artista : this.artistas){
            if(nome.equals(artista.getNome())){
                this.artistas.remove(artista);
                return true;
            }
        }
        return false;
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
    
    public String toStringResumido(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Artistas ---\n ");
        
        for(Artista artista : this.artistas){
            sb.append(artista.toStringResumido());
        }
        
        return sb.toString();
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.artistas);
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
        final GerenteArtistas other = (GerenteArtistas) obj;
        return Objects.equals(this.artistas, other.artistas);
    }
    
    
    
    public Artista getArtista(int index){
        return this.artistas.get(index);
    }
    public Artista getArtista(String nome){
        for(Artista artista : this.artistas){
            if(nome.equals(artista.getNome())){
                return artista;
            }
        }
        return null;
    }
    
    public List<Artista> getArtistas() {
        return artistas;
    }
}
