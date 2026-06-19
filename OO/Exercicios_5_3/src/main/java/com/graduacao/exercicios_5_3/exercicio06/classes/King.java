
package com.graduacao.exercicios_5_3.exercicio06.classes;


public class King extends Piece{
    public King(boolean color){
        super(color);
    }
    @Override
    public void move(){
        System.out.println("Rei se move por uma posição em qualquer direção");
    }
}
