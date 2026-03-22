package com.graduacao.exercicios_2_2_1;

import com.graduacao.exercicios_2_2_1.exercicios.ContagemPalavras;
import com.graduacao.exercicios_2_2_1.exercicios.DicionarioProdutos;
import com.graduacao.exercicios_2_2_1.exercicios.FilaBanco;
import com.graduacao.exercicios_2_2_1.exercicios.FrequenciaCaracteres;
import com.graduacao.exercicios_2_2_1.exercicios.HistoricoNavegacao;
import com.graduacao.exercicios_2_2_1.exercicios.InverterDicionario;
import com.graduacao.exercicios_2_2_1.exercicios.ListaPresenca;
import com.graduacao.exercicios_2_2_1.exercicios.PontuacaoJogadores;
import java.util.Scanner;


public class Exercicios_2_2_1 {

    public static int imprimeMenu(){
        Scanner ler = new Scanner(System.in);
        System.out.println("--------Exercicios2.2.1--------");
        System.out.println("1 - Exercicio 01 Fila de Banco");
        System.out.println("2 - Exercicio 02 Dicionario de Produtos(*)");
        System.out.println("3 - Exercicio 03 Historico de Navegacao(*)");
        System.out.println("4 - Exercicio 04 Lista de presenca");
        System.out.println("5 - Exercicio 05 Pontuacao de jogadores");
        System.out.println("6 - Exercicio 06 Contagem de palavras");
        System.out.println("7 - Exercicio 07 Frequencia de caracteres");
        System.out.println("8 - Exercicio 08 Inverter Dicionario");
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
                    break;
                }
                case 2 -> {
                    DicionarioProdutos.main(args);
                    break;
                }
                case 3 -> {
                    HistoricoNavegacao.main(args);
                    break;
                }
                case 4 -> {
                    ListaPresenca.main(args);
                    break;
                }
                case 5 -> {
                    PontuacaoJogadores.main(args);
                    break;
                }
                case 6 -> {
                    ContagemPalavras.main(args);
                    break;
                }
                case 7 -> {
                    FrequenciaCaracteres.main(args);
                    break;
                }
                case 8 -> {
                    InverterDicionario.main(args);
                    break;
                }
                
            }
            
            
        }while(opcao!=0);
        
        
    }
}
