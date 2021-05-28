package com.zup.orangetalentsdesafio.entities.models;

import java.util.List;

public class Modelo {

    private List<Modelos> modelos;

    public Modelo() {
    }

    public Modelo(List<Modelos> modelos) {
        this.modelos = modelos;
    }

    public List<Modelos> getModelos() {
        return modelos;
    }

    public void setModelos(List<Modelos> modelos) {
        this.modelos = modelos;
    }

    public static class Modelos {
        private String nome;
        private Integer codigo;

        public Modelos() {
        }

        public Modelos(String nome, Integer codigo) {
            this.nome = nome;
            this.codigo = codigo;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Integer getCodigo() {
            return codigo;
        }

        public void setCodigo(Integer codigo) {
            this.codigo = codigo;
        }
    }
}
