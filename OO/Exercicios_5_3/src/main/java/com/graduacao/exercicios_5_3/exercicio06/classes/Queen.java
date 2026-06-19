package com.graduacao.exercicios_5_3.exercicio06.classes;


public class Queen extends Piece{
    
    public Queen(boolean color){
        super(color);
    }
    @Override
    public void move(){
        System.out.println("Rainha se move linearmente ou diagonalmente");
    }
    
}
