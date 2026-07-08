package com.graduacao.trabalhofinal.model.dao;


import com.graduacao.trabalhofinal.model.entities.Musica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class MusicaDAOBanco implements IDAOMusica {
    
    private Connection connection;

    public MusicaDAOBanco(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void save(Musica musica) throws SQLException{
        String sql = "INSERT INTO MUSICA (COD_MUSICA, COD_ALBUM, TITULO, DURACAO) VALUES(?, ?, ?, ?);";
        try(PreparedStatement stmt = this.connection.prepareStatement(sql)){
            stmt.setString(1, musica.getCodMusica());
            stmt.setString(2, musica.getCodAlbum());
            stmt.setString(3, musica.getTitulo());
            stmt.setDouble(4, musica.getDuracao());
            stmt.executeUpdate();
        }catch(SQLException e){
            throw e;
        }
    }
    @Override
    public void update(String codMusica, Musica musica) throws SQLException{
        String sql = "UPDATE MUSICA SET TITULO = ?, DURACAO = ? WHERE COD_MUSICA = ?;";
        try(PreparedStatement stmt = this.connection.prepareStatement(sql)){
            stmt.setString(1, musica.getTitulo());
            stmt.setDouble(2, musica.getDuracao());
            stmt.setString(3, codMusica);
            stmt.executeUpdate();
        }catch(SQLException e){
            throw e;
        }
    }
    @Override
    public void delete(String codMusica) throws SQLException{
        String sql = "DELETE FROM MUSICA WHERE COD_MUSICA = ?;";
        try(PreparedStatement stmt = this.connection.prepareStatement(sql)){
            stmt.setString(1, codMusica);
            stmt.executeUpdate();
        }catch(SQLException e){
            throw e;
        }
    }
    @Override 
    public Musica find(String codMusica) throws SQLException{
        String sql = "SELECT * FROM MUSICA WHERE COD_MUSICA = ?;";
        try(PreparedStatement stmt = this.connection.prepareStatement(sql)){
            stmt.setString(1, codMusica);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    return new Musica(
                        rs.getString("COD_MUSICA"),
                        rs.getString("TITULO"),
                        rs.getString("COD_ALBUM"),
                        rs.getInt("DURACAO"));
                }
            }
            
        }catch(SQLException e){
            throw e;
        }
        return null;
    }
    @Override
    public List<Musica> findAll() throws SQLException{
        String sql = "SELECT * FROM MUSICA;";
        List<Musica> musicas = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                musicas.add(new Musica(
                        rs.getString("COD_MUSICA"),
                        rs.getString("TITULO"),
                        rs.getString("COD_ALBUM"),
                        rs.getInt("DURACAO")));
            }
        } catch (SQLException e) {
            throw e;
        }
        
        return musicas;
    }
    
}
