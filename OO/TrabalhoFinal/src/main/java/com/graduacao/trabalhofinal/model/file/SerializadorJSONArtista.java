package com.graduacao.trabalhofinal.model.file;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.graduacao.trabalhofinal.model.entities.Artista;
import java.util.List;


public class SerializadorJSONArtista implements ISerializadorArtista{
    
    @Override
    public String toFile(List<Artista> artistas) throws Exception{
        try{
            ObjectMapper mapper = new ObjectMapper();
            String data = mapper.writeValueAsString(artistas);
            
            return data;
        }catch(Exception e){
            throw e;
        }
    }
    
    @Override
    public List<Artista> fromFile(String data) throws Exception{
        try{
            ObjectMapper mapper = new ObjectMapper();
            
            List<Artista> artistas = mapper.readValue(data, new TypeReference<List<Artista>>() {});
            
            return artistas;
        }catch(Exception e){
            throw e;
        }
    }
    
}
