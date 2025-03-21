package com.tabela.fipe.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "carros")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "A marca não pode ser nula")
    private String marca;

    @NotNull(message = "O modelo não pode ser nulo")
    private String modelo;

    @NotNull(message = "O ano do modelo não pode ser nulo")
    private Integer anoModelo;

    @NotNull(message = "O valor do carro não pode ser nulo")
    private Double valor;

    @NotNull(message = "O tipo de combustível não pode ser nulo")
    private String combustivel;

    @NotNull(message = "O código FIPE não pode ser nulo")
    private String codigoFipe;

    @NotNull(message = "O mês de referência não pode ser nulo")
    private String mesReferencia;

    @NotNull(message = "A sigla do combustível não pode ser nula")
    private String siglaCombustivel;

    // Construtor vazio
    public Carro() {
    }

    // Construtor completo
    public Carro(Long id, String marca, String modelo, Integer anoModelo, Double valor, String combustivel,
                 String codigoFipe, String mesReferencia, String siglaCombustivel) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.anoModelo = anoModelo;
        this.valor = valor;
        this.combustivel = combustivel;
        this.codigoFipe = codigoFipe;
        this.mesReferencia = mesReferencia;
        this.siglaCombustivel = siglaCombustivel;
    }

    // Getters e Setters
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

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getCodigoFipe() {
        return codigoFipe;
    }

    public void setCodigoFipe(String codigoFipe) {
        this.codigoFipe = codigoFipe;
    }

    public String getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(String mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    public String getSiglaCombustivel() {
        return siglaCombustivel;
    }

    public void setSiglaCombustivel(String siglaCombustivel) {
        this.siglaCombustivel = siglaCombustivel;
    }

    // Método toString para facilitar logs e depuração
    @Override
    public String toString() {
        return "Carro{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anoModelo=" + anoModelo +
                ", valor=" + valor +
                ", combustivel='" + combustivel + '\'' +
                ", codigoFipe='" + codigoFipe + '\'' +
                ", mesReferencia='" + mesReferencia + '\'' +
                ", siglaCombustivel='" + siglaCombustivel + '\'' +
                '}';
    }
}
