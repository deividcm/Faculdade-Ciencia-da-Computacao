package com.graduacao.exercicios_2_3.projetos;

import com.graduacao.exercicios_2_3.classes.ControleDeEstoque;
import com.graduacao.exercicios_2_3.classes.Produto;
import java.util.Scanner;

public class ProjetoEstoqueProdutos {
    
    private static int imprimeMenu(){
        Scanner ler = new Scanner(System.in);

        System.out.println("--------Estoque de Produtos--------");
        System.out.println("1 - Adicionar Produto");
        System.out.println("2 - Remover Produto");
        System.out.println("3 - Atualizar Quantidade");
        System.out.println("4 - Pesquisar Produto");
        System.out.println("5 - Imprimir Produtos");
        System.out.println("0 - Sair");
        System.out.println("-----------------------------------");
        System.out.println("Escolha uma opcao:");
        
        return ler.nextInt();
    }
    
    public static void main(String[] args) {
        int opcao = 0;
        Scanner ler = new Scanner(System.in);
        ControleDeEstoque controle = new ControleDeEstoque();
        do{
            opcao = imprimeMenu();
            switch(opcao){
                case 1 -> {
                    Produto produto = new Produto();
                    produto.preencher();
                    controle.adicionarProduto(produto);
                    System.out.println("Produto adicionado com sucesso!");
                    break;
                }
                case 2 -> {
                    System.out.println("Informe o codigo: ");
                    String codigo = ler.next();
                    if(controle.removerProduto(codigo)){
                        System.out.println("Produto removido com sucesso! ");
                    }
                    else{
                        System.out.println("Produto nao encontrado");
                    }
                    break;
                }
                
                case 3 -> {
                    System.out.println("Informe o codigo: ");
                    String codigo = ler.next();
                    System.out.println("Informe a nova quantidade: ");
                    int novaQuantidade = ler.nextInt();
                    if(controle.atualizarQuantidade(codigo, novaQuantidade)){
                        System.out.println("Produto atualizado com sucesso!");
                    }else{
                        System.out.println("Produto nao encontrado");
                    }
                    
                }
                
                case 4 -> {
                    System.out.println("Informe o codigo: ");
                    String codigo = ler.next();
                    
                    Produto produto = controle.buscarProduto(codigo);
                    if(produto != null){
                        System.out.println(produto);
                    }
                    else{
                        System.out.println("Produto nao encontrado");
                    }
                }
                
                case 5 -> {
                    controle.listarProdutos();
                }
            }
            
            
        }while(opcao !=0);
        
    }
    
}
