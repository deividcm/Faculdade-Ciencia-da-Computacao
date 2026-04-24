package com.graduacao.roteiro02.classes;

import com.graduacao.roteiro02.gerenciadores.GerenciadorPassageiros;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Voo {
    private String numVoo;
    private String destino;
    private String estadoVoo;
    private List<String> escalas;
    private final GerenciadorPassageiros gerenciadorPassageiros;
    
    public Voo(){
        this.numVoo = "";
        this.destino = "";
        this.estadoVoo = "Aguardando decolagem";
        this.escalas = new ArrayList<>();
        this.gerenciadorPassageiros = new GerenciadorPassageiros();
    }
    public Voo(String numVoo, String destino, String estadoVoo) {
        this.numVoo = numVoo;
        this.destino = destino;
        this.estadoVoo = estadoVoo;
        this.escalas = new ArrayList<>();
        this.gerenciadorPassageiros = new GerenciadorPassageiros();
    }
    public Voo(Voo outro){
        this.numVoo = outro.getNumVoo();
        this.destino = outro.getDestino();
        this.estadoVoo = outro.getEstadoVoo();
        this.gerenciadorPassageiros = new GerenciadorPassageiros(outro.getGerenciadorPassageiros());
        
        for(String e: outro.getEscalas()){
            this.escalas.add(e);
        }
    }

    public void addEscala(String escala){
        this.escalas.add(escala);
    }
    
    public void alterarEstadoVoo(String estadoVoo) {
        this.estadoVoo = estadoVoo;
    }
    
    public void recompensarPassageiros(int pontos){
        for(Passageiro passageiro: this.gerenciadorPassageiros.getPasssageiros().values()){
            passageiro.getSistemaFidelidade().adicionarPontos(pontos);
            passageiro.setEmbarcado(false);
        }
    }
    
    public boolean removeEscala(int index){
        if(index < this.escalas.size()){
            this.escalas.remove(index);
        }
        return index < this.escalas.size();
    }
    public boolean removeEscala(String escala){
        return this.escalas.remove(escala);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.numVoo);
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
        final Voo other = (Voo) obj;
        if (!Objects.equals(this.numVoo, other.numVoo)) {
            return false;
        }
        if (!Objects.equals(this.destino, other.destino)) {
            return false;
        }
        if (!Objects.equals(this.estadoVoo, other.estadoVoo)) {
            return false;
        }
        if (!Objects.equals(this.escalas, other.escalas)) {
            return false;
        }
        return Objects.equals(this.gerenciadorPassageiros, other.gerenciadorPassageiros);
    }
    
    public String toStringResumido(){
        return this.numVoo + " - " + this.estadoVoo + " - " + this.destino + " - " + this.gerenciadorPassageiros.size() + "/" + this.gerenciadorPassageiros.getCapacidadeMaxima() + " passageiros embarcados\n ";
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Voo ---\n ");
        sb.append("NumVoo: ").append(this.numVoo).append("\n ");
        sb.append("Destino: ").append(this.destino).append("\n ");
        sb.append("Estado de Voo: ").append(this.estadoVoo).append("\n ");
        sb.append("Escalas[").append(this.escalas.size()).append("]: ");
        sb.append("Capacidade maxima: ").append(this.gerenciadorPassageiros.getCapacidadeMaxima()).append("\n ");
        for(int i = 0; i < this.escalas.size() - 1; i++){
            sb.append(this.escalas.get(i)).append(" -> ");
        }
        sb.append(this.escalas.get(this.escalas.size() - 1)).append("\n ");
        
        sb.append("--- Passageiros (").append(this.gerenciadorPassageiros.size()).append(") ---\n ");
        sb.append(this.gerenciadorPassageiros.toStringResumido());
        
        return sb.toString();
    }
    
    public boolean temPrejuizo(){
        return this.gerenciadorPassageiros.size() < 5;
    }
    
    public String getNumVoo() {
        return this.numVoo;
    }
    public void setNumVoo(String numVoo) {
        this.numVoo = numVoo;
    }

    public String getDestino() {
        return this.destino;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getEstadoVoo() {
        return this.estadoVoo;
    }
    
    
    public List<String> getEscalas() {
        return escalas;
    }

    public GerenciadorPassageiros getGerenciadorPassageiros() {
        return gerenciadorPassageiros;
    }
}
