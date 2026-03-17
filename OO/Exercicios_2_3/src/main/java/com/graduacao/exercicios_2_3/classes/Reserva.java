package com.graduacao.exercicios_2_3.classes;

import java.util.Scanner;

public class Reserva {
    private String nomeReserva;
    private int numPessoas;
    private String dataHora; // dd/MM/yyyy HH:mm

    
    public Reserva(){
        this.nomeReserva = "";
        this.numPessoas = 0;
        this.dataHora = "";
    }
    
    public Reserva(String nomeReserva, int numPessoas, String dataHora) {
        this.nomeReserva = nomeReserva;
        this.numPessoas = numPessoas;
        this.dataHora = dataHora;
    }

    public Reserva(Reserva outra){
        this.nomeReserva = outra.getNomeReserva();
        this.numPessoas = outra.getNumPessoas();
        this.dataHora = outra.getDataHora();
    }
    
    
    public void fill(){
        Scanner ler = new Scanner(System.in);
        
        System.out.println("Informe o nome da reserva: ");
        this.nomeReserva = ler.nextLine();
        System.out.println("Informe o numero de pessoas: ");
        this.numPessoas = ler.nextInt();
        ler.nextLine();
        System.out.println("Informe a data e hora(dd/MM/yyyy HH:mm): ");
        this.dataHora = ler.nextLine();
        
    }
    
    
    
    @Override
    public String toString(){
        return "Reserva - Nome: " + this.nomeReserva +
               " - Numero de pessoas: " + this.numPessoas +
               " - Data e Hora: " + this.dataHora;
    }
    
    public String getNomeReserva() {
        return this.nomeReserva;
    }
    public void setNomeReserva(String nomeReserva) {
        this.nomeReserva = nomeReserva;
    }

    public int getNumPessoas() {
        return this.numPessoas;
    }
    public void setNumPessoas(int numPessoas) {
        this.numPessoas = numPessoas;
    }

    public String getDataHora() {
        return this.dataHora;
    }
    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }
    
    
}
