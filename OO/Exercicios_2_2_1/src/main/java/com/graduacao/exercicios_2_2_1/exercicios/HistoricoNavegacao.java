package com.graduacao.exercicios_2_2_1.exercicios;

import com.graduacao.exercicios_2_2_1.classes.GerenciadorHistorico;
import java.util.Scanner;

public class HistoricoNavegacao {
    public static int imprimeMenu(String link){
        Scanner ler = new Scanner(System.in);
        System.out.println("--------Navegacao--------");
        System.out.println("Site atual - " + link);
        System.out.println("1 - Entrar em outro site");
        System.out.println("2 - Voltar para o site anterior");
        System.out.println("0 - Sair(Exibe todos os sites unicos visitados)");
        System.out.println("-----------------------------");
        System.out.println("Escolha uma opcao:");
        
        return ler.nextInt();
    }
    public static void main(String[] args) {
        int opcao = 0;
        Scanner ler = new Scanner(System.in);
        GerenciadorHistorico gerenciador = new GerenciadorHistorico();
        
        do{
            opcao = imprimeMenu(gerenciador.siteAtual());
            
            switch(opcao){
                case 1 -> {
                    System.out.println("Informe o link do site que deseja entrar: ");
                    String link = ler.next();//Nao tem necessidade de ser next line pois links nao tem espacos
                    
                    gerenciador.entrarEmSite(link);
                    break;
                }
                case 2 -> {
                    gerenciador.voltarParaAnterior();
                    break;
                }
                case 0 -> {
                    gerenciador.finalizar();
                    break;
                }
            }
            
            
        }while(opcao !=0);
        
    }
}
