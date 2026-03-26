
package com.graduacao.exercicios_2_3.classes;

import java.util.HashMap;
import java.util.Map;


public class ControleDeEstoque {
    private final Map<String, Produto> estoque;
    
    public ControleDeEstoque(){
        estoque = new HashMap<>();
    }
    
    public void adicionarProduto(Produto produto){
        estoque.put(produto.getCodigo(), produto);
    }
    
    public boolean removerProduto(String codigo){
        if(estoque.containsKey(codigo)){
            estoque.remove(codigo);
            return true;
        }
        
        return false;
    }
    
    public boolean atualizarQuantidade(String codigo, int novaQuantidade){
        if(estoque.containsKey(codigo)){
            Produto p = estoque.get(codigo);
            p.setQuantidadeEmEstoque(novaQuantidade);
            return true;
        }
        return false;
    }
    
    public void listarProdutos(){
        System.out.println("---- Produtos ----");
        for(Produto produto : estoque.values()){
            System.out.println(produto);
        }
    }
    
    public Produto buscarProduto(String codigo){
        return estoque.getOrDefault(codigo, null);
    }
    
}
