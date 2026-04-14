package com.graduacao.exercicios_2_5.exercicios;

import com.graduacao.exercicios_2_5.classes.Endereco;
import com.graduacao.exercicios_2_5.classes.Funcionario;
import java.util.Scanner;

public class Exercicio03 {
    
    
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Funcionario f1 = criaPreenchendoFuncionario(ler);
        System.out.println(f1);
        
        Funcionario f2 = new Funcionario();
        f2.copiar(f1);
        
        f2.getEndereco().setCidade("Rio de Janeiro");
        
        System.out.println(f1);
        System.out.println(f2);
    }
    
    private static Funcionario criaPreenchendoFuncionario(Scanner ler){
        Funcionario funcionario = new Funcionario();
        System.out.println("--- Preenchendo Funcionario ---");
        System.out.print("Informe o nome: ");
        funcionario.setNome(ler.nextLine());
        System.out.print("Infrome a matricula: ");
        funcionario.setMatricula(ler.nextLine());
        System.out.print("Informe o salario: ");
        funcionario.setSalario(ler.nextDouble());
        ler.nextLine();
        Endereco endereco = criaPreenchendoEndereco(ler);
        funcionario.setEndereco(endereco);
        
        return funcionario;
    }
    
    private static Endereco criaPreenchendoEndereco(Scanner ler){
        Endereco endereco = new Endereco();
        
        System.out.println("--- Preenchendo Endereco ---");
        System.out.print("Informe a rua: ");
        endereco.setRua(ler.nextLine());
        System.out.print("Informe o numero: ");
        endereco.setNumero(ler.nextInt());
        ler.nextLine();
        System.out.print("Informe o bairro: ");
        endereco.setBairro(ler.nextLine());
        System.out.print("Informe a cidade: ");
        endereco.setCidade(ler.nextLine());
        return endereco;
    }
    
}
