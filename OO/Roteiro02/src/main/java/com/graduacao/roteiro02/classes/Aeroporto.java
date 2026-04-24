package com.graduacao.roteiro02.classes;

import com.graduacao.roteiro02.gerenciadores.GerenciadorPassageiros;
import com.graduacao.roteiro02.gerenciadores.GerenciadorVoos;

public class Aeroporto {
    private String nome;
    private String localizacao;
    private final GerenciadorVoos gerenciadorVoos;
    private final GerenciadorPassageiros gerenciadorPassageiros;
    
    public Aeroporto(){
        this.nome = "";
        this.localizacao = "";
        this.gerenciadorVoos = new GerenciadorVoos();
        this.gerenciadorPassageiros = new GerenciadorPassageiros();
    }
    public Aeroporto(String nome, String localizacao) {
        this.nome = nome;
        this.localizacao = localizacao;
        this.gerenciadorVoos = new GerenciadorVoos();
        this.gerenciadorPassageiros = new GerenciadorPassageiros();
    }
    
    public String iniciarVoo(String numVoo){
        Voo voo = this.gerenciadorVoos.get(numVoo);
        
        voo.alterarEstadoVoo("Voando");
        
        return voo.toStringResumido();
    }
    
    public String concluirVoo(String numVoo){
        Voo voo = this.gerenciadorVoos.get(numVoo);
        
        voo.alterarEstadoVoo("Concluido");
        
        voo.recompensarPassageiros(100);
        
        return voo.toStringResumido();
    }
        
    
    public int qtdPrejuizos(){
        int contador = 0;
        
        for(Voo voo: this.gerenciadorVoos.getVoos().values()){
            if(voo.temPrejuizo()){
                contador++;
            }
        }
        
        return contador;
    }
    
    public String toStringPrejuizo(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Voos com Prejuizo (").append(this.qtdPrejuizos()).append(") ---\n ");
        
        for(Voo voo: this.gerenciadorVoos.getVoos().values()){
            if(voo.temPrejuizo()){
                sb.append(voo.toString());
            }
        }
        
        return sb.toString();
    }
    
    
    public String toStringVoos(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Voos (").append(this.gerenciadorVoos.size()).append(") ---\n ");
        sb.append(this.gerenciadorVoos.toString());
        
        return sb.toString();
    }
    public String toStringPassageiros(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Passageiros (").append(this.gerenciadorPassageiros.size()).append(") ---\n ");
        sb.append(this.gerenciadorPassageiros.toString());
        
        return sb.toString();
    }
    
    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return this.localizacao;
    }
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public GerenciadorVoos getGerenciadorVoos() {
        return this.gerenciadorVoos;
    }

    public GerenciadorPassageiros getGerenciadorPassageiros() {
        return this.gerenciadorPassageiros;
    }
    
}
