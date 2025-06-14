package com.InnoSistemasDocumentos.GestionDocumentos.controller;

import com.InnoSistemasDocumentos.GestionDocumentos.model.Usuario;
import com.InnoSistemasDocumentos.GestionDocumentos.service.UsuarioService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @QueryMapping
    public List<Usuario> findAllUsuarios() {
        return usuarioService.findAll();
    }

    @QueryMapping
    public List<Usuario> findAllUsuario(){
        return usuarioService.findAll();
    }

    @QueryMapping
    public Usuario findUsuarioById(@Argument Long id) {
        return usuarioService.findById(id);
    }

    public record UsuarioInput(String nombreusuario, String rol, String correo) {}

    @MutationMapping
    public Usuario createUsuario(@Argument UsuarioInput usuarioInput) {
        Usuario usuario = new Usuario();
        usuario.setNombreusuario(usuarioInput.nombreusuario());
        usuario.setRol(usuarioInput.rol());
        usuario.setCorreo(usuarioInput.correo());
        return usuarioService.save(usuario);
    }

    @MutationMapping
    public Usuario updateUsuario(@Argument Long id, @Argument UsuarioInput usuarioInput) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombreusuario(usuarioInput.nombreusuario());
        usuario.setRol(usuarioInput.rol());
        usuario.setCorreo(usuarioInput.correo());
        return usuarioService.update(id, usuario);
    }

    @MutationMapping
    public Boolean deleteUsuario(@Argument Long id) {
        usuarioService.deleteById(id);
        return true;
    }
}
