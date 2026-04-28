
package com.graduacao.exercicios_3_2.gerenciadores.exercicio01;

import com.graduacao.exercicios_3_2.classes.exercicio01.Pessoa;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class GerenciadorPessoa {
    
    private final Map<String, Pessoa> pessoas;

    public GerenciadorPessoa() {
        this.pessoas = new HashMap<>();
    }
    public GerenciadorPessoa(GerenciadorPessoa outro){
        this.pessoas = new HashMap<>();
        
        for(Pessoa p: outro.getPessoas().values()){
            Pessoa pessoa = new Pessoa(p);
            this.pessoas.put(pessoa.getCPF(), pessoa);
        }
        
    }
    
    public void put(Pessoa pessoa){
        this.pessoas.put(pessoa.getCPF(), pessoa);
    }
    public Pessoa remove(String CPF){
        return this.pessoas.remove(CPF);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.pessoas);
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
        final GerenciadorPessoa other = (GerenciadorPessoa) obj;
        return Objects.equals(this.pessoas, other.getPessoas());
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Pessoas (").append(this.size()).append(") ---\n ");
        for(Pessoa pessoa: this.pessoas.values()){
            sb.append(pessoa.toString());
        }
        
        
        return sb.toString();
    }
    
    public int size(){
        return this.pessoas.size();
    }
    
    public boolean containsKey(String CPF){
        return this.pessoas.containsKey(CPF);
    }
    public Pessoa get(String CPF){
        return this.pessoas.get(CPF);
    }
    public Map<String, Pessoa> getPessoas() {
        return this.pessoas;
    }
}
