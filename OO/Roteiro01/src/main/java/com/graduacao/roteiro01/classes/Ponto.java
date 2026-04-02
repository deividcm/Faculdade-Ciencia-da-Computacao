package com.graduacao.roteiro01.classes;

public class Ponto {
    private double x;
    private double y;

    
    public Ponto(){
        this.x = 0.0;
        this.y = 0.0;
    }
    public Ponto(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Ponto(Ponto outro) {
        this.x = outro.getX();
        this.y = outro.getY();
    }
    public void copiar(Ponto outro) {
        this.x = outro.getX();
        this.y = outro.getY();
    }
    
    
    public double distanciaDoisPontos(Ponto outro){
        double deltaX = outro.getX() - this.x;
        double deltaY = outro.getY() - this.y;
        deltaX *= deltaX;
        deltaY *= deltaY;
        double distancia = Math.sqrt(deltaX+deltaY);
        return distancia;
    }
    
    public double getDeterminante3(Ponto p2, Ponto p3){
        double d1 = (this.x * p2.getY()) + (this.y * p3.getX()) + (p2.getX() * p3.getY());
        double d2 = (this.x * p3.getY()) + (this.y * p2.getX()) + (p2.getY() * p3.getX());
        
        return (d1 - d2);
    }
    
    public boolean isColinear(Ponto p2, Ponto p3){
        return (this.getDeterminante3(p2, p3) == 0);
    }
    
    public double getArea(Ponto p2, Ponto p3){
        double det = this.getDeterminante3(p2, p3);
        if(det < 0){
            det = det * -1;
        }
        
        return det/2;
    }
    
    @Override
    public String toString(){
        return "(x:" + this.x + ", y:" + this.y + ")";
    }
    
    public double getX() {
        return this.x;
    }
    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }
    public void setY(double y) {
        this.y = y;
    }
    
    
    
    
}
