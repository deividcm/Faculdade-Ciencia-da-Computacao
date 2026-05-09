package com.graduacao.exercicios_3_3__4__5.gerenciadores;

import com.graduacao.exercicios_3_3__4__5.classes.Carro;
import com.graduacao.exercicios_3_3__4__5.file.FilePersistence;
import com.graduacao.exercicios_3_3__4__5.file.exercicio04.SerializadorCSVCarros;
import com.graduacao.exercicios_3_3__4__5.file.exercicio04.SerializadorJSONCarros;
import com.graduacao.exercicios_3_3__4__5.file.exercicio04.SerializadorXMLCarros;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Carros")
public class GerenciadorCarro {
    @XmlElement(name = "Carro")
    private Map<String, Carro> carros;
    
    public GerenciadorCarro(){
        this.carros = new HashMap<>();
    }
    public GerenciadorCarro(GerenciadorCarro outro){
        this.carros = new HashMap<>();
        
        for(Carro c: outro.getCarros().values()){
            Carro carro = new Carro(c);
            this.carros.put(carro.getCod(), carro);
        }
    }
    
    public void put(Carro carro){
        this.carros.put(carro.getCod(), carro);
    }
    public Carro remove(String cod){
        return this.carros.remove(cod);
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Carros (").append(this.size()).append(") ---\n ");
        
        for(Carro carro: this.carros.values()){
            sb.append(carro.toString());
        }
        
        return sb.toString();
    }
    
    public void salvarNoArquivo(String pathFile){
        /*SerializadorCSVCarros serializador = new SerializadorCSVCarros();
        String data = serializador.toCSV(this.carros);*/
        /*SerializadorXMLCarros serializador = new SerializadorXMLCarros();
        String data = serializador.toXML(this);*/
        SerializadorJSONCarros serializador = new SerializadorJSONCarros();
        String data = serializador.toJSON(this.carros);
        FilePersistence filePersistence = new FilePersistence();
        filePersistence.saveToFile(data, pathFile);
    }
    
    public void carregarDoArquivo(String pathFile){
        
        FilePersistence filePersistence = new FilePersistence();
        String data = filePersistence.loadFromFile(pathFile);
        
        /*SerializadorCSVCarros serializador = new SerializadorCSVCarros();
        this.carros = serializador.fromCSV(data);*/
        /*SerializadorXMLCarros serializador = new SerializadorXMLCarros();
        this.carros = serializador.fromXML(data).getCarros();*/
        SerializadorJSONCarros serializador = new SerializadorJSONCarros();
        this.carros = serializador.fromJSON(data);
    }
    
    public int size(){
        return this.carros.size();
    }
    public boolean containsKey(String cod){
        return this.carros.containsKey(cod);
    }
    
    public Carro get(String cod){
        return this.carros.get(cod);
    }
    public Map<String, Carro> getCarros() {
        return this.carros;
    } 
}
