package com.prueba.PruebaTecnica.Service;

import com.prueba.PruebaTecnica.Dtos.CompraDto;
import com.prueba.PruebaTecnica.Entity.Compra;
import com.prueba.PruebaTecnica.Repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CompraService {
    @Autowired
    private CompraRepository compraRepository;
    public Optional<Compra> getCompraById(Long id) {
        return compraRepository.findById(id);
    }

    public void saveOrUpdate(Compra compra) {
        compraRepository.save(compra);
    }

    public void deleteById(Long id) {
        compraRepository.deleteById(id);
    }


    public List<CompraDto> getCompras() {
        return compraRepository.findAll().stream()
                .map(c -> new CompraDto(
                        c.getIdCompra(),
                        c.getFecha(),
                        c.getLugar(),
                        c.getMontoTotal(),
                        c.getCliente().getNombre(),
                        c.getComercio().getNombre(),
                        c.getMedioPago().getTipo()
                ))
                .toList();
    }

    public List<CompraDto> getComprasByComercioFechaMedioPago(Long idComercio, LocalDate fecha, String medioPago) {
        return compraRepository.findByComercio_IdComercioAndFechaAndMedioPago_Tipo(idComercio, fecha, medioPago)
                .stream()
                .map(c -> new CompraDto(
                        c.getIdCompra(),
                        c.getFecha(),
                        c.getLugar(),
                        c.getMontoTotal(),
                        c.getCliente().getNombre(),
                        c.getComercio().getNombre(),
                        c.getMedioPago().getTipo()
                ))
                .toList();
    }
}
