package com.graduacao.exercicios_2_5.exercicios;

import com.graduacao.exercicios_2_5.classes.Carro;
import com.graduacao.exercicios_2_5.classes.Motorista;
import java.util.Scanner;


public class Exercicio00 {
    
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Motorista motorista = criarPreenchendoMotorista(ler);
        
        System.out.println(motorista);
        
        motorista.dirigir();
    }
    
    private static Motorista criarPreenchendoMotorista(Scanner ler){
        Motorista m = new Motorista();
        System.out.println("--- Preenchendo o Motorista ---");
        
        System.out.print("Informe o nome: ");
        m.setNome(ler.next());
        
        Carro c = criarPreenchendoCarro(ler);
        
        m.setCarro(c);
        
        return m;
        
    }
    private static Carro criarPreenchendoCarro(Scanner ler){
        Carro c = new Carro();
        System.out.println("--- Preenchendo o Carro ---");
        
        System.out.print("Informe o modelo: ");
        c.setModelo(ler.next());
        
        System.out.print("Informe a cor: ");
        c.setCor(ler.next());
        
        System.out.print("Informe o ano de fabricacao: ");
        c.setAno(ler.nextInt());
        
        return c;
    }
}
