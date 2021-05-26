package com.zup.orangetalentsdesafio.controllers;

import com.zup.orangetalentsdesafio.entities.Users;
import com.zup.orangetalentsdesafio.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/all")
    public ResponseEntity<List<Users>> listarTodos() {
        List<Users> list = usersService.listarTodos();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Users> cadastrar(@Valid @RequestBody Users user) {
        Optional<Users> usuarioExistente = usersService.cadastrar(user);

        if(usuarioExistente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioExistente.get());
        }
    }

}
