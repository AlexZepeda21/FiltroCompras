package com.prueba.PruebaTecnica.Repository;

import com.prueba.PruebaTecnica.Entity.MedioPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedioPagoRepository extends JpaRepository<MedioPago, Long> {
}
