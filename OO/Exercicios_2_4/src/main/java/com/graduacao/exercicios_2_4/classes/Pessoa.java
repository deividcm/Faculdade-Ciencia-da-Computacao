package com.graduacao.exercicios_2_4.classes;

import java.util.Objects;

public class Pessoa {
    private String cpf;
    private String nome;
    private int idade;
    
    private static int contador;
    
    public Pessoa(){
        cpf = "";
        nome = "";
        idade = 0;
        
        contador++;
    }

    public Pessoa(String cpf, String nome, int idade) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        
        contador++;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.cpf);
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
        final Pessoa other = (Pessoa) obj;
        if (this.idade != other.idade) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        return Objects.equals(this.nome, other.nome);
    }

    @Override
    public String toString() {
        return "Pessoa{ " + "CPF: " + cpf + " - Nome: " + nome + " - Idade: " + idade + '}';
    }

    public String getCPF() {
        return this.cpf;
    }
    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return this.idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public static int getContador(){
        return contador;
    }
}
