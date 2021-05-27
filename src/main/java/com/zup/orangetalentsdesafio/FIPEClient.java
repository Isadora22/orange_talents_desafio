package com.zup.orangetalentsdesafio;

import com.zup.orangetalentsdesafio.entities.Vehicle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "fipeClient", url = "https://parallelum.com.br/fipe/api/v1/carros/marcas/")
public interface FIPEClient {

    @GetMapping("{marca}/modelos")
    Vehicle searchVehiclePorMarca(@PathVariable("marca") String marca);
}
