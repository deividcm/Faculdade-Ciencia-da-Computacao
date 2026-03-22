

package com.graduacao.exercicios_2_2;

import com.graduacao.exercicios_2_2.classes.Musica;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class ProjetoCadMusica {
    public static int imprimeMenu(){
        Scanner ler = new Scanner(System.in);

        System.out.println("-------ProjetoCadMusica-------");
        System.out.println("1 - Inserir Musica");
        System.out.println("2 - Remover Musica");
        System.out.println("3 - Pesquisar Musica (titulo)");
        System.out.println("4 - Pesquisar Musica (artista)");
        System.out.println("0 - Sair");
        System.out.println("-----------------------------");
        System.out.println("Escolha uma opcao:");
        
        return ler.nextInt();
    }
    
    public static void main(String[] args) {
        List<Musica> listaMusicas = new ArrayList<Musica>();
        Scanner ler = new Scanner(System.in);
        int opcao = 0;
        
        
        do{
            opcao = imprimeMenu();
            Musica encontrada = null;
            switch(opcao){
                case 1 -> {
                    Musica m = new Musica();
                    m.preencher();
                    listaMusicas.add(m);
                    break;
                }
                case 2 -> {
                    System.out.print("Informe o titulo: ");
                    String titulo = ler.nextLine();
                    
                    for(Musica mi: listaMusicas){
                        if (titulo.equals(mi.getTitulo())){
                            encontrada = mi;
                            System.out.println("Musica encontrada");
                            listaMusicas.remove(mi);
                        }
                    }
                    if (encontrada == null){
                        System.out.println("Musica nao foi encontrada");
                    }
                    break;
                }
                    
                case 3 -> {
                    System.out.print("Informe o titulo: ");
                    String titulo = ler.nextLine(); 
                    
                    for (Musica mi: listaMusicas){
                        if (titulo.equals(mi.getTitulo())){
                            encontrada = mi;
                            System.out.println(mi);
                        }
                        
                    }
                    if (encontrada == null){
                        System.out.println("Musica nao foi encontrada");
                    }
                    break;
                }
                case 4 -> {
                    System.out.print("Informe o artista: ");
                    String artista = ler.nextLine();
                    
                    for (Musica mi: listaMusicas){
                        if(artista.equals(mi.getArtista())){
                            encontrada = mi;
                            System.out.println(mi);
                        }
                    }
                    if (encontrada == null){
                        System.out.println("Musica nao foi encontrada");
                    }
                    break;
                }
                 
                    
                
            }
            encontrada = null;
            
            
        }while(opcao != 0);
        
        
    }
}
