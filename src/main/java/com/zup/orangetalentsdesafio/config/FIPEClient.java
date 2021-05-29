package com.zup.orangetalentsdesafio.config;

import com.zup.orangetalentsdesafio.entities.models.Ano;
import com.zup.orangetalentsdesafio.entities.models.Marca;
import com.zup.orangetalentsdesafio.entities.models.Modelo;
import com.zup.orangetalentsdesafio.entities.models.VeiculoDetalhe;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "fipeClient", url = "https://parallelum.com.br/fipe/api/v1")
public interface FIPEClient {

    @GetMapping("/carros/marcas")
    List<Marca> getMarcas();

    @GetMapping("/carros/marcas/{codigo}/modelos")
    Modelo getModelos(@PathVariable String codigo);

    @GetMapping("/carros/marcas/{codigoMarca}/modelos/{codigoModelo}/anos")
    List<Ano> getAnos(@PathVariable String codigoMarca, @PathVariable Integer codigoModelo);

    @GetMapping("/carros/marcas/{codigoMarca}/modelos/{codigoModelo}/anos/{ano}")
    VeiculoDetalhe getVeiculoDetalhe(@PathVariable String codigoMarca, @PathVariable Integer codigoModelo, @PathVariable String ano);

}
