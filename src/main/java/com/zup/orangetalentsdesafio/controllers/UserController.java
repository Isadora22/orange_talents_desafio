package com.zup.orangetalentsdesafio.controllers;

import com.zup.orangetalentsdesafio.entities.User;
import com.zup.orangetalentsdesafio.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> listarTodos() {
        List<User> list = userService.listarTodos();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> cadastrar(@Valid @RequestBody User user) {
        Optional<User> usuarioExistente = userService.cadastrar(user);

        if(usuarioExistente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioExistente.get());
        }
    }

}
