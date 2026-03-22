package com.graduacao.exercicios_2_1.classes;

import java.util.Scanner;

public class Casa {
    private String endereco;
    private double area;
    private int num_quartos;
    private double preco;
    
    
    public Casa(){
        this.endereco = "";
        this.area = 0.0;
        this.num_quartos = 0;
        this.preco = 0.0;
    }
    public Casa(String endereco, double area, int num_quartos, double preco) {
        this.endereco = endereco;
        this.area = area;
        this.num_quartos = num_quartos;
        this.preco = preco;
    }
    public Casa(Casa outra){
        this.endereco = outra.getEndereco();
        this.area = outra.getArea();
        this.num_quartos = outra.getNumQuartos();
        this.preco = outra.getPreco();
    }
    
    public void copiar(Casa outra){
        this.endereco = outra.getEndereco();
        this.area = outra.getArea();
        this.num_quartos = outra.getNumQuartos();
        this.preco = outra.getPreco();
    }
    
    public void preencher(){
        Scanner ler = new Scanner(System.in);
        
        System.out.print("Informe o Endereco: ");
        this.endereco = ler.next();
        System.out.print("Informe a Area: ");
        this.area = ler.nextDouble();
        System.out.print("Informe a Numero de Quartos: ");
        this.num_quartos = ler.nextInt();
        System.out.print("Informe o Preco: ");
        this.preco = ler.nextDouble(); 
    }
    
   
    
    public void exibirResumo(){
        System.out.println(this.endereco +
               " | " + this.area +
               "m2 | " + this.num_quartos +
               " | R$" + this.preco +
               " | R$" + this.calcularPrecoPorM2() + "/m2 ");
    }
    
    
    public double calcularPrecoPorM2(){
        return this.preco/this.area;
    }
    @Override
    public String toString(){
        return "Casa { Endereco: " + this.endereco +
               " - Area: " + this.area +
               "m2 - Numero de Quartos: " + this.num_quartos +
               " - Preco: R$" + this.preco + " }";
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

    public int getNumQuartos() {
        return this.num_quartos;
    }
    public void setNumQuartos(int num_quartos) {
        this.num_quartos = num_quartos;
    }

    public double getPreco() {
        return this.preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
}
