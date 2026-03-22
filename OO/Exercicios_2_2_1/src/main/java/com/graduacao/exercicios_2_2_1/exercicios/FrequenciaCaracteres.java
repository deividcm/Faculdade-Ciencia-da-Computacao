

package com.graduacao.exercicios_2_2_1.exercicios;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FrequenciaCaracteres {
    
    private static Map<Character, Integer> contador(String texto){
        Map<Character, Integer> contagem = new HashMap<>();
        
        for(char c : texto.toCharArray()){
            int cont = contagem.getOrDefault(c, 0);
            
            contagem.put(c, cont+1);
        }
        return contagem;
    }
    
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Informe o texto: ");
        String texto = ler.nextLine();
        
        Map<Character,Integer> frequencia = contador(texto);
        
        
        System.out.println(frequencia);
        
    }
}
