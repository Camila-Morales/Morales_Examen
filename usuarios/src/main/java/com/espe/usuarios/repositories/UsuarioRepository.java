package com.espe.usuarios.repositories;

import com.espe.usuarios.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}