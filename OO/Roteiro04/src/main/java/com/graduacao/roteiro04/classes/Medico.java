package com.graduacao.roteiro04.classes;


import java.util.Objects;

public class Medico {
    private String name;
    private String crm;
    private String especialty;
    private String avaliableSchedule;
    
    public Medico () {
        name = "";
        crm = "";
        especialty = "";
        avaliableSchedule = "";
    }
    
    public Medico (String name , String crm , String especialty , String avaliableSchedule) {
        this.name = name;
        this.crm = crm;
        this.especialty = especialty;
        this.avaliableSchedule = avaliableSchedule;
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
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.crm, other.crm)) {
            return false;
        }
        if (!Objects.equals(this.especialty, other.especialty)) {
            return false;
        }
        return Objects.equals(this.avaliableSchedule, other.avaliableSchedule);
    }

    @Override
    public String toString() {
        return "Medico{" + "name=" + name + ", crm=" + crm + ", especialty=" + especialty + ", avaliableSchedule=" + avaliableSchedule + '}';
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialty() {
        return especialty;
    }

    public void setEspecialty(String especialty) {
        this.especialty = especialty;
    }

    public String getAvaliableSchedule() {
        return avaliableSchedule;
    }

    public void setAvaliableSchedule(String avaliableSchedule) {
        this.avaliableSchedule = avaliableSchedule;
    }
    
    
}
