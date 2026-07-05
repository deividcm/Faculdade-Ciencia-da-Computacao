package com.graduacao.trabalhofinal.model.file;


import com.graduacao.trabalhofinal.model.entities.Artista;
import java.util.List;

public interface ISerializadorArtista {
    String toFile(List<Artista> artistas) throws Exception;
    
    List<Artista> fromFile(String data) throws Exception;
}
