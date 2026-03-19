

package com.graduacao.exercicios_2_3.projetos;

import com.graduacao.exercicios_2_3.classes.GerenciadorMusicas;
import com.graduacao.exercicios_2_3.classes.Musica;
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
        GerenciadorMusicas gerenciador = new GerenciadorMusicas();
        Scanner ler = new Scanner(System.in);
        int opcao = 0;
        
        
        do{
            opcao = imprimeMenu();
            switch(opcao){
                case 1 -> {
                    Musica musica = new Musica();
                    musica.preencher();
                    gerenciador.adicionarMusica(musica);
                }
                case 2 -> {
                    System.out.print("Informe o titulo: ");
                    String titulo = ler.nextLine();
                    
                    gerenciador.removerMusica(titulo);
                    
                }
                    
                case 3 -> {
                    System.out.print("Informe o titulo: ");
                    String titulo = ler.nextLine(); 
                    
                    Musica musica = gerenciador.pesquisarMusicaArtista(titulo);
                    if(musica != null){
                        System.out.println(musica);
                    }
                    else{
                        System.out.println("Musica nao encontrada");
                    }
                }
                case 4 -> {
                    System.out.print("Informe o artista: ");
                    String artista = ler.nextLine();
                    
                    Musica musica = gerenciador.pesquisarMusicaArtista(artista);
                    if(musica != null){
                        System.out.println(musica);
                    }
                    else{
                        System.out.println("Musica nao encontrada");
                    }
                    
                }

                 
                    
                
            }
            
            
        }while(opcao != 0);
        
        
    }
}
