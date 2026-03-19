
package com.graduacao.exercicios_2_3.projetos;

import com.graduacao.exercicios_2_3.classes.GerenciadorReservas;
import com.graduacao.exercicios_2_3.classes.Reserva;
import java.util.Scanner;



public class ProjetoCadReserva {
    
    public static int imprimeMenu(){
        Scanner ler = new Scanner(System.in);

        System.out.println("-------ProjetoCadReserva-------");
        System.out.println("1 - Adicionar Reserva");
        System.out.println("2 - Cancelar Reserva");
        System.out.println("3 - Listar Reservas");
        System.out.println("4 - Buscar Reservas");
        System.out.println("0 - Sair");
        System.out.println("-----------------------------");
        System.out.println("Escolha uma opcao:");
        
        return ler.nextInt();
    }
    
    public static void main(String[] args) {
        GerenciadorReservas gerenciador = new GerenciadorReservas();
        Scanner ler = new Scanner(System.in);
        int opcao = 0;
        do{
            opcao = imprimeMenu();
            
            switch(opcao){
                case 1 -> {
                    Reserva reserva = new Reserva();
                    reserva.fill();
                    gerenciador.adicionarReserva(reserva);
                    break;
                }
                case 2 -> {
                    System.out.println("Informe o nome da reserva a ser cancelada: ");
                    String nomeReserva = ler.nextLine();
                    
                    gerenciador.cancelarReserva(nomeReserva);
                    
                    break;
                }
                case 3 -> {
                    gerenciador.listarReservas();
                    break;
                }
                case 4 -> {
                    System.out.println("Informe o nome da reserva: ");
                    String nomeReserva = ler.nextLine();
                    
                    Reserva reserva = gerenciador.buscarReserva(nomeReserva);
                    if (reserva != null){
                        System.out.println(reserva);
                    }
                    else{
                        System.out.println("Reserva nao encontrada");
                    }
                    break;
                }
                
                
            }
            
            
            
            
        }while(opcao != 0);
        
        
    }
    
    
}
