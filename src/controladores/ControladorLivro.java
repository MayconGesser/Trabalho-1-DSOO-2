package controladores;

import apresentacao.TelaCadastroLivro;
import apresentacao.TelaLivros;
import controladores.interfaces.IControladorPrincipal;
import entidades.Livro;
import excecoes.BusinessException;
import controladores.interfaces.IControladorLivro;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static util.Mensagens.LIVRO_ALTERADO;
import static util.Mensagens.LIVRO_CADASTRADO;
import static util.Mensagens.LIVRO_DELETADO;

public class ControladorLivro implements IControladorLivro {

    private TelaLivros telaLivros;
    private TelaCadastroLivro telaCadastroLivro;
    private Map<Integer, Livro> acervo;
    private Integer ultimoId;

    public ControladorLivro(IControladorPrincipal controladorPrincipal) {
        this.telaCadastroLivro = new TelaCadastroLivro(controladorPrincipal);
        this.acervo = new HashMap<>();
        this.ultimoId = 0;
        this.telaLivros = new TelaLivros(controladorPrincipal);
    }

    @Override
    public String cadastrarLivro(Livro livro) {
        livro.setCodigo(ultimoId++);
        livro.cadastrarLivro(livro, this.acervo);
        return LIVRO_CADASTRADO;
    }

    @Override
    public Map<Integer, Livro> listarLivros() {
        return this.acervo;
    }

    @Override
    public String deleteLivro(Integer codLivro) {
        Livro livro = this.getLivro(codLivro);
        livro.deleteLivro(livro, this.acervo);
        return LIVRO_DELETADO;
    }

    @Override
    public Livro getLivro(Integer idLivro) {
        return this.acervo.get(idLivro);
    }

    @Override
    public void abreTelaLivros() {
        this.telaLivros.setVisible(true);
        this.telaLivros.atualizaDados();
    }

    @Override
    public void abreTelaCadastroLivro() {
        this.fechaTelaLivros();
        this.telaCadastroLivro.setVisible(true);
    }

    @Override
    public void fechaTelaLivros() {
        this.telaLivros.setVisible(false);
    }

    @Override
    public void fechaTelaCadastroLivro() {
        this.telaCadastroLivro.setVisible(false);
        this.abreTelaLivros();
    }
}
