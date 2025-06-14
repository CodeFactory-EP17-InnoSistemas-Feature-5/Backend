package com.InnoSistemasDocumentos.GestionDocumentos.service;

import com.InnoSistemasDocumentos.GestionDocumentos.model.Proyecto;
import com.InnoSistemasDocumentos.GestionDocumentos.repository.ProyectoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoService {
    private final ProyectoRepository proyectoRepository;

    public ProyectoService(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    public List<Proyecto> findAll() {
        return proyectoRepository.findAll();
    }

    public Proyecto findById(Long id) {
        return proyectoRepository.findById(id).orElseThrow();
    }

    public Proyecto save(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    public Proyecto update(Long id, Proyecto proyectoDetails) {
        Proyecto proyecto = findById(id);
        proyecto.setNombreproyecto(proyectoDetails.getNombreproyecto());
        proyecto.setDescripcion(proyectoDetails.getDescripcion());
        proyecto.setFechacreacion(proyectoDetails.getFechacreacion());
        return proyectoRepository.save(proyecto);
    }

    public void deleteById(Long id) {
        proyectoRepository.deleteById(id);
    }
}