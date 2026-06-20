package com.graduacao.exercicios_5_3.exercicio01;

import com.graduacao.exercicios_5_3.exercicio01.classes.EnviadorEMAIL;
import com.graduacao.exercicios_5_3.exercicio01.classes.EnviadorSMS;
import com.graduacao.exercicios_5_3.exercicio01.classes.EnviadorTelegram;
import com.graduacao.exercicios_5_3.exercicio01.classes.ProcessadorMensagem;
import com.graduacao.exercicios_5_3.exercicio01.interfaces.IEnviadorMensagem;
import java.util.Scanner;


public class Exercicio01 {
    public static int imprimeMenu(Scanner ler){
        System.out.println("------ Exercicio 01 ------");
        System.out.println(" 1 - Enviar por SMS");
        System.out.println(" 2 - Enviar por EMAIL");
        System.out.println(" 3 - Enviar por Telegram");
        System.out.println(" 0 - Sair ");
        System.out.println("---------------------------");
        System.out.print("Opcao: ");
        return ler.nextInt();
    }
    
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int opcao;
        ProcessadorMensagem processador;
        IEnviadorMensagem enviador;
        do{
            opcao = imprimeMenu(ler);
            ler.nextLine();
            switch(opcao){
                case 1 -> {
                    enviador = new EnviadorSMS();
                    break;
                }
                case 2 -> {
                    enviador = new EnviadorEMAIL();
                    break;
                }
                case 3 -> {
                    enviador = new EnviadorTelegram();
                    break;
                }
                case 0 -> {
                    enviador = null;
                    System.out.println("Saindo...");
                    break;
                }
                default -> {
                    enviador = null;
                    System.out.println("Opcao Invalida!");
                }
            }
            if(enviador != null){
                String resposta;
                processador = new ProcessadorMensagem(enviador);
                do{
                    System.out.print("Informe a mensagem a ser enviada: ");
                    String mensagem = ler.nextLine();
                    processador.processar(mensagem);
                    
                    System.out.print("Deseja enviar outra mensagem por esse enviador? [s/n]: ");
                    resposta = ler.nextLine();
                }while(resposta.equalsIgnoreCase("s"));
            }
            
        }while(opcao != 0);
        
    }
}
