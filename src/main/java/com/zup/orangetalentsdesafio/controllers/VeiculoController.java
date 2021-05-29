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

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping("/all")
    public ResponseEntity<List<Veiculo>> listarTodos() {
        List<Veiculo> list = veiculoService.listarTodos();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/add")
    public ResponseEntity<Veiculo> addVehicle(@RequestBody Veiculo veiculo) throws MarcaNotFoundException,
            ModeloNotFoundException, AnoNotFoundException {

        Optional<Veiculo> nvVeiculo = veiculoService.cadastrar(veiculo, veiculo.getUsuario().getId());

        if(nvVeiculo.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.CREATED).body(nvVeiculo.get());
        }
    }
}
