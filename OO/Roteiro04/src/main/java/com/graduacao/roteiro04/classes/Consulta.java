
package com.graduacao.roteiro04.classes;


import java.util.Objects;

public class Consulta {
    private Medico medico;
    private Paciente paciente;
    private String schedule;
    private String cod;
    
    public Consulta () {
        medico = new Medico ();
        paciente = new Paciente ();
        schedule = "";
        cod = "";
    }
    
    public Consulta (Medico medico , Paciente paciente , String schedule , String cod) {
        this.medico = medico;
        this.paciente = paciente;
        this.schedule = schedule;
        this.cod = cod;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.cod);
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
        final Consulta other = (Consulta) obj;
        if (!Objects.equals(this.schedule, other.schedule)) {
            return false;
        }
        if (!Objects.equals(this.cod, other.cod)) {
            return false;
        }
        if (!Objects.equals(this.medico, other.medico)) {
            return false;
        }
        return Objects.equals(this.paciente, other.paciente);
    }

    @Override
    public String toString() {
        return "Consulta{" + "medico=" + medico + ", paciente=" + paciente + ", schedule=" + schedule + ", cod=" + cod + '}';
    }
    
    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getCod () {
        return cod;
    }
    
    public void setCod(String cod) {
        this.cod = cod;
    }
    
    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
    
    
}
