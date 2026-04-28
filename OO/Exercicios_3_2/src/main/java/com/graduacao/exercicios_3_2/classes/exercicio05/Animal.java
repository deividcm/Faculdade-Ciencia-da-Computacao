package com.graduacao.exercicios_3_2.classes.exercicio05;

import java.util.Objects;

public class Animal {
    private String cod;
    private String nome;
    private String especie;
    private String raca;
    private double peso;
    private int idade;
    
    public Animal(){
        this.cod = "";
        this.nome = "";
        this.especie = "";
        this.raca = "";
        this.peso = 0.0;
        this.idade = 0;
    }
    public Animal(String cod, String nome, String especie, String raca, double peso, int idade) {
        this.cod = cod;
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.peso = peso;
        this.idade = idade;
    }
    public Animal(Animal outro){
        this.cod = outro.getCod();
        this.nome = outro.getNome();
        this.especie = outro.getEspecie();
        this.raca = outro.getRaca();
        this.peso = outro.getPeso();
        this.idade = outro.getIdade();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.cod);
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
        final Animal other = (Animal) obj;
        if (Double.doubleToLongBits(this.peso) != Double.doubleToLongBits(other.peso)) {
            return false;
        }
        if (this.idade != other.idade) {
            return false;
        }
        if (!Objects.equals(this.cod, other.cod)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.especie, other.especie)) {
            return false;
        }
        return Objects.equals(this.raca, other.raca);
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Animal ---\n ");
        sb.append("Código: ").append(this.cod).append("\n ");
        sb.append("Nome: ").append(this.nome).append("\n ");
        sb.append("Espécie: ").append(this.especie).append("\n ");
        sb.append("Raça: ").append(this.raca).append("\n ");
        sb.append("Peso: ").append(this.peso).append("\n ");
        sb.append("Idade: ").append(this.idade).append("\n ");
        
        return sb.toString();
    }
    
    public String getCod() {
        return this.cod;
    }
    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return this.especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return this.raca;
    }
    public void setRaca(String raca) {
        this.raca = raca;
    }

    public double getPeso() {
        return this.peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getIdade() {
        return this.idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
}
