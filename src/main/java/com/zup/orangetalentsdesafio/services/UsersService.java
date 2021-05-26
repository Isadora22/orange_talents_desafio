package com.zup.orangetalentsdesafio.services;

import com.zup.orangetalentsdesafio.config.UserResponse;
import com.zup.orangetalentsdesafio.entities.Users;
import com.zup.orangetalentsdesafio.repositories.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public List<Users> listarTodos() {
        return usersRepository.findAll();
    }

    public Optional<Users> cadastrar(Users user) {
        Optional<Users> cpf = usersRepository.findByCpf(user.getCpf());
        Optional<Users> email = usersRepository.findByEmail(user.getEmail());

        UserResponse userResponse = new UserResponse();

        if(cpf.isPresent() || email.isPresent()) {
            if(cpf.isPresent() && email.isPresent()) {
                userResponse.setMensagem("E-mail é obrigatório e deve ser único." + "CPF é obrigatório e deve ser único.");
            }

            return Optional.empty();
        }
        return Optional.ofNullable(usersRepository.save(user));
    }

}
