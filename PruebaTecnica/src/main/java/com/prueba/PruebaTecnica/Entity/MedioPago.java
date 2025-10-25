package com.prueba.PruebaTecnica.Entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

@Entity
public class MedioPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedioPago;

    private String tipo; // Efectivo, Tarjeta, Plazos

    @OneToMany(mappedBy = "medioPago")
    @JsonManagedReference("medioPago-compras")
    private List<Compra> compras;

    // Getters y Setters
    public Long getIdMedioPago() { return idMedioPago; }
    public void setIdMedioPago(Long idMedioPago) { this.idMedioPago = idMedioPago; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public List<Compra> getCompras() { return compras; }
    public void setCompras(List<Compra> compras) { this.compras = compras; }
}
