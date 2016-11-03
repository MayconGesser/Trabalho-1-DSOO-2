package controladores;

import apresentacao.TelaCadastroUsuario;
import apresentacao.TelaUsuarios;
import controladores.interfaces.IControladorPrincipal;
import controladores.interfaces.IControladorUsuario;
import entidades.Usuario;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static util.Mensagens.USUARIO_ALTERADO;
import static util.Mensagens.USUARIO_CADASTRADO;
import static util.Mensagens.USUARIO_DELETADO;

public class ControladorUsuario implements IControladorUsuario {

    private TelaCadastroUsuario telaCadastroUsuario;
    private TelaUsuarios telaUsuarios;
    private Map<Integer, Usuario> usuarios;
    private Integer ultimoId;

    public ControladorUsuario(IControladorPrincipal controladorPrincipal) {
        this.telaUsuarios = new TelaUsuarios(controladorPrincipal);
        this.telaCadastroUsuario = new TelaCadastroUsuario(controladorPrincipal);
        this.usuarios = new HashMap<>();
        this.ultimoId = 0;
    }

    @Override
    public String cadastrarUsuario(Usuario usuario) {
        usuario.setCodigo(ultimoId++);
        usuario.cadastrar(usuario, this.usuarios);
        return USUARIO_CADASTRADO;
    }

    @Override
    public Map<Integer, Usuario> listarUsuarios() {
        return this.usuarios;
    }

    @Override
    public String deletaUsuario(Integer codUsuario) {
        Usuario usuario = this.getUsuario(codUsuario);
        usuario.deletaUsuario(usuario, this.usuarios);
        return USUARIO_DELETADO;
    }

    @Override
    public Usuario getUsuario(Integer idUsuario) {
        return this.usuarios.get(idUsuario);
    }

    @Override
    public void abreTelaUsuarios(){
        this.telaUsuarios.setVisible(true);
        this.telaUsuarios.atualizaDados();
    }

    @Override
    public void abreTelaCadastroUsuario(){
        this.fechaTelaUsuarios();
        this.telaCadastroUsuario.setVisible(true);
    }

    @Override
    public void fechaTelaCadastroUsuario(){
        this.telaCadastroUsuario.setVisible(false);
        this.abreTelaUsuarios();
    }

    @Override
    public void fechaTelaUsuarios(){
        this.telaUsuarios.setVisible(false);
    }
}
