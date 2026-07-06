package com.graduacao.trabalhofinal.model.dao;


import com.graduacao.trabalhofinal.model.entities.Musica;
import com.graduacao.trabalhofinal.model.exceptions.ObjectNotFoundException;
import com.graduacao.trabalhofinal.model.file.FilePersistence;
import com.graduacao.trabalhofinal.model.file.ISerializadorMusica;

import java.util.List;



public class MusicaDAOFile implements IDAOMusica {
    private ISerializadorMusica serializador;
    private FilePersistence filePersistence;
    private String pathFile;

    public MusicaDAOFile(ISerializadorMusica serializador, String pathFile) {
        this.serializador = serializador;
        this.filePersistence = new FilePersistence();
        this.pathFile = pathFile;
    }
    @Override
    public void save(Musica musica) throws Exception{
        List<Musica> musicas = this.findAll();
        musicas.add(musica);

        String data = serializador.toFile(musicas);
        filePersistence.saveToFile(data, pathFile);
    }
    @Override
    public void update(String codMusica, Musica musica) throws Exception{
        this.delete(codMusica);
        this.save(musica);
    }
    @Override
    public void delete(String codMusica) throws Exception{
        Musica musica = this.find(codMusica);
        if (musica == null){
            throw new ObjectNotFoundException("Musica nao encontrada!");
        }

        List<Musica> musicas = this.findAll();
        musicas.remove(musica);

        String data = serializador.toFile(musicas);
        filePersistence.saveToFile(data, pathFile);
    }
    @Override
    public Musica find(String codMusica) throws Exception{
        List<Musica> musicas = this.findAll();
        
        for(Musica musica : musicas){
            if(musica.getCodMusica().equals(codMusica)){
                return musica;
            }
        }
        return null;
    }
    
    @Override
    public List<Musica> findAll() throws Exception{
        String data = filePersistence.loadFromFile(pathFile);
        return serializador.fromFile(data);
    }
    
}
