package com.prueba.PruebaTecnica.Service;

import com.prueba.PruebaTecnica.Entity.Cliente;
import com.prueba.PruebaTecnica.Entity.Comercio;
import com.prueba.PruebaTecnica.Repository.ClienteRepository;
import com.prueba.PruebaTecnica.Repository.ComercioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComercioService {

    @Autowired
    private ComercioRepository comercioRepository;

    public List<Comercio> getComercios() {
        return comercioRepository.findAll();
    }

    public Optional<Comercio> getComercioById(Long id) {
        return comercioRepository.findById(id);
    }

    public void saveOrUpdate(Comercio comercio) {
        comercioRepository.save(comercio);
    }

    public void deleteById(Long id) {
        comercioRepository.deleteById(id);
    }

}
