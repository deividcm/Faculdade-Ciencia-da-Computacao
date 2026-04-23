package com.graduacao.exercicios_2_6.exercicios;

import com.graduacao.exercicios_2_6.classes.Empresa;
import com.graduacao.exercicios_2_6.classes.Funcionario;
import com.graduacao.exercicios_2_6.classes.Projeto;
import java.util.Scanner;


public class Exercicio12 {
    
    private static int imprimeMenuEmpresa(Scanner ler, String nome){
        System.out.println("------------- Empresa " + nome +" -------------");
        System.out.println("01 - Adicionar Funcionario");
        System.out.println("02 - Adicionar Projeto");
        System.out.println("03 - Remover Funcionario");
        System.out.println("04 - Remover Projeto");
        System.out.println("05 - Imprimir Funcionario Mais Produtivo");
        System.out.println("06 - Imprimir Funcionario Menos Produtivo");
        System.out.println("07 - Pesquisar Funcionario");
        System.out.println("08 - Pesquisar Projeto");
        System.out.println("09 - Listar Funcionarios");
        System.out.println("10 - Listar Projetos");
        System.out.println("00 - Sair");
        System.out.println("---------------------------------------------------");

        return ler.nextInt();
    }
    private static int imprimeMenuFuncionario(Scanner ler, String nome){
        System.out.println("------------- Funcionario " + nome +" -------------");
        System.out.println("01 - Adicionar Projeto");
        System.out.println("02 - Remover Projeto");
        System.out.println("03 - Pesquisar e Imprimir Projeto");
        System.out.println("04 - Listar Projetos");
        System.out.println("00 - Voltar");
        System.out.println("---------------------------------------------------");

        return ler.nextInt();
    }
    private static int imprimeMenuProjeto(Scanner ler, String nome){
        System.out.println("------------- Projeto " + nome +" -------------");
        System.out.println("01 - Alocar Funcionario");
        System.out.println("02 - Remover Funcionario");
        System.out.println("03 - Pesquisar e Imprimir Funcionario");
        System.out.println("04 - Listar Funcionarios");
        System.out.println("00 - Voltar");
        System.out.println("---------------------------------------------------");

        return ler.nextInt();
    }
    
    private static void menuFuncionario(Scanner ler, Funcionario funcionario, Empresa empresa){
        int opcao;
        
        do{
            opcao = imprimeMenuFuncionario(ler, funcionario.getNome());
            ler.nextLine();
            
            switch(opcao){
                case 0 -> {
                    System.out.println("Voltando...");
                    break;
                }
                case 1 -> {
                    System.out.print("Informe o codigo: ");
                    String codigo = ler.nextLine();
                    if(funcionario.getGerenteProjetos().containsKey(codigo)){
                        System.out.println("Projeto ja esta adicionado");
                    }else{
                        Projeto projeto = empresa.getGerenteProjetos().getProjeto(codigo);
                        if(projeto != null){
                            funcionario.getGerenteProjetos().putProjeto(projeto);
                            projeto.getGerenteFuncionarios().putFuncionario(funcionario);
                            System.out.println("Projeto adicionado com sucesso!");
                        }else{
                            System.out.println("Projeto nao encontrado!");
                        }
                    }
                    break;
                }
                case 2 -> {
                    System.out.print("Informe o codigo: ");
                    String codigo = ler.nextLine();
                    
                    Projeto projeto = funcionario.getGerenteProjetos().removerProjeto(codigo);
                    if(projeto != null){
                        projeto.getGerenteFuncionarios().removerFuncionario(funcionario.getID());
                        System.out.println("Projeto removido com sucesso!");
                    }else{
                        System.out.println("Projeto nao encontrado!");
                    }
                    break;
                }
                case 3 -> {
                    System.out.print("Informe o codigo: ");
                    String codigo = ler.nextLine();
                    Projeto projeto = funcionario.getGerenteProjetos().getProjeto(codigo);
                    
                    if(projeto != null){
                        System.out.println(projeto.toString());
                    }else{
                        System.out.println("Projeto nao encontrado!");
                    }
                }
                case 4 -> {
                    System.out.println(funcionario.toString());
                }
                
                default -> {
                    System.out.println("Opcao invalida!");
                }
            }
            
        }while(opcao != 0);
        
    }
    
    private static void menuProjeto(Scanner ler, Projeto projeto, Empresa empresa){
        int opcao;
        
        do{
            opcao = imprimeMenuProjeto(ler, projeto.getNome());
            ler.nextLine();
            
            switch(opcao){
                case 0 -> {
                    System.out.println("Voltando...");
                    break;
                }
                case 1 -> {
                    System.out.print("Informe o ID: ");
                    String ID = ler.nextLine();
                    if(projeto.getGerenteFuncionarios().containsKey(ID)){
                        System.out.println("Funcionario ja esta alocado");
                    }else{
                        Funcionario funcionario = empresa.getGerenteFuncionarios().getFuncionario(ID);
                        if(funcionario != null){
                            projeto.getGerenteFuncionarios().putFuncionario(funcionario);
                            funcionario.getGerenteProjetos().putProjeto(projeto);
                            System.out.println("Funcionario adicionado com sucesso!");
                        }else{
                            System.out.println("Funcionario nao encontrado!");
                        }
                    }
                    break;
                }
                case 2 -> {
                    System.out.print("Informe o ID: ");
                    String ID = ler.nextLine();
                    
                    Funcionario funcionario = projeto.getGerenteFuncionarios().removerFuncionario(ID);
                    if(funcionario != null){
                        funcionario.getGerenteProjetos().removerProjeto(projeto.getCodigo());
                        System.out.println("Funcionario removido com sucesso!");
                    }else{
                        System.out.println("Funcionario nao encontrado!");
                    }
                    break;
                }
                case 3 -> {
                    System.out.print("Informe o ID: ");
                    String ID = ler.nextLine();
                    Funcionario funcionario = projeto.getGerenteFuncionarios().getFuncionario(ID);
                    
                    if(funcionario != null){
                        System.out.println(funcionario.toString());
                    }else{
                        System.out.println("Funcionario nao encontrado!");
                    }
                }
                case 4 -> {
                    System.out.println(projeto.toString());
                }
                
                default -> {
                    System.out.println("Opcao invalida!");
                }
            }
            
        }while(opcao != 0);
    }
    
