
package com.graduacao.exercicios_2_2;

import java.util.Scanner;


public class Exercicios_2_2 {

    // Não seria melhor criar um atributo  "private Scanner ler;" ao invés de criar um objeto em cada função?
    
    
    
    
    public static int imprimeMenu(){
        Scanner ler = new Scanner(System.in);
        System.out.println("--------Exercicios2.2--------");
        System.out.println("1 - Exercicio 12");
        System.out.println("2 - Exercicio 13");
        System.out.println("0 - Sair");
        System.out.println("-----------------------------");
        System.out.println("Escolha uma opcao:");
        
        return ler.nextInt();
    }
    
    
    
    public static void main(String[] args) {
        int opcao = 0;
        
        do{
            opcao = imprimeMenu();
            switch(opcao){
                case 1 -> {
                    ProjetoCadMusica.main(args);
                    break;
                }
                case 2 -> {
                    ProjetoCadFilme.main(args);
                    break;
                }
            }
            
        }while(opcao != 0);
        
        System.out.println("Encerrando Programa...");
    }
}
