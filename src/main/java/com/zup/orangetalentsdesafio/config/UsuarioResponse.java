package com.zup.orangetalentsdesafio.config;

import com.zup.orangetalentsdesafio.entities.Usuario;

public class UsuarioResponse {

    private Usuario usuario;
    private String mensagem;

    public UsuarioResponse() {
    }

    public UsuarioResponse(Usuario usuario, String mensagem) {
        this.usuario = usuario;
        this.mensagem = mensagem;
    }

    public Usuario getUsers() {
        return usuario;
    }

    public void setUsers(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
