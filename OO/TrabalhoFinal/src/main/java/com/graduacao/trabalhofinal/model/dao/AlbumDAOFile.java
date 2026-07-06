package com.graduacao.trabalhofinal.model.dao;

import com.graduacao.trabalhofinal.model.entities.Album;
import com.graduacao.trabalhofinal.model.exceptions.ObjectNotFoundException;
import com.graduacao.trabalhofinal.model.file.FilePersistence;
import com.graduacao.trabalhofinal.model.file.ISerializadorAlbum;

import java.util.List;



public class AlbumDAOFile implements IDAOAlbum{
    private ISerializadorAlbum serializador;
    private FilePersistence filePersistence;
    private String pathFile;

    public AlbumDAOFile(ISerializadorAlbum serializador, String pathFile) {
        this.serializador = serializador;
        this.filePersistence = new FilePersistence();
        this.pathFile = pathFile;
    }
    @Override
    public void save(Album album) throws Exception{
        List<Album> albuns = this.findAll();
        albuns.add(album);

        String data = serializador.toFile(albuns);
        filePersistence.saveToFile(data, pathFile);
    }
    @Override
    public void update(String codAlbum, Album album) throws Exception{
        this.delete(codAlbum);
        this.save(album);
    }
    @Override
    public void delete(String codAlbum) throws Exception{
        Album album = this.find(codAlbum);
        if (album == null){
            throw new ObjectNotFoundException("Album nao encontrado!");
        }

        List<Album> albuns = this.findAll();
        albuns.remove(album);

        String data = serializador.toFile(albuns);
        filePersistence.saveToFile(data, pathFile);
    }
    @Override
    public Album find(String codAlbum) throws Exception{
        List<Album> albuns = this.findAll();
        
        for(Album album : albuns){
            if(album.getCodAlbum().equals(codAlbum)){
                return album;
            }
        }
        return null;
    }
    
    @Override
    public List<Album> findAll() throws Exception{
        String data = filePersistence.loadFromFile(pathFile);
        return serializador.fromFile(data);
    }
    
}
