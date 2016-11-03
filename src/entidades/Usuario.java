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

import static util.Mensagens.INPUT_IRREGULAR;
import static util.Mensagens.USUARIO_NAO_ENCONTRADO;

public class Usuario {

    private String nome;
    private Integer codigo;
    private long CPF; 
    private long telefone; 

    public Usuario(String nome, long CPF, long telefone) {
        this.nome = nome;
        this.CPF = CPF;
        this.telefone = telefone; 
    }

    public Usuario cadastrar(Usuario usuario, Map<Integer, Usuario> usuarios) {
        this.validaUsuario(usuario);
        usuarios.put(usuario.getCodigo(), usuario);
        return usuario;
    }

    public void deletaUsuario(Usuario usuario, Map<Integer, Usuario> usuarios) {
        this.validaUsuario(usuario);
        usuarios.remove(usuario.getCodigo());
    }

    private void validaUsuario(Usuario usuario) {
        Collection<String> erros = new ArrayList<>();

        if (usuario.getNome() == null || usuario.getNome().equals(""))
            erros.add(INPUT_IRREGULAR);

        if (!erros.isEmpty())
            throw new BusinessException(erros);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public long getCPF() {
        return CPF;
    }

    public void setCPF(long CPF) {
        this.CPF = CPF;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }
}
