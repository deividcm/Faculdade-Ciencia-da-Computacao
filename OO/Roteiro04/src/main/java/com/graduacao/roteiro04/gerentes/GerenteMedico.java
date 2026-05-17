package com.graduacao.roteiro04.gerentes;

import com.graduacao.roteiro04.classes.Medico;
import com.graduacao.roteiro04.file.FilePersistence;
import com.graduacao.roteiro04.file.SerializadorMedico;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class GerenteMedico {
    
    private Map <String , Medico> medicos;

    public GerenteMedico () {
        this.medicos = new HashMap <>();
    }
    public GerenteMedico(GerenteMedico outro){
        this.medicos = new HashMap <>();
        
        for(Medico m: outro.getMedicos().values()){
            Medico medico = new Medico(m);
            this.medicos.put(medico.getCrm(), medico);
        }
    }
    
    public void put(Medico medico) {
        this.medicos.put(medico.getCrm(), medico);
    }
    
    public Medico remove (String crm) {
        return this.medicos.remove(crm);
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.medicos);
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
        final GerenteMedico other = (GerenteMedico) obj;
        return Objects.equals(this.medicos, other.getMedicos());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("--- Medicos(").append(this.size()).append(") ---\n ");
        
        for(Medico medico: this.medicos.values()){
            sb.append(medico.toString());
        }
        
        return sb.toString();
    }
    
    public void carregarDoArquivo(String pathFile){
        FilePersistence filePersistence = new FilePersistence();
        String data = filePersistence.carregarDeArquivo(pathFile);
        SerializadorMedico serializador = new SerializadorMedico();
        this.medicos = serializador.fromJSON(data).getMedicos();
    }
    public void salvarNoArquivo(String pathFile){
        SerializadorMedico serializador = new SerializadorMedico();
        String data = serializador.toJSON(this);
        FilePersistence filePersistence = new FilePersistence();
        filePersistence.salvarEmArquivo(data, pathFile);
    }
    
    public int size () {
        return this.medicos.size();
    }
    
    public boolean containsKey (String crm) {
        return this.medicos.containsKey(crm);
    }
    
    public Medico get(String crm) {
       return this.medicos.get(crm);
    }
    
    public Map<String, Medico> getMedicos() {
        return this.medicos;
    }
    
}
