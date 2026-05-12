package com.graduacao.exercicios_3_6.gerentes.exercicio01;

import com.graduacao.exercicios_3_6.classes.exercicio01.Disciplina;
import com.graduacao.exercicios_3_6.file.FilePersistence;
import com.graduacao.exercicios_3_6.file.exercicio01.SerializadorDisciplina;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GerenteDisciplina {
    
    private Map<String, Disciplina> disciplinas;

    public GerenteDisciplina(){
        this.disciplinas = new HashMap<>();
    }
    public GerenteDisciplina(GerenteDisciplina outro){
        this.disciplinas = new HashMap<>();
        
        for(Disciplina d: outro.getDisciplinas().values()){
            Disciplina disciplina = new Disciplina(d);
            this.disciplinas.put(disciplina.getCod(), disciplina);
        }
    }
    public void put(Disciplina disciplina){
        this.disciplinas.put(disciplina.getCod(), disciplina);
    }
    public Disciplina remove(String cod){
        return this.disciplinas.remove(cod);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.disciplinas);
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
        final GerenteDisciplina other = (GerenteDisciplina) obj;
        return Objects.equals(this.disciplinas, other.disciplinas);
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("--- Disciplinas(").append(this.size()).append(") ---\n ");
        
        for(Disciplina disciplina: this.disciplinas.values()){
            sb.append(disciplina.toString());
        }
        
        return sb.toString();
    }
    
    public void salvarNoArquivo(String pathFile){
        SerializadorDisciplina serializador = new SerializadorDisciplina();
        String data = serializador.toJSON(this);
        
        FilePersistence filePersistence = new FilePersistence();
        filePersistence.salvarEmArquivo(data, pathFile);
    }
    
    public void carregarDoArquivo(String pathFile){
        FilePersistence filePersistence = new FilePersistence();
        String data = filePersistence.carregarDeArquivo(pathFile);
        
        SerializadorDisciplina serializador = new SerializadorDisciplina();
        this.disciplinas = serializador.fromJSON(data).getDisciplinas();
    }
    
    
    public boolean containsKey(String cod){
        return this.disciplinas.containsKey(cod);
    }
    public int size(){
        return this.disciplinas.size();
    }
    public Disciplina get(String cod){
        return this.disciplinas.get(cod);
    }
    public Map<String, Disciplina> getDisciplinas() {
        return this.disciplinas;
    }
}
