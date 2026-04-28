
package com.graduacao.exercicios_3_2.gerenciadores.exercicio02;

import com.graduacao.exercicios_3_2.classes.exercicio02.Professor;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class GerenciadorProfessor {
    
    private final Map<String, Professor> professores;

    public GerenciadorProfessor() {
        this.professores = new HashMap<>();
    }
    public GerenciadorProfessor(GerenciadorProfessor outro){
        this.professores = new HashMap<>();
        
        for(Professor p: outro.getProfessores().values()){
            Professor professor = new Professor(p);
            this.professores.put(professor.getCPF(), professor);
        }
        
    }
    
    public void put(Professor professor){
        this.professores.put(professor.getCPF(), professor);
    }
    public Professor remove(String CPF){
        return this.professores.remove(CPF);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.professores);
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
        final GerenciadorProfessor other = (GerenciadorProfessor) obj;
        return Objects.equals(this.professores, other.getProfessores());
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Professores (").append(this.size()).append(") ---\n ");
        for(Professor professor: this.professores.values()){
            sb.append(professor.toString());
        }
        
        
        return sb.toString();
    }
    
    public int size(){
        return this.professores.size();
    }
    
    public boolean containsKey(String CPF){
        return this.professores.containsKey(CPF);
    }
    public Professor get(String CPF){
        return this.professores.get(CPF);
    }
    public Map<String, Professor> getProfessores() {
        return this.professores;
    }
}
