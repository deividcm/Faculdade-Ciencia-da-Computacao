

package com.graduacao.exercicios_2_5.classes;

import java.util.Objects;

public class Endereco {
    private String rua;
    private int numero;
    private String bairro;
    private String cidade;
    
    public Endereco(){
        this.rua = "";
        this.numero = 0;
        this.bairro = "";
        this.cidade = "";
    }
    public Endereco(String rua, int numero, String bairro, String cidade) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
    }
    public Endereco(Endereco outro){
        this.rua = outro.getRua();
        this.numero = outro.getNumero();
        this.bairro = outro.getBairro();
        this.cidade = outro.getCidade();
    }
    
    public void copiar(Endereco outro){
        this.rua = outro.getRua();
        this.numero = outro.getNumero();
        this.bairro = outro.getBairro();
        this.cidade = outro.getCidade();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.rua);
        hash = 43 * hash + this.numero;
        hash = 43 * hash + Objects.hashCode(this.bairro);
        hash = 43 * hash + Objects.hashCode(this.cidade);
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
        final Endereco other = (Endereco) obj;
        if (this.numero != other.numero) {
            return false;
        }
        if (!Objects.equals(this.rua, other.rua)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        return Objects.equals(this.cidade, other.cidade);
    }
    
    
    
    
    
    @Override
    public String toString(){
        return "--- Endereco ---\n " +
               "Rua: " + this.rua + "\n " +
               "Numero: " + this.numero + "\n " +
               "Bairro: " + this.bairro + "\n " +
               "Cidade: " + this.cidade + "\n";
    }
    
    public String getRua() {
        return this.rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return this.numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return this.bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return this.cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
