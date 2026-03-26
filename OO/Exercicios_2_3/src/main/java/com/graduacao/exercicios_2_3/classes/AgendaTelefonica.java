
package com.graduacao.exercicios_2_3.classes;

import java.util.HashMap;
import java.util.Map;


public class AgendaTelefonica {
    private Map<String, String> contatos;
    
    public AgendaTelefonica(){
        contatos = new HashMap<>();
    }
    
    public boolean adicionarContato(String nome, String num){
        contatos.put(nome, num);
        return contatos.containsKey(nome);
    }
    
    public boolean removerContato(String nome){
        if(contatos.containsKey(nome)){
            contatos.remove(nome);
            return true;
        }
        
        return false;
    }
    
    public String buscarContato(String nome){
        return contatos.getOrDefault(nome, "Contato nao encontrado");
    }
    
    public void imprimirContatos(){
        for (Map.Entry<String,String> contato : contatos.entrySet()){
            System.out.println(contato.getKey() + ": " + contato.getValue());
        }
        
    }
    
    
    
}
