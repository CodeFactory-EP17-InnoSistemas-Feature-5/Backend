package com.InnoSistemasDocumentos.GestionDocumentos.controller;

import com.InnoSistemasDocumentos.GestionDocumentos.model.Documento;
import com.InnoSistemasDocumentos.GestionDocumentos.model.Entrega;
import com.InnoSistemasDocumentos.GestionDocumentos.model.Proyecto;
import com.InnoSistemasDocumentos.GestionDocumentos.model.Usuario;
import com.InnoSistemasDocumentos.GestionDocumentos.service.EntregaService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EntregaController {
    private final EntregaService entregaService;

    public EntregaController(EntregaService entregaService) {
        this.entregaService = entregaService;
    }

    @QueryMapping
    public List<Entrega> findAllEntregas() {
        return entregaService.findAll();
    }

    @QueryMapping
    public Entrega findEntregaById(Long id) {
        return entregaService.findById(id);
    }

    public record EntregaInput(String fechaentrega, Long usuarioid, Long proyectoid, Long documentoid) {}

    @MutationMapping
    public Entrega createEntrega(@Argument EntregaInput entregaInput){
        Entrega entrega = new Entrega();
        entrega.setFechaentrega(entregaInput.fechaentrega());

        Usuario usuario = new Usuario();
        usuario.setId(entregaInput.usuarioid());
        entrega.setUsuario(usuario);

        Proyecto proyecto = new Proyecto();
        proyecto.setId(entregaInput.proyectoid());
        entrega.setProyecto(proyecto);

        Documento documento = new Documento();
        documento.setId(entregaInput.documentoid());
        entrega.setDocumento(documento);

        return entregaService.save(entrega);
    }

    @MutationMapping
    public Entrega updateEntrega(@Argument Long id, @Argument EntregaInput entregaInput) {
        Entrega entrega = new Entrega();
        entrega.setId(id);
        entrega.setFechaentrega(entregaInput.fechaentrega());

        Usuario usuario = new Usuario();
        usuario.setId(entregaInput.usuarioid());
        entrega.setUsuario(usuario);

        Proyecto proyecto = new Proyecto();
        proyecto.setId(entregaInput.proyectoid());
        entrega.setProyecto(proyecto);

        Documento documento = new Documento();
        documento.setId(entregaInput.documentoid());
        entrega.setDocumento(documento);

        return entregaService.update(id, entrega);
    }

    @MutationMapping
    public Boolean deleteEntrega(@Argument Long id) {
        entregaService.deleteById(id);
        return true;
    }

}
