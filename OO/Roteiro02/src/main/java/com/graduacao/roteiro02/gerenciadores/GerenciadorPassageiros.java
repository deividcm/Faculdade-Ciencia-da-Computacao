package com.graduacao.roteiro02.gerenciadores;

import com.graduacao.roteiro02.classes.Passageiro;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class GerenciadorPassageiros {
    
    private final Map<String, Passageiro> passsageiros;
    
    public GerenciadorPassageiros(){
        this.passsageiros = new HashMap<>();
    }
    public GerenciadorPassageiros(GerenciadorPassageiros outro){
        this.passsageiros = new HashMap<>();
        
        for(Passageiro p: outro.getPasssageiros().values()){
            Passageiro passageiro = new Passageiro(p);
            this.passsageiros.put(passageiro.getCPF(), passageiro);
        }
    }
    
    public void put(Passageiro passageiro){
        this.passsageiros.put(passageiro.getCPF(), passageiro);
    }
    public Passageiro remove(String CPF){
        return this.passsageiros.remove(CPF);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.passsageiros);
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
        final GerenciadorPassageiros other = (GerenciadorPassageiros) obj;
        
        return Objects.equals(this.passsageiros, other.passsageiros);
    }
    
    public String toStringResumido(){
        StringBuilder sb = new StringBuilder();
        
        for(Passageiro passageiro: this.passsageiros.values()){
            sb.append(passageiro.toStringResumido());
        }
        
        return sb.toString();
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        for(Passageiro passageiro: this.passsageiros.values()){
            sb.append(passageiro.toString());
        }
        
        return sb.toString();
    }
    
    public Passageiro get(String CPF){
        return this.passsageiros.get(CPF);
    }
    
    public Map<String, Passageiro> getPasssageiros() {
        return passsageiros;
    }
    
    public boolean containsKey(String CPF){
        return this.passsageiros.containsKey(CPF);
    }
    
    public int size(){
        return this.passsageiros.size();
    }

}
