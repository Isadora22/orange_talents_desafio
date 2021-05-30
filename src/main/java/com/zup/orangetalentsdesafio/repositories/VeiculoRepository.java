package com.zup.orangetalentsdesafio.repositories;

import com.zup.orangetalentsdesafio.entities.Veiculo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

}
