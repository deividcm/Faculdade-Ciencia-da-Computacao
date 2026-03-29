

package com.graduacao.exercicios_2_4.exercicios;

import com.graduacao.exercicios_2_4.classes.Biblioteca;
import com.graduacao.exercicios_2_4.classes.Livro;

public class Exercicio02 {
    
    
    
    public static void main(String[] args) {
        Biblioteca b1 = new Biblioteca();
        b1.setNome("Biblioteca 1");//Define o nome de b1
        Livro l1 = new Livro("Quando as gaivotas choram", "Ryukishi07", 2007);
        b1.add(l1); //l1 muda o nomeBiblioteca para "Biblioteca 1" que é o nome de b1
        b1.getLivros().get(0).imprimirNomeBBT(); //Imprime o nome
        Biblioteca b2 = new Biblioteca();
        b2.setNome("Biblioteca 2");//Define o nome de b2
        Livro l2 = new Livro("Quando as cigarras choram", "Ryukishi07", 1983);
        b2.add(l2); // l2 muda o nomeBiblioteca para "Biblioteca 2" que é o nome de b2
       
        b1.getLivros().get(0).imprimirNomeBBT();// Ao imprimir o nomeBiblioteca usando l1 o nome imprimido é o de b2
        
        
        /*Isso acontece porque independente da biblioteca que o livro esteja
        o atributo "nomeBiblioteca é compartilhado entre todos os livros 
        pois ele pertence à classe Livro"*/
        
        
    }
}
