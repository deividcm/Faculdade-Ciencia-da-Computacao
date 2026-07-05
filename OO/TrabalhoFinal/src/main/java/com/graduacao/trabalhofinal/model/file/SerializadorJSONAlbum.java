package com.graduacao.trabalhofinal.model.file;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.graduacao.trabalhofinal.model.entities.Album;
import java.util.List;


public class SerializadorJSONAlbum implements ISerializadorAlbum{
    
    @Override
    public String toFile(List<Album> albuns) throws Exception{
        try{
            ObjectMapper mapper = new ObjectMapper();
            String data = mapper.writeValueAsString(albuns);
            
            return data;
        }catch(Exception e){
            throw e;
        }
    }
    
    @Override
    public List<Album> fromFile(String data) throws Exception{
        try{
            ObjectMapper mapper = new ObjectMapper();
            
            List<Album> albuns = mapper.readValue(data, new TypeReference<List<Album>>() {});
            
            return albuns;
        }catch(Exception e){
            throw e;
        }
    }
    
}
