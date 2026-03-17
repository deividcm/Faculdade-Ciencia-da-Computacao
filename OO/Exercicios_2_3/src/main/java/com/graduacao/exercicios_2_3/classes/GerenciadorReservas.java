package com.graduacao.exercicios_2_3.classes;

import java.util.ArrayList;
import java.util.List;


public class GerenciadorReservas {
    private List<Reserva> reservas;
    
    public GerenciadorReservas(){
        reservas = new ArrayList<>();
    }
    
    
    public void adicionarReserva(Reserva reserva){
        reservas.add(reserva);
        
        System.out.println("Reserva adicionada!");
    }
    
    public void cancelarReserva(String nomeReserva){
        boolean encontrada = false;
        for(Reserva reserva : reservas){
            if (nomeReserva.equals(reserva.getNomeReserva())){
                encontrada = true;
                reservas.remove(reserva);
                System.out.println("Reserva removida");
                break;
            }
        }
        if (encontrada == false){
            System.out.println("Reserva não foi encontrada");
        }
    }
    
    
    public void listarReservas(){
        if (reservas.isEmpty()){
            System.out.println("A lista esta vazia");
        }
        else{
            System.out.println("------- Reservas -------");

            for(Reserva reserva : reservas){
                System.out.println(reserva);
            }
            System.out.println("------------------------");
        }
    }
    
    public Reserva buscarReserva(String nomeReserva){
        
        for(Reserva reserva : reservas){
            if(nomeReserva.equals(reserva.getNomeReserva())){
                return reserva;
            }
        }
        
        
        return null;
    }
    
    
}

