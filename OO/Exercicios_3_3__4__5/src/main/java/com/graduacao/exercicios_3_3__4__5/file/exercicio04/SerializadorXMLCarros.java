package com.graduacao.exercicios_3_3__4__5.file.exercicio04;

import com.graduacao.exercicios_3_3__4__5.gerenciadores.GerenciadorCarro;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class SerializadorXMLCarros {
    
    public String toXML(GerenciadorCarro gerenciador){
        try{
            JAXBContext context = JAXBContext.newInstance(GerenciadorCarro.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            
            StringWriter writer = new StringWriter();
            marshaller.marshal(gerenciador, writer);
            
            return writer.toString();
        }catch(Exception e){
            e.printStackTrace();
            return "";
        }
    }
    
    public GerenciadorCarro fromXML(String data){
        try{
            JAXBContext context = JAXBContext.newInstance(GerenciadorCarro.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader reader = new StringReader(data);
            
            return (GerenciadorCarro) unmarshaller.unmarshal(reader);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
}
