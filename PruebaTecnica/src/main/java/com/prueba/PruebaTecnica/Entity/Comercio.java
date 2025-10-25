package com.prueba.PruebaTecnica.Entity;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

@Entity
@Data
public class Comercio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComercio;

    private String nombre;
    private String direccion;
    private String rubro; // opcional

    // Relación: un comercio tiene muchas compras
    @OneToMany(mappedBy = "comercio")
    @JsonManagedReference("comercio-compras")
    private List<Compra> compras;

}
