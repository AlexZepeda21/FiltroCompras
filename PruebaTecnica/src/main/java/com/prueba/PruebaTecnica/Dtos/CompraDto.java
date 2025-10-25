package com.prueba.PruebaTecnica.Dtos;

import java.time.LocalDate;

public class CompraDto {
    private Long idCompra;
    private LocalDate fecha;
    private String lugar;
    private Double montoTotal;
    private String cliente;
    private String comercio;
    private String medioPago;

    public CompraDto(Long idCompra, LocalDate fecha, String lugar, Double montoTotal,
                     String cliente, String comercio, String medioPago) {
        this.idCompra = idCompra;
        this.fecha = fecha;
        this.lugar = lugar;
        this.montoTotal = montoTotal;
        this.cliente = cliente;
        this.comercio = comercio;
        this.medioPago = medioPago;
    }

    // Getters y setters
    public Long getIdCompra() { return idCompra; }
    public LocalDate getFecha() { return fecha; }
    public String getLugar() { return lugar; }
    public Double getMontoTotal() { return montoTotal; }
    public String getCliente() { return cliente; }
    public String getComercio() { return comercio; }
    public String getMedioPago() { return medioPago; }
}
