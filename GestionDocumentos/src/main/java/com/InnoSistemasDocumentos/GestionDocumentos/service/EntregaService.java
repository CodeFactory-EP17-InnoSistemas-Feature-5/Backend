package com.InnoSistemasDocumentos.GestionDocumentos.service;

import com.InnoSistemasDocumentos.GestionDocumentos.model.Entrega;
import com.InnoSistemasDocumentos.GestionDocumentos.repository.EntregaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregaService {
    private final EntregaRepository entregaRepository;

    public EntregaService(EntregaRepository entregaRepository) {
        this.entregaRepository = entregaRepository;
    }

    public List<Entrega> findAll() {
        return entregaRepository.findAll();
    }

    public Entrega findById(Long id) {
        return entregaRepository.findById(id).orElseThrow();
    }

    public Entrega save(Entrega entrega) {
        return entregaRepository.save(entrega);
    }

    public Entrega update(Long id, Entrega entregaDetails) {
        Entrega entrega = findById(id);
        entrega.setFechaentrega(entregaDetails.getFechaentrega());

        return null;
    }

    public void deleteById(Long id) {
        entregaRepository.deleteById(id);
    }
}
