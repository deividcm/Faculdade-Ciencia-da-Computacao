package com.graduacao.exercicios_2_5.classes;

public class Motorista {
    private String nome;
    private Carro carro;
    
    public Motorista(){
        this.nome = "";
        this.carro = new Carro();
    }
    public Motorista(String nome, Carro carro) {
        this.nome = nome;
        this.carro = carro;
    }
    public Motorista(Motorista outro){
        this.nome = outro.getNome();
        this.carro.copiar(outro.getCarro());
    }
    
    public void copiar(Motorista outro){
        this.nome = outro.getNome();
        this.carro.copiar(outro.getCarro());
    }
    
    public void dirigir(){
        this.carro.abrirPorta(nome);
        System.out.println(this.nome + " esta dirigindo " + this.carro.getModelo());
        this.carro.buzinar();
    }
    
    
    @Override
    public String toString(){
        return "--- Motorista ---\n " +
               "Nome: " + this.nome + "\n " +
               this.carro;
    }

    
    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Carro getCarro() {
        return this.carro;
    }
    public void setCarro(Carro carro) {
        this.carro = carro;
    }
    
    
    
    
}
