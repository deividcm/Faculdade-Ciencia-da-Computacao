package com.graduacao.exercicios_2_2_1;

import com.graduacao.exercicios_2_2_1.exercicios.ContagemPalavras;
import com.graduacao.exercicios_2_2_1.exercicios.DicionarioProdutos;
import com.graduacao.exercicios_2_2_1.exercicios.FilaBanco;
import com.graduacao.exercicios_2_2_1.exercicios.HistoricoNavegacao;
import com.graduacao.exercicios_2_2_1.exercicios.ListaPresenca;
import java.util.Scanner;


public class Exercicios_2_2_1 {

    public static int imprimeMenu(){
        Scanner ler = new Scanner(System.in);
        System.out.println("--------Exercicios2.2.1--------");
        System.out.println("1 - Exercicio 01 Fila de Banco");
        System.out.println("2 - Exercicio 02 Dicionario de Produtos(*)");
        System.out.println("3 - Exercicio 03 Historico de Navegacao(*)");
        System.out.println("4 - Exercicio 04 Lista de presenca");
        System.out.println("5 - Exercicio 05 Contagem de palavras");
        System.out.println("0 - Sair");
        System.out.println("*(Tem menu)");
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
                    FilaBanco.main(args);
                }
                case 2 -> {
                    DicionarioProdutos.main(args);
                }
                case 3 -> {
                    HistoricoNavegacao.main(args);
                }
                case 4 -> {
                    ListaPresenca.main(args);
                }
                case 5 -> {
                    ContagemPalavras.main(args);
                }
                
            }
            
            
        }while(opcao!=0);
        
        
    }
}
