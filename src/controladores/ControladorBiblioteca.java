/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import apresentacao.TelaDevolucao;
import apresentacao.TelaEmprestimo;
import controladores.interfaces.IControladorPrincipal;
import entidades.Emprestimo;
import entidades.Livro;
import entidades.Usuario;
import excecoes.BusinessException;
import controladores.interfaces.IControladorLivro;
import controladores.interfaces.IControladorUsuario;

import controladores.interfaces.IControladorBiblioteca;
import util.Mensagens;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

import static util.Mensagens.*;

public class ControladorBiblioteca implements IControladorBiblioteca {

    private TelaDevolucao telaDevolucao;
    private TelaEmprestimo telaEmprestimo;
    private Collection<Emprestimo> emprestimos;

    public ControladorBiblioteca(IControladorPrincipal controladorPrincipal) {
        this.telaDevolucao = new TelaDevolucao(controladorPrincipal);
        this.telaEmprestimo = new TelaEmprestimo(controladorPrincipal);
        this.emprestimos = new ArrayList<>();
    }

    @Override
    public String emprestarLivro(Emprestimo emprestimo) {
        emprestimo.cadastraEmprestimo(emprestimo, this.emprestimos);
        emprestimo.getLivro().setDisponivel(false);
        return EMPRESTIMO_SUCESSO;
    }

    @Override
    public String processarDevolucao(Usuario usuario, Livro livro) {
        Emprestimo emprestimoDevolucao = null;
        for (Emprestimo emprestimo : this.emprestimos)
            if (emprestimo.getLivro().getCodigo().equals(livro.getCodigo()) && emprestimo.getUsuario().getCodigo().equals(usuario.getCodigo()))
                emprestimoDevolucao = emprestimo;

        if (emprestimoDevolucao == null)
            throw new BusinessException(Mensagens.EMPRESTIMO_NAO_ENCONTRADO);

        emprestimoDevolucao.cadastraDevolucao(emprestimoDevolucao, this.emprestimos);
        livro.setDisponivel(true);
        return DEVOLUCAO_SUCESSO;
    }

    @Override
    public TelaDevolucao getTelaDevolucao() {
        return telaDevolucao;
    }

    @Override
    public TelaEmprestimo getTelaEmprestimo() {
        return telaEmprestimo;
    }

    @Override
    public void abreTelaDevolucao(){
        this.telaDevolucao.setVisible(true);
    }

    @Override
    public void abreTelaEmprestimo(){
        this.telaEmprestimo.setVisible(true);
    }
}
