
package com.graduacao.exercicios_2_5.exercicios;

import com.graduacao.exercicios_2_5.classes.Cliente;
import com.graduacao.exercicios_2_5.classes.ContaBancaria;
import java.util.Scanner;

public class Exercicio02 {
    
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Cliente c1 = criarPreenchendoCliente(ler);
        System.out.println(c1);
        c1.depositar(500);
        System.out.println(c1);
        c1.sacar(600);
        System.out.println(c1);
    }
    
    private static Cliente criarPreenchendoCliente(Scanner ler){
        Cliente cliente = new Cliente();
        System.out.println("--- Preenchendo Cliente ---");
        System.out.print("Informe o nome: ");
        cliente.setNome(ler.nextLine());
        System.out.print("Informe o CPF: ");
        cliente.setCpf(ler.nextLine());
        
        ContaBancaria conta = criarPreenchendoContaBancaria(ler);
        cliente.setConta(conta);
        return cliente;
    }
    
    private static ContaBancaria criarPreenchendoContaBancaria(Scanner ler){
        ContaBancaria conta = new ContaBancaria();
        System.out.println("--- Preenchendo Conta Bancaria ---");
        System.out.print("Informe o numero: ");
        conta.setNumero(ler.nextInt());
        System.out.print("Informe o tipo: ");
        conta.setTipo(ler.next());
        System.out.print("Informe o saldo: ");
        conta.setSaldo(ler.nextDouble());
        
        return conta;
    }
}
