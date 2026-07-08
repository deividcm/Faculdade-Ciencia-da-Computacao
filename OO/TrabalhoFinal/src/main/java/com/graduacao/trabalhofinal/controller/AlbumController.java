package com.graduacao.trabalhofinal.controller;

import com.graduacao.trabalhofinal.model.dao.IDAOAlbum;
import com.graduacao.trabalhofinal.model.entities.Album;
import com.graduacao.trabalhofinal.model.repo.AlbumRepo;
import com.graduacao.trabalhofinal.model.valid.ValidacaoAlbum;
import java.util.List;


public class AlbumController {
    private AlbumRepo repositorio;

    public AlbumController(IDAOAlbum dao) {
        this.repositorio = new AlbumRepo(dao);
    }
    public void save(String codAlbum, String nome, String codArtista, String anoLancamento) throws Exception{
        ValidacaoAlbum validacao = new ValidacaoAlbum();
        Album album = validacao.validacao(codAlbum, nome, codArtista, anoLancamento);
        this.repositorio.save(album);
    }
    public void update(String codAlbum, String nome, String anoLancamento) throws Exception{
        ValidacaoAlbum validacao = new ValidacaoAlbum();
        Album album = validacao.validacao(codAlbum, nome, "não precisa", anoLancamento);
        this.repositorio.update(codAlbum, album);
    }
    public void delete(String codAlbum) throws Exception{
        this.repositorio.delete(codAlbum);
    }
    public List<String> deleteByArtista(String codArtista) throws Exception{
        return this.repositorio.deleteByArtista(codArtista);
    }
    public Album find(String codAlbum) throws Exception{
        return this.repositorio.find(codAlbum);
    }
    public List<Album> findAll() throws Exception{
        return this.repositorio.findAll();
    }
    public List<Album> findAllByArtista(String codArtista) throws Exception{
        return this.repositorio.findAllByArtista(codArtista);
    }
    public boolean containsKey(String codAlbum) throws Exception{
        return this.repositorio.containsKey(codAlbum);
    }
}
