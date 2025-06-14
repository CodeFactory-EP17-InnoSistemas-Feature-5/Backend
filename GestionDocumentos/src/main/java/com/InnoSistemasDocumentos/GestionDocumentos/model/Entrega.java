package com.InnoSistemasDocumentos.GestionDocumentos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fechaentrega;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idusuario", referencedColumnName = "id")
    private Usuario usuario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idproyecto", referencedColumnName = "id")
    private Proyecto proyecto;

    @ManyToOne(optional = false)
    @JoinColumn(name = "iddocumento", referencedColumnName = "id")
    private Documento documento;
}