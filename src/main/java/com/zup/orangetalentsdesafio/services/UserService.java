package com.zup.orangetalentsdesafio.services;

import com.zup.orangetalentsdesafio.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

}
