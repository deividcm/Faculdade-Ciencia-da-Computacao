package com.graduacao.exercicios_2_1.classes;

import java.util.Scanner;

public class Ativo {
    private String nome_empresa;
    private double preco_acao;
    private double qtd_acoes;
    private double variacao_diaria; 

    
    public Ativo(){
        this.nome_empresa = "";
        this.preco_acao = 0.0;
        this.qtd_acoes = 0.0;
        this.variacao_diaria = 0.0;
    }
    public Ativo(Ativo outro){
        this.nome_empresa = outro.getNomeEmpresa();
        this.preco_acao = outro.getPrecoAcao();
        this.qtd_acoes = outro.getQtdAcoes();
        this.variacao_diaria = outro.getVariacaoDiaria();
    }
    public Ativo(String nome_empresa, double preco_acao, double qtd_acoes, double variacao_diaria) {
        this.nome_empresa = nome_empresa;
        this.preco_acao = preco_acao;
        this.qtd_acoes = qtd_acoes;
        this.variacao_diaria = variacao_diaria;
    }

    public void copiar(Ativo outro){
        this.nome_empresa = outro.getNomeEmpresa();
        this.preco_acao = outro.getPrecoAcao();
        this.qtd_acoes = outro.getQtdAcoes();
        this.variacao_diaria = outro.getVariacaoDiaria();
    }
    public void preencher(){
        Scanner ler = new Scanner(System.in);
        
        System.out.print("Informe o Nome da Empresa: ");
        this.nome_empresa = ler.next();
        System.out.print("Informe o Preco da Acao: ");
        this.preco_acao = ler.nextDouble();
        System.out.print("Informe a Quantidade de Acoes: ");
        this.qtd_acoes = ler.nextDouble();
        System.out.print("Informe a Variacao Diaria: ");
        this.variacao_diaria = ler.nextDouble(); 
    }
    
    public void exibirResumo(){
        System.out.println(this.nome_empresa + 
                " | Preco: R$" + this.preco_acao + 
                " | Qtd: " + this.qtd_acoes +
                " | Variacao: " + this.variacao_diaria +
                " | Posicao: " + this.calcularPosicaoDoAtivo());
        
    }
    
    
    public double calcularPosicaoDoAtivo(){
        return this.preco_acao * this.qtd_acoes;
    }
    
    @Override
    public String toString(){
        return "Ativo { Nome da Empresa: " + this.nome_empresa +
               " - Preco da Acao: R$" + this.preco_acao +
               " - Quantidade de Acoes: " + this.qtd_acoes +
               " - Variacao Diaria: " + this.variacao_diaria + " }";
    }
    
    public String getNomeEmpresa() {
        return this.nome_empresa;
    }
    public void setNomeEmpresa(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }

    public double getPrecoAcao() {
        return this.preco_acao;
    }
    public void setPrecoAcao(double preco_acao) {
        this.preco_acao = preco_acao;
    }

    public double getQtdAcoes() {
        return this.qtd_acoes;
    }
    public void setQtd_acoes(double qtd_acoes) {
        this.qtd_acoes = qtd_acoes;
    }

    public double getVariacaoDiaria() {
        return this.variacao_diaria;
    }
    public void setVariacaoDiaria(double variacaoDiaria) {
        this.variacao_diaria = variacaoDiaria;
    }
}
