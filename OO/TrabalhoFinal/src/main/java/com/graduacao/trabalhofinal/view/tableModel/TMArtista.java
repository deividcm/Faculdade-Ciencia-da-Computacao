package com.graduacao.trabalhofinal.view.tableModel;

import com.graduacao.trabalhofinal.model.entities.Artista;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class TMArtista extends AbstractTableModel {
    
    private List<Artista> artistas;
    
    private final int COL_COD_ARTISTA = 0;
    private final int COL_NOME = 1;
    
    public TMArtista(List<Artista> artistas){
        this.artistas = artistas;
    }

    @Override
    public int getRowCount() {
        return this.artistas.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }
    
    public Artista getRow(int rowIndex){
        return this.artistas.get(rowIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(artistas.isEmpty()){
            return null;
        }
        Artista aux = artistas.get(rowIndex);
        
        switch(columnIndex){
            case COL_COD_ARTISTA -> {
                return aux.getCodArtista();
            }
            case COL_NOME -> {
                return aux.getNome();
            }
            default -> {
                break;
            }
        }
        return null;
    }

    @Override
    public String getColumnName(int column){
        
        switch(column){
            case COL_COD_ARTISTA -> {
                return "Código";
            }
            case COL_NOME -> {
                return "Nome";
            }
            default -> {
                break;
            }
        }
        
        return "";
    }
    
    
}
