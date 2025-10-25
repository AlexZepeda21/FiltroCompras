package com.prueba.PruebaTecnica.Controller;

import com.prueba.PruebaTecnica.Entity.Comercio;
import com.prueba.PruebaTecnica.Service.ComercioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/comercios")
public class ComercioController {

    @Autowired
    private ComercioService comercioService;

    @GetMapping
    public List<Comercio> getComercios() {
        return comercioService.getComercios();
    }

    @GetMapping("/{id}")
    public Optional<Comercio> getComercioById(@PathVariable Long id) {
        return comercioService.getComercioById(id);
    }

    @PostMapping
    public void saveComercio(@RequestBody Comercio comercio) {
        comercioService.saveOrUpdate(comercio);
    }

    @PutMapping("/{id}")
    public void updateComercio(@PathVariable Long id, @RequestBody Comercio comercio) {
        comercio.setIdComercio(id);
        comercioService.saveOrUpdate(comercio);
    }

    @DeleteMapping("/{id}")
    public void deleteComercio(@PathVariable Long id) {
        comercioService.deleteById(id);
    }
}
