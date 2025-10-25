package com.prueba.PruebaTecnica.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompra;

    private LocalDate fecha;
    private String lugar;
    private Double montoTotal;

    // Relaciones
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @JsonBackReference("cliente-compras")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_comercio")
    @JsonBackReference("comercio-compras")
    private Comercio comercio;

    @ManyToOne
    @JoinColumn(name = "id_medio_pago")
    @JsonBackReference("medioPago-compras")
    private MedioPago medioPago;


    public void setIdCompra(Long idCompra) {
        this.idCompra = idCompra;
    }

    public Long getIdCompra() {
        return idCompra;
    }
}
