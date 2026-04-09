package com.graduacao.exercicios_2_5;

import com.graduacao.exercicios_2_5.exercicios.Exercicio00;
import com.graduacao.exercicios_2_5.exercicios.Exercicio01;
import com.graduacao.exercicios_2_5.exercicios.Exercicio04;
import java.util.Scanner;


public class Exercicios_2_5 {
    
    
    private static int imprimeMenu(){
        Scanner ler = new Scanner(System.in);
        System.out.println("---------Exercicios2.5---------");
        System.out.println("1 - Exercicio 00");
        System.out.println("2 - Exercicio 01");
        System.out.println("3 - Exercicio 04");
        System.out.println("0 - Sair");
        System.out.println("-------------------------------");
        System.out.println("Escolha uma opcao:");
        
        return ler.nextInt();
    }
    
    public static void main(String[] args) {
        int opcao;
        
        do{
            opcao = imprimeMenu();
            
            switch(opcao){
                case 1 -> {
                    Exercicio00.main(args);
                    break;
                }
                case 2 -> {
                    Exercicio01.main(args);
                    break;
                }
                case 3 -> {
                    Exercicio04.main(args);
                    break;
                }
                
                
            }
        }while(opcao != 0);
        
        
        
    }
}
