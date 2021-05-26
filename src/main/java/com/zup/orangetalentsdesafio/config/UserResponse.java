package com.zup.orangetalentsdesafio.config;

import com.zup.orangetalentsdesafio.entities.Users;

public class UserResponse {

    private Users users;
    private String mensagem;

    public UserResponse() {
    }

    public UserResponse(Users users, String mensagem) {
        this.users = users;
        this.mensagem = mensagem;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
