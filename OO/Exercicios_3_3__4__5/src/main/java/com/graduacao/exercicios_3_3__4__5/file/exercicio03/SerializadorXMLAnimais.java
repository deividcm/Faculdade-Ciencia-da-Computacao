package com.graduacao.exercicios_3_3__4__5.file.exercicio03;

import com.graduacao.exercicios_3_3__4__5.gerenciadores.GerenciadorAnimal;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class SerializadorXMLAnimais {
    
    public String toXML(GerenciadorAnimal gerenciador){
        try{
            JAXBContext context = JAXBContext.newInstance(GerenciadorAnimal.class);
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
    
    public GerenciadorAnimal fromXML(String xmlString){
        try{
            JAXBContext context = JAXBContext.newInstance(GerenciadorAnimal.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader reader = new StringReader(xmlString);

            return (GerenciadorAnimal) unmarshaller.unmarshal(reader);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    
}
