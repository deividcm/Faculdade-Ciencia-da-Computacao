package com.graduacao.roteiro02.classes;

import java.util.Objects;

public class Passageiro {
    private String nome;
    private String CPF;
    private boolean embarcado;
    private final SistemaFidelidade sistemaFidelidade;
    
    public Passageiro(){
        this.nome = "";
        this.CPF = "000.000.000-00";
        this.sistemaFidelidade = new SistemaFidelidade();
    }
    public Passageiro(String nome, String CPF) {
        this.nome = nome;
        this.CPF = CPF;
        this.sistemaFidelidade = new SistemaFidelidade();
    }
    public Passageiro(Passageiro outro){
        this.nome = outro.getNome();
        this.CPF = outro.getCPF();
        this.sistemaFidelidade = new SistemaFidelidade(outro.getSistemaFidelidade());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.CPF);
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
        final Passageiro other = (Passageiro) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.CPF, other.CPF)) {
            return false;
        }
        return Objects.equals(this.sistemaFidelidade, other.sistemaFidelidade);
    }
    
    public String toStringResumido(){
        return this.CPF + " - " + this.nome + "\n ";
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Passageiro ---\n ");
        sb.append("Nome: ").append(this.nome).append("\n ");
        sb.append("CPF: ").append(this.CPF).append("\n ");
        sb.append("Embarcado: ").append(this.embarcado).append("\n ");
        sb.append("Pontos: ").append(this.sistemaFidelidade.getSaldoPontos()).append("\n ");
        
        return sb.toString();
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return this.CPF;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public SistemaFidelidade getSistemaFidelidade() {
        return this.sistemaFidelidade;
    }

    public boolean isEmbarcado() {
        return this.embarcado;
    }
    public void setEmbarcado(boolean embarcado) {
        this.embarcado = embarcado;
    }
    
    
}
