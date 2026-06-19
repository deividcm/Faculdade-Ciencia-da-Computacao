
package com.graduacao.exercicios_5_3.exercicio06.classes;

public class Rook extends Piece{
    
    public Rook(boolean color){
        super(color);
    }
    
    @Override
    public void move(){
        System.out.println("Torre se move linearmente");
    }
    
}
