
package com.graduacao.exercicios_2_2_1.exercicios;

import java.util.HashMap;
import java.util.Map;

public class InverterDicionario {
    
    private static Map<String, Integer> inverter(Map<Integer, String> dicionario){
        Map<String, Integer> invertido = new HashMap<>();
        
        for(Map.Entry<Integer, String> par: dicionario.entrySet()){
            
            invertido.put(par.getValue(), par.getKey());
        }
        
        return invertido;
    }
    
    
    public static void main(String[] args) {
        Map<Integer, String> dicionario  = new HashMap<>();
        dicionario.put(1, "a");
        dicionario.put(2, "b");
        dicionario.put(3, "c");
        
        Map<String, Integer> invertido = inverter(dicionario);
        
        System.out.println(invertido);
    }
    
    
}
