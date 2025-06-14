package com.InnoSistemasDocumentos.GestionDocumentos.controller;

import com.InnoSistemasDocumentos.GestionDocumentos.model.Documento;
import com.InnoSistemasDocumentos.GestionDocumentos.service.DocumentoService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class DocumentoController {
    
    private final DocumentoService documentoService;


    public DocumentoController(DocumentoService documentoService) {
        this.documentoService = documentoService;

    }

    @QueryMapping
    public List<Documento> findAllDocumento() {
        return documentoService.findAll();
    }

    @QueryMapping
    public Documento findDocumentoById(@Argument Long id) {
        return documentoService.findById(id);
    }

    public record DocumentoInput(String nombrearchivo, String tipodocumento, String urlubicacion, String fechasubida, String ultimamodificacion) {}

    @MutationMapping
    public Documento createDocumento(@Argument DocumentoInput documentoInput) {
        Documento documento = new Documento();
        documento.setNombrearchivo(documentoInput.nombrearchivo());
        documento.setTipodocumento(documentoInput.tipodocumento());
        documento.setUrlubicacion(documentoInput.urlubicacion());
        documento.setFechasubida(documentoInput.fechasubida());
        documento.setUltimamodificacion(documentoInput.ultimamodificacion());
        return documentoService.save(documento);
    }

    @MutationMapping
    public Documento updateDocumento(@Argument Long id, @Argument DocumentoInput documentoInput) {
        Documento documento = new Documento();
        documento.setNombrearchivo(documentoInput.nombrearchivo());
        documento.setTipodocumento(documentoInput.tipodocumento());
        documento.setUrlubicacion(documentoInput.urlubicacion());
        documento.setFechasubida(documentoInput.fechasubida());
        documento.setUltimamodificacion(documentoInput.ultimamodificacion());
        return documentoService.update(id, documento);
    }

    @MutationMapping
    public Boolean deleteDocumento(@Argument Long id) {
        documentoService.deleteById(id);
        return true;
    }

    public record BookInput(String title, String author, Double price) {}
    
    
}




