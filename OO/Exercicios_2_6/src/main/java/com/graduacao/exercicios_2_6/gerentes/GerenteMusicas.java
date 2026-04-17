package com.graduacao.exercicios_2_6.gerentes;

import com.graduacao.exercicios_2_6.classes.Musica;
import java.util.ArrayList;
import java.util.List;


public class GerenteMusicas {
    private List<Musica> musicas;
    
    public GerenteMusicas(){
        this.musicas = new ArrayList<>();
    }
    public GerenteMusicas(GerenteMusicas outro){
        this.musicas = new ArrayList<>();
        
        for(Musica m: outro.getMusicas()){
            Musica musica = new Musica(m);
            this.musicas.add(musica);
        }
    }
    
    public void copiar(GerenteMusicas outro){
        this.musicas.clear();
        
        for(Musica m: outro.getMusicas()){
            Musica musica = new Musica();
            musica.copiar(m);
            this.musicas.add(musica);
        }
    }
    
    public int size(){
        return this.musicas.size();
    }
    public void addMusica(Musica musica){
        this.musicas.add(musica);
    }
    public void removerMusica(int index){
        this.musicas.remove(index);
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Musicas[").append(this.size()).append("]: \n ");
        
        for(Musica musica: this.musicas){
            sb.append(musica.toString());
        }
        
        return sb.toString();
    }
    
    public Musica getMusica(int index){
        return this.musicas.get(index);
    }
    
    public List<Musica> getMusicas() {
        return musicas;
    }
}
