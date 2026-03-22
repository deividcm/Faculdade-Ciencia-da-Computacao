package com.graduacao.exercicios_2_1;

import com.graduacao.exercicios_2_1.classes.Animal;
import com.graduacao.exercicios_2_1.classes.Ativo;
import com.graduacao.exercicios_2_1.classes.Casa;
import com.graduacao.exercicios_2_1.classes.Musica;

public class Exercicios_2_1 {

    public static void main(String[] args) {
        
        //exercicio05();
        
        System.out.println("=== Exercicio 08 ===");
        exercicio08();
        System.out.println("=== Exercicio 10 ===");
        exercicio10();
        System.out.println("=== Exercicio 11 ===");
        exercicio11();
    }
    
    public static void exercicio05(){
        Animal a1 = new Animal();
        
        a1.preencher();
        Animal a2 = new Animal("Lili", "Gato", "Tricolor", 6, 10);
        
        Animal a3 = new Animal(a1);
        a3.setNome("Rex");
        
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
    }
    
    public static void exercicio08(){
        Musica m1 = new Musica();
        m1.preencher();
        
        System.out.println(m1);
        m1.tocarMusica();

        m1.desligarMusica();
    }
    
    public static void exercicio10(){
        Casa c1 = new Casa("Rua das Gaivotas, 413", 200, 3, 950000);
        System.out.println("Casa 01: " + c1);
        System.out.println("Casa 02: ");
        Casa c2 = new Casa();
        c2.preencher();
        System.out.println("Casa 03: ");
        Casa c3 = new Casa();
        c3.preencher();
        
        System.out.println("--- Comparativo de Imoveis ---");
        c1.exibirResumo();
        c2.exibirResumo();
        c3.exibirResumo();
        System.out.println("---------------------------------------------------------------");
        
        Casa melhor = new Casa(c1);
        if(melhor.calcularPrecoPorM2() > c2.calcularPrecoPorM2()){
            melhor.copiar(c2);
        }
        if (melhor.calcularPrecoPorM2() > c3.calcularPrecoPorM2()){
            melhor.copiar(c3);
        }
        
        System.out.println("Melhor custo por m²: " + melhor.getEndereco() + " - R$" + melhor.calcularPrecoPorM2() + " /m²");
        
    }
    
    public static void exercicio11(){
        Ativo a1 = new Ativo();
        Ativo a2 = new Ativo();
        Ativo a3 = new Ativo();
        System.out.println("Ativo 01: ");
        a1.preencher();
        System.out.println("Ativo 02: ");
        a2.preencher();
        System.out.println("Ativo 03: ");
        a3.preencher();
        
        System.out.println("--- Resumo da Carteira ---");
        a1.exibirResumo();
        a2.exibirResumo();
        a3.exibirResumo();
        System.out.println("---------------------------------------------------------------");
        
        double soma = a1.calcularPosicaoDoAtivo()+a2.calcularPosicaoDoAtivo()+a3.calcularPosicaoDoAtivo();
        
        System.out.println("Valor total da carteira: R$" + soma);
        
        
    }
}