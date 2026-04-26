package com.graduacao.exercicios_2_6.gerentes.exercicio11;

import com.graduacao.exercicios_2_6.classes.exercicio11.Conta;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GerenteContas {
    
    private final Map<String, Conta> contas;
    
    public GerenteContas(){
        this.contas = new HashMap<>();
    }
    public GerenteContas(GerenteContas outra){
        this.contas = new HashMap<>();
        
        for(Conta c: outra.getContas().values()){
            Conta conta = new Conta(c);
            this.contas.put(conta.getNumConta(), conta);
        }
    }
    public void copiar(GerenteContas outra){
        this.contas.clear();
        
        for(Conta c: outra.getContas().values()){
            Conta conta = new Conta();
            conta.copiar(c);
            this.contas.put(conta.getNumConta(), conta);
        }
    }
    
    public void put(Conta conta){
        this.contas.put(conta.getNumConta(), conta);
    }
    public Conta remove(String numConta){
        return this.contas.remove(numConta);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.contas);
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
        final GerenteContas other = (GerenteContas) obj;
        return Objects.equals(this.contas, other.contas);
    }
    
    public String toStringResumido(){
        StringBuilder sb = new StringBuilder();
        
        for(Conta conta: this.contas.values()){
            sb.append(conta.toStringResumido());
        }
        
        return sb.toString();
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        for(Conta conta: this.contas.values()){
            sb.append(conta.toString());
        }
        
        return sb.toString();
    }
    
    public boolean containsKey(String numConta){
        return this.contas.containsKey(numConta);
    }
    
    public Conta get(String numConta){
        return this.contas.get(numConta);
    }
    public int size(){
        return this.contas.size();
    }
    
    public Map<String, Conta> getContas() {
        return contas;
    }
}
