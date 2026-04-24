package com.graduacao.roteiro02;

import com.graduacao.roteiro02.classes.Aeroporto;
import com.graduacao.roteiro02.classes.Passageiro;
import com.graduacao.roteiro02.classes.Voo;
import java.util.Scanner;


public class Roteiro02 {
    
    private static int imprimeMenuAeroporto(Scanner ler, String nome){
        System.out.println("--------- Aeroporto " + nome + " ---------");
        System.out.println("01 - Adicionar Voo");
        System.out.println("02 - Adicionar Passageiro");
        System.out.println("03 - Remover Voo");
        System.out.println("04 - Remover Passageiro");
        System.out.println("05 - Pesquisar e Gerenciar Voo");
        System.out.println("06 - Pesquisar e Gerenciar Passageiro"); 
        System.out.println("07 - Iniciar Voo");
        System.out.println("08 - Concluir Voo");
        System.out.println("09 - Listar Voos");
        System.out.println("10 - Listar Voos com Prejuizo");
        System.out.println("11 - Listar Passageiros");
        System.out.println("12 - Imprimir Aeroporto");
        System.out.println("00 - Sair");
        System.out.println("-----------------------------------------");
        
        return ler.nextInt();
    }
    
    private static int imprimeMenuVoo(Scanner ler, String numVoo){
        System.out.println("---------- Voo " + numVoo + " ----------");
        System.out.println("01 - Adicionar Passageiro");
        System.out.println("02 - Remover Passageiro");
        System.out.println("03 - Pesquisar e Imprimir Passageiro"); 
        System.out.println("04 - Imprimir Voo");
        System.out.println("05 - Listar Passageiros");
        System.out.println("00 - Voltar");
        System.out.println("-----------------------------------------");
        
        return ler.nextInt();
    }
    
    private static int imprimeMenuPassageiro(Scanner ler, String nome){
        System.out.println("--------- Passageiro " + nome + " ---------");
        System.out.println("01 - Verificar Pontos");
        System.out.println("02 - Resgatar Pontos");
        System.out.println("03 - Imprimir Passageiro");
        System.out.println("00 - Voltar");
        System.out.println("-----------------------------------------");
        
        return ler.nextInt();
    }
    

    private static void menuPassageiro(Scanner ler, Passageiro passageiro){
        int opcao;
        
        do{
            opcao = imprimeMenuPassageiro(ler, passageiro.getNome());
            
            switch(opcao){
                case 0 ->{
                    System.out.println("Voltando...");
                    break;
                }
                case 1 -> {
                    System.out.println(passageiro.getSistemaFidelidade().getSaldoPontos() + " pontos.");
                    break;
                }
                case 2 -> {
                    System.out.print("Informe quantos pontos deseja resgatar: ");
                    int pontos = ler.nextInt();
                    ler.nextLine();
                    
                    if(passageiro.getSistemaFidelidade().resgatarPontos(pontos)){
                        System.out.println(pontos + " pontos resgatados com sucesso!");
                    }else{
                        System.out.println("Nao foi possivel resgatar os pontos, quantidade invalida!");
                    }
                    break;
                }
                case 3 -> {
                    System.out.println(passageiro.toString());
                    break;
                }
                
                default -> {
                    System.out.println("Opcao invalida!");
                }
            }
            
        }while(opcao != 0);
    }
    
    private static void menuVoo(Scanner ler, Voo voo, Aeroporto aeroporto){
        int opcao;
        
        do{
            opcao = imprimeMenuVoo(ler, voo.getNumVoo());
            ler.nextLine();
            switch(opcao){
                case 0 -> {
                    System.out.println("Voltando..");
                    break;
                }
                case 1 -> {
                    System.out.print("Informe o CPF: ");
                    String CPF = ler.nextLine();
                    Passageiro passageiro = aeroporto.getGerenciadorPassageiros().get(CPF);
                    
                    if(passageiro == null){
                        System.out.println("Passageiro nao encontrado!");
                    }else if(!passageiro.isEmbarcado()){
                        voo.put(passageiro);
                        passageiro.setEmbarcado(true);
                        System.out.println("Passageiro embarcado!");
                    }else{
                        System.out.println("Passageiro ja esta embarcado em um Voo!");
                    }
                    break;
                }
                case 2 -> {
                    System.out.print("Informe o CPF: ");
                    String CPF = ler.nextLine();
                    Passageiro passageiro = voo.getGerenciadorPassageiros().remove(CPF);
                    if(passageiro != null){
                        passageiro.setEmbarcado(false);
                        System.out.println("Passageiro removido!");
                    }else{
                        System.out.println("Passageiro nao encontrado!");
                    }
                    break;
                }
                case 3 -> {
                    System.out.print("Informe o CPF: ");
                    String CPF = ler.nextLine();
                    Passageiro passageiro = voo.getGerenciadorPassageiros().get(CPF);
                    if(passageiro != null){
                        System.out.println(passageiro.toString());
                    }
                    else{
                        System.out.println("Passageiro nao encontrado!");
                    }
                    break;
                }
                case 4 -> {
                    System.out.println(voo.toString());
                    break;
                }
                case 5 -> {
                    System.out.println("--- Passageiros("+ voo.getGerenciadorPassageiros().size() + ") ---\n ");
                    System.out.println(voo.getGerenciadorPassageiros().toString());
                    break;
                }
                
                default -> {
                    System.out.println("Opcao invalida!");
                }
            }
            
        }while(opcao != 0);
    }
    
