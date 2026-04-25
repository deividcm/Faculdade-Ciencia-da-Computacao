package com.graduacao.exercicios_2_6.classes.exercicio08;

import com.graduacao.exercicios_2_6.gerentes.exercicio08.GerenteMusicas;
import java.util.Objects;

public class Album {
    private String nome;
    private int anoLancamento;
    private GerenteMusicas gerente;
    
    public Album(){
        this.nome = "";
        this.anoLancamento = 0;
        this.gerente= new GerenteMusicas();
    }
    public Album(String nome, int anoLancamento) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.gerente = new GerenteMusicas();
    }
    public Album(Album outro){
        this.nome = outro.getNome();
        this.anoLancamento = outro.getAnoLancamento();
        this.gerente = new GerenteMusicas(outro.getGerente());
    }
    public void copiar(Album outro){
        this.nome = outro.getNome();
        this.anoLancamento = outro.getAnoLancamento();
        this.gerente.copiar(outro.getGerente());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.nome);
        hash = 79 * hash + this.anoLancamento;
        hash = 79 * hash + Objects.hashCode(this.gerente);
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
        final Album other = (Album) obj;
        if (this.anoLancamento != other.anoLancamento) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.gerente, other.gerente);
    }
    
    public String toStringResumido(){
        return this.nome + ": " + this.gerente.size() + " Musicas\n ";
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Album ---\n ");
        sb.append("Nome: ").append(this.nome).append("\n ");
        sb.append("Ano de lancamento: ").append(this.anoLancamento).append("\n ");
        sb.append(this.gerente.toString());
        
        return sb.toString();
    }
    
    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoLancamento() {
        return this.anoLancamento;
    }
    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public GerenteMusicas getGerente() {
        return this.gerente;
    }
}
