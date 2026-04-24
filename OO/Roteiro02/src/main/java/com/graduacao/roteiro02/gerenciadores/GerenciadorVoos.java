package com.graduacao.roteiro02.gerenciadores;

import com.graduacao.roteiro02.classes.Voo;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class GerenciadorVoos {
    
    private final Map<String, Voo> voos;
    
    public GerenciadorVoos(){
        this.voos = new HashMap<>();
    }
    public GerenciadorVoos(GerenciadorVoos outro){
        this.voos = new HashMap<>();
        
        for(Voo v: outro.getVoos().values()){
            Voo voo = new Voo(v);
            this.voos.put(voo.getNumVoo(), voo);
        }
    }
    
    public void put(Voo voo){
        this.voos.put(voo.getNumVoo(),voo);
    }
    public Voo remove(String numVoo){
        return this.voos.remove(numVoo);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.voos);
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
        final GerenciadorVoos other = (GerenciadorVoos) obj;
        return Objects.equals(this.voos, other.voos);
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        for(Voo voo: this.voos.values()){
            sb.append(voo.toString());
        }
        
        return sb.toString();
    }
    
    public boolean containsKey(String numVoo){
        return this.voos.containsKey(numVoo);
    }
    
    public int size(){
        return this.voos.size();
    }

    public Voo get(String numVoo){
        return this.voos.get(numVoo);
    }
    
    public Map<String, Voo> getVoos() {
        return voos;
    }
}
