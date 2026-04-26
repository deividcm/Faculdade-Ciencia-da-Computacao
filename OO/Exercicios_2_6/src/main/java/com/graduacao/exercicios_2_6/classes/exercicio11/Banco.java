package com.graduacao.exercicios_2_6.classes.exercicio11;

import com.graduacao.exercicios_2_6.gerentes.exercicio11.GerenteContas;
import com.graduacao.exercicios_2_6.gerentes.exercicio11.GerenteTransacoes;

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
    
    
    
    public Conta getMaiorSaldo(){
        Conta maior = null;
        for(Conta conta: this.gerenteContas.getContas().values()){
            if(maior == null){
                maior = conta;
            }
            else if(conta.getSaldo() > maior.getSaldo()){
                maior = conta;
            }
        }
        
        return maior;
    }
    public Conta getMenorSaldo(){
        Conta menor = null;
        for(Conta conta: this.gerenteContas.getContas().values()){
            if(menor == null){
                menor = conta;
            }
            else if(conta.getSaldo() < menor.getSaldo()){
                menor = conta;
            }
        }
        
        return menor;
    }
    
    public int totalDevedores(){
        int contador = 0;
        for(Conta conta: this.gerenteContas.getContas().values()){
            if(conta.isDevedor()){
                contador++;
            }
        }
        return contador;
    }
    public int totalCredores(){
        int contador = 0;
        for(Conta conta: this.gerenteContas.getContas().values()){
            if(!conta.isDevedor()){
                contador++;
            }
        }
        return contador;
    }
    public double totalSaldoDevedores(){
        double total = 0.0;
        
        for(Conta conta: this.gerenteContas.getContas().values()){
            if(conta.isDevedor()){
                total += conta.getSaldo();
            }
        }
        
        return total;
    }
    public double totalSaldoCredores(){
        double total = 0.0;
        
        for(Conta conta: this.gerenteContas.getContas().values()){
            if(!conta.isDevedor()){
                total += conta.getSaldo();
            }
        }
        
        return total;
    }
    
    
    public String toStringDevedores(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Devedores (").append(this.totalDevedores()).append(") ---\n ");
        for(Conta conta: this.gerenteContas.getContas().values()){
            if(conta.isDevedor()){
                sb.append(conta.toString());
            }
        }
        sb.append("----------------------------\n ");
        sb.append("Total de Dividas: R$").append(this.totalSaldoDevedores()).append("\n ");
        
        return sb.toString();
    }
    
    public String toStringCredores(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Credores (").append(this.totalCredores()).append(") ---\n ");
        for(Conta conta: this.gerenteContas.getContas().values()){
            if(!conta.isDevedor()){
                sb.append(conta.toString());
            }
        }
        sb.append("----------------------------\n ");
        sb.append("Total de Saldo: R$").append(this.totalSaldoCredores()).append("\n ");
        
        return sb.toString();
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
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Banco ---\n ");
        sb.append("Nome: ").append(this.nome).append("\n ");
        sb.append("--- Contas (").append(this.gerenteContas.size()).append(") ---\n ");
        sb.append(this.gerenteContas.toStringResumido());
        
        sb.append("--- Transacoes(").append(this.gerenteTransacoes.size()).append(") ---\n ");
        sb.append(this.gerenteTransacoes.toStringResumido());
        
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
