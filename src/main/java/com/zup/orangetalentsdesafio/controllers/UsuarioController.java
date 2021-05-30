package com.zup.orangetalentsdesafio.controllers;

import com.zup.orangetalentsdesafio.entities.Usuario;
import com.zup.orangetalentsdesafio.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/add")
    public ResponseEntity<Usuario> cadastrar(@Valid @RequestBody Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuarioService.cadastrar(usuario);

        if(usuarioExistente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioExistente.get());
        }
    }
}


