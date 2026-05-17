
package com.graduacao.roteiro04.file;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.graduacao.roteiro04.gerentes.GerenteMedico;


public class SerializadorMedico {
    
    public String toJSON(GerenteMedico gerente){
        try{
            ObjectMapper mapper = new ObjectMapper();
            String data = mapper.writeValueAsString(gerente);
            return data;
        }catch(Exception e){
            e.printStackTrace();
            return "";
        }
    }
    public GerenteMedico fromJSON(String data){
        try{
            ObjectMapper mapper = new ObjectMapper();
            GerenteMedico gerente = mapper.readValue(data, new TypeReference<GerenteMedico>(){});
            return gerente;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
}
