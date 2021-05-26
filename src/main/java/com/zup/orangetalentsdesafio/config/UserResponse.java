package com.zup.orangetalentsdesafio.config;

import com.zup.orangetalentsdesafio.entities.User;

public class UserResponse {

    private User user;
    private String mensagem;

    public UserResponse() {
    }

    public UserResponse(User user, String mensagem) {
        this.user = user;
        this.mensagem = mensagem;
    }

    public User getUsers() {
        return user;
    }

    public void setUsers(User user) {
        this.user = user;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
