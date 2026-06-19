package com.graduacao.exercicios_5_3.exercicio06.classes;

import java.util.ArrayList;
import java.util.List;



public class ChessGame {
    private List<Piece> pecasBrancas;
    private List<Piece> pecasPretas;
    
    public ChessGame(){
        this.pecasBrancas = new ArrayList<>();
        this.pecasPretas = new ArrayList<>();
    }
    
    public void jogar(){
        this.pecasBrancas.clear();
        this.pecasPretas.clear();
        for(int i = 0; i < 8; i++){
            Piece peaoBranco = new Pawn(false);
            this.pecasBrancas.add(peaoBranco);
            Piece peaoPreto = new Pawn(true);
            this.pecasPretas.add(peaoPreto);
        }
        for(int i = 0; i < 2; i++){
            Piece torreBranca = new Rook(false);
            Piece torrePreta = new Rook(true);
            Piece cavaloBranco = new Knight(false);
            Piece cavaloPreto = new Knight(true);
            Piece bispoBranco = new Bishop(false);
            Piece bispoPreto = new Bishop(true);
            this.pecasBrancas.add(torreBranca);
            this.pecasBrancas.add(cavaloBranco);
            this.pecasBrancas.add(bispoBranco);
            this.pecasPretas.add(torrePreta);
            this.pecasPretas.add(cavaloPreto);
            this.pecasPretas.add(bispoPreto);
        }
        Piece rainhaBranca = new Queen(false);
        this.pecasBrancas.add(rainhaBranca);
        Piece rainhaPreta = new Queen(true);
        this.pecasPretas.add(rainhaPreta);
        Piece reiBranco = new King(false);
        this.pecasBrancas.add(reiBranco);
        Piece reiPreto = new King(true);
        this.pecasPretas.add(reiPreto);
    }
    
    public void move(boolean color, int index){
        if(color){
            this.pecasPretas.get(index).move();
        }
        else{
            this.pecasBrancas.get(index).move();
        }
    }
    
}
