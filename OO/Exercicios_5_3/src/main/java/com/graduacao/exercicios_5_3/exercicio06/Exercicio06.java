
package com.graduacao.exercicios_5_3.exercicio06;

import com.graduacao.exercicios_5_3.exercicio06.classes.ChessGame;
import java.util.Scanner;


public class Exercicio06 {
    
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        ChessGame jogo = new ChessGame();
        jogo.jogar();
        String resposta = "";
        do{
            System.out.print("Deseja mover uma peca preta ou branca?: ");
            boolean color = ler.next().equalsIgnoreCase("preta");
            System.out.print("Informe o index da peca: ");
            int index = ler.nextInt();
            jogo.move(color, index);
            System.out.print("Deseja mover mais alguma peca?[S/N]: ");
            resposta =  ler.next();
        }while(resposta.equalsIgnoreCase("s"));
    }
    
    
}
