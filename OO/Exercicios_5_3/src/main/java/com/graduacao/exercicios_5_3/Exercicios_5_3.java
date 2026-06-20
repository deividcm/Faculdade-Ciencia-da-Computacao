

package com.graduacao.exercicios_5_3;

import com.graduacao.exercicios_5_3.exercicio01.Exercicio01;
import com.graduacao.exercicios_5_3.exercicio02.Exercicio02;
import com.graduacao.exercicios_5_3.exercicio06.Exercicio06;
import com.graduacao.exercicios_5_3.exercicio07e08.Exercicio07e08;
import java.util.Scanner;

public class Exercicios_5_3 {
    
    public static int imprimeMenu(Scanner ler){
        System.out.println("------ Exercicios 5.3 ------");
        System.out.println(" 1 - Exercicio 01 Enviadores de Mensagem");
        System.out.println(" 2 - Exercicio 02 Processadores de Pagamento");
        System.out.println(" 6 - Exercicio 06 Pecas de Xadrez");
        System.out.println(" 7 - Exercicios 07 e 08 Persistencia de Dados com SQLite");
        System.out.println(" 0 - Sair");
        System.out.println("--------------------------------");
        System.out.print("Opcao: ");
        return ler.nextInt();
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int opcao = 0;
        do{
            opcao = imprimeMenu(ler);
            switch(opcao){
                case 1 -> {
                    Exercicio01.main(args);
                    break;
                }
                case 2 -> {
                    Exercicio02.main(args);
                    break;
                }
                case 6 -> {
                    Exercicio06.main(args);
                    break;
                }
                case 7 -> {
                    Exercicio07e08.main(args);
                    break;
                }
                case 0 -> {
                    System.out.println("Finalizando...");
                    break;
                }
                default ->{
                    System.out.println("Opcao invalida!");
                }
            }
            
        }while(opcao != 0);
    }
}
