package com.graduacao.exercicios_3_6.file;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FilePersistence {
    
    public void salvarEmArquivo(String texto, String pathFile){
        try{
            FileWriter arquivo = new FileWriter(pathFile);
            PrintWriter gravarArquivo = new PrintWriter(arquivo);
            gravarArquivo.print(texto);
            arquivo.close();
        }
        catch(Exception e){
            Logger.getLogger(FilePersistence.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public String carregarDeArquivo(String pathFile){
        String conteudo = "";
        try{
            File file = new File(pathFile);
            Scanner ler = new Scanner(file);
            
            ler.useDelimiter("\\Z");
            while(ler.hasNext()){
                conteudo += ler.next();
            }
            
        }
        catch(Exception e){
            Logger.getLogger(FilePersistence.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }
    
    
}
