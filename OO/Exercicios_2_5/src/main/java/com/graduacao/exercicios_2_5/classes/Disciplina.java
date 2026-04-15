package com.graduacao.exercicios_2_5.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Disciplina {
    private String nome;
    private String horario;
    private int semestre;
    private Professor professor;
    private List<Aluno> alunos;
    
    public Disciplina(){
        this.nome = "";
        this.horario = "";
        this.semestre = 0;
        this.professor = new Professor();
        this.alunos = new ArrayList<>();
    }
    public Disciplina(String nome, String horario, int semestre, Professor professor, List<Aluno> alunos) {
        this.nome = nome;
        this.horario = horario;
        this.semestre = semestre;
        this.professor = professor;
        this.alunos = alunos;
    }
    public Disciplina(Disciplina outra){
        this.nome = outra.getNome();
        this.horario = outra.getHorario();
        this.semestre = outra.getSemestre();
        this.professor = new Professor(outra.getProfessor());
        
        this.alunos = new ArrayList<>();
        
        for(Aluno a: alunos){
            Aluno aluno = new Aluno(a);
            this.alunos.add(aluno);
        }
    }
    public void copiar(Disciplina outra){
        this.nome = outra.getNome();
        this.horario = outra.getHorario();
        this.semestre = outra.getSemestre();
        this.professor.copiar(outra.getProfessor());
        
        this.alunos.clear();
        
        for(Aluno a: alunos){
            Aluno aluno = new Aluno(a);
            this.alunos.add(aluno);
        }
    }
    
    public void addAluno(Aluno aluno){
        this.alunos.add(aluno);
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.horario);
        hash = 97 * hash + this.semestre;
        hash = 97 * hash + Objects.hashCode(this.professor);
        hash = 97 * hash + Objects.hashCode(this.alunos);
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
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.horario, other.horario)) {
            return false;
        }
        if (!Objects.equals(this.professor, other.professor)) {
            return false;
        }
        return Objects.equals(this.alunos, other.alunos);
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Disciplina ---\n ");
        sb.append("Nome: ").append(this.nome).append("\n ");
        sb.append("Horario: ").append(this.horario).append("\n ");
        sb.append("Semestre: ").append(this.semestre).append("\n ");
        sb.append(this.professor.toString());
        
        for (Aluno aluno : this.alunos) {
            sb.append(aluno.toString());
        }
        
        return sb.toString();
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

    public Professor getProfessor() {
        return this.professor;
    }
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Aluno> getAlunos() {
        return this.alunos;
    }
    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}
