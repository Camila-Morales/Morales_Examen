package com.espe.usuario.services;

import java.util.List;
import java.util.Optional;

import com.espe.usuario.models.Usuario;

public interface UsuarioService {
    List<Usuario> findAll();

    Optional<Usuario> findById(Long id);

    Usuario save(Usuario usuario);

    void deleteById(Long id);
}
