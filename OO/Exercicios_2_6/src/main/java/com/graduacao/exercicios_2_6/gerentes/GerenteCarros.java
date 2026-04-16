
package com.graduacao.exercicios_2_6.gerentes;

import com.graduacao.exercicios_2_6.classes.Carro;
import java.util.ArrayList;
import java.util.List;


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
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Carros[").append(this.carros.size()).append("]: \n ");
        for(Carro carro: this.carros){
            sb.append(carro.toString());
        } 
        return sb.toString();
    }
    
    
    public Carro getCarro(int index){
        return this.carros.get(index);
    }
    
    public List<Carro> getCarros() {
        return this.carros;
    }
}
