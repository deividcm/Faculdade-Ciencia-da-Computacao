package com.graduacao.trabalhofinal.controller;

import com.graduacao.trabalhofinal.model.dao.IDAOArtista;
import com.graduacao.trabalhofinal.model.entities.Artista;
import com.graduacao.trabalhofinal.model.repo.ArtistaRepo;
import com.graduacao.trabalhofinal.model.valid.ValidacaoArtista;
import java.util.List;


public class ArtistaController {
    private ArtistaRepo repositorio;
    
    public ArtistaController(IDAOArtista dao){
        this.repositorio = new ArtistaRepo(dao);
    }
    public void save(String codArtista, String nome) throws Exception{
        ValidacaoArtista validacao = new ValidacaoArtista();
        Artista artista = validacao.validacao(codArtista, nome);
        this.repositorio.save(artista);
    }
    public void update(String codArtista, String nome) throws Exception{
        ValidacaoArtista validacao = new ValidacaoArtista();
        Artista artista = validacao.validacao(codArtista, nome);
        this.repositorio.update(codArtista, artista);
    }
    public void delete(String codArtista) throws Exception{
        this.repositorio.delete(codArtista);
    }
    public Artista find(String codArtista) throws Exception{
        return this.repositorio.find(codArtista);
    }
    public List<Artista> findAll() throws Exception{
        return this.repositorio.findAll();
    }
    public boolean containsKey(String codArtista) throws Exception{
        return this.repositorio.containsKey(codArtista);
    }
}
