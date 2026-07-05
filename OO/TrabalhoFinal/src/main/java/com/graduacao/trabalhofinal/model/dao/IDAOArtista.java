package com.graduacao.trabalhofinal.model.dao;

import com.graduacao.trabalhofinal.model.entities.Artista;
import java.util.List;



public interface IDAOArtista {
    void save(Artista artista) throws Exception;
    
    void update(String codArtista, Artista artista) throws Exception;
    
    void delete(String codArtista) throws Exception;
    
    Artista find(String codArtista) throws Exception;
    
    List<Artista> findAll() throws Exception;
}
