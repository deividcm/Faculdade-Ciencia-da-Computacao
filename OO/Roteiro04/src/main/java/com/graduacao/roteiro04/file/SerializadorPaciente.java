
package com.graduacao.roteiro04.file;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.graduacao.roteiro04.gerentes.GerentePaciente;


public class SerializadorPaciente {
    
    public String toJSON(GerentePaciente gerente){
        try{
            ObjectMapper mapper = new ObjectMapper();
            String data = mapper.writeValueAsString(gerente);
            return data;
        }catch(Exception e){
            e.printStackTrace();
            return "";
        }
    }
    public GerentePaciente fromJSON(String data){
        try{
            ObjectMapper mapper = new ObjectMapper();
            GerentePaciente gerente = mapper.readValue(data, new TypeReference<GerentePaciente>(){});
            return gerente;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
}
