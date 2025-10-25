package com.prueba.PruebaTecnica.Repository;

import com.prueba.PruebaTecnica.Entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

    // Buscar por comercio, fecha y medio de pago
    List<Compra> findByComercio_IdComercioAndFechaAndMedioPago_Tipo(
            Long idComercio,
            LocalDate fecha,
            String tipoMedioPago
    );

}
