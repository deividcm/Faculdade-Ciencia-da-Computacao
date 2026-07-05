package com.graduacao.trabalhofinal.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class SQLiteConnector {
    
    private Connection connection;

    public SQLiteConnector(String dbName) throws SQLException {
        String url = "jdbc:sqlite:" + dbName;
        this.connection = DriverManager.getConnection(url);
        
        this.criarTabelaArtista();
        this.criarTabelaAlbum();
        this.criarTabelaMusica();
    }
    
    public Connection getConnection(){
        return this.connection;
    }
    
    private void criarTabelaMusica() throws SQLException{
        String sql = "CREATE TABLE IF NOT EXISTS MUSICA("
                + " ID_MUSICA INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " COD MUSICA TEXT PRIMARY KEY,"
                + " COD_ALBUM TEXT REFERENCES ALBUM(COD_ALBUM),"
                + " TITULO TEXT NOT NULL,"
                + " DURACAO REAL NOT NULL);";
        try(Statement stmt = this.connection.createStatement()){
            stmt.execute(sql);
        }catch(SQLException e){
            throw e;
        }
    }
    private void criarTabelaAlbum() throws SQLException{
        String sql = "CREATE TABLE IF NOT EXISTS ALBUM("
                + " ID_ALBUM INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " COD_ALBUM TEXT PRIMARY KEY, "
                + " COD_ARTISTA TEXT REFERENCES ARTISTA(COD_ARTISTA),"
                + " NOME TEXT NOT NULL,"
                + " ANO_LANCAMENTO INTEGER NOT NULL);";
        try(Statement stmt = this.connection.createStatement()){
            stmt.execute(sql);
        }catch(SQLException e){
            throw e;
        }
    }
    
    private void criarTabelaArtista() throws SQLException{
        String sql = "CREATE TABLE IF NOT EXISTS ARTISTA("
                + " ID_ARTISTA INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " COD_ARTISTA TEXT PRIMARY KEY,"
                + " NOME TEXT NOT NULL);";
        try(Statement stmt = this.connection.createStatement()){
            stmt.execute(sql);
        }catch(SQLException e){
            throw e;
        }
    }
    
}
