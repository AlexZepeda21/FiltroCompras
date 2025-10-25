package com.prueba.PruebaTecnica.Repository;

import com.prueba.PruebaTecnica.Entity.Comercio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComercioRepository extends JpaRepository<Comercio, Long> {
}
