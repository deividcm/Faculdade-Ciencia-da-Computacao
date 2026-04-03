package com.graduacao.roteiro01;

import com.graduacao.roteiro01.exercicios.Exercicio01;
import com.graduacao.roteiro01.exercicios.Exercicio02;
import java.util.Scanner;


public class Roteiro01 {

    private static int imprimeMenu(){
        Scanner ler = new Scanner(System.in);
        System.out.println("--------Roteiro 01--------");
        System.out.println("1 - Exercicio 01 Triangulo");
        System.out.println("2 - Exercicio 02 Quadrado");
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
                    Exercicio01.main(args);
                    break;
                }
                case 2 -> {
                    Exercicio02.main(args);
                }
            }
            
            
        }while(opcao != 0);
        
    }
}
