package com.graduacao.exercicios_2_6.gerentes.exercicio11;

import com.graduacao.exercicios_2_6.classes.exercicio11.Transacao;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GerenteTransacoes {
    
    private final Map<String, Transacao> transacoes;
    
    public GerenteTransacoes(){
        this.transacoes = new HashMap<>();
    }
    public GerenteTransacoes(GerenteTransacoes outro){
        this.transacoes = new HashMap<>();
        
        for(Transacao t: outro.getTransacoes().values()){
            Transacao transacao = new Transacao(t);
            this.transacoes.put(transacao.getID(), transacao);
        }
    }
    public void copiar(GerenteTransacoes outro){
        this.transacoes.clear();
        
        for(Transacao t: outro.getTransacoes().values()){
            Transacao transacao = new Transacao();
            transacao.copiar(t);
            this.transacoes.put(transacao.getID(), transacao);
        }
    } 
    
    public void put(Transacao transacao){
        this.transacoes.put(transacao.getID(), transacao);
    }
    public Transacao remove(String ID){
        return this.transacoes.remove(ID);
    }
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.transacoes);
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
        final GerenteTransacoes other = (GerenteTransacoes) obj;
        return Objects.equals(this.transacoes, other.transacoes);
    }
    
    public String toStringResumido(){
        StringBuilder sb = new StringBuilder();
        
        for(Transacao transacao: this.transacoes.values()){
            sb.append(transacao.toStringResumido());
        }
        
        return sb.toString();
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        for(Transacao transacao: this.transacoes.values()){
            sb.append(transacao.toString());
        }
        
        return sb.toString();
    }
    
    public boolean containsKey(String ID){
        return this.transacoes.containsKey(ID);
    }
    
    public Transacao get(String ID){
        return this.transacoes.get(ID);
    }

    public int size(){
        return this.transacoes.size();
    }
    
    public Map<String, Transacao> getTransacoes() {
        return this.transacoes;
    }

}
