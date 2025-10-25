package com.prueba.PruebaTecnica.Entity;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

@Data
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    private String nombre;
    private String email;
    private String telefono;

    // Relación: un cliente puede hacer muchas compras
    @OneToMany(mappedBy = "cliente")
    @JsonManagedReference("cliente-compras")
    private List<Compra> compras;

}
