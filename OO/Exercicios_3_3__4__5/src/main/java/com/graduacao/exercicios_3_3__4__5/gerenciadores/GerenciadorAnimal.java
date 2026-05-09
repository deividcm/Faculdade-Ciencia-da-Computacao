package com.graduacao.exercicios_3_3__4__5.gerenciadores;


import com.graduacao.exercicios_3_3__4__5.classes.Animal;
import com.graduacao.exercicios_3_3__4__5.file.FilePersistence;
import com.graduacao.exercicios_3_3__4__5.file.exercicio03.SerializadorCSVAnimais;
import com.graduacao.exercicios_3_3__4__5.file.exercicio03.SerializadorJSONAnimais;
import com.graduacao.exercicios_3_3__4__5.file.exercicio03.SerializadorXMLAnimais;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Animais")
public class GerenciadorAnimal {
    
    @XmlElement(name = "Animal")
    private Map<String,Animal> animais;
    
    public GerenciadorAnimal(){
        this.animais = new HashMap<>();
    }
    public GerenciadorAnimal(GerenciadorAnimal outro){
        this.animais = new HashMap<>();
        
        for(Animal a: this.animais.values()){
            Animal animal = new Animal(a);
            this.animais.put(animal.getCod(), animal);
        }
    }
    public void put(Animal animal){
        this.animais.put(animal.getCod(), animal);
    }
    public Animal remove(String cod){
        return this.animais.remove(cod);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.animais);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GerenciadorAnimal other = (GerenciadorAnimal) obj;
        return Objects.equals(this.animais, other.animais);
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Animais (").append(this.size()).append(") ---\n ");
        
        for(Animal animal: this.animais.values()){
            sb.append(animal.toString());
        }
        
        return sb.toString();
    }
    
    public void salvarNoArquivo(String pathFile){
        /*SerializadorCSVAnimais serializador = new SerializadorCSVAnimais();
        String data = serializador.toCSV(this.animais);*/
        /*SerializadorXMLAnimais serializador = new SerializadorXMLAnimais();
        String data = serializador.toXML(this);*/
        SerializadorJSONAnimais serializador = new SerializadorJSONAnimais();
        String data = serializador.toJSON(this.animais);
        FilePersistence filePersistence = new FilePersistence();
        filePersistence.saveToFile(data, pathFile);
    }
    
    public void carregarDoArquivo(String pathFile){
        
        FilePersistence filePersistence = new FilePersistence();
        String data = filePersistence.loadFromFile(pathFile);
        
        /*SerializadorCSVAnimais serializador = new SerializadorCSVAnimais();
        this.animais = serializador.fromCSV(data);*/
        /*SerializadorXMLAnimais serializador = new SerializadorXMLAnimais();
        this.animais = serializador.fromXML(data).getAnimais();*/
        SerializadorJSONAnimais serializador = new SerializadorJSONAnimais();
        this.animais = serializador.fromJSON(data);
    }
    
    
    public int size(){
        return this.animais.size();
    }
    public boolean containsKey(String cod){
        return this.animais.containsKey(cod);
    }
    public Animal get(String cod){
        return this.animais.get(cod);
    }
    public Map<String, Animal> getAnimais() {
        return this.animais;
    }
}
