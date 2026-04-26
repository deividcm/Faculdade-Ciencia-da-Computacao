package com.graduacao.exercicios_2_6.classes.exercicio12;

import com.graduacao.exercicios_2_6.gerentes.exercicio12.GerenteFuncionarios;
import com.graduacao.exercicios_2_6.gerentes.exercicio12.GerenteProjetos;


public class Empresa {
    private String nome;
    private final GerenteFuncionarios gerenteFuncionarios;
    private final GerenteProjetos gerenteProjetos;
    
    public Empresa(){
        this.nome = "";
        this.gerenteFuncionarios = new GerenteFuncionarios();
        this.gerenteProjetos = new GerenteProjetos();
    }
    public Empresa(String nome) {
        this.nome = nome;
        this.gerenteFuncionarios = new GerenteFuncionarios();
        this.gerenteProjetos = new GerenteProjetos();
    }
    
    public Funcionario removerFuncionario(String ID){
        Funcionario funcionario = this.gerenteFuncionarios.removerFuncionario(ID);
        if (funcionario != null){
            for(Projeto projeto: funcionario.getGerenteProjetos().getProjetos().values()){
                projeto.getGerenteFuncionarios().removerFuncionario(ID);
            }
        } 
        return funcionario;
    }
    public Projeto removerProjeto(String codigo){
        Projeto projeto = this.gerenteProjetos.removerProjeto(codigo);
        if(projeto != null){
            for(Funcionario funcionario: projeto.getGerenteFuncionarios().getFuncionarios().values()){
                funcionario.getGerenteProjetos().removerProjeto(codigo);
            }
        }
        return projeto;
    }
    
    
    public Funcionario getFuncionarioMaisProdutivo(){
        Funcionario maior = null;
        
        for(Funcionario funcionario: this.gerenteFuncionarios.getFuncionarios().values()){
            if(maior == null){
                maior = funcionario;
            }else if (funcionario.getGerenteProjetos().size() > maior.getGerenteProjetos().size()){
                maior = funcionario;
            }
            
        }
        
        return maior;
    }
    
    public Funcionario getFuncionarioMenosProdutivo(){
        Funcionario menor = null;
        
        for(Funcionario funcionario: this.gerenteFuncionarios.getFuncionarios().values()){
            if(menor == null){
                menor = funcionario;
            }else if (funcionario.getGerenteProjetos().size() < menor.getGerenteProjetos().size()){
                menor = funcionario;
            }
            
        }
        
        return menor;
    }
    
    public String toStringFuncionarios(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("--- Funcionarios (").append(this.gerenteFuncionarios.size()).append(") ---\n ");
        sb.append(this.gerenteFuncionarios.toString());
        
        return sb.toString();
    }
    
    public String toStringProjetos(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("--- Projetos (").append(this.gerenteProjetos.size()).append(") ---\n ");
        sb.append(this.gerenteProjetos.toString());
        
        return sb.toString();
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Empresa ---\n ");
        sb.append("Nome: ").append(this.nome).append("\n ");
        sb.append("--- Projetos (").append(this.gerenteProjetos.size()).append(") ---\n ");
        sb.append(this.gerenteProjetos.toStringResumido());
        sb.append("--- Funcionarios (").append(this.gerenteFuncionarios.size()).append(") ---\n ");
        sb.append(this.gerenteFuncionarios.toStringResumido());
        return sb.toString();
    }
    
    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public GerenteFuncionarios getGerenteFuncionarios() {
        return this.gerenteFuncionarios;
    }
    public GerenteProjetos getGerenteProjetos() {
        return this.gerenteProjetos;
    }
}
