package com.graduacao.exercicios_3_2.classes.exercicio03;

import java.util.Objects;

public class Casa {
    private String endereco;
    private double area;
    private double preco;
    private int numQuartos;
    
    public Casa(){
        this.endereco = "";
        this.area = 0.0;
        this.preco = 0.0;
        this.numQuartos = 0;
    }
    public Casa(String endereco, double area, double preco, int numQuartos) {
        this.endereco = endereco;
        this.area = area;
        this.preco = preco;
        this.numQuartos = numQuartos;
    }
    public Casa(Casa outra){
        this.endereco = outra.getEndereco();
        this.area = outra.getArea();
        this.preco = outra.getPreco();
        this.numQuartos = outra.getNumQuartos();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.endereco);
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
        final Casa other = (Casa) obj;
        if (Double.doubleToLongBits(this.area) != Double.doubleToLongBits(other.area)) {
            return false;
        }
        if (Double.doubleToLongBits(this.preco) != Double.doubleToLongBits(other.preco)) {
            return false;
        }
        if (this.numQuartos != other.numQuartos) {
            return false;
        }
        return Objects.equals(this.endereco, other.endereco);
    }
    
    
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Casa ---\n ");
        sb.append("Endereço: ").append(this.endereco).append("\n ");
        sb.append("Área: ").append(this.area).append("\n ");
        sb.append("Preço: ").append(this.preco).append("\n ");
        sb.append("Número de Quartos: ").append(this.numQuartos).append("\n ");
        
        return sb.toString();
    }

    public String getEndereco() {
        return this.endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getArea() {
        return this.area;
    }
    public void setArea(double area) {
        this.area = area;
    }

    public double getPreco() {
        return this.preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getNumQuartos() {
        return this.numQuartos;
    }
    public void setNumQuartos(int numQuartos) {
        this.numQuartos = numQuartos;
    } 
}
