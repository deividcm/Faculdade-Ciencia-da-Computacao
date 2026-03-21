
package com.graduacao.exercicios_2_2_1.exercicios;

import java.util.LinkedList;
import java.util.Queue;


public class FilaBanco {
    
    
    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<>();
        
        fila.add("Pedro");
        fila.add("Jose");
        fila.add("Rosa");
        fila.add("Maria");
        fila.add("Eva");
        
        while(!fila.isEmpty()){
            System.out.print("Atendendo: " + fila.poll());
            if(fila.peek() != null){
                System.out.println(" Proximo: " + fila.peek());
            }
            else{
                System.out.println("");
            }
            System.out.println("Faltam: " + fila.size() + " clientes");
        }
        
        System.out.println("A fila esta vazia");
        
    }
    
}
