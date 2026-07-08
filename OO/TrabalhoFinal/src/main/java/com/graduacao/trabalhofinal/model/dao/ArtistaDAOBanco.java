package com.graduacao.trabalhofinal.model.dao;

import com.graduacao.trabalhofinal.model.entities.Artista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ArtistaDAOBanco implements IDAOArtista {
    
    private Connection connection;

    public ArtistaDAOBanco(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void save(Artista artista) throws SQLException{
        String sql = "INSERT INTO ARTISTA (COD_ARTISTA, NOME) VALUES(?, ?);";
        try(PreparedStatement stmt = this.connection.prepareStatement(sql)){
            stmt.setString(1, artista.getCodArtista());
            stmt.setString(2, artista.getNome());
            stmt.executeUpdate();
        }catch(SQLException e){
            throw e;
        }
    }
    @Override
    public void update(String codArtista, Artista artista) throws SQLException{
        String sql = "UPDATE ARTISTA SET NOME = ? WHERE COD_ARTISTA = ?;";
        try(PreparedStatement stmt = this.connection.prepareStatement(sql)){
            stmt.setString(1, artista.getNome());
            stmt.setString(2, codArtista);
            stmt.executeUpdate();
        }catch(SQLException e){
            throw e;
        }
    }
    @Override
    public void delete(String codArtista) throws SQLException{
        String sql = "DELETE FROM ARTISTA WHERE COD_ARTISTA = ?;";
        try(PreparedStatement stmt = this.connection.prepareStatement(sql)){
            stmt.setString(1, codArtista);
            stmt.executeUpdate();
        }catch(SQLException e){
            throw e;
        }
    }
    @Override 
    public Artista find(String codArtista) throws SQLException{
        String sql = "SELECT * FROM ARTISTA WHERE COD_ARTISTA = ?;";
        try(PreparedStatement stmt = this.connection.prepareStatement(sql)){
            stmt.setString(1, codArtista);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    return new Artista(
                        rs.getString("COD_ARTISTA"),
                        rs.getString("NOME"));
                }
            }
            
        }catch(SQLException e){
            throw e;
        }
        return null;
    }
    @Override
    public List<Artista> findAll() throws SQLException{
        String sql = "SELECT * FROM ARTISTA;";
        List<Artista> artistas = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                artistas.add(new Artista(
                    rs.getString("COD_ARTISTA"),
                    rs.getString("NOME")));
            }
        } catch (SQLException e) {
            throw e;
        }
        
        return artistas;
    }
    
}
