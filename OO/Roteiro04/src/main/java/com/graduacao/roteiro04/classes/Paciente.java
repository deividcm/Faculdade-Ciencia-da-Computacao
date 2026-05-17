
package com.graduacao.roteiro04.classes;

import java.util.Objects;

public class Paciente {
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String historico;
    
    public Paciente() {
        this.nome = "";
        this.cpf = "";
        this.dataNascimento = "";
        this.historico = "";
    }
    public Paciente (String nome , String cpf , String dataNascimento , String historico) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.historico = historico;
    }
    
    public Paciente(Paciente outro){
        this.nome = outro.getNome();
        this.cpf = outro.getCpf();
        this.dataNascimento = outro.getDataNascimento();
        this.historico = outro.getHistorico();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.cpf);
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
        final Paciente other = (Paciente) obj;
        if (!Objects.equals(this.nome, other.getNome())) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.getCpf())) {
            return false;
        }
        if (!Objects.equals(this.dataNascimento, other.getDataNascimento())) {
            return false;
        }
        return Objects.equals(this.historico, other.getHistorico());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("--- Paciente ---\n ");
        sb.append("Nome: ").append(this.nome).append("\n ");
        sb.append("CPF: ").append(this.cpf).append("\n ");
        sb.append("Data de Nascimento: ").append(this.dataNascimento).append("\n ");
        sb.append("Histórico: ").append(this.historico).append("\n ");
        
        
        return sb.toString();
    }
    
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getHistorico() {
        return this.historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }
    
    
    
}
