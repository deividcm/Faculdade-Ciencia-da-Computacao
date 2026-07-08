package com.graduacao.trabalhofinal.controller;

import com.graduacao.trabalhofinal.model.dao.IDAOMusica;
import com.graduacao.trabalhofinal.model.entities.Musica;
import com.graduacao.trabalhofinal.model.repo.MusicaRepo;
import com.graduacao.trabalhofinal.model.valid.ValidacaoMusica;
import java.util.List;


public class MusicaController {
    
    private MusicaRepo repositorio;

    public MusicaController(IDAOMusica dao) {
        this.repositorio = new MusicaRepo(dao);
    }
    public void save(String codMusica, String titulo, String codAlbum, String duracao) throws Exception{
        ValidacaoMusica validacao = new ValidacaoMusica();
        Musica musica = validacao.validacao(codMusica, titulo, codAlbum, duracao);
        this.repositorio.save(musica);
    }
    public void update(String codMusica, String titulo, String codAlbum, String duracao) throws Exception{
        ValidacaoMusica validacao = new ValidacaoMusica();
        Musica musica = validacao.validacao(codMusica, titulo, codAlbum, duracao);
        this.repositorio.update(codMusica, musica);
    }
    public void delete(String codMusica) throws Exception{
        this.repositorio.delete(codMusica);
    }
    public void deleteByAlbum(String codAlbum) throws Exception{
        this.repositorio.deleteByAlbum(codAlbum);
    }
    public void deleteByAlbuns(List<String> codAlbuns) throws Exception{
        this.repositorio.deleteByAlbuns(codAlbuns);
    }
    public Musica find(String codMusica) throws Exception{
        return this.repositorio.find(codMusica);
    }
    public List<Musica> findAll() throws Exception{
        return this.repositorio.findAll();
    }
    public List<Musica> findAllByAlbum(String codAlbum) throws Exception{
        return this.repositorio.findAllByAlbum(codAlbum);
    }
    public boolean containsKey(String codMusica) throws Exception{
        return this.repositorio.containsKey(codMusica);
    }
}
