
package com.graduacao.roteiro04.classes;


import java.util.Objects;

public class Consulta {
    private Medico medico;
    private Paciente paciente;
    private String data;
    private String hora;
    private String cod;
    
    public Consulta () {
        this.medico = new Medico ();
        this.paciente = new Paciente ();
        this.data = "DD/MM/AAAA";
        this.hora = "hh:mm";
        this.cod = "";
    }
    
    public Consulta (Medico medico , Paciente paciente , String data, String hora , String cod) {
        this.medico = medico;
        this.paciente = paciente;
        this.data = data;
        this.hora = hora;
        this.cod = cod;
    }
    
    public Consulta(Consulta outra){
        this.medico = outra.getMedico();
        this.paciente = outra.getPaciente();
        this.cod = outra.getCod();
        this.data = outra.getData();
        this.hora = outra.getHora();
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
        if (!Objects.equals(this.data, other.getData())) {
            return false;
        }
        if (!Objects.equals(this.hora, other.getHora())) {
            return false;
        }
        if (!Objects.equals(this.cod, other.getCod())) {
            return false;
        }
        if (!Objects.equals(this.medico, other.getMedico())) {
            return false;
        }
        return Objects.equals(this.paciente, other.getPaciente());
    }

    
    public String toStringResumido() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("--- Consulta ---\n ");
        sb.append("Código: ").append(this.cod).append("\n ");
        sb.append("Data: ").append(this.data).append("\n ");
        sb.append("Horário: ").append(this.hora).append("\n ");
        sb.append("Medico: ").append(this.medico.getNome()).append("\n ");
        sb.append("Paciente: ").append(this.paciente.getNome()).append("\n ");
        
        
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("--- Consulta ---\n ");
        sb.append("Código: ").append(this.cod).append("\n ");
        sb.append("Data: ").append(this.data).append("\n ");
        sb.append("Horário: ").append(this.hora).append("\n ");
        sb.append(this.medico.toString());
        sb.append(this.paciente.toString());
        
        
        return sb.toString();
    }
    
    public Medico getMedico() {
        return this.medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return this.paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getCod () {
        return this.cod;
    }
    
    public void setCod(String cod) {
        this.cod = cod;
    }
    
    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return this.hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    
}
