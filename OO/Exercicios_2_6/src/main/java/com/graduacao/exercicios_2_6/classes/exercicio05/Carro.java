package com.graduacao.exercicios_2_6.classes.exercicio05;

import com.graduacao.exercicios_2_6.classes.exercicio05.Roda;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Carro {
    private String fabricante;
    private String modelo;
    private String cor;
    private List<Roda> rodas;
    
    public Carro(){
        this.fabricante = "";
        this.modelo = "";
        this.cor = "";
        this.rodas = new ArrayList<>();
    }
    public Carro(String fabricante, String modelo, String cor) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.cor = cor;
        this.rodas = new ArrayList<>();
    }
    public Carro(Carro outro){
        this.fabricante = outro.getFabricante();
        this.modelo = outro.getModelo();
        this.cor = outro.getCor();
        
        this.rodas = new ArrayList<>();
        
        for(Roda r: outro.getRodas()){
            Roda roda = new Roda(r);
            
            this.rodas.add(roda);
        }
    }
    
    public void copiar(Carro outro){
        this.fabricante = outro.getFabricante();
        this.modelo = outro.getModelo();
        this.cor = outro.getCor();
        
        this.rodas.clear();
        
        for(Roda r: outro.getRodas()){
            Roda roda = new Roda();
            roda.copiar(roda);
            this.rodas.add(roda);
        }
    }
    
    public void addRoda(Roda roda){
        rodas.add(roda);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.fabricante);
        hash = 53 * hash + Objects.hashCode(this.modelo);
        hash = 53 * hash + Objects.hashCode(this.cor);
        hash = 53 * hash + Objects.hashCode(this.rodas);
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
        final Carro other = (Carro) obj;
        if (!Objects.equals(this.fabricante, other.fabricante)) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (!Objects.equals(this.cor, other.cor)) {
            return false;
        }
        return Objects.equals(this.rodas, other.rodas);
    }
    
    
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Carro ---\n ");
        sb.append("Fabricante: ").append(this.fabricante).append("\n ");
        sb.append("Modelo: ").append(this.modelo).append("\n ");
        sb.append("Cor: ").append(this.cor).append("\n ");
        sb.append("Rodas[").append(this.rodas.size()).append("]:\n ");
        
        for(Roda roda: this.rodas){
            sb.append(roda.toString());
        }
        
        return sb.toString();
    }
    
    
    public String getFabricante() {
        return this.fabricante;
    }
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return this.modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return this.cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }

    public List<Roda> getRodas() {
        return this.rodas;
    }
    public void setRodas(List<Roda> rodas) {
        this.rodas = rodas;
    }
}
