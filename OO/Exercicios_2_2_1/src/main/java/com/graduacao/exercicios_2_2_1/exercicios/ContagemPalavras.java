

package com.graduacao.exercicios_2_2_1.exercicios;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContagemPalavras {
    
    private static Map<String, Integer> contador(String[] arr, int tam){
        Map<String, Integer> contagem = new HashMap<>();
        
        for(int i  = 0; i < tam; i++){
            int cont = contagem.getOrDefault(arr[i], 0);

            contagem.put(arr[i], cont+1);
            
        }
        return contagem;
    }
    
    private static void preencher(String[] arr, int tam){
        Scanner ler = new Scanner(System.in);
        for(int i = 0; i < tam; i++){
            System.out.println("Digite uma palavra para a posicao " + i + ": ");
            arr[i] = ler.next();
        }
    }
    
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Informe o tamanho do vetor: ");
        int tam = ler.nextInt();
        
        String[] palavras = new String[tam];
        preencher(palavras,tam);
        
        Map<String, Integer> contagem = contador(palavras, tam);
        
        System.out.println(contagem);
    }
    
}
