package com.graduacao.trabalhofinal.model.repo;

import com.graduacao.trabalhofinal.model.dao.IDAOMusica;

import com.graduacao.trabalhofinal.model.entities.Musica;
import java.util.ArrayList;
import java.util.List;


public class MusicaRepo {
    private IDAOMusica dao;
    
    public MusicaRepo(IDAOMusica dao){
        this.dao = dao;
    }
    public void save(Musica musica) throws Exception{
        this.dao.save(musica);
    }
    public void update(String codMusica, Musica musica) throws Exception{
        this.dao.update(codMusica, musica);
    }
    public void delete(String codMusica)throws Exception{
        this.dao.delete(codMusica);
    }
    public void deleteByAlbum(String codAlbum) throws Exception{
        List<Musica> todasAsMusicas = this.findAll();
        
        for(Musica musica : todasAsMusicas){
            if(musica.getCodAlbum().equals(codAlbum)){
                this.delete(musica.getCodMusica());
            }
        }
    }
    public void deleteByAlbuns(List<String> codAlbuns) throws Exception{
        List<Musica> todasAsMusicas = this.findAll();
        for(String codAlbum : codAlbuns){
            for(int i = 0; i < todasAsMusicas.size(); i++){
                Musica musica = todasAsMusicas.get(i);
                if(musica.getCodAlbum().equals(codAlbum)){
                    this.delete(musica.getCodMusica());
                    todasAsMusicas.remove(musica);
                    i--;
                }
            }
        }
    }
    
    public Musica find(String codMusica) throws Exception {
        return this.dao.find(codMusica);
    }
    public List<Musica> findAll() throws Exception{
        return this.dao.findAll();
    }
    public List<Musica> findAllByAlbum(String codAlbum) throws Exception{
        List<Musica> todasAsMusicas = this.findAll();
        List<Musica> musicasDoAlbum = new ArrayList<>();
        
        for(Musica musica : todasAsMusicas){
            if(musica.getCodAlbum().equals(codAlbum)){
                musicasDoAlbum.add(musica);
            }
        }
      return musicasDoAlbum;  
    }
    public boolean containsKey(String codMusica) throws Exception{
        return this.find(codMusica) != null;
    }
}
