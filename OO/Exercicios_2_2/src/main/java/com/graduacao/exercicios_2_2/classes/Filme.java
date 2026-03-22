
package com.graduacao.exercicios_2_2.classes;

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
        System.out.print("Informe o Preco: R$");
        this.preco = ler.nextDouble(); 
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
