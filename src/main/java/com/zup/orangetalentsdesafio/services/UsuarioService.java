package com.zup.orangetalentsdesafio.services;

import com.zup.orangetalentsdesafio.config.UsuarioResponse;
import com.zup.orangetalentsdesafio.entities.Usuario;
import com.zup.orangetalentsdesafio.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<Usuario> cadastrar(Usuario usuario) {
        Optional<Usuario> cpf = usuarioRepository.findByCpf(usuario.getCpf());
        Optional<Usuario> email = usuarioRepository.findByEmail(usuario.getEmail());

        UsuarioResponse usuarioResponse = new UsuarioResponse();

        if(cpf.isPresent() || email.isPresent()) {
            if(cpf.isPresent() && email.isPresent()) {
                usuarioResponse.setMensagem("E-mail deve ser único." + "CPF deve ser único.");
            }
            return Optional.empty();
        }

        return Optional.ofNullable(usuarioRepository.save(usuario));
    }
}



