/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.interfaces;

import apresentacao.TelaDevolucao;
import apresentacao.TelaEmprestimo;
import entidades.Emprestimo;
import entidades.Livro;
import entidades.Usuario;

public interface IControladorBiblioteca {
    
    String emprestarLivro(Emprestimo emprestimo);

    String processarDevolucao(Usuario usuario, Livro livro);

    TelaDevolucao getTelaDevolucao();

    TelaEmprestimo getTelaEmprestimo();

    void abreTelaDevolucao();

    void abreTelaEmprestimo();
}
