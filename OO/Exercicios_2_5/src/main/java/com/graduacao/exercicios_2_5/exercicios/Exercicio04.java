package com.graduacao.exercicios_2_5.exercicios;

import com.graduacao.exercicios_2_5.classes.Tecnico;
import com.graduacao.exercicios_2_5.classes.Time;
import java.util.Scanner;


public class Exercicio04 {
    
    
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Tecnico t1 = criarTecnico(ler);
        Tecnico t2 = criarTecnico(ler);
        
        Time time1 = criarTime(ler);
        time1.escalonarTecnico(t1);
        
        Time time2 = criarTime(ler);
        time2.escalonarTecnico(t2);
        
        System.out.println(time1);
        System.out.println(time2);
        
        Tecnico t3 = criarTecnico(ler);
        time1.escalonarTecnico(t3);
        
        System.out.println("Apos a troca: ");
        System.out.println(time1);
        System.out.println(time2);
    }
    
    
    private static Tecnico criarTecnico(Scanner ler){
        Tecnico tecnico = new Tecnico();
        System.out.println("--- Preenchendo Tecnico ---");
        System.out.print("Informe o nome: ");
        tecnico.setNome(ler.nextLine());
        System.out.print("Informe a nacionalidade: ");
        tecnico.setNacionalidade(ler.nextLine());
        System.out.print("Informe o ano de nascimento: ");
        tecnico.setAnoNascimento(ler.nextLine());
        
        return tecnico;
    }
    private static Time criarTime(Scanner ler){
        Time time = new Time();
        System.out.println("--- Preenchendo Time ---");
        
        System.out.print("Informe o nome: ");
        time.setNome(ler.nextLine());
        System.out.print("Informe a cidade: ");
        time.setCidade(ler.nextLine());
        System.out.print("Informe o ano de fundacao: ");
        time.setAnoFundacao(ler.nextLine());
        
        return time;
    }
}
