package com.graduacao.exercicios_2_3.classes;

import java.util.Objects;
import java.util.Scanner;


public class Produto {
    private String codigo;
    private String nome;
    private int quantidadeEmEstoque;
    
    public Produto() {
        this.codigo = "";
        this.nome = "";
        this.quantidadeEmEstoque = 0;
    }
    public Produto(String codigo, String nome, int quantidadeEmEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }
    public Produto(Produto outro) {
        this.codigo = outro.getCodigo();
        this.nome = outro.getNome();
        this.quantidadeEmEstoque = outro.getQuantidadeEmEstoque();
    }

    
    public void preencher(){
        Scanner ler = new Scanner(System.in);
        
        System.out.print("Informe o Codigo: ");
        this.codigo = ler.next();
        System.out.print("Informe o Nome: ");
        this.nome = ler.nextLine();
        System.out.print("Informe a Quantidade em Estoque: ");
        this.quantidadeEmEstoque = ler.nextInt();
        ler.nextLine();
    }

    
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.codigo);
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
        final Produto other = (Produto) obj;
        if (this.quantidadeEmEstoque != other.quantidadeEmEstoque) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return Objects.equals(this.nome, other.nome);
    }

    @Override
    public String toString() {
        return "Produto{ " + "Codigo:" + codigo + 
               " - Nome:" + nome + 
               " - Quantidade em Estoque:" + quantidadeEmEstoque + '}';
    }
    
    
    public String getCodigo() {
        return this.codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeEmEstoque() {
        return this.quantidadeEmEstoque;
    }
    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }
    
    
}