    private static void menuAeroporto(Scanner ler, Aeroporto aeroporto){
        int opcao;
        
        do{
            opcao = imprimeMenuAeroporto(ler, aeroporto.getNome());
            ler.nextLine();
            switch(opcao){
                case 0 -> {
                    System.out.println("Saindo...");
                    break;
                }
                case 1 -> {
                    Voo voo = criarPreenchendoVoo(ler);
                    
                    if(aeroporto.getGerenciadorVoos().containsKey(voo.getNumVoo())){
                        System.out.println("Ja existe um voo com este numero!");
                    }else{
                        aeroporto.getGerenciadorVoos().put(voo);
                        System.out.println("Voo adicionado!");
                    }
                    break;
                }
                case 2 -> {
                    Passageiro passageiro = criarPreenchendoPassageiro(ler);
                    
                    if(aeroporto.getGerenciadorPassageiros().containsKey(passageiro.getCPF())){
                        System.out.println("Ja existe um passageiro com este CPF!");
                    }else{
                        aeroporto.getGerenciadorPassageiros().put(passageiro);
                        System.out.println("Passageiro adicionado!");
                    }
                    break;
                }
                case 3 -> {
                    System.out.print("Informe o numero do voo: ");
                    String numVoo = ler.nextLine();
                    Voo voo = aeroporto.getGerenciadorVoos().remove(numVoo);
                    if(voo != null){
                        System.out.println("Voo removido com sucesso!");
                    }
                    else{
                        System.out.println("Voo nao encontrado!");
                    }
                    break;
                }
                case 4 -> {
                    System.out.print("Informe o CPF: ");
                    String CPF = ler.nextLine();
                    
                    if(aeroporto.getGerenciadorPassageiros().remove(CPF) != null){
                        System.out.println("Passageiro removido com sucesso!");
                    }
                    else{
                        System.out.println("Passageiro nao encontrado!");
                    }
                    break;
                }
                case 5 -> {
                    System.out.print("Informe o numero do voo: ");
                    String numVoo = ler.nextLine();
                    Voo voo = aeroporto.getGerenciadorVoos().get(numVoo);
                    
                    if(voo != null){
                        menuVoo(ler,voo,aeroporto);
                    }else{
                        System.out.println("Voo nao encontrado!");
                    }
                    break;
                }
                case 6 -> {
                    System.out.print("Informe o CPF: ");
                    String CPF = ler.nextLine();
                    Passageiro passageiro = aeroporto.getGerenciadorPassageiros().get(CPF);
                    
                    if(passageiro != null){
                        menuPassageiro(ler, passageiro);
                    }else{
                        System.out.println("Passageiro nao encontrado!");
                    }
                    
                    break;
                }
                case 7 -> {
                    System.out.print("Informe o numero do voo: ");
                    String numVoo = ler.nextLine();
                    if(aeroporto.getGerenciadorVoos().get(numVoo).getEstadoVoo().equalsIgnoreCase("aguardando decolagem")){
                        System.out.println(aeroporto.iniciarVoo(numVoo));
                    }else{
                        System.out.println("Voo nao pode ser inciado!");
                    }
                    break;
                }
                case 8 -> {
                    System.out.print("Informe o numero do voo: ");
                    String numVoo = ler.nextLine();
                    if(aeroporto.getGerenciadorVoos().get(numVoo).getEstadoVoo().equalsIgnoreCase("voando")){
                        System.out.println(aeroporto.concluirVoo(numVoo));
                    }else{
                        System.out.println("Voo nao pode ser concluido!");
                    }
                    break;
                }
                
                case 9 -> {
                    System.out.println(aeroporto.toStringVoos());
                    break;
                }
                case 10 -> {
                    System.out.println(aeroporto.toStringPrejuizo());
                    break;
                }
                case 11 -> {
                    System.out.println(aeroporto.toStringPassageiros());
                    break;
                }
                case 12 -> {
                    System.out.println(aeroporto.toString());
                    break;
                }
                
                default ->{
                    System.out.println("Opcao invalida!");
                }
            }
            
        }while(opcao != 0);
    }
    
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Aeroporto aeroporto = new Aeroporto();
        System.out.print("Informe o nome do Aeroporto: ");
        aeroporto.setNome(ler.nextLine());
        System.out.print("Informe a localizacao do Aeroporto: ");
        aeroporto.setLocalizacao(ler.nextLine());
        
        menuAeroporto(ler,aeroporto);
    }
    
    
    private static Voo criarPreenchendoVoo(Scanner ler){
        Voo voo = new Voo();
        System.out.println("--- Preenchendo Voo ---");
        System.out.print("Informe o numero do Voo: ");
        voo.setNumVoo(ler.nextLine());
        System.out.print("Informe o destino do Voo: ");
        voo.setDestino(ler.nextLine());
        String resposta;
        do{
            System.out.print("Informe a proxima escala: ");
            String escala = ler.nextLine();
            
            voo.addEscala(escala);
            
            System.out.print("Deseja adicionar mais uma escala? [s/n]: ");
            resposta = ler.nextLine();
            
        }while(resposta.equalsIgnoreCase("s"));
        
        System.out.print("Informe a capacidade maxima de passageiros: ");
        voo.setCapacidadeMaxima(ler.nextInt());
        ler.nextLine();
        
        return voo;
    }
    
    private static Passageiro criarPreenchendoPassageiro(Scanner ler){
        Passageiro passageiro = new Passageiro();
        System.out.println("--- Preenchendo Passageiro ---");
        System.out.print("Informe o nome: ");
        passageiro.setNome(ler.nextLine());
        System.out.print("Informe o CPF: ");
        passageiro.setCPF(ler.nextLine());
        
        return passageiro;
    }
    
}
