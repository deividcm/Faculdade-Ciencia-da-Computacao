package com.graduacao.exercicios_2_2_1.exercicios;

import com.graduacao.exercicios_2_2_1.classes.GerenciadorProdutos;
import java.util.Scanner;

public class DicionarioProdutos {
    
    public static int imprimeMenu(){
        Scanner ler = new Scanner(System.in);
        System.out.println("--------Dicionario de Produtos--------");
        System.out.println("1 - Adicionar ou Atualizar Produto");
        System.out.println("2 - Remover Produto");
        System.out.println("3 - Exibir todos os Produtos");
        System.out.println("0 - Sair");
        System.out.println("-----------------------------");
        System.out.println("Escolha uma opcao:");
        
        return ler.nextInt();
    }
    
    public static void main(String[] args) {
        int opcao = 0;
        Scanner ler = new Scanner(System.in);
        GerenciadorProdutos gerenciador = new GerenciadorProdutos();
        
        do{
            opcao = imprimeMenu();
            
            switch(opcao){
                case 1 -> {
                    System.out.println("Informe o nome do produto: ");
                    String nome = ler.next(); //Usei next pra não ter o problema do nextline
                    System.out.println("Informe o preco: ");
                    double preco = ler.nextDouble();
                    gerenciador.adicionarOuAtualizarProduto(nome, preco);
                    break;
                }
                case 2 -> {
                    System.out.println("Informe o nome do produto: ");
                    String nome = ler.next();
                    
                    gerenciador.removerProduto(nome);
                    break;
                }
                
                case 3 -> {
                    gerenciador.exibirProdutos();
                    break;
                }
            }
            
            
        }while(opcao != 0);
        
    }
    
}
