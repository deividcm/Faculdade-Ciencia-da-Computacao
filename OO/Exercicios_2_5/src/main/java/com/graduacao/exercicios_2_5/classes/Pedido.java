
package com.graduacao.exercicios_2_5.classes;

import java.util.Objects;


public class Pedido {
    private String numero;
    private String data;
    private int quantidade;
    private Produto produto;
    
    public Pedido(){
        this.numero = "";
        this.data = "";
        this.quantidade = 0;
        this.produto = new Produto();
    }

    public Pedido(String numero, String data, int quantidade, Produto produto) {
        this.numero = numero;
        this.data = data;
        this.quantidade = quantidade;
        this.produto = produto;
    }
    public Pedido(Pedido outro){
        this.numero = outro.getNumero();
        this.data = outro.getData();
        this.quantidade = outro.getQuantidade();
    }
    public void copiar(Pedido outro){
        this.numero = outro.getNumero();
        this.data = outro.getData();

    }
    
    public double calcularPrecoTotal(){
        return quantidade * produto.getPreco();
    }
    
    @Override 
    public String toString(){
        return "--- Pedido ---\n " +
               "Numero: " + this.numero + "\n " +
               "Data: " + this.data + "\n " +
               "Quantidade: " + this.quantidade + "\n " +
               this.produto;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.numero);
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
        final Pedido other = (Pedido) obj;
        if (this.quantidade != other.quantidade) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return Objects.equals(this.produto, other.produto);
    }
    
    public String getNumero() {
        return this.numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getData() {
        return this.data;
    }
    public void setData(String data) {
        this.data = data;
    }

    public int getQuantidade() {
        return this.quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return this.produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    } 
}
