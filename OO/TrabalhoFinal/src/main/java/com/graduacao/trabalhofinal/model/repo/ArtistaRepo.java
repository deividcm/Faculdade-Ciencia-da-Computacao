package com.graduacao.trabalhofinal.model.repo;

import com.graduacao.trabalhofinal.model.dao.IDAOArtista;
import com.graduacao.trabalhofinal.model.entities.Artista;
import java.util.List;

public class ArtistaRepo {
    
    private IDAOArtista dao;
    
    public ArtistaRepo(IDAOArtista dao){
        this.dao = dao;
    }
    public void save(Artista artista) throws Exception{
        this.dao.save(artista);
    }
    public void update(String codArtista, Artista artista) throws Exception{
        this.dao.update(codArtista, artista);
    }
    public void delete(String codArtista) throws Exception{
        this.dao.delete(codArtista);
    }
    public Artista find(String codArtista) throws Exception{
        return this.dao.find(codArtista);
    }
    public List<Artista> findAll() throws Exception{
        return this.dao.findAll();
    }
    public boolean containsKey(String codArtista) throws Exception{
        List<Artista> artistas = this.findAll();
        boolean verifica = false;
        for(Artista artista: artistas){
            verifica = verifica || artista.getCodArtista().equals(codArtista);
        }
        return verifica;
    }
}
