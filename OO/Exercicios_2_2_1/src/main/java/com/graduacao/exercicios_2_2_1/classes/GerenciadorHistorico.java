

package com.graduacao.exercicios_2_2_1.classes;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class GerenciadorHistorico {
    private Stack<String> historico;
    private Set<String> sitesUnicos;
    
    public GerenciadorHistorico(){
        historico = new Stack<>();
        historico.push("https://www.google.com/");
        sitesUnicos = new HashSet<>();
        
        
    }
    public String siteAtual(){
        return historico.peek();
    }
    
    public void entrarEmSite(String link){
        historico.add(link);
    }
    
    public void voltarParaAnterior(){
        sitesUnicos.add(historico.pop());
    }
    
    public void finalizar(){
        int tamanho = historico.size();
        
        for(int i = 0; i < tamanho; i++){
            this.voltarParaAnterior();
        }
        
        System.out.println("Sites visitados: " + sitesUnicos);
    }
    
}
