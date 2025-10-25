package com.prueba.PruebaTecnica.Service;

import com.prueba.PruebaTecnica.Entity.MedioPago;
import com.prueba.PruebaTecnica.Repository.MedioPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedioPagoService {
    @Autowired
    private MedioPagoRepository medioPagoRepository;

    public List<MedioPago> getMediosPago() {
        return medioPagoRepository.findAll();
    }

    public Optional<MedioPago> getMedioPagoById(Long id) {
        return medioPagoRepository.findById(id);
    }

    public void saveOrUpdate(MedioPago medioPago) {
        medioPagoRepository.save(medioPago);
    }

    public void deleteById(Long id) {
        medioPagoRepository.deleteById(id);
    }
}
