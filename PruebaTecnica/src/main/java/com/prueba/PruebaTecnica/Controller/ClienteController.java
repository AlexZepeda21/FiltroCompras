package com.prueba.PruebaTecnica.Controller;

import com.prueba.PruebaTecnica.Entity.Cliente;
import com.prueba.PruebaTecnica.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> getClientes() {
        return clienteService.getClientes();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> getClienteById(@PathVariable Long id) {
        return clienteService.getClienteById(id);
    }

    @PostMapping
    public void saveCliente(@RequestBody Cliente cliente) {
        clienteService.saveOrUpdate(cliente);
    }

    @PutMapping("/{id}")
    public void updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        cliente.setIdCliente(id);
        clienteService.saveOrUpdate(cliente);
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {
        clienteService.deleteById(id);
    }
}