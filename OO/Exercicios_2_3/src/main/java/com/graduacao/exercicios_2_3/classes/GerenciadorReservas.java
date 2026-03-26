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
        
        
    }
    
    public boolean cancelarReserva(String nomeReserva){
        for(Reserva reserva : reservas){
            if (nomeReserva.equals(reserva.getNomeReserva())){
                reservas.remove(reserva);
                
                return true;
            }
        }
        
        return false;
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

