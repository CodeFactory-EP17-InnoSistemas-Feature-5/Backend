package com.InnoSistemasDocumentos.GestionDocumentos.service;

import com.InnoSistemasDocumentos.GestionDocumentos.model.Usuario;
import com.InnoSistemasDocumentos.GestionDocumentos.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElseThrow();
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario update(Long id, Usuario usuarioDetails) {
        Usuario usuario = findById(id);
        usuario.setNombreusuario(usuarioDetails.getNombreusuario());
        usuario.setRol(usuarioDetails.getRol());
        usuario.setCorreo(usuarioDetails.getCorreo());
        return usuarioRepository.save(usuario);
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);}
}