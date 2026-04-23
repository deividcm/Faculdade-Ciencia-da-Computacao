package com.graduacao.exercicios_2_6.gerentes;

import com.graduacao.exercicios_2_6.classes.Funcionario;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;



public class GerenteFuncionarios {
    
    private final Map<String, Funcionario> funcionarios;
    
    public GerenteFuncionarios(){
        this.funcionarios = new HashMap<>();
    }
    /*public GerenteFuncionarios(GerenteFuncionarios outro){ Loop Infinito, ignorar por enquanto
        this.funcionarios = new ArrayList<>();
        
        for(Funcionario f: outro.getFuncionarios()){
            Funcionario funcionario = new Funcionario(f);
            this.funcionarios.add(funcionario);
        }

    }*/
    
    public void putFuncionario(Funcionario funcionario){
        this.funcionarios.put(funcionario.getID(), funcionario);
    }
    public Funcionario removerFuncionario(String ID){
        return this.funcionarios.remove(ID);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.funcionarios);
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
        final GerenteFuncionarios other = (GerenteFuncionarios) obj;
        return Objects.equals(this.funcionarios, other.funcionarios);
    }
    
    
    public String toStringResumido(){
        StringBuilder sb = new StringBuilder();
        
        for(Funcionario funcionario: this.funcionarios.values()){
            sb.append(funcionario.toStringResumido());
        }
        
        return sb.toString();
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        for(Funcionario funcionario: this.funcionarios.values()){
            sb.append(funcionario.toString());
        }
        
        return sb.toString();
    }
    
    public boolean containsKey(String ID){
        return this.funcionarios.containsKey(ID);
    }
    
    public int size(){
        return this.funcionarios.size();
    }
    
    public Funcionario getFuncionario(String ID){
        return this.funcionarios.get(ID);
    }

    public Map<String, Funcionario> getFuncionarios() {
        return funcionarios;
    }
}
