package com.graduacao.trabalhofinal.model.dao;

import com.graduacao.trabalhofinal.model.entities.Musica;
import java.util.List;


public interface IDAOMusica {
    void save(Musica musica) throws Exception;
    
    void update(String codMusica, Musica musica) throws Exception;
    
    void delete(String codMusica) throws Exception;
    
    Musica find(String codMusica) throws Exception;
     
    List<Musica> findAll() throws Exception;
}
