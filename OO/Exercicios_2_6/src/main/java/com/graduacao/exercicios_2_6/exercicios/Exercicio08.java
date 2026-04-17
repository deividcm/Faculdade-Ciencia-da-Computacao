package com.graduacao.exercicios_2_6.exercicios;

import com.graduacao.exercicios_2_6.classes.Album;
import com.graduacao.exercicios_2_6.classes.Artista;
import com.graduacao.exercicios_2_6.classes.Musica;
import com.graduacao.exercicios_2_6.gerentes.GerenteArtistas;
import java.util.Scanner;

public class Exercicio08 {
    
    private static int imprimeMenu(Scanner ler){
        System.out.println("--------- Artistas ---------");
        System.out.println("1 - Adicionar artista");
        System.out.println("2 - Remover artista(Index)");
        System.out.println("0 - Sair");
        System.out.println("-------------------------------");
        System.out.println("Escolha uma opcao:");
        
        return ler.nextInt();
    }
    
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int opcao;
        GerenteArtistas gerente = new GerenteArtistas();
        
        do{
            opcao = imprimeMenu(ler);
            
            switch(opcao){
                case 0 -> {
                    System.out.println("Saindo...");
                    break;
                }
                case 1 -> {
                    Artista artista = criarPreenchendoArtista(ler);
                    gerente.addArtista(artista);
                    break;
                }
                
                
                default -> {
                    System.out.println("Opcao invalida!");
                }
            }
            
        }while(opcao != 0);
    }
    
    private static Artista criarPreenchendoArtista(Scanner ler){
        Artista artista = new Artista();
        System.out.println("--- Preenchendo Artista ---");
        System.out.print("Informe o nome: ");
        artista.setNome(ler.nextLine());
        
        String resposta;
        do{
            Album album = criarPreenchendoAlbum(ler);
            
            artista.getGerente().addAlbum(album);
            
            System.out.print("Criar outro album? [s/n]: ");
            resposta = ler.nextLine();
        }while(resposta.equalsIgnoreCase("s"));
        return artista;
    }
    
    private static Album criarPreenchendoAlbum(Scanner ler){
        Album album = new Album();
        System.out.println("--- Preenchendo Album ---");
        System.out.print("Informe o nome: ");
        album.setNome(ler.nextLine());
        System.out.print("Informe o ano de lancamento: ");
        album.setAnoLancamento(ler.nextInt());
        ler.nextLine();
        
        String resposta;
        do{
            Musica musica = criarPreenchendoMusica(ler);
            
            album.getGerente().addMusica(musica);
            
            System.out.print("Criar outro album? [s/n]: ");
            resposta = ler.nextLine();
        }while(resposta.equalsIgnoreCase("s"));
        
        return album;
    }
    
    private static Musica criarPreenchendoMusica(Scanner ler){
        Musica musica = new Musica();
        System.out.println("--- Preenchendo Musica ---");
        System.out.print("Informe o titulo: ");
        musica.setTitulo(ler.nextLine());
        System.out.print("Informe a duracao: ");
        musica.setDuracao(ler.nextDouble());
        ler.nextLine();
        return musica;
    }
    
}
