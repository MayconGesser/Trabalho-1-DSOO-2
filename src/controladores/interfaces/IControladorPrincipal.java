package controladores.interfaces;

import apresentacao.Tela;
import entidades.Livro;
import entidades.Usuario;

import java.util.Map;

public interface IControladorPrincipal {

    String cadastrarLivro(String titulo, String autor, String editora);

    String cadastrarUsuario(String nome, long CPF, long telefone);

    String emprestarLivro(Integer codLivro, Integer codUsr);

    String processarDevolucao(Integer codLivro, Integer codUsr);

    void abreTelaPrincipal();

    void abreTelaDevolucao();

    void abreTelaEmprestimo();

    void abreTelaCadastroUsuario();

    void abreTelaCadastroLivro();

    void fechaTela(Tela tela);

    void fechaTelaCadastroUsuario();

    void fechaTelaCadastroLivro();

    void abreTelaUsuarios();

    void abreTelaLivros();

    IControladorBiblioteca getControladorBiblioteca();

    IControladorLivro getControladorLivro();

    IControladorUsuario getControladorUsuario();
}
