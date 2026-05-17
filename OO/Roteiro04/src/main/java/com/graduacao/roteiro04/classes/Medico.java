package com.graduacao.roteiro04.classes;


import java.util.Objects;

public class Medico {
    private String nome;
    private String crm;
    private String especialidade;
    private String agendaDisponivel;
    
    public Medico () {
        this.nome = "";
        this.crm = "";
        this.especialidade = "";
        this.agendaDisponivel = "";
    }
    public Medico (String nome , String crm , String especialidade , String agendaDisponivel) {
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;
        this.agendaDisponivel = agendaDisponivel;
    }
    public Medico(Medico outro){
        this.nome = outro.getNome();
        this.crm = outro.getCrm();
        this.agendaDisponivel = outro.getAgendaDisponivel();
        this.especialidade = outro.getEspecialidade();
    }
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.crm);
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
        final Medico other = (Medico) obj;
        if (!Objects.equals(this.nome, other.getNome())) {
            return false;
        }
        if (!Objects.equals(this.crm, other.getCrm())) {
            return false;
        }
        if (!Objects.equals(this.especialidade, other.getEspecialidade())) {
            return false;
        }
        return Objects.equals(this.agendaDisponivel, other.getAgendaDisponivel());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("--- Médico ---\n ");
        sb.append("Nome: ").append(this.nome).append("\n ");
        sb.append("CRM: ").append(this.crm).append("\n ");
        sb.append("Especialidade: ").append(this.especialidade).append("\n ");
        sb.append("Horários Disponiveis: ").append(this.agendaDisponivel).append("\n ");
        
        return sb.toString();
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getAgendaDisponivel() {
        return agendaDisponivel;
    }

    public void setAgendaDisponivel(String agendaDisponivel) {
        this.agendaDisponivel = agendaDisponivel;
    }
    
    
}
