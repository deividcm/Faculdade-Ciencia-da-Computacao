
package com.graduacao.exercicios_2_3.projetos;

import com.graduacao.exercicios_2_3.classes.AgendaTelefonica;
import java.util.Scanner;


public class ProjetoAgendaContatos {
    
    private static int imprimeMenu(){
        Scanner ler = new Scanner(System.in);

        System.out.println("--------Agenda de Contatos--------");
        System.out.println("1 - Adicionar/Atualizar Contato");
        System.out.println("2 - Remover Contato");
        System.out.println("3 - Pesquisar Contato");
        System.out.println("4 - Imprimir Contatos");
        System.out.println("0 - Sair");
        System.out.println("-------------------------------");
        System.out.println("Escolha uma opcao:");
        
        return ler.nextInt();
    }
    
    public static void main(String[] args) {
        AgendaTelefonica agenda = new AgendaTelefonica();
        int opcao = 0;
        Scanner ler = new Scanner(System.in);
        
        do{
            opcao = imprimeMenu();
            switch(opcao){
                case 1 -> {
                    System.out.println("Informe o nome: ");
                    String nome = ler.nextLine();
                    System.out.println("Informe o numero: ");
                    String num = ler.next();
                    ler.nextLine();
                    if(agenda.adicionarContato(nome, num)){
                        System.out.println("Contato atualizado com sucesso!");
                    }
                    else{   
                        System.out.println("Contato adicionado com sucesso!");
                    }
                    break;
                }
                case 2 -> {
                    System.out.println("Informe o nome: ");
                    String nome = ler.nextLine();
                    if(agenda.removerContato(nome)){
                        System.out.println("Contato removido com sucesso!");
                    }
                    else{
                        System.out.println("Contato nao encontrado"); 
                    }
                    break;
                }
                case 3 -> {
                    System.out.println("Informe o nome: ");
                    String nome = ler.nextLine();
                    
                    System.out.println(agenda.buscarContato(nome));
                    break;
                }
                case 4 -> {
                    agenda.imprimirContatos();
                    break;
                }
            }
            
        }while(opcao != 0);
        
        
    }
    
    
    
}
