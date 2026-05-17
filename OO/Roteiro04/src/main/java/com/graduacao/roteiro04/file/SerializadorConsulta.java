
package com.graduacao.roteiro04.file;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.graduacao.roteiro04.gerentes.GerenteConsulta;


public class SerializadorConsulta {
    
    public String toJSON(GerenteConsulta gerente){
        try{
            ObjectMapper mapper = new ObjectMapper();
            String data = mapper.writeValueAsString(gerente);
            return data;
        }catch(Exception e){
            e.printStackTrace();
            return "";
        }
    }
    public GerenteConsulta fromJSON(String data){
        try{
            ObjectMapper mapper = new ObjectMapper();
            GerenteConsulta gerente = mapper.readValue(data, new TypeReference<GerenteConsulta>(){});
            return gerente;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
}
