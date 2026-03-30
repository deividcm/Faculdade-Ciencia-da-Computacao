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
