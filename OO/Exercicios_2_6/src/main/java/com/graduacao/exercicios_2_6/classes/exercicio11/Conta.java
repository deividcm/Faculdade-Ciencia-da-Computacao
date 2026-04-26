package com.graduacao.exercicios_2_6.classes.exercicio11;

import java.util.Objects;

public class Conta {
    private String numConta;
    private String titular;
    private double saldo;

    public Conta() {
        this.numConta = "";
        this.titular = "";
        this.saldo = 0.0;
    }
    public Conta(String numConta, String titular, double saldo) {
        this.numConta = numConta;
        this.titular = titular;
        this.saldo = saldo;
    }
    public Conta(Conta outra){
        this.numConta = outra.getNumConta();
        this.titular = outra.getTitular();
        this.saldo = outra.getSaldo();
    }
    public void copiar(Conta outra){
        this.numConta = outra.getNumConta();
        this.titular = outra.getTitular();
        this.saldo = outra.getSaldo();
    }
    
    public double sacar(double valor){
        if(valor > 0){
            this.saldo -= valor;
            return valor;
        }
        else{
            return 0;
        }
    }
    
    public boolean depositar(double valor){
        if(valor > 0){
            this.saldo += valor;
        }
        
        return valor > 0;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.numConta);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Conta other = (Conta) obj;
        if (Double.doubleToLongBits(this.saldo) != Double.doubleToLongBits(other.saldo)) {
            return false;
        }
        if (!Objects.equals(this.numConta, other.numConta)) {
            return false;
        }
        return Objects.equals(this.titular, other.titular);
    }
    
    public String toStringResumido(){
        return this.numConta + " - " + this.titular + "\n ";
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Conta ---\n ");
        sb.append("Numero: ").append(this.numConta).append("\n ");
        sb.append("Titular: ").append(this.titular).append("\n ");
        sb.append("Saldo: R$").append(this.saldo).append("\n ");
        return sb.toString();
    }
    
    public boolean isDevedor(){
        return this.saldo < 0;
    }

    public String getNumConta() {
        return this.numConta;
    }
    public void setNumConta(String numConta) {
        this.numConta = numConta;
    }

    public String getTitular() {
        return this.titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return this.saldo;
    }
}
