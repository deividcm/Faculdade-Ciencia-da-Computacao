package com.graduacao.exercicios_3_6.file.exercicio01;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.graduacao.exercicios_3_6.gerentes.exercicio01.GerenteAluno;

public class SerializadorAluno {
    
    public String toJSON(GerenteAluno gerente){
        try{
            ObjectMapper mapper = new ObjectMapper();
            String jsonStr = mapper.writeValueAsString(gerente);
            return jsonStr;
        }
        catch(Exception e){
            e.printStackTrace();
            return "";
        }
    }
    
    public GerenteAluno fromJSON(String data){
        try{
            ObjectMapper mapper = new ObjectMapper();
            
            GerenteAluno gerente = mapper.readValue(data, new TypeReference<GerenteAluno>() {});
            return gerente;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }
    
}
