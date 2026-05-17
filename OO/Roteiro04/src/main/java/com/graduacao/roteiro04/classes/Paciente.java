
package com.graduacao.roteiro04.classes;

import java.util.Objects;

public class Paciente {
    private String name;
    private String cpf;
    private String yearOfBirth;
    private String medicalHistory;
    
    public Paciente() {
        name = "";
        cpf = "";
        yearOfBirth = "";
        medicalHistory = "";
    }
    
    public Paciente (String name , String cpf , String yearOfBirth , String medicalHistory) {
        this.name = name;
        this.cpf = cpf;
        this.yearOfBirth = yearOfBirth;
        this.medicalHistory = medicalHistory;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.cpf);
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
        final Paciente other = (Paciente) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.yearOfBirth, other.yearOfBirth)) {
            return false;
        }
        return Objects.equals(this.medicalHistory, other.medicalHistory);
    }

    @Override
    public String toString() {
        return "Paciente{" + "name=" + name + ", cpf=" + cpf + ", yearOfBirth=" + yearOfBirth + ", medicalHistory=" + medicalHistory + '}';
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }
    
    
    
}
