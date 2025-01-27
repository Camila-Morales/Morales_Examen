package com.espe.roles.services.impl;

import com.espe.roles.model.entities.Rol;
import com.espe.roles.repositories.RolRepository;
import com.espe.roles.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<Rol> getAllRoles() {
        return rolRepository.findAll();
    }

    @Override
    public Optional<Rol> getRolById(Long id) {
        return rolRepository.findById(id);
    }

    @Override
    public Rol createRol(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public Optional<Rol> updateRol(Long id, Rol rol) {
        if (rolRepository.existsById(id)) {
            rol.setId(id);
            return Optional.of(rolRepository.save(rol));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteRol(Long id) {
        if (rolRepository.existsById(id)) {
            rolRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
