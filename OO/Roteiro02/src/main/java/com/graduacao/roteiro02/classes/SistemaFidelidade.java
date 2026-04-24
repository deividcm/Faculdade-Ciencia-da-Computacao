package com.graduacao.roteiro02.classes;

// Classe entregue pelo exercicio
public class SistemaFidelidade {
    // Atributo para armazenar os pontos acumulados pelo passageiro
    private int pontos;

    public SistemaFidelidade() {
        this.pontos = 0; // Todos os passageiros começam sem pontos
    }
    public SistemaFidelidade(SistemaFidelidade outro){ // Construtor de cópia
        this.pontos = outro.getSaldoPontos();
    }

    // Método para adicionar pontos ao saldo do passageiro
    public void adicionarPontos(int pontos) {
        if (pontos > 0) {
            this.pontos += pontos;
        }
    }

    // Método para verificar o saldo atual de pontos
    public int getSaldoPontos() {
        return pontos;
    }

    // Método para resgatar pontos (opcional, dependendo dos requisitos)
    public boolean resgatarPontos(int pontosParaResgate) {
        if (pontosParaResgate <= 0 || pontosParaResgate > this.pontos) {
            // Resgate inválido: quantidade negativa ou insuficiente de pontos
            return false;
        } else {
            // Reduz os pontos do saldo após o resgate
            this.pontos -= pontosParaResgate;
            return true;
        }
    }
}
