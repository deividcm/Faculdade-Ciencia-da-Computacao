package com.graduacao.roteiro01;

import com.graduacao.roteiro01.classes.Ponto;

public class Roteiro01 {

    public static void main(String[] args) {
        Ponto p1 = new Ponto(1,2);
        Ponto p2 = new Ponto(1,7);
        Ponto p3 = new Ponto(1,9);
        
        System.out.println(p1.distanciaDoisPontos(p3));
        
        System.out.println(p1.isColinear(p2, p3));
        
        p3.setX(6);
        
        System.out.println(p1.distanciaDoisPontos(p3));
        
        System.out.println(p1.isColinear(p2, p3));
        System.out.println(p1.getArea(p2, p3));
    }
}
