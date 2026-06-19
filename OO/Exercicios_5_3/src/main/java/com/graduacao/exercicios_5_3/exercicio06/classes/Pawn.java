
package com.graduacao.exercicios_5_3.exercicio06.classes;


public class Pawn extends Piece{
    
    public Pawn(boolean color){
        super(color);
    }
    @Override
    public void move(){
        System.out.println("Peao se move 1 casa para frente");
    }
    
}
