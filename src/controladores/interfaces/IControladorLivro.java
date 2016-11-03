package controladores.interfaces;

import entidades.Livro;

import java.util.Map;

public interface IControladorLivro {

    String cadastrarLivro(Livro livro);

    Map<Integer, Livro> listarLivros();

    String deleteLivro(Integer codLivro);

    Livro getLivro(Integer idLivro);

    void abreTelaLivros();

    void abreTelaCadastroLivro();

    void fechaTelaLivros();

    void fechaTelaCadastroLivro();
}
