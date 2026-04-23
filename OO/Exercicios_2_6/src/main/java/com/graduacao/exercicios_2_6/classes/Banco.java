package com.graduacao.exercicios_2_6.classes;

import com.graduacao.exercicios_2_6.gerentes.GerenteContas;
import com.graduacao.exercicios_2_6.gerentes.GerenteTransacoes;

public class Banco {
    private String nome;
    private final GerenteContas gerenteContas;
    private final GerenteTransacoes gerenteTransacoes;
    
    public Banco(){
        this.nome = "";
        this.gerenteContas = new GerenteContas();
        this.gerenteTransacoes = new GerenteTransacoes();
    }
    public Banco(String nome){
        this.nome = nome;
        this.gerenteContas = new GerenteContas();
        this.gerenteTransacoes = new GerenteTransacoes();
    }
    public Banco(Banco outro){
        this.nome = outro.getNome();
        this.gerenteContas = new GerenteContas(outro.getGerenteContas());
        this.gerenteTransacoes = new GerenteTransacoes(outro.getGerenteTransacoes());
    }
    public void copiar(Banco outro){
        this.nome = outro.getNome();
        this.gerenteContas.copiar(outro.getGerenteContas());
        this.gerenteTransacoes.copiar(outro.getGerenteTransacoes());
    }
    
    
    
    
    public String toStringContas(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Contas (").append(this.gerenteContas.size()).append(") ---\n ");
        
        sb.append(this.gerenteContas.toString());
        
        return sb.toString();
    }
    public String toStringTransacoes(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Transacoes(").append(this.gerenteTransacoes.size()).append(") ---\n ");
        
        sb.append(this.gerenteTransacoes.toString());
        
        return sb.toString();
    }
    
    

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public GerenteContas getGerenteContas() {
        return this.gerenteContas;
    }
    public GerenteTransacoes getGerenteTransacoes() {
        return this.gerenteTransacoes;
    }
    
    
    
}
