package com.graduacao.exercicios_2_5.classes;

import java.util.Objects;

public class ContaBancaria {
    private int numero;
    private String tipo;
    private double saldo;
    
    public ContaBancaria(){
        this.numero = 0;
        this.tipo = "";
        this.saldo = 0.0;
    }
    public ContaBancaria(int numero, String tipo, double saldo) {
        this.numero = numero;
        this.tipo = tipo;
        this.saldo = saldo;
    }
    public ContaBancaria(ContaBancaria outra){
        this.numero = outra.getNumero();
        this.tipo = outra.getTipo();
        this.saldo = outra.getSaldo();
    }
    public void copiar(ContaBancaria outra){
        this.numero = outra.getNumero();
        this.tipo = outra.getTipo();
        this.saldo = outra.getSaldo();
    }
    
    public void depositar(double valor){
        if(valor > 0){
            this.saldo += valor;
            System.out.println("Deposito de R$" + valor + " realizado com sucesso!");
        }
        else{
            System.out.println("Valor invalido");
        }
    }
    public void sacar(double valor){
        if(valor > 0 && this.saldo >= valor){
            this.saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso!");
        }
        else if (valor <= 0){
            System.out.println("Valor invalido");
        }
        else{
            System.out.println("Saldo insuficiente");
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.numero;
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
        final ContaBancaria other = (ContaBancaria) obj;
        if (this.numero != other.numero) {
            return false;
        }
        if (Double.doubleToLongBits(this.saldo) != Double.doubleToLongBits(other.saldo)) {
            return false;
        }
        return Objects.equals(this.tipo, other.tipo);
    }
    
    @Override
    public String toString(){
        return "--- Conta Bancaria ---\n " +
               "Numero: " + this.numero + "\n "+
               "Tipo: " + this.tipo + "\n "+ 
               "Saldo: " + this.saldo + "\n";
    }
    
    public int getNumero() {
        return this.numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return this.tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getSaldo() {
        return this.saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
