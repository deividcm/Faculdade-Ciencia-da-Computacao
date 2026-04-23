package com.graduacao.exercicios_2_6.classes;

import com.graduacao.exercicios_2_6.gerentes.GerenteProjetos;
import java.util.Objects;


public class Funcionario {
    private String nome;
    private String ID;
    private final GerenteProjetos gerenteProjetos;
    
    public Funcionario(){
        this.nome = "";
        this.ID = "";
        this.gerenteProjetos = new GerenteProjetos();
    }
    public Funcionario(String nome, String ID) {
        this.nome = nome;
        this.ID = ID;
        this.gerenteProjetos = new GerenteProjetos();
    }
    /*public Funcionario(Funcionario outro){ Loop Infinito, ignorar por enquanto
        this.nome = outro.getNome();
        this.ID = outro.getID();
        
        this.gerenteProjetos = new GerenteProjetos(outro.getGerenteProjetos());
    }*/

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.ID);
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
        final Funcionario other = (Funcionario) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.ID, other.ID); //Não coloquei o gerenciador por receio de cair em um loop infinito
    }
    
    public String toStringResumido(){
        return this.ID + " - " + this.nome + "\n ";
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Funcionario ---\n ");
        sb.append("Nome: ").append(this.nome).append("\n ");
        sb.append("ID: ").append(this.ID).append("\n ");
        sb.append("--- Projetos Envolvidos (").append(this.gerenteProjetos.size()).append(") ---\n ");
        sb.append(this.gerenteProjetos.toStringResumido());
        
        return sb.toString();
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getID() {
        return this.ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }

    public GerenteProjetos getGerenteProjetos() {
        return gerenteProjetos;
    }
}
