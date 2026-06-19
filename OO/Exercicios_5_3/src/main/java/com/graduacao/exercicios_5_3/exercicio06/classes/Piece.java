package com.graduacao.exercicios_5_3.exercicio06.classes;

public abstract class Piece {
    protected boolean color;
    
    public Piece(boolean color){
        this.color = color;
    }
    
    abstract void move();
    
}
