package com.graduacao.trabalhofinal.model.dao;

import com.graduacao.trabalhofinal.model.entities.Album;
import java.util.List;


public interface IDAOAlbum {
    void save(Album album) throws Exception;
    
    void update(String codAlbum, Album album) throws Exception;
    
    void delete(String codAlbum) throws Exception;
    
    Album find(String codAlbum) throws Exception;
    
    List<Album> findAll() throws Exception;
}
