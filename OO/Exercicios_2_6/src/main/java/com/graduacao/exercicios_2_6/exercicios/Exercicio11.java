package com.graduacao.exercicios_2_6.exercicios;

import com.graduacao.exercicios_2_6.classes.exercicio11.Banco;
import com.graduacao.exercicios_2_6.classes.exercicio11.Conta;
import com.graduacao.exercicios_2_6.classes.exercicio11.Transacao;
import java.util.Scanner;


public class Exercicio11 {
    
    private static int imprimeMenuBanco(Scanner ler, String nome){
        System.out.println("------------- Banco " + nome +" -------------");
        System.out.println("01 - Adicionar Conta");
        System.out.println("02 - Remover Conta");
        System.out.println("03 - Pesquisar e Gerenciar Conta");
        System.out.println("04 - Imprimir Conta com Maior Saldo");
        System.out.println("05 - Imprimir Conta com Menor Saldo");
        System.out.println("06 - Listar Contas");
        System.out.println("07 - Listar Devedores");
        System.out.println("08 - Listar Credores");
        System.out.println("09 - Listar Transacoes");
        System.out.println("10 - Imprimir Banco");
        System.out.println("00 - Sair");
        System.out.println("---------------------------------------------------");
        return ler.nextInt();
    }
    private static int imprimeMenuConta(Scanner ler, String titular){
        System.out.println("------------- Conta " + titular +" -------------");
        System.out.println("01 - Verificar Saldo");
        System.out.println("02 - Fazer Deposito");
        System.out.println("03 - Fazer Saque");
        System.out.println("04 - Fazer Transferencia");
        System.out.println("05 - Imprimir Conta");
        System.out.println("00 - Voltar");
        System.out.println("---------------------------------------------------");
        return ler.nextInt();
    }
    
    private static void menuConta(Scanner ler, Conta conta, Banco banco){
        int opcao;
        
        do{
            opcao = imprimeMenuConta(ler, conta.getTitular());
            ler.nextLine();
            
            switch(opcao){
                case 0 -> {
                    System.out.println("Voltando...");
                    break;
                }
                case 1 -> {
                    System.out.println("Saldo: R$" + conta.getSaldo());
                    break;
                }
                case 2 -> {
                    System.out.print("Informe o valor: ");
                    double valor = ler.nextDouble();
                    ler.nextLine();
                    if(conta.depositar(valor)){
                        Transacao transacao = new Transacao();
                        transacao.setID("D" + (banco.getGerenteTransacoes().size() + 413));
                        transacao.setTipo("Deposito");
                        System.out.print("Informe a data de hoje: ");
                        transacao.setData(ler.nextLine());
                        transacao.setValor(valor);
                        transacao.setContaAssociada(conta);
                        banco.getGerenteTransacoes().put(transacao);
                        System.out.println(transacao.toString());
                    }
                    else{
                        System.out.println("Valor invalido!");
                    }
                    break;
                }
                case 3 -> {
                    System.out.print("Informe o valor: ");
                    double valor = ler.nextDouble();
                    ler.nextLine();
                    if(conta.sacar(valor) != 0){
                        Transacao transacao = new Transacao();
                        transacao.setID("S" + (banco.getGerenteTransacoes().size() + 612));
                        transacao.setTipo("Saque");
                        System.out.print("Informe a data de hoje: ");
                        transacao.setData(ler.nextLine());
                        transacao.setValor(valor);
                        transacao.setContaAssociada(conta);
                        banco.getGerenteTransacoes().put(transacao);
                        System.out.println(transacao.toString());
                    }
                    else{
                        System.out.println("Valor invalido!");
                    }
                    break;
                }
                case 4 -> {
                    System.out.print("Informe o numero da conta recebedora: ");
                    Conta recebedora = banco.getGerenteContas().get(ler.nextLine());
                    
                    if(recebedora != null){
                        System.out.print("Informe o valor: ");
                        double valor = ler.nextDouble();
                        ler.nextLine();
                        if(conta.sacar(valor) != 0){
                            recebedora.depositar(valor);
                            Transacao transacao = new Transacao();
                            transacao.setID("T" + (banco.getGerenteTransacoes().size() + 1025));
                            transacao.setTipo("Transferencia");
                            System.out.print("Informe a data de hoje: ");
                            transacao.setData(ler.nextLine());
                            transacao.setValor(valor);
                            transacao.setContaAssociada(conta);
                            transacao.setContaRecebedora(recebedora);
                            banco.getGerenteTransacoes().put(transacao);
                            System.out.println(transacao.toString());
                        }
                        else{
                            System.out.println("Valor invalido!");
                        }
                    }
                    else{
                        System.out.println("Conta nao encontrada!");
                    }
                    break;
                }
                case 5 -> {
                    System.out.println(conta.toString());
                    break;
                }
                
                default -> {
                    System.out.println("Opcao invalida!");
                }
            }
            
        }while(opcao != 0);
    }
    
    private static void menuBanco(Scanner ler, Banco banco){
        int opcao;
        
        do{
            opcao = imprimeMenuBanco(ler, banco.getNome());
            ler.nextLine();
            
            switch(opcao){
                case 0 -> {
                    System.out.println("Saindo...");
                    break;
                }
                case 1 -> {
                    Conta conta = criarPreenchendoConta(ler);
                    if(banco.getGerenteContas().containsKey(conta.getNumConta())){
                        System.out.println("Ja existe uma conta com este numero!");
                    }else{
                        banco.getGerenteContas().put(conta);
                        System.out.println("Conta adicionada!");
                    }
                    break;
                }
                case 2 -> {
                    System.out.print("Informe o numero da conta: ");
                    String numConta = ler.nextLine();
                    Conta conta = banco.getGerenteContas().remove(numConta);
                    if(conta != null){
                        System.out.println("Conta removida com sucesso!");
                    }
                    else{
                        System.out.println("Conta nao encontrada!");
                    }
                    break;
                }
                case 3 -> {
                    System.out.print("Informe o numero da conta: ");
                    String numConta = ler.nextLine();
                    
                    Conta conta = banco.getGerenteContas().get(numConta);
                    if(conta != null){
                        menuConta(ler,conta,banco);
                    }
                    else{
                        System.out.println("Conta nao encontrada!");
                    }
                    break;
                }
                case 4 -> {
                    Conta conta = banco.getMaiorSaldo();
                    System.out.println(conta.toString());
                    break;
                }
                case 5 -> {
                    Conta conta = banco.getMenorSaldo();
                    System.out.println(conta.toString());
                    break;
                }
                case 6 -> {
                    System.out.println(banco.toStringContas());
                    break;
                }
                case 7 -> {
                    System.out.println(banco.toStringDevedores());
                    break;
                }
                case 8 -> {
                    System.out.println(banco.toStringCredores());
                    break;
                }
                case 9 -> {
                    System.out.println(banco.toStringTransacoes());
                    break;
                }
                case 10 -> {
                    System.out.println(banco.toString());
                    break;
                }
                
                default -> {
                    System.out.println("Opcao invalida!");
                }
            }
            
        }while(opcao != 0);
    }
    
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Banco banco = new Banco();
        System.out.print("Informe o nome do Banco: ");
        banco.setNome(ler.nextLine());
        
        menuBanco(ler, banco);
    }
    
    private static Conta criarPreenchendoConta(Scanner ler){
        Conta conta = new Conta();
        System.out.println("--- Preenchendo Conta ---");
        System.out.print("Informe o numero da conta: ");
        conta.setNumConta(ler.nextLine());
        System.out.print("Informe o nome do titular: ");
        conta.setTitular(ler.nextLine());
        return conta;
    }
    
}
