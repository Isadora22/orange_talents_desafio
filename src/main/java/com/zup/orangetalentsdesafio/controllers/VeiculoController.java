package com.zup.orangetalentsdesafio.controllers;

import com.zup.orangetalentsdesafio.entities.Veiculo;
import com.zup.orangetalentsdesafio.exceptions.AnoNotFoundException;
import com.zup.orangetalentsdesafio.exceptions.MarcaNotFoundException;
import com.zup.orangetalentsdesafio.exceptions.ModeloNotFoundException;
import com.zup.orangetalentsdesafio.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping("/add/{id}")
    public ResponseEntity<Veiculo> addVehicle(@Valid @RequestBody Veiculo veiculo, @PathVariable("id") Long id) throws MarcaNotFoundException,
            ModeloNotFoundException, AnoNotFoundException {
        Optional<Veiculo> newVehicle = veiculoService.cadastrar(veiculo, id);

        if(newVehicle.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.CREATED).body(newVehicle.get());
        }
    }


}
