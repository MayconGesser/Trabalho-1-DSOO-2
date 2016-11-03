package controladores.interfaces;

import entidades.Usuario;

import java.util.Map;

public interface IControladorUsuario {

    String cadastrarUsuario(Usuario usuario);

    Map<Integer, Usuario> listarUsuarios();

    String deletaUsuario(Integer codUsuario);

    Usuario getUsuario(Integer idUsuario);

    void abreTelaUsuarios();

    void abreTelaCadastroUsuario();

    void fechaTelaCadastroUsuario();

    void fechaTelaUsuarios();
}
