package com.zup.orangetalentsdesafio.repositories;

import com.zup.orangetalentsdesafio.entities.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByEmail(String email);
    Optional<Users> findByCpf(String cpf);

}
