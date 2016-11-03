package controladores;

import apresentacao.*;
import controladores.interfaces.IControladorBiblioteca;
import controladores.interfaces.IControladorLivro;
import controladores.interfaces.IControladorPrincipal;
import controladores.interfaces.IControladorUsuario;
import entidades.Emprestimo;
import entidades.Livro;
import entidades.Usuario;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

public class ControladorPrincipal implements IControladorPrincipal {

    private TelaPrincipal telaPrincipal;

    private final IControladorBiblioteca controladorBiblioteca;
    private final IControladorLivro controladorLivro;
    private final IControladorUsuario controladorUsuario;

    public ControladorPrincipal() {
        this.controladorUsuario = new ControladorUsuario(this);
        this.controladorBiblioteca = new ControladorBiblioteca(this);
        this.controladorLivro = new ControladorLivro(this);
        this.telaPrincipal = new TelaPrincipal(this);
    }

    @Override
    public String cadastrarLivro(String titulo, String autor, String editora) {
        return this.controladorLivro.cadastrarLivro(new Livro(titulo, autor, editora));
    }

    @Override
    public String cadastrarUsuario(String nome, long CPF, long telefone) {
        return this.controladorUsuario.cadastrarUsuario(new Usuario(nome, CPF, telefone));
    }

    @Override
    public String emprestarLivro(Integer codLivro, Integer codUsr) {
        Livro livro = this.controladorLivro.getLivro(codLivro);
        Usuario usuario = this.controladorUsuario.getUsuario(codUsr);
        return this.controladorBiblioteca.emprestarLivro(new Emprestimo(usuario, livro, new Date()));
    }

    @Override
    public String processarDevolucao(Integer codLivro, Integer codUsr) {
        Livro livro = this.controladorLivro.getLivro(codLivro);
        Usuario usuario = this.controladorUsuario.getUsuario(codUsr);
        return this.controladorBiblioteca.processarDevolucao(usuario, livro);
    }

    @Override
    public void abreTelaPrincipal() {
        this.telaPrincipal.setVisible(true);
        this.telaPrincipal.atualizaDados();
    }

    @Override
    public void abreTelaDevolucao() {
        this.fechaTelaPrincipal();
        this.controladorBiblioteca.abreTelaDevolucao();
    }

    @Override
    public void abreTelaEmprestimo() {
        this.fechaTelaPrincipal();
        this.controladorBiblioteca.abreTelaEmprestimo();
    }

    @Override
    public void abreTelaCadastroUsuario() {
        this.controladorUsuario.abreTelaCadastroUsuario();
    }

    @Override
    public void abreTelaCadastroLivro() {
        this.controladorLivro.abreTelaCadastroLivro();
    }

    @Override
    public void abreTelaUsuarios() {
        this.fechaTelaPrincipal();
        this.controladorUsuario.abreTelaUsuarios();
    }

    @Override
    public void abreTelaLivros() {
        this.fechaTelaPrincipal();
        this.controladorLivro.abreTelaLivros();
    }

    @Override
    public void fechaTela(Tela tela) {
        tela.setVisible(false);
        this.abreTelaPrincipal();
    }

    @Override
    public void fechaTelaCadastroUsuario() {
        this.controladorUsuario.fechaTelaCadastroUsuario();
    }

    @Override
    public void fechaTelaCadastroLivro() {
        this.controladorLivro.fechaTelaCadastroLivro();
    }

    private void fechaTelaPrincipal() {
        this.telaPrincipal.setVisible(false);
    }

    @Override
    public IControladorBiblioteca getControladorBiblioteca() {
        return this.controladorBiblioteca;
    }

    @Override
    public IControladorLivro getControladorLivro() {
        return this.controladorLivro;
    }

    @Override
    public IControladorUsuario getControladorUsuario() {
        return this.controladorUsuario;
    }
}
