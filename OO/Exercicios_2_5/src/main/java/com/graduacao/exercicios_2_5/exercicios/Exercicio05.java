package com.graduacao.exercicios_2_5.exercicios;

import com.graduacao.exercicios_2_5.classes.Aluno;
import com.graduacao.exercicios_2_5.classes.Disciplina;
import com.graduacao.exercicios_2_5.classes.Professor;
import java.util.Scanner;

public class Exercicio05 {
    
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        
        Disciplina d1 = criarPreenchendoDisciplina(ler);
        
        System.out.println(d1);
        
        Disciplina d2 = new Disciplina(d1);
        
        
        Aluno aluno = criarPreenchendoAluno(ler);
        d2.addAluno(aluno);
        System.out.println(d2);
    }
    
    private static Disciplina criarPreenchendoDisciplina(Scanner ler){
        Disciplina disciplina = new Disciplina();
        System.out.println("--- Preenchendo Disciplina ---");
        System.out.print("Informe o nome: ");
        disciplina.setNome(ler.nextLine());
        System.out.print("Informe o horario: ");
        disciplina.setHorario(ler.nextLine());
        System.out.print("Informe o semestre: ");
        disciplina.setSemestre(ler.nextInt());
        ler.nextLine();
        
        Professor professor = criarPreenchendoProfessor(ler);
        disciplina.setProfessor(professor);
        
        String resposta;
        do{
            Aluno aluno = criarPreenchendoAluno(ler);
            disciplina.addAluno(aluno);
            
            System.out.print("Adicionar mais um aluno? (s/n): ");
            resposta = ler.nextLine();
        }while(resposta.equalsIgnoreCase("s"));
        
        return disciplina;
    }
    
    private static Professor criarPreenchendoProfessor(Scanner ler){
        Professor professor = new Professor();
        System.out.println("--- Preenchendo Professor ---");
        System.out.print("Informe o nome: ");
        professor.setNome(ler.nextLine());
        System.out.print("Informe o CPF: ");
        professor.setCpf(ler.nextLine());
        System.out.print("Informe a idade: ");
        professor.setIdade(ler.nextInt());
        System.out.print("Informe o sexo: ");
        professor.setSexo(ler.next().charAt(0));
        ler.nextLine();
        
        return professor;
    }
    
    
    private static Aluno criarPreenchendoAluno(Scanner ler){
        Aluno aluno = new Aluno();
        System.out.println("--- Preenchendo Aluno ---");
        System.out.print("Informe o nome: ");
        aluno.setNome(ler.nextLine());
        System.out.print("Informe o CPF: ");
        aluno.setCpf(ler.nextLine());
        System.out.print("Informe a matricula: ");
        aluno.setMatricula(ler.nextLine());
        System.out.print("Informe o ano de ingresso: ");
        aluno.setAnoIngresso(ler.nextInt());
        System.out.print("Informe a idade: ");
        aluno.setIdade(ler.nextInt());
        System.out.print("Informe o sexo: ");
        aluno.setSexo(ler.next().charAt(0));
        ler.nextLine();
        
        return aluno;
    }
    
}
