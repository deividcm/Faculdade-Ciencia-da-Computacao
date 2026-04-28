package com.graduacao.exercicios_3_2.gerenciadores.exercicio03;

import com.graduacao.exercicios_3_2.classes.exercicio03.Casa;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class GerenciadorCasa {
    
    private final Map<String, Casa> casas;
    
    public GerenciadorCasa(){
        this.casas = new HashMap<>();
    }
    public GerenciadorCasa(GerenciadorCasa outro){
        this.casas = new HashMap<>();
        
        for(Casa c: outro.getCasas().values()){
            Casa casa = new Casa(c);
            this.casas.put(casa.getEndereco(), casa);
        }
    }
    
    public void put(Casa casa){
        this.casas.put(casa.getEndereco(), casa);
    }
    public Casa remove(String endereco){
        return this.casas.remove(endereco);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.casas);
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
        final GerenciadorCasa other = (GerenciadorCasa) obj;
        return Objects.equals(this.casas, other.casas);
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Casas (").append(this.size()).append(") ---\n ");
        
        for(Casa casa: this.casas.values()){
            sb.append(casa.toString());
        }
        
        return sb.toString();
    }
    
    public int size(){
        return this.casas.size();
    }
    public boolean containsKey(String endereco){
        return this.casas.containsKey(endereco);
    }
    public Casa get(String endereco){
        return this.casas.get(endereco);
    }
    public Map<String, Casa> getCasas() {
        return this.casas;
    }
}
