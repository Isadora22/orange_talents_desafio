package com.zup.orangetalentsdesafio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Ano deste veículo não foi encontrado.")
public class AnoNotFoundException extends Exception{

    public AnoNotFoundException() {
        super();
    }
}
