package com.graduacao.exercicios_5_3.exercicio06.classes;


public class Knight extends Piece{
    public Knight(boolean color){
        super(color);
    }
    @Override
    public void move(){
        System.out.println("Cavalo se move em L");
    }
}
