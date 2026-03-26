
package com.graduacao.exercicios_2_3.classes;

import java.util.ArrayList;
import java.util.List;


public class GerenciadorFilmes {
    private List<Filme> filmes;
    
    public GerenciadorFilmes(){
        filmes = new ArrayList<>();
    }
    
    public void adicionarFilme(Filme filme){
        filmes.add(filme);
    }
    
    public boolean removerFilme(String titulo){

        for(Filme filme: filmes){
            if(titulo.equals(filme.getTitulo())){
                filmes.remove(filme);
                return true;
            }
        }
        
        return false;
        
    }
    
    
    public Filme pesquisarFilmeTitulo(String titulo){
        for(Filme filme: filmes){
            if(titulo.equals(filme.getTitulo())){
                return filme;
            }
        }
        return null;
    }
    public Filme pesquisarFilmeDiretor(String diretor){
        for(Filme filme: filmes){
            if(diretor.equals(filme.getDiretor())){
                return filme;
            }
        }
        return null;
    }
}
