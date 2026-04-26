package com.graduacao.exercicios_2_6.exercicios;

import com.graduacao.exercicios_2_6.classes.exercicio08.Album;
import com.graduacao.exercicios_2_6.classes.exercicio08.Artista;
import com.graduacao.exercicios_2_6.classes.exercicio08.Musica;
import com.graduacao.exercicios_2_6.gerentes.exercicio08.GerenteArtistas;
import java.util.Scanner;

public class Exercicio08 {
    
    private static int imprimeMenu(Scanner ler){
        System.out.println("------- Gerenciador de Artistas -------");
        System.out.println("01 - Adicionar Artista");
        System.out.println("02 - Remover Artista(Index)");
        System.out.println("03 - Remover Artista(Nome)");
        System.out.println("04 - Pesquisar e Imprimir Artista(Nome)");
        System.out.println("05 - Pesquisar e Gerenciar Artista(Nome)");
        System.out.println("06 - Pesquisar Artista com mais Albuns");
        System.out.println("07 - Listar Artistas(Resumido)");
        System.out.println("08 - Listar Artistas(Completo)");
        System.out.println("00 - Sair");
        System.out.println("---------------------------------------");
        System.out.println("Escolha uma opcao:");
        
        return ler.nextInt();
    }
    
    private static int imprimeMenu(Scanner ler, String nome){
        System.out.println("------- " + nome +" -------");
        System.out.println("01 - Adicionar Album");
        System.out.println("02 - Remover Album(Index)");
        System.out.println("03 - Remover Album(Nome)");
        System.out.println("04 - Pesquisar e Imprimir Album(Nome)");
        System.out.println("05 - Pesquisar Album com mais Musicas");
        System.out.println("06 - Listar Albuns(Resumido)");
        System.out.println("07 - Listar Albuns(Completo)");
        System.out.println("00 - Voltar");
        System.out.println("----------------------------");
        System.out.println("Escolha uma opcao:");
        
        return ler.nextInt();
    }
    
    
    
    private static void menuArtista(Scanner ler, Artista artista){
        int opcao;
        
        do{
            opcao = imprimeMenu(ler, artista.getNome());
            ler.nextLine();
            switch(opcao){
                case 0 -> {
                    System.out.println("Voltando...");
                    break;
                }
                case 1 -> {
                    Album album = criarPreenchendoAlbum(ler);
                    artista.getGerente().addAlbum(album);
                }
                case 2 -> {
                    System.out.print("Informe o index: ");
                    int index = ler.nextInt();
                    
                    if(artista.getGerente().removerAlbum(index)){
                        System.out.println("Album removido com sucesso!");
                    }else{
                        System.out.println("Index invalido!");
                    }
                    break;
                }
                case 3 -> {
                    System.out.print("Informe o nome: ");
                    String nome = ler.nextLine();
                    
                    if(artista.getGerente().removerAlbum(nome)){
                        System.out.println("Album removido com sucesso!");
                    }else{
                        System.out.println("Album nao encontrado!");
                    }
                    break;
                }
                case 4 -> {
                    System.out.print("Informe o nome: ");
                    String nome = ler.nextLine();
                    
                    Album album = artista.getGerente().getAlbum(nome);
                    
                    if(album != null){
                        System.out.println(album.toString());
                    }else{
                        System.out.println("Album nao encontrado!");
                    }
                    
                    break;
                }
                case 5 -> {
                    Album album = artista.getGerente().getMaiorAlbum();
                    
                    if(album != null){
                        System.out.println(album.toStringResumido());
                    }else{
                        System.out.println("Lista vazia!");
                    }
                    break;
                }
                case 6 ->{
                    System.out.println(artista.getGerente().toStringResumido());
                    break;
                }
                case 7 -> {
                    System.out.println(artista.getGerente().toString());
                    break;
                }
                
                default -> {
                    System.out.println("Opcao invalida!");
                }
            }
            
        }while(opcao !=0);
        
    }
    
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int opcao;
        GerenteArtistas gerente = new GerenteArtistas();
        
        do{
            opcao = imprimeMenu(ler);
            ler.nextLine();
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
                case 2 -> {
                    System.out.print("Informe o index: ");
                    int index = ler.nextInt();
                    if(gerente.removerArtista(index)){
                        System.out.println("Artista removido com sucesso!");
                    }else{
                        System.out.println("Index invalido!");
                    }
                    break;
                }
                case 3 -> {
                    System.out.print("Informe o nome: ");
                    String nome = ler.nextLine();
                    
                    if(gerente.removerArtista(nome)){
                        System.out.println("Artista removido com sucesso!");
                    }else{
                        System.out.println("Artista nao encontrado!");
                    }
                    break;
                }
                case 4 -> {
                    System.out.print("Informe o nome: ");
                    String nome = ler.nextLine();
                    
                    Artista artista = gerente.getArtista(nome);
                    
                    if(artista != null){
                        System.out.println(artista.toString());
                    }else{
                        System.out.println("Artista nao encontrado!");
                    }
                    break;
                }
                case 5 -> {
                    System.out.print("Informe o nome: ");
                    String nome = ler.nextLine();
                    
                    Artista artista = gerente.getArtista(nome);
                    
                    if(artista != null){
                        menuArtista(ler,artista);
                    }else{
                        System.out.println("Artista nao encontrado!");
                    }
                    break;
                }
                case 6 -> {
                    Artista artista = gerente.getMaiorArtista();
                    if(artista != null){
                        System.out.println(artista.toStringResumido());
                    }else{
                        System.out.println("Lista vazia");
                    }
                    break;
                }
                case 7 -> {
                    System.out.println(gerente.toStringResumido());
                    break;
                }
                case 8 -> {
                    System.out.println(gerente.toString());
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
            
            System.out.print("Criar outra musica? [s/n]: ");
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
