package com.graduacao.exercicios_2_2_1.classes;

import java.util.HashMap;
import java.util.Map;

public class GerenciadorProdutos {
    private Map<String, Double> produtos;
    
    public GerenciadorProdutos(){
        produtos = new HashMap<>();
    }
    
    public void adicionarOuAtualizarProduto(String nome, double preco){
        produtos.put(nome, preco);
    }
    
    public void exibirProdutos(){
        System.out.println("--- Produtos ---");
        for(Map.Entry<String, Double> produto: produtos.entrySet()){
            System.out.println(produto.getKey() + ": R$" + produto.getValue());
        }
    }
    
    public void removerProduto(String nome){
        if(produtos.containsKey(nome)){
            produtos.remove(nome);
            System.out.println("Produto removido com sucesso!");
        }
        else{
            System.out.println("Produto nao encontrado");
        }
        
    }
    
    
}
