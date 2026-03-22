package com.graduacao.exercicios_2_1.classes;

import java.util.Scanner;

public class Animal {
    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private double peso;
    
    public Animal(){
        this.nome = "";
        this.especie = "";
        this.raca = "";
        this.idade = 0;
        this.peso = 0.0;
    }
    public Animal(Animal outro){
        this.nome = outro.getNome();
        this.especie = outro.getEspecie();
        this.raca = outro.getRaca();
        this.idade = outro.getIdade();
        this.peso = outro.getPeso();
    }
    public Animal(String nome, String especie, String raca, int idade, double peso){
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.peso = peso;
    }
    
    public void preencher(){
        Scanner ler = new Scanner(System.in);
        
        System.out.print("Informe o Nome: ");
        this.nome = ler.next();
        System.out.print("Informe a Especie: ");
        this.especie = ler.next();
        System.out.print("Informe a Raca: ");
        this.raca = ler.next();
        System.out.print("Informe a Idade: ");
        this.idade = ler.nextInt();
        System.out.print("Informe o Peso: ");
        this.peso = ler.nextDouble();
    }
    
    public void copiar(Animal outro){
        this.nome = outro.getNome();
        this.especie = outro.getEspecie();
        this.raca = outro.getRaca();
        this.idade = outro.getIdade();
        this.peso= outro.getPeso();
    }
    
    public void fazerSom(){
        String som = "Grr";
        if ("Cachorro".equals(especie)){
            som = "Auau";
        }else if ("Gato".equals(especie)){
            som = "Miau";
        }
        
        System.out.println(getNome() + "faz: " + som);
    }
    
    @Override
    public String toString(){
        return "Animal { Nome: " + this.nome +
               " - Especie: " + this.especie +
               " - Raca: " + this.raca +
               " - Idade: " + this.idade +
               " anos - Peso: " + this.peso + 
               "kg - Idade humana: " + this.calcularIdadeHumana() + " anos }";
    }
    
    public int calcularIdadeHumana(){
        return this.idade * 7;
    }
    
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getEspecie(){
        return this.especie;
    }
    public void setEspecie(String especie){
        this.especie = especie;
    }
    public String getRaca(){
        return this.raca;
    }
    public void setRaca(String raca){
        this.raca = raca;
    }
    public int getIdade(){
        return this.idade;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }
    public double getPeso(){
        return this.peso;
    }
    public void setPeso(double peso){
        this.peso = peso;
    }
}