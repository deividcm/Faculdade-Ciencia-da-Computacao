package com.graduacao.exercicios_2_6.gerentes;

import com.graduacao.exercicios_2_6.classes.Projeto;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;



public class GerenteProjetos {
    
    private final Map<String, Projeto> projetos;
    
    public GerenteProjetos(){
        this.projetos = new HashMap<>();
    }
    /*public GerenteProjetos(GerenteProjetos outro){ Loop Infinito, ignorar por enquanto
        this.projetos = new ArrayList<>();
        
        for(Projeto p: outro.getProjetos()){
            Projeto projeto = new Projeto(p);
            this.projetos.add(projeto);
        }
        
    }*/
    public void putProjeto(Projeto projeto){
        this.projetos.put(projeto.getCodigo(), projeto);
    }
    public Projeto removerProjeto(String codigo){
        return this.projetos.remove(codigo);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.projetos);
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
        final GerenteProjetos other = (GerenteProjetos) obj;
        return Objects.equals(this.projetos, other.projetos);
    }
    
    public String toStringResumido(){
        StringBuilder sb = new StringBuilder();
        
        for(Projeto projeto: this.projetos.values()){
            sb.append(projeto.toStringResumido());
        }
        
        return sb.toString();
    }
    
    @Override 
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        for(Projeto projeto: this.projetos.values()){
            sb.append(projeto.toString());
        }
        
        return sb.toString();
    }
    
    public boolean containsKey(String codigo){
        return this.projetos.containsKey(codigo);
    }
    
    public int size(){
        return this.projetos.size();
    }
    
    public Projeto getProjeto(String codigo){
        return this.projetos.get(codigo);
    }
    
    public Map<String, Projeto> getProjetos() {
        return projetos;
    }
}
