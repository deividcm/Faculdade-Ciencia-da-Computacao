package com.graduacao.exercicios_3_3__4__5.file.exercicio03;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.graduacao.exercicios_3_3__4__5.classes.Animal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class SerializadorJSONAnimais {
    
    public String toJSON(Map<String, Animal> animais){
        try{          
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(animais);
            
            return jsonString;
        }catch(Exception e){
            e.printStackTrace();
            return "";
        }
    }
    
    public Map<String, Animal> fromJSON(String jsonString){
        try{
            ObjectMapper mapper = new ObjectMapper();
            Map<String,Animal> animais = mapper.readValue(jsonString, new TypeReference<Map<String,Animal>>() {});
           
            return animais;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
}
