package com.graduacao.exercicios_3_3__4__5.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



public class FilePersistence {
    
    public void saveToFile(String texto, String filePath){
        try{
            FileWriter arquivo = new FileWriter(filePath);
            PrintWriter gravarArquivo = new PrintWriter(arquivo);
            gravarArquivo.print(texto);
            arquivo.close();  
        }
        catch(IOException e){    
            Logger.getLogger(FilePersistence.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public String loadFromFile(String filePath){
        String conteudo = "";
        try{
            File file = new File(filePath);
            Scanner ler = new Scanner(file);
            
            while(ler.hasNextLine()){
                conteudo += ler.nextLine();
            }
        }
        catch(IOException e){    
            Logger.getLogger(FilePersistence.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }
    
}
