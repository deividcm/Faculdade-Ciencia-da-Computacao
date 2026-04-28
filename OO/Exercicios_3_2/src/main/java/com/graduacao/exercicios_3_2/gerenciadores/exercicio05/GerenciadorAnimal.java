package com.graduacao.exercicios_3_2.gerenciadores.exercicio05;

import com.graduacao.exercicios_3_2.classes.exercicio05.Animal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class GerenciadorAnimal {
    
    private final Map<String,Animal> animais;
    
    public GerenciadorAnimal(){
        this.animais = new HashMap<>();
    }
    public GerenciadorAnimal(GerenciadorAnimal outro){
        this.animais = new HashMap<>();
        
        for(Animal a: this.animais.values()){
            Animal animal = new Animal(a);
            this.animais.put(animal.getCod(), animal);
        }
    }
    public void put(Animal animal){
        this.animais.put(animal.getCod(), animal);
    }
    public Animal remove(String cod){
        return this.animais.remove(cod);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.animais);
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
        final GerenciadorAnimal other = (GerenciadorAnimal) obj;
        return Objects.equals(this.animais, other.animais);
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Animais (").append(this.size()).append(") ---\n ");
        
        for(Animal animal: this.animais.values()){
            sb.append(animal.toString());
        }
        
        return sb.toString();
    }
    
    public int size(){
        return this.animais.size();
    }
    public boolean containsKey(String cod){
        return this.animais.containsKey(cod);
    }
    public Animal get(String cod){
        return this.animais.get(cod);
    }
    public Map<String, Animal> getAnimais() {
        return this.animais;
    }
}
