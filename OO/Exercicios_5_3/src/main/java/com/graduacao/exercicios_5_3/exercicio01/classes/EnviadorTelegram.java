package com.graduacao.exercicios_5_3.exercicio01.classes;

import com.graduacao.exercicios_5_3.exercicio01.interfaces.IEnviadorMensagem;


public class EnviadorTelegram implements IEnviadorMensagem {
    
    @Override
    public void enviarMensagem(String msg){
        System.out.println("Mensagem: " + msg + " Enviado por Telegram");
    }
}
