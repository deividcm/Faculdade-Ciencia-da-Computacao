package com.graduacao.trabalhofinal.model.dao;

import com.graduacao.trabalhofinal.model.entities.Artista;
import java.sql.SQLException;
import java.util.List;



public interface IDAOArtista {
    void save(Artista artista) throws SQLException;
    
    void update(String codArtista, Artista artista) throws SQLException;
    
    void delete(String codArtista) throws SQLException;
    
    Artista find(String codArtista) throws SQLException;
    
    List<Artista> findAll() throws SQLException;
}
