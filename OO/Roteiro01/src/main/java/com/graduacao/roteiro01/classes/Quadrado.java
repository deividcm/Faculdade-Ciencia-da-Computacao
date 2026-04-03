package com.graduacao.roteiro01.classes;
    
public class Quadrado {
    private Ponto p1;
    private Ponto p2;
    private Ponto p3;
    private Ponto p4;
    
    public Quadrado(){
        this.p1 = null;
        this.p2 = null;
        this.p3 = null;
        this.p4 = null;
    }
    public Quadrado(Ponto p1, Ponto p2, Ponto p3, Ponto p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }
    public Quadrado(Quadrado outro){
        this.p1.copiar(outro.getP1());
        this.p2.copiar(outro.getP2());
        this.p3.copiar(outro.getP3());
        this.p4.copiar(outro.getP4());
    }
    public void copiar(Quadrado outro){
        this.p1.copiar(outro.getP1());
        this.p2.copiar(outro.getP2());
        this.p3.copiar(outro.getP3());
        this.p4.copiar(outro.getP4());
    }
    
/*
    public boolean ehQuadrado() {

        double[] d = new double[6];

        d[0] = distancia(p1, p2);
        d[1] = distancia(p1, p3);
        d[2] = distancia(p1, p4);
        d[3] = distancia(p2, p3);
        d[4] = distancia(p2, p4);
        d[5] = distancia(p3, p4);

        Arrays.sort(d);
        
        //Acho que não funcionaria
        return d[0] > 0 &&
               d[0] == d[1] &&
               d[1] == d[2] &&
               d[2] == d[3] &&
               d[4] == d[5];
    }
*/
    
    public boolean ehQuadrado(){
        double AC = p1.distanciaDoisPontos(p3);
        double BD = p2.distanciaDoisPontos(p4);
        boolean i1 = AC == BD;
        
        double AB = p1.distanciaDoisPontos(p2);
        double BC = p2.distanciaDoisPontos(p3);
        double CD = p3.distanciaDoisPontos(p4);
        double DA = p4.distanciaDoisPontos(p1);
        boolean i2 = (AB == BC) && (BC == CD) && (CD == DA);
        
        return i1 && i2;
    }
    
    public double area() {
        if (this.ehQuadrado()){
            double lado = p1.distanciaDoisPontos(p2); 
            return lado * lado;
        }
        else{
            return 0;
        }
    }

    public double perimetro() {
        if(this.ehQuadrado()){
            double lado = p1.distanciaDoisPontos(p2);
            return 4 * lado;
        }
        else{
            return 0;
        }
    }
    
    
    
    @Override
    public String toString(){
        return "Quadrado{ Ponto 1: " + p1.toString() +
               " - Ponto 2: " + p2.toString() +
               " - Ponto 3: " + p3.toString() +
               " - Ponto 4: " + p4.toString() + " }";
    }

    public Ponto getP1() {
        return this.p1;
    }
    public void setP1(Ponto p1) {
        this.p1 = p1;
    }

    public Ponto getP2() {
        return this.p2;
    }
    public void setP2(Ponto p2) {
        this.p2 = p2;
    }

    public Ponto getP3() {
        return this.p3;
    }
    public void setP3(Ponto p3) {
        this.p3 = p3;
    }

    public Ponto getP4() {
        return this.p4;
    }
    public void setP4(Ponto p4) {
        this.p4 = p4;
    }
    
    
}
