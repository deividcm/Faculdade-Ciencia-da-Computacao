package com.graduacao.roteiro01.exercicios;

import com.graduacao.roteiro01.classes.Ponto;
import com.graduacao.roteiro01.classes.Quadrado;
import java.util.Scanner;


public class Exercicio02 {
    
    private static int imprimeMenu(){
        Scanner ler = new Scanner(System.in);
        System.out.println("--------Quadrado--------");
        System.out.println("1 - Preencher Quadrado");
        System.out.println("2 - Calcular Area");
        System.out.println("3 - Calcular Perimetro");
        System.out.println("4 - Imprimir Pontos");
        System.out.println("0 - Sair");
        System.out.println("-----------------------------");
        System.out.println("Escolha uma opcao:");
        
        return ler.nextInt();
    }
    
    private static void preencher(Quadrado quadrado){
        Scanner ler = new Scanner(System.in);
        
        Ponto p1 = new Ponto();
        System.out.println("Informe o valor da componente x de p1: ");
        p1.setX(ler.nextDouble());
        System.out.println("Informe o valor da  componente y de p1: ");
        p1.setY(ler.nextDouble());
        quadrado.setP1(p1);
        
        Ponto p2 = new Ponto();
        System.out.println("Informe o valor da  componente x de p2: ");
        p2.setX(ler.nextDouble());
        System.out.println("Informe o valor da  componente y de p2: ");
        p2.setY(ler.nextDouble());
        quadrado.setP2(p2);
        
        Ponto p3 = new Ponto();
        System.out.println("Informe o valor da  componente x de p3: ");
        p3.setX(ler.nextDouble());
        System.out.println("Informe o valor da  componente y de p3: ");
        p3.setY(ler.nextDouble());
        quadrado.setP3(p3);
        
        Ponto p4 = new Ponto();
        System.out.println("Informe o valor da  componente x de p4: ");
        p4.setX(ler.nextDouble());
        System.out.println("Informe o valor da  componente y de p4: ");
        p4.setY(ler.nextDouble());
        quadrado.setP3(p4);
    }
    
    
    public static void main(String[] args) {
        int opcao = 0;
        Quadrado quadrado = new Quadrado();
        
        do{
            opcao = imprimeMenu();
            switch(opcao){
                case 1 -> {
                    preencher(quadrado);
                    if(quadrado.ehQuadrado()){
                        System.out.println("Quadrado preenchido com sucesso");
                    }
                    else{
                        System.out.println("Quadrado invalido");
                    }
                    
                    break;
                }
                
                case 2 -> {
                    double area = quadrado.area();
                    
                    if(area == 0){
                        System.out.println("Nao e um quadrado");
                    }
                    else{
                        System.out.println("Area: " + area);
                    }
                    break;
                }
                
                case 3 -> {
                    double perimetro = quadrado.perimetro();
                    
                    if (perimetro == 0){
                        System.out.println("Nao e um quadrado");
                    }
                    else{
                        System.out.println("Perimetro: " +  perimetro);
                    }
                    break;
                }
                
                case 4 -> {
                    System.out.println(quadrado.toString());
                    break;
                }
                
            }
            
            
            
        }while(opcao != 0);
        
    }
}
