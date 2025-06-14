package com.InnoSistemasDocumentos.GestionDocumentos.controller;

import com.InnoSistemasDocumentos.GestionDocumentos.model.Proyecto;
import com.InnoSistemasDocumentos.GestionDocumentos.service.ProyectoService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProyectoController {

    private final ProyectoService proyectoService;

    public ProyectoController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

    @QueryMapping
    public List<Proyecto> findAllProyecto(){
        return proyectoService.findAll();
    }

    @QueryMapping
    public Proyecto findProyectoById(@Argument Long id) {
        return proyectoService.findById(id);
    }

    public record ProyectoInput(String nombreproyecto, String descripcion, String fechacreacion) {}

    @MutationMapping
    public Proyecto createProyecto(@Argument ProyectoInput proyectoInput) {
        Proyecto proyecto = new Proyecto();
        proyecto.setNombreproyecto(proyectoInput.nombreproyecto());
        proyecto.setDescripcion(proyectoInput.descripcion());
        proyecto.setFechacreacion(proyectoInput.fechacreacion());
        return proyectoService.save(proyecto);
    }

    @MutationMapping
    public Proyecto updateProyecto(@Argument Long id, @Argument ProyectoInput proyectoInput) {
        Proyecto proyecto = new Proyecto();
        proyecto.setNombreproyecto(proyectoInput.nombreproyecto());
        proyecto.setDescripcion(proyectoInput.descripcion());
        proyecto.setFechacreacion(proyectoInput.fechacreacion());
        return proyectoService.update(id, proyecto);
    }

    @MutationMapping
    public Boolean deleteProyecto(@Argument Long id) {
        proyectoService.deleteById(id);
        return true;
    }

}
