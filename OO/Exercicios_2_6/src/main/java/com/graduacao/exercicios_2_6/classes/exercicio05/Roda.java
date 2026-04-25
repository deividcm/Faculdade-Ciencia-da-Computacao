
package com.graduacao.exercicios_2_6.classes.exercicio05;

import java.util.Objects;

public class Roda {
    private String material;
    private String cor;
    private double raio;

    public Roda(){
        this.material = "";
        this.cor = "";
        this.raio = 0.0;
    }
    public Roda(String material, String cor, double raio) {
        this.material = material;
        this.cor = cor;
        this.raio = raio;
    }
    public Roda(Roda outra){
        this.material = outra.getMaterial();
        this.cor = outra.getCor();
        this.raio = outra.getRaio();
    }
    public void copiar(Roda outra){
        this.material = outra.getMaterial();
        this.cor = outra.getCor();
        this.raio = outra.getRaio();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.material);
        hash = 29 * hash + Objects.hashCode(this.cor);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.raio) ^ (Double.doubleToLongBits(this.raio) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Roda other = (Roda) obj;
        if (Double.doubleToLongBits(this.raio) != Double.doubleToLongBits(other.raio)) {
            return false;
        }
        if (!Objects.equals(this.material, other.material)) {
            return false;
        }
        return Objects.equals(this.cor, other.cor);
    }
    
    @Override
    public String toString(){
        return "--- Roda ---\n " +
               "Material: " + this.material + "\n "+
               "Cor: " + this.cor + "\n " +
               "Raio: " + this.raio + "\n ";
    }
    
    public String getMaterial() {
        return this.material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCor() {
        return this.cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getRaio() {
        return this.raio;
    }
    public void setRaio(double raio) {
        this.raio = raio;
    }
}
