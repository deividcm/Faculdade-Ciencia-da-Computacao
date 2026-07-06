package com.graduacao.trabalhofinal.model.dao;

import com.graduacao.trabalhofinal.model.entities.Artista;
import com.graduacao.trabalhofinal.model.exceptions.ObjectNotFoundException;
import com.graduacao.trabalhofinal.model.file.FilePersistence;
import com.graduacao.trabalhofinal.model.file.ISerializadorArtista;
import java.util.List;



public class ArtistaDAOFile implements IDAOArtista {
    private ISerializadorArtista serializador;
    private FilePersistence filePersistence;
    private String pathFile;

    public ArtistaDAOFile(ISerializadorArtista serializador, String pathFile) {
        this.serializador = serializador;
        this.filePersistence = new FilePersistence();
        this.pathFile = pathFile;
    }
    @Override
    public void save(Artista artista) throws Exception{
        List<Artista> artistas = this.findAll();
        artistas.add(artista);

        String data = serializador.toFile(artistas);
        filePersistence.saveToFile(data, pathFile);
    }
    @Override
    public void update(String codArtista, Artista artista) throws Exception{
        this.delete(codArtista);
        this.save(artista);
    }
    @Override
    public void delete(String codArtista) throws Exception{
        Artista artista = this.find(codArtista);
        if (artista == null){
            throw new ObjectNotFoundException("Artista nao encontrado!");
        }

        List<Artista> artistas = this.findAll();
        artistas.remove(artista);

        String data = serializador.toFile(artistas);
        filePersistence.saveToFile(data, pathFile);
    }
    @Override
    public Artista find(String codArtista) throws Exception{
        List<Artista> artistas = this.findAll();
        
        for(Artista artista : artistas){
            if(artista.getCodArtista().equals(codArtista)){
                return artista;
            }
        }
        return null;
    }
    
    @Override
    public List<Artista> findAll() throws Exception{
        String data = filePersistence.loadFromFile(pathFile);
        return serializador.fromFile(data);
    }
    
}
