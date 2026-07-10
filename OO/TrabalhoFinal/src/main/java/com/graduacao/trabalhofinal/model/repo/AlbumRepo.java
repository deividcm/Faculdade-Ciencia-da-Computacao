package com.graduacao.trabalhofinal.model.repo;

import com.graduacao.trabalhofinal.model.dao.IDAOAlbum;
import com.graduacao.trabalhofinal.model.entities.Album;
import java.util.ArrayList;
import java.util.List;


public class AlbumRepo {
    private IDAOAlbum dao;
    
    public AlbumRepo(IDAOAlbum dao){
        this.dao = dao;
    }
    public void save(Album album) throws Exception{
        this.dao.save(album);
    }
    public void update(String codAlbum, Album album) throws Exception{
        this.dao.update(codAlbum, album);
    }
    public void delete(String codAlbum) throws Exception{
        this.dao.delete(codAlbum);
    }
    public List<String> deleteByArtista(String codArtista) throws Exception{
        List<Album> albuns = this.findAll();
        List<String> codigosDeletados = new ArrayList<>();
        for(Album album : albuns){
            if(album.getCodArtista().equals(codArtista)){
                this.delete(album.getCodAlbum());
                codigosDeletados.add(album.getCodAlbum());
            }
        }
        return codigosDeletados;
    }
    public Album find(String codAlbum) throws Exception{
        return this.dao.find(codAlbum);
    }
    public List<Album> findAll() throws Exception{
        return this.dao.findAll();
    }
    public List<Album> findAllByArtista(String codArtista) throws Exception{
        List<Album> todosOsAlbuns = this.findAll();
        List<Album> albunsDoArtista = new ArrayList<>();
        for(Album album : todosOsAlbuns){
            if(album.getCodArtista().equals(codArtista)){
                albunsDoArtista.add(album);
            }
        }
        return albunsDoArtista;
    }
    public boolean containsKey(String codAlbum) throws Exception{
        return this.find(codAlbum) != null;
    }
}
