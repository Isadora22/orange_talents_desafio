package com.zup.orangetalentsdesafio.services;

import com.zup.orangetalentsdesafio.config.UserResponse;
import com.zup.orangetalentsdesafio.entities.User;
import com.zup.orangetalentsdesafio.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listarTodos() {
        return userRepository.findAll();
    }

    public Optional<User> cadastrar(User user) {
        Optional<User> cpf = userRepository.findByCpf(user.getCpf());
        Optional<User> email = userRepository.findByEmail(user.getEmail());

        UserResponse userResponse = new UserResponse();

        if(cpf.isPresent() || email.isPresent()) {
            if(cpf.isPresent() && email.isPresent()) {
                userResponse.setMensagem("E-mail é obrigatório e deve ser único." + "CPF é obrigatório e deve ser único.");
            }

            return Optional.empty();
        }
        return Optional.ofNullable(userRepository.save(user));
    }

}
