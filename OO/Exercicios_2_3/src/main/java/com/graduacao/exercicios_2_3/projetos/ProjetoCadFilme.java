package com.graduacao.exercicios_2_3.projetos;

import com.graduacao.exercicios_2_3.classes.Filme;
import com.graduacao.exercicios_2_3.classes.GerenciadorFilmes;
import java.util.Scanner;


public class ProjetoCadFilme {
    public static int imprimeMenu(){
        Scanner ler = new Scanner(System.in);

        System.out.println("--------ProjetoCadFilme--------");
        System.out.println("1 - Inserir Filme");
        System.out.println("2 - Remover Filme");
        System.out.println("3 - Pesquisar Filme (titulo)");
        System.out.println("4 - Pesquisar Filme (diretor)");
        System.out.println("0 - Sair");
        System.out.println("-------------------------------");
        System.out.println("Escolha uma opcao:");
        
        return ler.nextInt();
    }
    
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int opcao = 0;
        GerenciadorFilmes gerenciador = new GerenciadorFilmes();
        
        do{
            opcao = imprimeMenu();
            
            switch(opcao){
                case 1 -> {
                    Filme filme = new Filme();
                    filme.preencher();
                    
                    gerenciador.adicionarFilme(filme);
                }
                case 2 -> {
                    System.out.println("Informe o titulo: ");
                    String titulo = ler.nextLine();
                    
                    gerenciador.removerFilme(titulo);
                }
                case 3 -> {
                   System.out.println("Informe o titulo: ");
                   String titulo = ler.nextLine(); 
                   
                   Filme filme = gerenciador.pesquisarFilmeTitulo(titulo);
                   
                   System.out.println(filme);
                }
                case 4 -> {
                   System.out.println("Informe o diretor: ");
                   String diretor = ler.nextLine(); 
                   
                   Filme filme = gerenciador.pesquisarFilmeDiretor(diretor);
                   
                   System.out.println(filme);
                }
                
                
            }
            
        }while(opcao !=0);
    }
    
}
