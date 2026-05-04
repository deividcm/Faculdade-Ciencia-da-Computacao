package com.graduacao.exercicios_3_3__4__5.file.exercicio03;

import com.graduacao.exercicios_3_3__4__5.classes.Animal;
import java.util.HashMap;
import java.util.Map;


public class SerializadorCSVAnimais {
    
    public String toCSV(Map<String, Animal> animais){
        String csv = "Cod;Nome;Especie;Raca;Peso;Idade;\n";
        
        for(Animal animal: animais.values()){
            csv += animal.getCod() + ";" +
                   animal.getNome() + ";" +
                   animal.getEspecie() + ";" +
                   animal.getRaca() + ";" +
                   animal.getPeso() + ";" +
                   animal.getIdade() + ";\n";
        }
        
        return csv;
    }
    
    public Map<String, Animal> fromCSV(String data){
        Map<String, Animal> animais = new HashMap<>();
        
        String[] linhas = data.split("\n");
        for(int i = 1; i < linhas.length; i++){
            String[] partes = linhas[i].split(";");
            if(partes.length >= 6){
                Animal animal = new Animal();
                animal.setCod(partes[0]);
                animal.setNome(partes[1]);
                animal.setEspecie(partes[2]);
                animal.setRaca(partes[3]);
                animal.setPeso(Double.parseDouble(partes[4]));
                animal.setIdade(Integer.parseInt(partes[5]));
                
                animais.put(animal.getCod(), animal);
            }
            
        }
        
        return animais;
    }
    
}
