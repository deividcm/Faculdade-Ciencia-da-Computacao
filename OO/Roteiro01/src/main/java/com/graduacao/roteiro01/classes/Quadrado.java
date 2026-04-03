package com.graduacao.roteiro01.classes;

import java.util.Arrays;
    
public class Quadrado {

    Ponto p1, p2, p3, p4;

    public Quadrado(Ponto p1, Ponto p2, Ponto p3, Ponto p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    // fórmula correta da distância
    private double distancia(Ponto a, Ponto b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }

    public boolean ehQuadrado() {

        double[] d = new double[6];

        d[0] = distancia(p1, p2);
        d[1] = distancia(p1, p3);
        d[2] = distancia(p1, p4);
        d[3] = distancia(p2, p3);
        d[4] = distancia(p2, p4);
        d[5] = distancia(p3, p4);

        Arrays.sort(d);

        return d[0] > 0 &&
               d[0] == d[1] &&
               d[1] == d[2] &&
               d[2] == d[3] &&
               d[4] == d[5];
    }

    public double area() {
        double lado = distancia(p1, p2); 
        return lado * lado;
    }

    public double perimetro() {
        double lado = distancia(p1, p2);
        return 4 * lado;
    }
}
