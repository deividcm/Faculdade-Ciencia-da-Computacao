package com.graduacao.exercicios_2_4.exercicios;

import com.graduacao.exercicios_2_4.classes.Pessoa;
import java.util.ArrayList;
import java.util.List;


public class ContadorPessoas {
    
    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>();
        Pessoa p1 = new Pessoa("041.361.212-25", "John", 13);
        Pessoa p2 = new Pessoa("034.021.104-13", "Rafael", 29);
        pessoas.add(p1);
        pessoas.add(p2);
        for(int i = 0; i < 20; i++){
            Pessoa p = new Pessoa();
            pessoas.add(p);
        }
        
        System.out.println(Pessoa.getContador()); 
    }
}
