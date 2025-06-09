package com.InnoSistemasDocumentos.GestionDocumentos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombrearchivo;
    private String tipodocumento;
    private String urlubicacion;
    private String fechasubida;
    private String ultimamodificacion;

}
