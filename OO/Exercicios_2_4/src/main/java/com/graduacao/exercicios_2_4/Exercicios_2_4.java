package com.graduacao.exercicios_2_4;

import com.graduacao.exercicios_2_4.exercicios.ContadorPessoas;
import com.graduacao.exercicios_2_4.exercicios.Exercicio02;
import java.util.Scanner;

public class Exercicios_2_4 {

    
    public static int imprimeMenu(){
        Scanner ler = new Scanner(System.in);
        System.out.println("--------Exercicios2.4--------");
        System.out.println("1 - Exercicio 01 Contador de Pessoas");
        System.out.println("2 - Exercicio 02 Nome de Biblioteca");
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
                    ContadorPessoas.main(args);
                    break;
                }
                case 2 -> {
                    Exercicio02.main(args);
                    break;
                }
            }
            
            
        }while(opcao != 0);
        
    }
}
