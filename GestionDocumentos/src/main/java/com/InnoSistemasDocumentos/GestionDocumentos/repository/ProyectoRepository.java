package com.InnoSistemasDocumentos.GestionDocumentos.repository;

import com.InnoSistemasDocumentos.GestionDocumentos.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
}
