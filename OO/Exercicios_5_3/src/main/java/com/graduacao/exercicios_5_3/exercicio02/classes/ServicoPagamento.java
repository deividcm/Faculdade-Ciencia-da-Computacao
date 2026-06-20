
package com.graduacao.exercicios_5_3.exercicio02.classes;

import com.graduacao.exercicios_5_3.exercicio02.interfaces.IProcessadorPagamento;


public class ServicoPagamento {
    private IProcessadorPagamento processador;
    
    public ServicoPagamento(IProcessadorPagamento processador){
        this.processador = processador;
    }
    
    public String realizarPagamento(double valor){
        return "Pagamento de: R$" + valor + " realizado atraves de um " + processador.processarPagamento();
    }
    
}
