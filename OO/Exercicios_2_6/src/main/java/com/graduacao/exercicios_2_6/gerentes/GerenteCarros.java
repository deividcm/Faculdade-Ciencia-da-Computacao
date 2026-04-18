
package com.graduacao.exercicios_2_6.gerentes;

import com.graduacao.exercicios_2_6.classes.Carro;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class GerenteCarros {
    private List<Carro> carros;
    
    public GerenteCarros(){
        this.carros = new ArrayList<>();
    }
    public GerenteCarros(GerenteCarros outro){
        this.carros = new ArrayList<>();
        
        for(Carro c: outro.getCarros()){
            Carro carro = new Carro(c);
            this.carros.add(carro);
        }
    }
    public void copiar(GerenteCarros outro){
        this.carros.clear();
        
        for(Carro c: outro.getCarros()){
            Carro carro = new Carro();
            carro.copiar(c);
            this.carros.add(carro);
        }
    }
    
    public void addCarro(Carro carro){
        this.carros.add(carro);
    }
    
    public void removerCarro(int index){
        this.carros.remove(index);
    }
    
    public boolean contains(Carro carro){
        return this.carros.contains(carro);
    }
    
    public boolean temFabricanteIgual(GerenteCarros outro){
        
        for(Carro carro1: this.carros){
            for(Carro carro2: outro.getCarros()){
                if(carro1.getFabricante().equals(carro2.getFabricante())){
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Carros[").append(this.carros.size()).append("]: \n ");
        for(Carro carro: this.carros){
            sb.append(carro.toString());
        } 
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.carros);
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
        final GerenteCarros other = (GerenteCarros) obj;
        return Objects.equals(this.carros, other.carros);
    }
    
    
    public Carro getCarro(int index){
        return this.carros.get(index);
    }
    
    public List<Carro> getCarros() {
        return this.carros;
    }
}
