package com.graduacao.exercicios_2_6.classes.exercicio11;

import com.graduacao.exercicios_2_6.classes.exercicio11.Conta;
import java.util.Objects;


public class Transacao {
    private String ID;
    private String tipo;
    private String data;
    private double valor;
    private Conta contaAssociada;
    private Conta contaRecebedora;
    
    public Transacao(){
        this.ID = "";
        this.tipo = "";
        this.data = "";
        this.valor = 0.0;
        this.contaAssociada = null;
        this.contaRecebedora = null;
    }
    public Transacao(String ID, String tipo, String data, double valor, Conta contaAssociada, Conta contaRecebedora) {
        this.ID = ID;
        this.tipo = tipo;
        this.data = data;
        this.valor = valor;
        this.contaAssociada = contaAssociada;
        this.contaRecebedora = contaRecebedora;
    }
    public Transacao(Transacao outra){
        this.ID = outra.getID();
        this.tipo = outra.getTipo();
        this.data = outra.getData();
        this.valor = outra.getValor();
        this.contaAssociada.copiar(outra.getContaAssociada());
        this.contaRecebedora.copiar(outra.getContaRecebedora());
    }
    public void copiar(Transacao outra){
        this.ID = outra.getID();
        this.tipo = outra.getTipo();
        this.data = outra.getData();
        this.valor = outra.getValor();
        this.contaAssociada.copiar(outra.getContaAssociada());
        this.contaRecebedora.copiar(outra.getContaRecebedora());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.ID);
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
        final Transacao other = (Transacao) obj;
        if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(other.valor)) {
            return false;
        }
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.contaAssociada, other.contaAssociada)) {
            return false;
        }
        return Objects.equals(this.contaRecebedora, other.contaRecebedora);
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Transacao ---\n ");
        sb.append("ID: ").append(this.ID).append("\n ");
        sb.append("Tipo: ").append(this.tipo).append("\n ");
        sb.append("Data: ").append(this.data).append("\n ");
        sb.append("Valor: ").append(this.valor).append("\n ");
        sb.append("Conta Associada: ").append(this.contaAssociada.toStringResumido()).append("\n ");
        if(this.tipo.equalsIgnoreCase("transferencia")){
            sb.append("Recebedor: ").append(this.contaRecebedora.toStringResumido()).append("\n ");
        }
        
        return sb.toString();
    }

    public String getID() {
        return this.ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTipo() {
        return this.tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getData() {
        return this.data;
    }
    public void setData(String data) {
        this.data = data;
    }

    public double getValor() {
        return this.valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public Conta getContaAssociada() {
        return this.contaAssociada;
    }
    public void setContaAssociada(Conta contaAssociada) {
        this.contaAssociada = contaAssociada;
    }

    public Conta getContaRecebedora() {
        return this.contaRecebedora;
    }
    public void setContaRecebedora(Conta contaRecebedora) {
        this.contaRecebedora = contaRecebedora;
    }

    
}
