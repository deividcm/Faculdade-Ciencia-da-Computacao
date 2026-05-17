package com.graduacao.roteiro04.gerentes;

import com.graduacao.roteiro04.classes.Paciente;
import com.graduacao.roteiro04.file.FilePersistence;
import com.graduacao.roteiro04.file.SerializadorPaciente;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GerentePaciente {
    private Map <String , Paciente> pacientes;

    public GerentePaciente () {
        this.pacientes = new HashMap <>();
    }
    public GerentePaciente(GerentePaciente outro){
        this.pacientes = new HashMap <>();
        
        for(Paciente p: outro.getPacientes().values()){
            Paciente paciente = new Paciente(p);
            this.pacientes.put(paciente.getCpf(), paciente);
        }
    }
    
    public void put(Paciente paciente) {
        this.pacientes.put(paciente.getCpf(), paciente);
    }
    
    public Paciente remove (String cpf) {
        return this.pacientes.remove(cpf);
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.pacientes);
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
        final GerentePaciente other = (GerentePaciente) obj;
        return Objects.equals(this.pacientes, other.getPacientes());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("--- Pacientes(").append(this.size()).append(") ---\n ");
        
        for(Paciente paciente: this.pacientes.values()){
            sb.append(paciente.toString());
        }
        
        return sb.toString();
    }
    
    public void carregarDoArquivo(String pathFile){
        FilePersistence filePersistence = new FilePersistence();
        String data = filePersistence.carregarDeArquivo(pathFile);
        SerializadorPaciente serializador = new SerializadorPaciente();
        this.pacientes = serializador.fromJSON(data).getPacientes();
    }
    public void salvarNoArquivo(String pathFile){
        SerializadorPaciente serializador = new SerializadorPaciente();
        String data = serializador.toJSON(this);
        FilePersistence filePersistence = new FilePersistence();
        filePersistence.salvarEmArquivo(data, pathFile);
    }
    
    public int size () {
        return this.pacientes.size();
    }
    
    public boolean containsKey (String cpf) {
        return this.pacientes.containsKey(cpf);
    }
    
    public Paciente get(String cpf) {
       return this.pacientes.get(cpf);
    }
    
    public Map<String, Paciente> getPacientes() {
        return this.pacientes;
    }
}
