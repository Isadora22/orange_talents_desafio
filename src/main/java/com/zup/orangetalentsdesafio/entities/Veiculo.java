package com.zup.orangetalentsdesafio.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "tb_vehicle")
public class Veiculo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String marca;

    @NotNull
    private String modelo;

    @NotNull
    private String ano;

    @NotNull
    private String valor;

    @NotNull
    private String diaRodizio;

    @NotNull
    private Boolean rodizioAtivo = false;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Usuario.class)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public Veiculo() {
    }

    public Veiculo(Long id, String marca, String modelo, String ano, String valor, String diaRodizio, Boolean rodizioAtivo, Usuario usuario) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.valor = valor;
        this.diaRodizio = diaRodizio;
        this.rodizioAtivo = rodizioAtivo;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDiaRodizio() {
        return diaRodizio;
    }

    public void setDiaRodizio(String diaRodizio) {
        this.diaRodizio = diaRodizio;
    }

    public Boolean getRodizioAtivo() {
        return rodizioAtivo;
    }

    public void setRodizioAtivo(Boolean rodizioAtivo) {
        this.rodizioAtivo = rodizioAtivo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
