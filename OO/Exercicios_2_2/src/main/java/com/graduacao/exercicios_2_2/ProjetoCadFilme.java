/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.graduacao.exercicios_2_2;

import com.graduacao.exercicios_2_2.classes.Filme;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProjetoCadFilme {
    
    public static int imprimeMenu(){
        Scanner ler = new Scanner(System.in);

        System.out.println("-------ProjetoCadFilme-------");
        System.out.println("1 - Inserir Filme");
        System.out.println("2 - Remover Filme");
        System.out.println("3 - Pesquisar Filme (titulo)");
        System.out.println("4 - Pesquisar Filme (diretor)");
        System.out.println("0 - Sair");
        System.out.println("-----------------------------");
        System.out.println("Escolha uma opcao:");
        
        return ler.nextInt();
    }
    
    public static void main(String[] args) {
        List<Filme> listaFilmes = new ArrayList<Filme>();
        Scanner ler = new Scanner(System.in);
        int opcao = 0;
        
        
        do{
            opcao = imprimeMenu();
            Filme encontrado = null;
            switch(opcao){
                case 1 -> {
                    Filme f = new Filme();
                    f.preencher();
                    listaFilmes.add(f);
                    break;
                }
                case 2 -> {
                    System.out.print("Informe o titulo: ");
                    String titulo = ler.nextLine();
                    
                    for(Filme fi: listaFilmes){
                        if (titulo.equals(fi.getTitulo())){
                            encontrado = fi;
                            System.out.println("Filme encontrado");
                            listaFilmes.remove(fi);
                        }
                    }
                    if (encontrado == null){
                        System.out.println("Filme nao foi encontrado");
                    }
                    break;
                }
                    
                case 3 -> {
                    System.out.print("Informe o titulo: ");
                    String titulo = ler.nextLine(); 
                    
                    for (Filme fi: listaFilmes){
                        if (titulo.equals(fi.getTitulo())){
                            encontrado = fi;
                            System.out.println(fi);
                        }
                        
                    }
                    if (encontrado == null){
                        System.out.println("Filme nao foi encontrado");
                    }
                    break;
                }
                case 4 -> {
                    System.out.print("Informe o artista: ");
                    String artista = ler.nextLine();
                    
                    for (Filme fi: listaFilmes){
                        if(artista.equals(fi.getDiretor())){
                            encontrado = fi;
                            System.out.println(fi);
                        }
                    }
                    if (encontrado == null){
                        System.out.println("Filme nao foi encontrado");
                    }
                    break;
                }

                    
                
            }
            encontrado = null;
            
            
        }while(opcao != 0);
        
        
    }
}
