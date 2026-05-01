package com.graduacao.exercicios_3_2.gerenciadores.exercicio04;

import com.graduacao.exercicios_3_2.classes.exercicio04.Livro;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class GerenciadorLivro {
    
    private final Map<String, Livro> livros;
    
    public GerenciadorLivro(){
        this.livros = new HashMap<>();
    }
    public GerenciadorLivro(GerenciadorLivro outro){
        this.livros = new HashMap<>();
        
        for(Livro l: outro.getLivros().values()){
            Livro livro = new Livro(l);
            
            this.livros.put(livro.getCod(), livro);
        }
    }
    
    public void put(Livro livro){
        this.livros.put(livro.getCod(), livro);
    }
    public Livro remove(String cod){
        return this.livros.remove(cod);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.livros);
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
        final GerenciadorLivro other = (GerenciadorLivro) obj;
        return Objects.equals(this.livros, other.livros);
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("--- Livros (").append(this.size()).append(") ---\n ");
        for(Livro livro: this.livros.values()){
            sb.append(livro.toString());
        }
        
        return sb.toString();
    }
    
    public int size(){
        return this.livros.size();
    }
    public boolean containsKey(String cod){
        return this.livros.containsKey(cod);
    }
    public Livro get(String cod){
        return this.livros.get(cod);
    }
    public Map<String, Livro> getLivros() {
        return this.livros;
    }
}
