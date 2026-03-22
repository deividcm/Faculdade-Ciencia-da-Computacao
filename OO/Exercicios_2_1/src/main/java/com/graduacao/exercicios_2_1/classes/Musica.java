package com.graduacao.exercicios_2_1.classes;


import java.util.Scanner;

public class Musica {
    private String titulo;
    private String artista;
    private double duracao;
    private double preco;
    
    
    public Musica(){
        this.titulo = "";
        this.artista = "";
        this.duracao = 0.0;
        this.preco = 0.0;
    }
    public Musica(Musica outra){
        this.titulo = outra.getTitulo();
        this.artista = outra.getArtista();
        this.duracao = outra.getDuracao();
        this.preco = outra.getPreco();
    }
    public Musica(String titulo, String artista, double duracao, double preco){
        this.titulo = titulo;
        this.artista = artista;
        this.duracao = duracao;
        this.preco = preco;
    }
    
    public void copiar(Musica outra){
        this.titulo = outra.getTitulo();
        this.artista = outra.getArtista();
        this.duracao = outra.getDuracao();
        this.preco = outra.getPreco();
    }
    
    public void preencher(){
        Scanner ler = new Scanner(System.in);
        
        System.out.print("Informe o Titulo: ");
        this.titulo = ler.next();
        System.out.print("Informe o/a Artista: ");
        this.artista = ler.next();
        System.out.print("Informe a Duracao(Minutos): ");
        this.duracao = ler.nextDouble();
        System.out.print("Informe o Preco: R$");
        this.preco = ler.nextDouble(); 
    }
    
    @Override
    public String toString(){
        return "Musica { Titulo: " + this.titulo +
               " - Artista: " + this.artista +
               " - Duracao: " + this.duracao +
               " minutos - Preco: R$" + this.preco + " }";
    }
    
    public void tocarMusica(){
        System.out.println("Tocando " +  this.titulo + "...");
    }
    public void desligarMusica(){
        System.out.println("Interrompendo " + this.titulo + "...");
    }
    
    public String getTitulo(){
        return this.titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public String getArtista(){
        return this.artista;
    }
    public void setArtista(String artista){
        this.artista = artista;
    }
    public double getDuracao(){
        return this.duracao;
    }
    public void setDuracao(double duracao){
        this.duracao = duracao;
    }
    public double getPreco(){
        return this.preco;
    }
    public void setPreco(double preco){
        this.preco = preco;
    }
}