package com.InnoSistemasDocumentos.GestionDocumentos.repository;

import com.InnoSistemasDocumentos.GestionDocumentos.model.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {
}
