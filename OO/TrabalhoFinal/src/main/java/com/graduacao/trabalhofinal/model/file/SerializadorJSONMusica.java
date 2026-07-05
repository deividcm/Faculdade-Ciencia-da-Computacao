package com.graduacao.trabalhofinal.model.file;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.graduacao.trabalhofinal.model.entities.Musica;
import java.util.List;


public class SerializadorJSONMusica implements ISerializadorMusica{
    
    @Override
    public String toFile(List<Musica> musicas) throws Exception{
        try{
            ObjectMapper mapper = new ObjectMapper();
            String data = mapper.writeValueAsString(musicas);
            
            return data;
        }catch(Exception e){
            throw e;
        }
    }
    
    @Override
    public List<Musica> fromFile(String data) throws Exception{
        try{
            ObjectMapper mapper = new ObjectMapper();
            
            List<Musica> musicas = mapper.readValue(data, new TypeReference<List<Musica>>() {});
            
            return musicas;
        }catch(Exception e){
            throw e;
        }
    }
    
}
