

package com.graduacao.exercicios_5_3.exercicio02.classes;

import com.graduacao.exercicios_5_3.exercicio02.interfaces.IProcessadorPagamento;


public class ProcessadorPagamentoBoleto implements IProcessadorPagamento{
    
    @Override
    public String processarPagamento(){
        return "boleto.";
    }
}
