package com.graduacao.trabalhofinal.model.file;

import com.graduacao.trabalhofinal.model.entities.Album;
import java.util.List;

public interface ISerializadorAlbum {
    String toFile(List<Album> albuns) throws Exception;
    
    List<Album> fromFile(String data) throws Exception;
}
