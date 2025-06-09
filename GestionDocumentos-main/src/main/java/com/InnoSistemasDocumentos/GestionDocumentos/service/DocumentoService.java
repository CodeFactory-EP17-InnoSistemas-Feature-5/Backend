package com.InnoSistemasDocumentos.GestionDocumentos.service;


import com.InnoSistemasDocumentos.GestionDocumentos.model.Documento;
import com.InnoSistemasDocumentos.GestionDocumentos.repository.DocumentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentoService {
    private final DocumentoRepository documentoRepository;

    public DocumentoService(DocumentoRepository documentoRepository) {
        this.documentoRepository = documentoRepository;
    }

    public List<Documento> findAll() {
        return documentoRepository.findAll();
    }

    public Documento findById(Long id) {
        return documentoRepository.findById(id).orElseThrow();
    }

    public Documento save(Documento documento) {
        return documentoRepository.save(documento);
    }

    public Documento update(Long id, Documento documentoDetails) {
        Documento documento = findById(id);
        documento.setNombrearchivo(documentoDetails.getNombrearchivo());
        documento.setTipodocumento(documentoDetails.getTipodocumento());
        documento.setUrlubicacion(documentoDetails.getUrlubicacion());
        documento.setFechasubida(documentoDetails.getFechasubida());
        documento.setUltimamodificacion(documentoDetails.getUltimamodificacion());
        return documentoRepository.save(documento);
    }

    public void deleteById(Long id) {
        documentoRepository.deleteById(id);
    }
}
