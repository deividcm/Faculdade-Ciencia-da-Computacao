
package com.graduacao.exercicios_5_3.exercicio02.classes;

import com.graduacao.exercicios_5_3.exercicio02.interfaces.IProcessadorPagamento;


public class ProcessadorPagamentoCartao implements IProcessadorPagamento {
    
    @Override
    public String processarPagamento(){
        return "cartao de credito.";
    }
}
