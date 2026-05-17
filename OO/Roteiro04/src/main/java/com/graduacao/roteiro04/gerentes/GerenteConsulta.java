package com.graduacao.roteiro04.gerentes;

import com.graduacao.roteiro04.classes.Consulta;
import com.graduacao.roteiro04.file.FilePersistence;
import com.graduacao.roteiro04.file.SerializadorConsulta;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class GerenteConsulta {
    private Map <String , Consulta> consultas;

    public GerenteConsulta () {
        this.consultas = new HashMap <>();
    }
    public GerenteConsulta(GerenteConsulta outro){
        this.consultas = new HashMap <>();
        
        for(Consulta c: outro.getConsultas().values()){
            Consulta consulta = new Consulta(c);
            this.consultas.put(consulta.getCod(), consulta);
        }
    }
    
    public void put(Consulta consulta) {
        this.consultas.put(consulta.getCod(), consulta);
    }
    
    public Consulta remove (String cod) {
        return this.consultas.remove(cod);
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.consultas);
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
        final GerenteConsulta other = (GerenteConsulta) obj;
        return Objects.equals(this.consultas, other.getConsultas());
    }
    
    public String toStringResumido() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("--- Consultas(").append(this.size()).append(") ---\n ");
        
        for(Consulta consulta: this.consultas.values()){
            sb.append(consulta.toStringResumido());
        }
        
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("--- Consultas(").append(this.size()).append(") ---\n ");
        
        for(Consulta consulta: this.consultas.values()){
            sb.append(consulta.toString());
        }
        
        return sb.toString();
    }
    
    public void carregarDoArquivo(String pathFile){
        FilePersistence filePersistence = new FilePersistence();
        String data = filePersistence.carregarDeArquivo(pathFile);
        SerializadorConsulta serializador = new SerializadorConsulta();
        this.consultas = serializador.fromJSON(data).getConsultas();
    }
    public void salvarNoArquivo(String pathFile){
        SerializadorConsulta serializador = new SerializadorConsulta();
        String data = serializador.toJSON(this);
        FilePersistence filePersistence = new FilePersistence();
        filePersistence.salvarEmArquivo(data, pathFile);
    }
    
    public int size () {
        return this.consultas.size();
    }
    
    public boolean containsKey (String cod) {
        return this.consultas.containsKey(cod);
    }
    
    public Consulta get(String cod) {
       return this.consultas.get(cod);
    }
    
    public Map<String, Consulta> getConsultas() {
        return this.consultas;
    }
}
