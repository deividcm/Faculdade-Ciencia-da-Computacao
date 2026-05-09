package com.graduacao.exercicios_3_3__4__5.classes;

import java.util.Objects;


public class Carro {
    private String cod;
    private String marca;
    private String modelo;
    private double preco;
    private int ano;
    
    public Carro(){
        this.cod = "";
        this.marca = "";
        this.modelo = "";
        this.preco = 0.0;
        this.ano = 0;
    }
    public Carro(String cod, String marca, String modelo, double preco, int ano) {
        this.cod = cod;
        this.marca = marca;
        this.modelo = modelo;
        this.preco = preco;
        this.ano = ano;
    }
    public Carro(Carro outro){
        this.cod = outro.getCod();
        this.marca = outro.getMarca();
        this.modelo = outro.getModelo();
        this.preco = outro.getPreco();
        this.ano = outro.getAno();
    }
    
    @Override
    public int hashCode(){
        int hash = 13;
        hash += 67 * hash + Objects.hashCode(this.cod);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(this.getClass() != obj.getClass()){
            return false;
        }
        
        final Carro outro = (Carro) obj;
        if(Double.doubleToLongBits(this.preco) != Double.doubleToLongBits(outro.getPreco())){
            return false;
        }
        if(this.ano != outro.getAno()){
            return false;
        }
        if(!Objects.equals(this.cod, outro.getCod())){
            return false;
        }
        if(!Objects.equals(this.marca, outro.getMarca())){
            return false;
        }
        return Objects.equals(this.modelo, outro.getModelo());
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("--- Carro ---\n ");
        sb.append("Cod: ").append(this.cod).append("\n ");
        sb.append("Marca: ").append(this.marca).append("\n ");
        sb.append("Modelo: ").append(this.modelo).append("\n ");
        sb.append("Preço: ").append(this.preco).append("\n ");
        sb.append("Ano: ").append(this.ano).append("\n ");
        
        return sb.toString();
    }

    public String getCod() {
        return this.cod;
    }
    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getMarca() {
        return this.marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPreco() {
        return this.preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getAno() {
        return this.ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
}
