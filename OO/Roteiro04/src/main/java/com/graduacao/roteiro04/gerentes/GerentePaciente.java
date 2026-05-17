package com.graduacao.roteiro04.gerentes;

import com.graduacao.roteiro04.classes.Paciente;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GerentePaciente {
    private Map <String , Paciente> pacientes;

    public GerentePaciente () {
        pacientes = new HashMap <>();
    }
    
    public void putPaciente (Paciente paciente) {
        pacientes.put(paciente.getCpf(), paciente);
    }
    
    public Paciente removePacienteByCpf (String cpf) {
        return pacientes.remove(cpf);
    }
    
    public Paciente searchPacienteByCpf (String cpf) {
       return pacientes.get(cpf);
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
        return Objects.equals(this.pacientes, other.pacientes);
    }

    @Override
    public String toString() {
        return "GerenciadorPaciente{" + "pacientes=" + pacientes + '}';
    }
    
    public int size () {
        return this.pacientes.size();
    }
    
    public boolean containsKey (String cpf) {
        return this.pacientes.containsKey(cpf);
    }
    
    public Map<String, Paciente> getPacientes() {
        return pacientes;
    }
}
