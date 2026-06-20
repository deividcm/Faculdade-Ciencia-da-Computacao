
package com.graduacao.exercicios_5_3.exercicio01.classes;

import com.graduacao.exercicios_5_3.exercicio01.interfaces.IEnviadorMensagem;


public class ProcessadorMensagem {

    private IEnviadorMensagem enviador;
    
    public ProcessadorMensagem(IEnviadorMensagem enviador){
        this.enviador = enviador;
    }
    public void processar(String msg){
        this.enviador.enviarMensagem(msg);
    }
    
}
