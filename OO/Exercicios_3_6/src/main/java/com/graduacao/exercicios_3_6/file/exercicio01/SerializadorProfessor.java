package com.graduacao.exercicios_3_6.file.exercicio01;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.graduacao.exercicios_3_6.gerentes.exercicio01.GerenteProfessor;

public class SerializadorProfessor {

        public String toJSON(GerenteProfessor gerente){
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
        
        public GerenteProfessor fromJSON(String data){
            try{
                ObjectMapper mapper = new ObjectMapper();
                GerenteProfessor gerente = mapper.readValue(data, new TypeReference<GerenteProfessor>() {});
                return gerente;
            }
            catch(Exception e){
                e.printStackTrace();
                return null;
            }
        }
        
}
