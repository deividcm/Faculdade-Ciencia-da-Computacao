package com.graduacao.exercicios_3_6.classes.exercicio01;

import com.graduacao.exercicios_3_6.gerentes.exercicio01.GerenteAluno;
import java.util.Objects;


public class Disciplina {
    private String cod;
    private String nome;
    private String horario;
    private int semestre;
    private Professor ministrante;
    private final GerenteAluno gerenteAlunos;
    
    public Disciplina(){
        this.cod = "";
        this.nome = "";
        this.horario = "";
        this.semestre = 0;
        this.ministrante = new Professor();
        this.gerenteAlunos = new GerenteAluno();
    }
    public Disciplina(String cod, String nome, String horario, int semestre, Professor ministrante) {
        this.cod = cod;
        this.nome = nome;
        this.horario = horario;
        this.semestre = semestre;
        this.ministrante = ministrante;
        this.gerenteAlunos = new GerenteAluno();
    }
    public Disciplina(Disciplina outra){
        this.cod = outra.getCod();
        this.nome = outra.getNome();
        this.horario = outra.getHorario();
        this.semestre = outra.getSemestre();
        this.ministrante = new Professor(outra.getMinistrante());
        this.gerenteAlunos = new GerenteAluno(outra.getGerenteAlunos());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.cod);
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
        final Disciplina other = (Disciplina) obj;
        if (this.semestre != other.semestre) {
            return false;
        }
        if (!Objects.equals(this.cod, other.cod)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.horario, other.horario)) {
            return false;
        }
        if (!Objects.equals(this.ministrante, other.ministrante)) {
            return false;
        }
        return Objects.equals(this.gerenteAlunos, other.gerenteAlunos);
    }
    
    public String toStringResumido(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Disciplina ---\n ");
        sb.append("Código: ").append(this.cod).append("\n ");
        sb.append("Nome: ").append(this.nome).append("\n ");
        sb.append("Horário: ").append(this.horario).append("\n ");
        sb.append("Semestre: ").append(this.semestre).append("\n ");
        sb.append("Professor Ministrante: ").append(this.ministrante.getNome()).append("\n ");
        sb.append("Quantidade de Alunos: ").append(this.gerenteAlunos.size()).append("\n ");
        return sb.toString();
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Disciplina ---\n ");
        sb.append("Código: ").append(this.cod).append("\n ");
        sb.append("Nome: ").append(this.nome).append("\n ");
        sb.append("Horário: ").append(this.horario).append("\n ");
        sb.append("Semestre: ").append(this.semestre).append("\n ");
        sb.append(ministrante.toString());
        sb.append(this.gerenteAlunos.toString());
        
        
        return sb.toString();
    }

    public String getCod() {
        return this.cod;
    }
    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHorario() {
        return this.horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getSemestre() {
        return this.semestre;
    }
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public Professor getMinistrante() {
        return this.ministrante;
    }
    public void setMinistrante(Professor ministrante) {
        this.ministrante = ministrante;
    }

    public GerenteAluno getGerenteAlunos() {
        return this.gerenteAlunos;
    }
}
