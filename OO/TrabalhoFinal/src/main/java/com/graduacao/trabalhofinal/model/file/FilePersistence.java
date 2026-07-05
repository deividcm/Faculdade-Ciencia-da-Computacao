package com.graduacao.trabalhofinal.model.file;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;


public class FilePersistence {
    
    public void saveToFile(String texto, String pathFile) throws Exception{
        try{
            FileWriter arquivo = new FileWriter(pathFile);
            PrintWriter gravarArquivo = new PrintWriter(arquivo);
            gravarArquivo.print(texto);
            arquivo.close();
        }
        catch(Exception e){
            throw e;
        }
    }
    
    public String loadFromFile(String pathFile) throws Exception{
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
            throw e;
        }
        return conteudo;
    }
    
    
}