    private static void menuEmpresa(Scanner ler, Empresa empresa){
        int opcao;
        
        do{
            opcao = imprimeMenuEmpresa(ler, empresa.getNome());
            ler.nextLine();
            switch(opcao){
                case 0 -> {
                    System.out.println("Saindo...");
                    break;
                }
                case 1 -> {
                    Funcionario funcionario = criarPreenchendoFuncionario(ler);
                    if(empresa.getGerenteFuncionarios().containsKey(funcionario.getID())){
                        System.out.print("Ja existe um funcionario com esse ID.\n Deseja remover o antigo? [s/n]: ");
                        String resposta = ler.nextLine();
                        
                        if(resposta.equalsIgnoreCase("s")){
                            empresa.removerFuncionario(funcionario.getID());
                            empresa.getGerenteFuncionarios().putFuncionario(funcionario);
                            System.out.println("Funcionario antigo removido, funcionario novo adicionado.");
                        }else{
                            System.out.println("Funcionario antigo mantido, funcionario novo descartado.");
                        }
                    }else{
                        empresa.getGerenteFuncionarios().putFuncionario(funcionario);
                        System.out.println("Funcionario adicionado com sucesso!");
                    }
                    break;
                }
                case 2 -> {
                    Projeto projeto = criarPreenchendoProjeto(ler);
                    if(empresa.getGerenteProjetos().containsKey(projeto.getCodigo())){
                        System.out.print("Ja existe um Projeto com esse Codigo.\n Deseja remover o antigo? [s/n]: ");
                        String resposta = ler.nextLine();
                        
                        if(resposta.equalsIgnoreCase("s")){
                            empresa.removerProjeto(projeto.getCodigo());
                            empresa.getGerenteProjetos().putProjeto(projeto);
                            System.out.println("Projeto antigo removido, projeto novo adicionado.");
                        }else{
                            System.out.println("Projeto antigo mantido, projeto novo descartado.");
                        }
                    }else{
                        empresa.getGerenteProjetos().putProjeto(projeto);
                        System.out.println("Projeto adicionado com sucesso!");
                    }
                    break;
                }
                case 3 -> {
                    System.out.print("Informe o ID: ");
                    String ID = ler.nextLine();
                    empresa.removerFuncionario(ID);
                    break;
                }
                case 4 -> {
                    System.out.print("Informe o Codigo: ");
                    String codigo = ler.nextLine();
                    empresa.removerProjeto(codigo);
                    break;
                }
                case 5 -> {
                    System.out.println(empresa.getFuncionarioMaisProdutivo());
                    break;
                }
                case 6 -> {
                    System.out.println(empresa.getFuncionarioMenosProdutivo());
                    break;
                }
                case 7 -> {
                    System.out.print("Informe a ID: ");
                    String ID = ler.nextLine();
                    Funcionario funcionario = empresa.getGerenteFuncionarios().getFuncionario(ID);
                    if(funcionario != null){
                        menuFuncionario(ler,funcionario,empresa);
                    }
                    else{
                        System.out.println("Funcionario nao encontrado!");
                    }
                    break;
                }
                case 8 -> {
                    System.out.print("Informe o codigo: ");
                    String codigo = ler.nextLine();
                    Projeto projeto = empresa.getGerenteProjetos().getProjeto(codigo);
                    if(projeto != null){
                        menuProjeto(ler,projeto,empresa);
                    }
                    else{
                        System.out.println("Projeto nao encontrado!");
                    }
                    break;
                }
                case 9 -> {
                    System.out.println(empresa.toStringFuncionarios());
                    break;
                }
                case 10 -> {
                    System.out.println(empresa.toStringProjetos());
                }
                
                default -> {
                    System.out.println("Opcao invalida!");
                }
            }
            
            
        }while(opcao != 0);
        
    }
    
    
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Empresa empresa = new Empresa();
        System.out.print("Informe o nome da empresa: ");
        empresa.setNome(ler.nextLine());
        
        menuEmpresa(ler,empresa);
        
    }
    
    private static Funcionario criarPreenchendoFuncionario(Scanner ler){
        Funcionario funcionario = new Funcionario();
        System.out.println("--- Preenchendo Funcionario ---");
        System.out.print("Informe o nome: ");
        funcionario.setNome(ler.nextLine());
        System.out.print("Informe o ID: ");
        funcionario.setID(ler.nextLine());
        
        return funcionario;
    }
    
    private static Projeto criarPreenchendoProjeto(Scanner ler){
        Projeto projeto = new Projeto();
        System.out.println("--- Preenchendo Projeto ---");
        System.out.print("Informe o nome: ");
        projeto.setNome(ler.nextLine());
        System.out.print("Informe o codigo: ");
        projeto.setCodigo(ler.nextLine());
        System.out.print("Descreva o projeto em uma linha: ");
        projeto.setDescricao(ler.nextLine());
        return projeto;
    }
    
    
}
