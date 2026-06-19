package com.graduacao.exercicios_5_3.exercicio06.classes;


public class Bishop extends Piece{
    
    public Bishop(boolean color){
        super(color);
    }
    @Override
    public void move(){
        System.out.println("Bispo se move diagonalmente");
    }
}
