
package com.graduacao.exercicios_2_5.classes;

import java.util.Objects;

public class Funcionario {
    private String nome;
    private String matricula;
    private double salario;
    private Endereco endereco;
    
    public Funcionario(){
        this.nome = "";
        this.matricula = "";
        this.salario = 0.0;
        this.endereco = new Endereco();
    }
    public Funcionario(String nome, String matricula, double salario, Endereco endereco) {
        this.nome = nome;
        this.matricula = matricula;
        this.salario = salario;
        this.endereco = endereco;
    }
    public Funcionario(Funcionario outro){
        this.nome = outro.getNome();
        this.matricula = outro.getMatricula();
        this.salario = outro.getSalario();
        this.endereco = new Endereco(outro.getEndereco());
    }
    public void copiar(Funcionario outro){
        this.nome = outro.getNome();
        this.matricula = outro.getMatricula();
        this.salario = outro.getSalario();
        this.endereco.copiar(outro.getEndereco());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.matricula);
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
        final Funcionario other = (Funcionario) obj;
        if (Double.doubleToLongBits(this.salario) != Double.doubleToLongBits(other.salario)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        return Objects.equals(this.endereco, other.endereco);
    }
    
    @Override
    public String toString(){
        return "--- Funcionario ---\n "+ 
               "Nome: " + this.nome + "\n " +
               "Matricula: " + this.matricula + "\n " +
               "Salario: " + this.salario + "\n " +
               this.endereco.toString();
    }
    
    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return this.matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getSalario() {
        return this.salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
