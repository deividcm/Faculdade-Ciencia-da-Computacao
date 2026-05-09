
package com.graduacao.exercicios_3_3__4__5.file.exercicio04;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.graduacao.exercicios_3_3__4__5.classes.Carro;
import java.util.Map;


public class SerializadorJSONCarros {
    
    public String toJSON(Map<String, Carro> carros){
        try{
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(carros);
            
            return jsonString;
        }catch(Exception e){
            e.printStackTrace();
            return "";
        }
    }
    
    public Map<String, Carro> fromJSON(String data){
        try{
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Carro> carros = mapper.readValue(data, new TypeReference<Map<String,Carro>>() {});
            
            return carros;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    
}
