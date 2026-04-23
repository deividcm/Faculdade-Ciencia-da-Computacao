package com.graduacao.roteiro02.gerenciadores;

import com.graduacao.roteiro02.classes.Passageiro;
import java.util.HashMap;
import java.util.Map;


public class GerenciadorPassageiros {
    
    private final Map<String, Passageiro> passsageiros;
    
    public GerenciadorPassageiros(){
        this.passsageiros = new HashMap<>();
    }
    
    
    public void putPassageiro(Passageiro passageiro){
        this.passsageiros.put(passageiro.getCPF(), passageiro);
    }
    
    
    
    
}
