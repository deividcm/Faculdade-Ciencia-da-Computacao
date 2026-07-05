package com.graduacao.trabalhofinal.model.dao;

import com.graduacao.trabalhofinal.model.entities.Musica;
import java.sql.SQLException;
import java.util.List;


public interface IDAOMusica {
    void save(Musica musica) throws SQLException;
    
    void update(String codMusica, Musica musica) throws SQLException;
    
    void delete(String codMusica) throws SQLException;
    
    Musica find(String codMusica) throws SQLException;
     
    List<Musica> findAll() throws SQLException;
}
