package com.espe.roles.services;

import com.espe.roles.model.Rol;

import java.util.List;
import java.util.Optional;

public interface RolService {
    List<Rol> findAll();
    Optional<Rol> findById(Long id);
    Rol save(Rol Rol);
    Rol update(Long id, Rol updatedRol);
    void deleteById(Long id);
}
