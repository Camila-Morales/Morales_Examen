package com.espe.roles.services;

import com.espe.roles.model.entities.Rol;

import java.util.List;
import java.util.Optional;

public interface RolService {
    List<Rol> getAllRoles();
    Optional<Rol> getRolById(Long id);
    Rol createRol(Rol rol);
    Optional<Rol> updateRol(Long id, Rol rol);
    boolean deleteRol(Long id);
}
