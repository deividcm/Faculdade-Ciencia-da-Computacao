
package com.graduacao.exercicios_2_2_1.exercicios;

import java.util.HashSet;
import java.util.Set;

public class ListaPresenca {
    
    
    public static void main(String[] args) {
        Set<String> alunos = new HashSet<>();
        
        alunos.add("Ana");
        alunos.add("Bruno");
        alunos.add("Ana");
        alunos.add("Carlos");
        alunos.add("Bruno");
        alunos.add("Diana");
        
        System.out.println("Existem: " + alunos.size() + " alunos");
        System.out.println("Carlos esta presente?  " + alunos.contains("Carlos"));
        
        
    }
}
