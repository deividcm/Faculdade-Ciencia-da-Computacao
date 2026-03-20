
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
        
        System.out.println("Filme adicionado");
    }
    
    public void removerFilme(String titulo){
        boolean encontrado = false;
        
        for(Filme filme: filmes){
            if(titulo.equals(filme.getTitulo())){
                encontrado = true;
                filmes.remove(filme);
                System.out.println("Filme removido");
                break;
            }
        }
        
        if(encontrado == false){
            System.out.println("Filme nao foi encontrado");
        }
        
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
