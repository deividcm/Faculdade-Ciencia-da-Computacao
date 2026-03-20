
package com.graduacao.exercicios_2_3.classes;


import java.util.Objects;
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
        this.titulo = ler.nextLine();
        System.out.print("Informe o/a Artista: ");
        this.artista = ler.nextLine();
        System.out.print("Informe a Duracao(Minutos): ");
        this.duracao = ler.nextDouble();
        ler.nextLine();
        System.out.print("Informe o Preco: R$");
        this.preco = ler.nextDouble(); 
    }
    
    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if (this.getClass() != obj.getClass()){
            return false;
        }
        
        final Musica other = (Musica) obj;
        
        if (!Objects.equals(this.titulo, other.getTitulo())){
            return false;
        }
        if (!Objects.equals(this.artista, other.getArtista())){
            return false;
        }
        if (this.duracao != other.getDuracao()){
            return false;
        }
        
        return this.preco == other.getPreco();
    }

    @Override
    public int hashCode() {
        int hash = 6;
        hash = 12 * hash + Objects.hashCode(this.titulo);
        hash = 12 * hash + Objects.hashCode(this.artista);
        hash = 12 * hash + (int) (Double.doubleToLongBits(this.duracao) ^ (Double.doubleToLongBits(this.duracao) >>> 32));
        hash = 12 * hash + (int) (Double.doubleToLongBits(this.preco) ^ (Double.doubleToLongBits(this.preco) >>> 32));
        return hash;
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