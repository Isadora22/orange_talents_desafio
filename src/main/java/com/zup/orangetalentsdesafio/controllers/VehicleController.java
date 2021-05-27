package com.zup.orangetalentsdesafio.controllers;

import com.zup.orangetalentsdesafio.FIPEClient;
import com.zup.orangetalentsdesafio.entities.User;
import com.zup.orangetalentsdesafio.entities.Vehicle;
import com.zup.orangetalentsdesafio.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private FIPEClient fipeClient;

    @GetMapping("/{marca}")
    public ResponseEntity<Vehicle> getCep(@PathVariable String marca) {
        Vehicle veiculo = fipeClient.searchVehiclePorMarca(marca);
        return veiculo != null ? ResponseEntity.ok().body(veiculo) : ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Vehicle>> listarTodos() {
        List<Vehicle> list = vehicleService.listarTodos();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Vehicle> addVehicle(@Valid @RequestBody Vehicle vehicle) {
        Optional<Vehicle> newVehicle = vehicleService.cadastrar(vehicle);

        if(newVehicle.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.CREATED).body(newVehicle.get());
        }
    }


}
