
package com.graduacao.exercicios_2_2_1.exercicios;

import java.util.HashMap;
import java.util.Map;

public class PontuacaoJogadores {

    
    public static void main(String[] args) {
        Map<String,Integer> pontuacoes = new HashMap<>();
        
        pontuacoes.put("George", 45);
        pontuacoes.put("Kris", 25);
        pontuacoes.put("Susie", 50);
        
        pontuacoes.put("Kris", pontuacoes.get("Kris") + 10);
        
        int maior = 0;
        String melhor = "";
        
        for(Map.Entry<String,Integer> pontuacao : pontuacoes.entrySet()){
            if(pontuacao.getValue() > maior){
                maior = pontuacao.getValue();
                melhor = pontuacao.getKey();
            }
        }
        
        System.out.println("Jogador com maior pontuacao: " + melhor + " - " + maior + " pontos");
    }
}
