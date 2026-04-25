package com.graduacao.exercicios_2_6.gerentes.exercicio08;

import com.graduacao.exercicios_2_6.classes.exercicio08.Musica;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class GerenteMusicas {
    private final List<Musica> musicas;
    
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
    public boolean removerMusica(int index){
        if(index < this.size() && index >= 0){
            this.musicas.remove(index);
            return true;
        }
        return false;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.musicas);
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
        final GerenteMusicas other = (GerenteMusicas) obj;
        return Objects.equals(this.musicas, other.musicas);
    }
    
    
    
    
    public Musica getMusica(int index){
        return this.musicas.get(index);
    }
    
    public List<Musica> getMusicas() {
        return musicas;
    }
}
