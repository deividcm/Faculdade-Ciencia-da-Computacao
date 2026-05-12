package com.graduacao.exercicios_3_6.gerentes.exercicio01;

import com.graduacao.exercicios_3_6.classes.exercicio01.Professor;
import com.graduacao.exercicios_3_6.file.FilePersistence;
import com.graduacao.exercicios_3_6.file.exercicio01.SerializadorProfessor;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GerenteProfessor {
    
    private Map<String, Professor> professores;
    
    public GerenteProfessor(){
        this.professores = new HashMap<>();
    }
    public GerenteProfessor(GerenteProfessor outro){
        this.professores = new HashMap<>();
        
        for(Professor p: outro.getProfessores().values()){
            Professor professor = new Professor(p);
            this.professores.put(professor.getCpf(), professor);
        }
    }
    public void put(Professor professor){
        this.professores.put(professor.getCpf(), professor);
    }
    public Professor remove(String cpf){
        return this.professores.remove(cpf);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.professores);
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
        final GerenteProfessor other = (GerenteProfessor) obj;
        return Objects.equals(this.professores, other.professores);
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("--- Professores(").append(this.size()).append(") ---\n ");
        
        for(Professor professor: this.professores.values()){
            sb.append(professor.toString());
        }
        
        return sb.toString();
    }
    
    public void salvarNoArquivo(String pathFile){
        SerializadorProfessor serializador = new SerializadorProfessor();
        String data = serializador.toJSON(this);
        
        FilePersistence filePersistence = new FilePersistence();
        filePersistence.salvarEmArquivo(data, pathFile);
    }
    
    public void carregarDoArquivo(String pathFile){
        FilePersistence filePersistence = new FilePersistence();
        String data = filePersistence.carregarDeArquivo(pathFile);
        
        SerializadorProfessor serializador = new SerializadorProfessor();
        this.professores = serializador.fromJSON(data).getProfessores();
    }
    
    public boolean containsKey(String cpf){
        return this.professores.containsKey(cpf);
    }
    public int size(){
        return this.professores.size();
    }
    public Professor get(String cpf){
        return this.professores.get(cpf);
    }
    public Map<String, Professor> getProfessores() {
        return this.professores;
    }
}
