package com.graduacao.exercicios_2_6.exercicios;

import com.graduacao.exercicios_2_6.classes.Carro;
import com.graduacao.exercicios_2_6.classes.Proprietario;
import com.graduacao.exercicios_2_6.classes.Roda;
import java.util.Scanner;

public class Exercicio05 {
    
    
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Proprietario p1 = criarPreenchendoProprietario(ler);
        
        System.out.println(p1.toString());
        
    }
    
    private static Proprietario criarPreenchendoProprietario(Scanner ler){
        Proprietario proprietario = new Proprietario();
        System.out.println("--- Preenchendo Proprietario ---");
        System.out.print("Informe o nome: ");
        proprietario.setNome(ler.nextLine());
        System.out.print("Informe o CPF: ");
        proprietario.setCpf(ler.nextLine());
        System.out.print("Informe o email: ");
        proprietario.setEmail(ler.nextLine());
        
        String resposta;
        do{
            Carro carro = criarPreenchendoCarro(ler);
            proprietario.getGerente().addCarro(carro);
            
            System.out.print("Criar outro carro? [s/n]: ");
            resposta = ler.nextLine();
        }while(resposta.equalsIgnoreCase("s"));
        
        return proprietario;
    }
    private static Carro criarPreenchendoCarro(Scanner ler){
        Carro carro = new Carro();
        System.out.println("--- Preenchendo Carro ---");
        System.out.print("Informe a fabricante: ");
        carro.setFabricante(ler.nextLine());
        System.out.print("Informe o modelo: ");
        carro.setModelo(ler.nextLine());
        System.out.print("Informe a cor: ");
        carro.setCor(ler.nextLine());
        
        String resposta;
        do{
            Roda roda = criarPreenchendoRoda(ler);
            carro.addRoda(roda);
            
            System.out.print("Criar outra roda? [s/n]: ");
            resposta = ler.nextLine();
        }while(resposta.equalsIgnoreCase("s"));
        
        return carro;
    }
    private static Roda criarPreenchendoRoda(Scanner ler){
        Roda roda = new Roda();
        System.out.println("--- Preenchendo Roda ---");
        System.out.print("Informe o material: ");
        roda.setMaterial(ler.nextLine());
        System.out.print("Informe a cor: ");
        roda.setCor(ler.nextLine());
        System.out.print("Informe o raio: ");
        roda.setRaio(ler.nextDouble());
        ler.nextLine();
        
        return roda;
    }
    
}
