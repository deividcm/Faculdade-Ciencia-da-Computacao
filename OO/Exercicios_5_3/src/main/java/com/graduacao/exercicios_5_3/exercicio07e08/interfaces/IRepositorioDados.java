
package com.graduacao.exercicios_5_3.exercicio07e08.interfaces;

import com.graduacao.exercicios_5_3.exercicio07e08.classes.Pessoa;
import java.util.List;

public interface IRepositorioDados {
    void salvar(Pessoa pessoa);
    void atualizar(int idPessoa, Pessoa pessoa);
    void excluir(int idPessoa);
    List<Pessoa> listar();
}
