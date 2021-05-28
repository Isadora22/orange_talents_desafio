package com.zup.orangetalentsdesafio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Usuário não encontrado.")
public class UsuarioNotFoundException extends Exception{

    public UsuarioNotFoundException() {
        super();
    }
}
