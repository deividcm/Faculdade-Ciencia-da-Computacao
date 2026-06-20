package com.graduacao.exercicios_5_3.exercicio02;

import com.graduacao.exercicios_5_3.exercicio02.classes.ProcessadorPagamentoBoleto;
import com.graduacao.exercicios_5_3.exercicio02.classes.ProcessadorPagamentoCartao;
import com.graduacao.exercicios_5_3.exercicio02.classes.ProcessadorPagamentoPix;
import com.graduacao.exercicios_5_3.exercicio02.classes.ServicoPagamento;
import com.graduacao.exercicios_5_3.exercicio02.interfaces.IProcessadorPagamento;
import java.util.Scanner;


public class Exercicio02 {
    
    public static int imprimeMenu(Scanner ler){
        System.out.println("------ Exercicio 01 ------");
        System.out.println(" 1 - Pagar por Cartao");
        System.out.println(" 2 - Pagar por Boleto");
        System.out.println(" 3 - Pagar por Pix");
        System.out.println(" 0 - Sair ");
        System.out.println("---------------------------");
        System.out.print("Opcao: ");
        return ler.nextInt();
    }
    
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int opcao;
        ServicoPagamento servico;
        IProcessadorPagamento processador;
        do{
            opcao = imprimeMenu(ler);
            ler.nextLine();
            switch(opcao){
                case 1 -> {
                    processador = new ProcessadorPagamentoCartao();
                    break;
                }
                case 2 -> {
                    processador = new ProcessadorPagamentoBoleto();
                    break;
                }
                case 3 -> {
                    processador = new ProcessadorPagamentoPix();
                    break;
                }
                case 0 -> {
                    processador = null;
                    System.out.println("Saindo...");
                    break;
                }
                default -> {
                    processador = null;
                    System.out.println("Opcao Invalida!");
                }

            }
            if(processador != null){
                String resposta;
                servico = new ServicoPagamento(processador);
                do{
                    System.out.print("Informe o valor do pagamento: ");
                    double valor = ler.nextDouble();
                    System.out.println(servico.realizarPagamento(valor));
                    
                    System.out.print("Deseja realizar outro pagamento por esse metodo? [s/n]: ");
                    resposta = ler.next();
                }while(resposta.equalsIgnoreCase("s"));
            }
            
        }while(opcao != 0);
        
    }
    
}
