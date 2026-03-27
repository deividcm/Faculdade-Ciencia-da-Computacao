
package com.graduacao.exercicios_2_3;

import com.graduacao.exercicios_2_3.projetos.ProjetoAgendaContatos;
import com.graduacao.exercicios_2_3.projetos.ProjetoCadFilme;
import com.graduacao.exercicios_2_3.projetos.ProjetoCadMusica;
import com.graduacao.exercicios_2_3.projetos.ProjetoCadReserva;
import com.graduacao.exercicios_2_3.projetos.ProjetoEstoqueProdutos;
import java.util.Scanner;


public class Exercicios_2_3 {
    
     public static int imprimeMenu(){
        Scanner ler = new Scanner(System.in);
        System.out.println("--------Exercicios2.3--------");
        System.out.println("1 - Exercicio 01 Cadastro de Reservas");
        System.out.println("2 - Exercicio 02 Cadastro de Musicas");
        System.out.println("3 - Exercicio 03 Cadastro de Filmes");
        System.out.println("4 - Exercicio 04 Agenda de Contatos");
        System.out.println("5 - Exercicio 05 e 06 Estoque de Produtos");
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
                    break;
                }
                case 2 -> {
                    ProjetoCadMusica.main(args);
                    break;
                }
                case 3 -> {
                    ProjetoCadFilme.main(args);
                    break;
                }
                case 4 -> {
                    ProjetoAgendaContatos.main(args);
                    break;
                }
                case 5 -> {
                    ProjetoEstoqueProdutos.main(args);
                }
            }
            
            
            
        }while(opcao !=0);
        
    }
}
