package com.graduacao.trabalhofinal.view.tableModel;

import com.graduacao.trabalhofinal.model.entities.Album;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class TMAlbum extends AbstractTableModel {
    private List<Album> albuns;
    
    private final int COL_COD_ALBUM = 0;
    private final int COL_NOME = 1;
    private final int COL_COD_ARTISTA = 2;
    private final int COL_ANO_LANCAMENTO = 3;

    public TMAlbum(List<Album> albuns) {
        this.albuns = albuns;
    }

    @Override
    public int getRowCount() {
        return this.albuns.size();
    }
    @Override
    public int getColumnCount(){
        return 4;
    }
    public Album getRow(int rowIndex){
        return this.albuns.get(rowIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(albuns.isEmpty()){
            return null;
        }
        Album aux = albuns.get(rowIndex);
        
        switch(columnIndex){
            case COL_COD_ALBUM -> {
                return aux.getCodAlbum();
            }
            case COL_NOME -> {
                return aux.getNome();
            }
            case COL_COD_ARTISTA -> {
                return aux.getCodArtista();
            }
            case COL_ANO_LANCAMENTO -> {
                return aux.getAnoLancamento();
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
            case COL_COD_ALBUM -> {
                return "Código Álbum";
            }
            case COL_NOME -> {
                return "Nome";
            }
            case COL_COD_ARTISTA -> {
                return "Código Artista";
            }
            case COL_ANO_LANCAMENTO -> {
                return "Ano de Lançamento";
            }
        }
        return "";
    }
    
}
