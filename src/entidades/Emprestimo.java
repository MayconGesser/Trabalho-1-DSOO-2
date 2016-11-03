package entidades;

import excecoes.BusinessException;
import util.Mensagens;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import static util.Mensagens.*;

public class Emprestimo {

    private Usuario usuario;
    private Livro livro;
    private Date dataEmprestimo;
    private Date dataDevolucao;

    public Emprestimo(Usuario usuario, Livro livro, Date dataEmprestimo) {
        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        Calendar dataDevolucao = Calendar.getInstance();
        dataDevolucao.setTime(dataEmprestimo);
        dataDevolucao.add(Calendar.DATE, 7);
        this.dataDevolucao = dataDevolucao.getTime();
    }

    public void cadastraEmprestimo(Emprestimo emprestimo, Collection<Emprestimo> emprestimos) {
        this.validaEmprestimo(emprestimo);
        emprestimos.add(emprestimo);
    }

    public void cadastraDevolucao(Emprestimo emprestimo, Collection<Emprestimo> emprestimos) {
        this.validaDevolucao(emprestimo);
        emprestimos.remove(emprestimo);
    }

    private void validaEmprestimo(Emprestimo emprestimo) {
        Collection<String> erros = new ArrayList<>();

        if (emprestimo.getDataEmprestimo() == null || emprestimo.getDataDevolucao() == null)
            erros.add(Mensagens.INPUT_IRREGULAR);
        if (emprestimo.getLivro() == null)
            throw new BusinessException(LIVRO_NAO_ENCONTRADO);
        if (!emprestimo.getLivro().estahDisponivel())
            throw new BusinessException(LIVRO_INDISPONIVEL);
        if (emprestimo.getUsuario() == null)
            throw new BusinessException(USUARIO_NAO_ENCONTRADO);

        if (!erros.isEmpty())
            throw new BusinessException(erros);
    }

    public void validaDevolucao(Emprestimo emprestimo){
        String erro = "";

        if (emprestimo.getLivro().estahDisponivel())
            throw new BusinessException(LIVRO_NAO_EMPRESTADO);

        if (!erro.equals(""))
            throw new BusinessException(erro);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}
