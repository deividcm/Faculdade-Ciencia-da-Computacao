
package com.graduacao.exercicios_2_5.exercicios;

import com.graduacao.exercicios_2_5.classes.Pedido;
import com.graduacao.exercicios_2_5.classes.Produto;
import java.util.Scanner;


public class Exercicio01 {
    
    
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        
        Pedido pedido1 = criarPreenchendoPedido(ler);
        
        System.out.println(pedido1);
        System.out.println("Preco total: " + pedido1.calcularPrecoTotal());
    }
    
    private static Pedido criarPreenchendoPedido(Scanner ler){
        Pedido p = new Pedido();
        System.out.println("--- Preenchendo o Pedido ---");
        System.out.print("Informe o numero: ");
        p.setNumero(ler.next());
        System.out.print("Informe a data(dd/mm/aaaa): ");
        p.setData(ler.next());
        System.out.print("Informe a quantidade: ");
        p.setQuantidade(ler.nextInt());
        
        Produto produto = criarPreenchendoProduto(ler);
        
        p.setProduto(produto);
        
        return p;
    }
    
    private static Produto criarPreenchendoProduto(Scanner ler){
        System.out.println("--- Preenchendo o Produto ---");
        Produto p = new Produto();
        System.out.print("Informe o nome: ");
        p.setNome(ler.next());
        System.out.print("Informe a categoria: ");
        p.setCategoria(ler.next());
        System.out.print("Informe o preco: ");
        p.setPreco(ler.nextDouble());
        
        return p;
    }
    
}
