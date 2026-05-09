package com.graduacao.exercicios_3_3__4__5.file.exercicio04;

import com.graduacao.exercicios_3_3__4__5.classes.Carro;
import java.util.HashMap;
import java.util.Map;

public class SerializadorCSVCarros {
    
    public String toCSV(Map<String, Carro> carros){
        String csv = "Cod;Marca;Modelo;Preco;Ano;\n";
        
        for(Carro carro: carros.values()){
            csv += carro.getCod() + ";" +
                   carro.getMarca() + ";" +
                   carro.getModelo() + ";" +
                   carro.getPreco() + ";" +
                   carro.getAno() + ";\n";
        }
        
        return csv;
    }
    
    public Map<String, Carro> fromCSV(String data){
        Map<String, Carro> carros = new HashMap<>();
        
        String[] linhas = data.split("\n");
        for(int i = 1; i < linhas.length; i++){
            String[] partes = linhas[i].split(";");
            if(partes.length >= 5){
                Carro carro = new Carro();
                carro.setCod(partes[0]);
                carro.setMarca(partes[1]);
                carro.setModelo(partes[2]);
                carro.setPreco(Double.parseDouble(partes[3]));
                carro.setAno(Integer.parseInt(partes[4]));
                
                carros.put(carro.getCod(), carro);
            }
            
        }
        
        return carros;
    }
    
    
}
