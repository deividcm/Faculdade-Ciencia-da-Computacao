package com.graduacao.exercicios_2_3.classes;


import java.util.Objects;
import java.util.Scanner;

public class Filme {
    String titulo;
    String diretor;
    double duracao;
    double preco;

    
    public Filme(){
        this.titulo = "";
        this.diretor = "";
        this.duracao = 0.0;
        this.preco = 0.0;
    }
    public Filme(String titulo, String diretor, float duracao, float preco) {
        this.titulo = titulo;
        this.diretor = diretor;
        this.duracao = duracao;
        this.preco = preco;
    }
    public Filme(Filme outro){
        this.titulo = outro.getTitulo();
        this.diretor = outro.getDiretor();
        this.duracao = outro.getDuracao();
        this.preco = outro.getPreco();
    }
    
    public void copiar(Filme outro){
        this.titulo = outro.getTitulo();
        this.diretor = outro.getDiretor();
        this.duracao = outro.getDuracao();
        this.preco = outro.getPreco();
    }
    
    public void preencher(){
        Scanner ler = new Scanner(System.in);
        
        System.out.print("Informe o Titulo: ");
        this.titulo = ler.nextLine();
        System.out.print("Informe o/a Diretor/a: ");
        this.diretor = ler.nextLine();
        System.out.print("Informe a Duracao(Horas): ");
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
        
        final Filme other = (Filme) obj;
        
        if(!Objects.equals(this.titulo, other.getTitulo())){
            return false;
        }
        if(this.duracao != other.getDuracao()){
            return false;
        }
        if(this.preco != other.getPreco()){
            return false;
        }
        return (Objects.equals(this.diretor, other.getDiretor()));
    }

    @Override
    public int hashCode() {
        int hash = 12;
        hash = 25 * hash + Objects.hashCode(this.titulo);
        hash = 25 * hash + Objects.hashCode(this.diretor);
        hash = 25 * hash + (int) (Double.doubleToLongBits(this.duracao) ^ (Double.doubleToLongBits(this.duracao) >>> 32));
        hash = 25 * hash + (int) (Double.doubleToLongBits(this.preco) ^ (Double.doubleToLongBits(this.preco) >>> 32));
        return hash;
    }
    
    @Override
    public String toString(){
        return "Filme { Titulo: " + this.titulo +
               " - Diretor: " + this.diretor +
               " - Duracao: " + this.duracao +
               " Horas - Preco: R$" + this.preco + " }";
    }
    
    
    public String getTitulo() {
        return this.titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDiretor() {
        return this.diretor;
    }
    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public double getDuracao() {
        return this.duracao;
    }
    public void setDuracao(float duracao) {
        this.duracao = duracao;
    }

    public double getPreco() {
        return this.preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    
    
}
