package com.graduacao.trabalhofinal.model.file;

import com.graduacao.trabalhofinal.model.entities.Musica;
import java.util.List;

public interface ISerializadorMusica {
    String toFile(List<Musica> musicas) throws Exception;
    
    List<Musica> fromFile(String data) throws Exception;
}
