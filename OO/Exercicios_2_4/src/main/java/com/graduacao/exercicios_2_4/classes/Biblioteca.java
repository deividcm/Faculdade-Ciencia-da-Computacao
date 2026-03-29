
package com.graduacao.exercicios_2_4.classes;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nome;
    private List<Livro> livros;
    
    public Biblioteca(){
        livros = new ArrayList<>();
        nome = "";
    }

    public void add(Livro livro){
        livros.add(livro);
        livro.trocarNomeBBT(nome);
    }
    
    
    
    
    
    
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return this.nome;
    }

    public List<Livro> getLivros() {
        return livros;
    }
    
    
    
}
