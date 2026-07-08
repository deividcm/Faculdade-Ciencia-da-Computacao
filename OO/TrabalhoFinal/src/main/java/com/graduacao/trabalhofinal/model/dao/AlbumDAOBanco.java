package com.graduacao.trabalhofinal.model.dao;

import com.graduacao.trabalhofinal.model.entities.Album;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class AlbumDAOBanco implements IDAOAlbum {
    
    private Connection connection;

    public AlbumDAOBanco(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void save(Album album) throws SQLException{
        String sql = "INSERT INTO ALBUM (COD_ALBUM, COD_ARTISTA, NOME, ANO_LANCAMENTO) VALUES(?, ?, ?, ?);";
        try(PreparedStatement stmt = this.connection.prepareStatement(sql)){
            stmt.setString(1, album.getCodAlbum());
            stmt.setString(2, album.getCodArtista());
            stmt.setString(3, album.getNome());
            stmt.setInt(4, album.getAnoLancamento());
            stmt.executeUpdate();
        }catch(SQLException e){
            throw e;
        }
    }
    @Override
    public void update(String codAlbum, Album album) throws SQLException{
        String sql = "UPDATE ALBUM SET NOME = ?, ANO_LANCAMENTO = ? WHERE COD_ALBUM = ?;";
        try(PreparedStatement stmt = this.connection.prepareStatement(sql)){
            stmt.setString(1, album.getNome());
            stmt.setInt(2, album.getAnoLancamento());
            stmt.setString(3, codAlbum);
            stmt.executeUpdate();
        }catch(SQLException e){
            throw e;
        }
    }
    @Override
    public void delete(String codAlbum) throws SQLException{
        String sql = "DELETE FROM ALBUM WHERE COD_ALBUM = ?;";
        try(PreparedStatement stmt = this.connection.prepareStatement(sql)){
            stmt.setString(1, codAlbum);
            stmt.executeUpdate();
        }catch(SQLException e){
            throw e;
        }
    }
    @Override 
    public Album find(String codAlbum) throws SQLException{
        String sql = "SELECT * FROM ALBUM WHERE COD_ALBUM = ?;";
        try(PreparedStatement stmt = this.connection.prepareStatement(sql)){
            stmt.setString(1, codAlbum);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    return new Album(
                        rs.getString("COD_ALBUM"),
                        rs.getString("NOME"),
                        rs.getString("COD_ARTISTA"),
                        rs.getInt("ANO_LANCAMENTO"));
                }
            }
            
        }catch(SQLException e){
            throw e;
        }
        return null;
    }
    @Override
    public List<Album> findAll() throws SQLException{
        String sql = "SELECT * FROM ALBUM;";
        List<Album> albuns = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                albuns.add(new Album(
                        rs.getString("COD_ALBUM"),
                        rs.getString("NOME"),
                        rs.getString("COD_ARTISTA"),
                        rs.getInt("ANO_LANCAMENTO")));
            }
        } catch (SQLException e) {
            throw e;
        }
        
        return albuns;
    }
    
}
