package com.graduacao.trabalhofinal.model.dao;

import com.graduacao.trabalhofinal.model.entities.Album;
import java.sql.SQLException;
import java.util.List;


public interface IDAOAlbum {
    void save(Album album) throws SQLException;
    
    void update(String codAlbum, Album album) throws SQLException;
    
    void delete(String codAlbum) throws SQLException;
    
    Album find(String codAlbum) throws SQLException;
    
    List<Album> findAll() throws SQLException;
}
