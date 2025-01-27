package com.espe.usuarios.repositories;

import com.espe.usuarios.model.UsuarioRol;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioRolRepository extends CrudRepository<UsuarioRol, Long> {
    List<UsuarioRol> findByUserId(Long userId);
    List<UsuarioRol> findByRoleId(Long roleId);
}