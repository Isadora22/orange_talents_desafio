package com.zup.orangetalentsdesafio.repositories;

import com.zup.orangetalentsdesafio.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
