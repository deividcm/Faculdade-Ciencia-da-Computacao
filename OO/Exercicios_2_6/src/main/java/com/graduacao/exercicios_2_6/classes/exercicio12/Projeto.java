package com.graduacao.exercicios_2_6.classes.exercicio12;

import com.graduacao.exercicios_2_6.gerentes.exercicio12.GerenteFuncionarios;
import java.util.Objects;

public class Projeto {
    private String nome;
    private String codigo;
    private String descricao;
    private final GerenteFuncionarios gerenteFuncionarios;
    
    public Projeto(){
        this.nome = "";
        this.codigo = "";
        this.descricao = "";
        this.gerenteFuncionarios = new GerenteFuncionarios();
    }
    public Projeto(String nome, String codigo, String descricao) {
        this.nome = nome;
        this.codigo = codigo;
        this.descricao = descricao;
        this.gerenteFuncionarios = new GerenteFuncionarios();
    }
    /*public Projeto(Projeto outro){ Loop Infinito, ignorar por enquanto
        this.nome = outro.getNome();
        this.codigo = outro.getCodigo();
        this.descricao = outro.getDescricao();
        this.gerenteFuncionarios = new GerenteFuncionarios(outro.getGerenteFuncionarios());
    }*/

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.codigo);
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
        final Projeto other = (Projeto) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return Objects.equals(this.descricao, other.descricao); //Não coloquei o gerenciador por receio de cair em um loop infinito
    }
    
    public String toStringResumido(){
        return this.codigo + " - " + this.nome + ": " + this.descricao + "\n ";
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Projeto ---\n ");
        sb.append("Nome: ").append(this.nome).append("\n ");
        sb.append("Codigo: ").append(this.codigo).append("\n ");
        sb.append("Descricao: ").append(this.descricao).append("\n ");
        sb.append("--- Funcionarios Alocados (").append(this.gerenteFuncionarios.size()).append(") ---\n ");
        sb.append(this.gerenteFuncionarios.toStringResumido());
        
        return sb.toString();
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return this.codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public GerenteFuncionarios getGerenteFuncionarios() {
        return this.gerenteFuncionarios;
    }
}
