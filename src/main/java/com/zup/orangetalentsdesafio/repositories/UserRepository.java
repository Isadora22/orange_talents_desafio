package com.zup.orangetalentsdesafio.repositories;

import com.zup.orangetalentsdesafio.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findByCpf(String cpf);

}
