package com.InnoSistemasDocumentos.GestionDocumentos.repository;

import com.InnoSistemasDocumentos.GestionDocumentos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
