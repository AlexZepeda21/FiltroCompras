package com.prueba.PruebaTecnica.Controller;

import com.prueba.PruebaTecnica.Entity.MedioPago;
import com.prueba.PruebaTecnica.Service.MedioPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/mediospago")
public class MedioPagoController {

    @Autowired
    private MedioPagoService medioPagoService;

    @GetMapping
    public List<MedioPago> getMediosPago() {
        return medioPagoService.getMediosPago();
    }

    @GetMapping("/{id}")
    public Optional<MedioPago> getMedioPagoById(@PathVariable Long id) {
        return medioPagoService.getMedioPagoById(id);
    }

    @PostMapping
    public void saveMedioPago(@RequestBody MedioPago medioPago) {
        medioPagoService.saveOrUpdate(medioPago);
    }

    @PutMapping("/{id}")
    public void updateMedioPago(@PathVariable Long id, @RequestBody MedioPago medioPago) {
        medioPago.setIdMedioPago(id);
        medioPagoService.saveOrUpdate(medioPago);
    }

    @DeleteMapping("/{id}")
    public void deleteMedioPago(@PathVariable Long id) {
        medioPagoService.deleteById(id);
    }
}
