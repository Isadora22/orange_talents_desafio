package com.zup.orangetalentsdesafio.services;

import com.zup.orangetalentsdesafio.FIPEClient;
import com.zup.orangetalentsdesafio.entities.User;
import com.zup.orangetalentsdesafio.entities.Vehicle;
import com.zup.orangetalentsdesafio.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> listarTodos() {
        return vehicleRepository.findAll();
    }

    public Optional<Vehicle> cadastrar(Vehicle vehicle) {
        return Optional.ofNullable(vehicleRepository.save(vehicle));
    }
}
