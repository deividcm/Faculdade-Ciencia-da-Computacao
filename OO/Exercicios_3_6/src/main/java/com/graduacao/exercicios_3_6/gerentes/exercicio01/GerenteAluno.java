package com.graduacao.exercicios_3_6.gerentes.exercicio01;

import com.graduacao.exercicios_3_6.classes.exercicio01.Aluno;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class GerenteAluno {

    private Map<String, Aluno> alunos;
    
    public GerenteAluno(){
        this.alunos = new HashMap<>();
    }
    public GerenteAluno(GerenteAluno outro){
        this.alunos = new HashMap<>();
        
        for(Aluno a: outro.getAlunos().values()){
            Aluno aluno = new Aluno(a);
            this.alunos.put(aluno.getMatricula(), aluno);
        }
    }
    
    public void put(Aluno aluno){
        this.alunos.put(aluno.getMatricula(), aluno);
    }
    public Aluno remove(String matricula){
        return this.alunos.remove(matricula);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.alunos);
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
        final GerenteAluno other = (GerenteAluno) obj;
        return Objects.equals(this.alunos, other.alunos);
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Alunos(").append(this.size()).append(") ---\n ");
        
        for(Aluno aluno: this.alunos.values()){
            sb.append(aluno.toString());
        }
        
        return sb.toString();
    }
    
    public boolean containsKey(String matricula){
        return this.alunos.containsKey(matricula);
    }
    public int size(){
        return this.alunos.size();
    }
    public Aluno get(String matricula){
        return this.alunos.get(matricula);
    }
    public Map<String, Aluno> getAlunos() {
        return this.alunos;
    }
}
