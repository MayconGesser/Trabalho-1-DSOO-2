/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import excecoes.BusinessException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import static util.Mensagens.*;

public class Livro {

    private String titulo;
    private String autor;
    private String editora;
    private Integer codigo;
    private boolean disponivel;

    public Livro(String titulo, String autor, String editora) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.disponivel = true;
    }

    public Livro cadastrarLivro(Livro livro, Map<Integer, Livro> livros) {
        this.validaLivro(livro);
        livros.put(livro.getCodigo(), livro);
        return livro;
    }

    public void deleteLivro(Livro livro, Map<Integer, Livro> livros) {
        this.validaLivro(livro);
        livros.remove(livro.getCodigo());
    }

    private void validaLivro(Livro livro) {
        Collection<String> erros = new ArrayList<>();
        if (livro.getTitulo() == null || livro.getTitulo().equals(""))
            erros.add(CAMPO_TITULO_OBRIGATORIO);
        if (livro.getAutor() == null || livro.getAutor().equals(""))
            erros.add(CAMPO_AUTOR_OBRIGATORIO);
        if (livro.getEditora() == null || livro.getEditora().equals(""))
            erros.add(CAMPO_EDITORA_OBRIGATORIO);

        if (!erros.isEmpty())
            throw new BusinessException(erros);
    }

    public boolean estahDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }


}
