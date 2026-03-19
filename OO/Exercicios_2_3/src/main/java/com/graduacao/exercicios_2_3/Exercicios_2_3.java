
package com.graduacao.exercicios_2_3;

import com.graduacao.exercicios_2_3.projetos.ProjetoCadMusica;
import com.graduacao.exercicios_2_3.projetos.ProjetoCadReserva;
import java.util.Scanner;


public class Exercicios_2_3 {
    
     public static int imprimeMenu(){
        Scanner ler = new Scanner(System.in);
        System.out.println("--------Exercicios2.3--------");
        System.out.println("1 - Exercicio 01");
        System.out.println("2 - Exercicio 02");
        System.out.println("3 - Exercicio 03");
        System.out.println("0 - Sair");
        System.out.println("-----------------------------");
        System.out.println("Escolha uma opcao:");
        
        return ler.nextInt();
    }
    
    public static void main(String[] args) {
        int opcao = 0;
        
        do{
            opcao = imprimeMenu();
            switch (opcao){
                case 1 -> {
                    ProjetoCadReserva.main(args);
                }
                case 2 -> {
                    ProjetoCadMusica.main(args);
                }
                case 3 -> {
                    System.out.println("Placeholder Exercicio 03");
                }
            }
            
            
            
        }while(opcao !=0);
        
    }
}
