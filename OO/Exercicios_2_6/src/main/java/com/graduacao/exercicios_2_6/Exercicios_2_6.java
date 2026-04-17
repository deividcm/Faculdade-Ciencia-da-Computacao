package com.graduacao.exercicios_2_6;

import com.graduacao.exercicios_2_6.exercicios.Exercicio05;
import com.graduacao.exercicios_2_6.exercicios.Exercicio08;
import java.util.Scanner;


public class Exercicios_2_6 {
    
    private static int imprimeMenu(){
        Scanner ler = new Scanner(System.in);
        System.out.println("---------Exercicios2.6---------");
        System.out.println("1 - Exercicio 05");
        System.out.println("2 - Exercicio 08");
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
                case 0 -> {
                    System.out.println("Finalizando...");
                    break;
                }
                case 1 -> {
                    Exercicio05.main(args);
                    break;
                }
                case 2 -> {
                    Exercicio08.main(args);
                    break;
                }
                
                default -> {
                    System.out.println("Opcao invalida!");
                }
                
            }
            
        }while(opcao != 0);
        
    }
}
