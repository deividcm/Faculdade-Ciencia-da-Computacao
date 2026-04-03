package com.graduacao.roteiro01.exercicios;

import com.graduacao.roteiro01.classes.Ponto;
import com.graduacao.roteiro01.classes.Triangulo;
import java.util.Scanner;

public class Exercicio01 {
    
    private static int imprimeMenu(){
        Scanner ler = new Scanner(System.in);
        System.out.println("--------Triangulo--------");
        System.out.println("1 - Preencher Triangulo");
        System.out.println("2 - Calcular Area");
        System.out.println("3 - Calcular Perimetro");
        System.out.println("4 - Verificar Tipo");
        System.out.println("5 - Imprimir Pontos");
        System.out.println("0 - Sair");
        System.out.println("-----------------------------");
        System.out.println("Escolha uma opcao:");
        
        return ler.nextInt();
    }
    
    private static void preencher(Triangulo triangulo){
        Scanner ler = new Scanner(System.in);
        
        Ponto p1 = new Ponto();
        System.out.println("Informe o valor da componente x de p1: ");
        p1.setX(ler.nextDouble());
        System.out.println("Informe o valor da  componente y de p1: ");
        p1.setY(ler.nextDouble());
        triangulo.setP1(p1);
        
        Ponto p2 = new Ponto();
        System.out.println("Informe o valor da  componente x de p2: ");
        p2.setX(ler.nextDouble());
        System.out.println("Informe o valor da  componente y de p2: ");
        p2.setY(ler.nextDouble());
        triangulo.setP2(p2);
        
        Ponto p3 = new Ponto();
        System.out.println("Informe o valor da  componente x de p3: ");
        p3.setX(ler.nextDouble());
        System.out.println("Informe o valor da  componente y de p3: ");
        p3.setY(ler.nextDouble());
        triangulo.setP3(p3);
    }
    
    
    public static void main(String[] args) {
        Triangulo triangulo = new Triangulo();
        int opcao = 0;
        
        do{
            opcao = imprimeMenu();
            switch(opcao){
                case 1 -> {
                    preencher(triangulo);
                    
                    if(triangulo.isColinear()){
                        System.out.println("Triangulo invalido");
                    }
                    else{
                        System.out.println("Triangulo preenchido com sucesso");
                    }
                    
                    break;
                }
                case 2 -> {
                    double area = triangulo.getArea();
                    
                    if(area == 0){
                        System.out.println("Nao e um triangulo");
                    }
                    else{
                        System.out.println("Area: " + area);
                    }
                    break;
                }
                case 3 -> {
                    double perimetro = triangulo.getPerimetro();
                    
                    if(perimetro == 0){
                        System.out.println("Nao e um triangulo");
                    }
                    else{
                        System.out.println("Perimetro: " + perimetro);
                    }
                    break;
                }
                case 4 -> {
                    System.out.println("Tipo: " + triangulo.getTipo());
                    break;
                }
                case 5 -> {
                    System.out.println(triangulo.toString());
                    break;
                }
                
            }
            
        }while(opcao != 0);
        
        
    }
    
}
