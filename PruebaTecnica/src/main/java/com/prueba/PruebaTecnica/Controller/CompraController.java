package com.prueba.PruebaTecnica.Controller;

import com.prueba.PruebaTecnica.Dtos.CompraDto;
import com.prueba.PruebaTecnica.Entity.Compra;
import com.prueba.PruebaTecnica.Service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @GetMapping
    public List<CompraDto> getCompras() {
        return compraService.getCompras();
    }

    @GetMapping("/{id}")
    public Optional<Compra> getCompraById(@PathVariable Long id) {
        return compraService.getCompraById(id);
    }

    @PostMapping
    public void saveCompra(@RequestBody Compra compra) {
        compraService.saveOrUpdate(compra);
    }

    @PutMapping("/{id}")
    public void updateCompra(@PathVariable Long id, @RequestBody Compra compra) {
        compra.setIdCompra(id);
        compraService.saveOrUpdate(compra);
    }

    @DeleteMapping("/{id}")
    public void deleteCompra(@PathVariable Long id) {
        compraService.deleteById(id);
    }

    @GetMapping("/buscar")
    public List<CompraDto> buscarCompras(
            @RequestParam Long idComercio,
            @RequestParam String fecha,
            @RequestParam String medioPago
    ) {
        return compraService.getComprasByComercioFechaMedioPago(
                idComercio,
                LocalDate.parse(fecha),
                medioPago
        );
    }
}
