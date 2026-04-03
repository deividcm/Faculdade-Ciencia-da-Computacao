package com.graduacao.roteiro01.classes;


public class Triangulo {
    private Ponto p1;
    private Ponto p2;
    private Ponto p3;
    
    public Triangulo(){
        this.p1 = null;
        this.p2 = null;
        this.p3 = null;
    }
    public Triangulo(Ponto p1, Ponto p2, Ponto p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }
    public Triangulo(Triangulo outro){
        p1.copiar(outro.getP1());
        p2.copiar(outro.getP2());
        p3.copiar(outro.getP3());
    }
    
    public void copiar(Triangulo outro){
        p1.copiar(outro.getP1());
        p2.copiar(outro.getP2());
        p3.copiar(outro.getP3());
    }
    
    
    public double getDeterminante3(){
        double d1 = (p1.getX() * p2.getY()) + (p1.getY() * p3.getX()) + (p2.getX() * p3.getY());
        double d2 = (p1.getX() * p3.getY()) + (p1.getY() * p2.getX()) + (p2.getY() * p3.getX());
        
        return (d1 - d2);
    }
    
    public boolean isColinear(){
        return (this.getDeterminante3() == 0);
    }
    
    public double getArea(){
        double det = this.getDeterminante3();
        if(det < 0){
            det = det * -1;
        }
        
        return det/2;
    }
    public double getPerimetro(){
        if (!this.isColinear()){
            double d1 = p1.distanciaDoisPontos(p2);
            double d2 = p2.distanciaDoisPontos(p3);
            double d3 = p3.distanciaDoisPontos(p1);
        
            return d1+d2+d3;
        }
        else{
            return 0;
        }
    }
    
    public String getTipo(){
        if (!this.isColinear()){
            double l1 = p1.distanciaDoisPontos(p2);
            double l2 = p2.distanciaDoisPontos(p3);
            double l3 = p3.distanciaDoisPontos(p1);

            if(l1 == l2 && l2 == l3){
                return "Equilatero";
            }
            else if (l1 == l2 || l2 == l3 || l3 == l1){
                return "Isosceles";
            }
            else{
                return "Escaleno";
            }
        }
        else{
            return "Nao e um triangulo";
        }
        
    }
    
    @Override 
    public String toString(){
        return "Triangulo{ Ponto 1: " + p1.toString() +
               " - Ponto 2: " + p2.toString() +
               " - Ponto 3: " + p3.toString() + " }";
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
    
    
    
}
