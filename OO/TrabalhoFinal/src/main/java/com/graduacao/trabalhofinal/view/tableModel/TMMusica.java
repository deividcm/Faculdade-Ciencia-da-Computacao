package com.graduacao.trabalhofinal.view.tableModel;

import com.graduacao.trabalhofinal.model.entities.Musica;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class TMMusica extends AbstractTableModel {
    private List<Musica> musicas;
    
    private final int COL_COD_MUSICA = 0;
    private final int COL_TITULO = 1;
    private final int COL_COD_ALBUM = 2;
    private final int COL_DURACAO = 3;

    public TMMusica(List<Musica> musicas) {
        this.musicas = musicas;
    }

    @Override
    public int getRowCount() {
        return this.musicas.size();
    }
    @Override
    public int getColumnCount(){
        return 4;
    }
    
    public Musica getRow(int rowIndex){
        return this.musicas.get(rowIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(musicas.isEmpty()){
            return null;
        }
        Musica aux = musicas.get(rowIndex);
        
        switch(columnIndex){
            case COL_COD_MUSICA -> {
                return aux.getCodMusica();
            }
            case COL_TITULO -> {
                return aux.getTitulo();
            }
            case COL_COD_ALBUM -> {
                return aux.getCodAlbum();
            }
            case COL_DURACAO -> {
                return aux.getDuracao();
            }
            default -> {
                break;
            }
        }
        return null;
    }
        
    
    
    @Override
    public String getColumnName(int columnIndex){
        
        switch(columnIndex){
            case COL_COD_MUSICA -> {
                return "Código Música";
            }
            case COL_TITULO -> {
                return "Nome";
            }
            case COL_COD_ALBUM -> {
                return "Código Álbum";
            }
            case COL_DURACAO -> {
                return "Duração";
            }

        }
        return "";
    }
}
