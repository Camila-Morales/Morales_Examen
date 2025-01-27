package com.espe.roles.services;

import com.espe.roles.model.Rol;
import com.espe.roles.repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository RolRepository;

    @Override
    public List<Rol> findAll() {
        return (List<Rol>) RolRepository.findAll();
    }

    @Override
    public Optional<Rol> findById(Long id) {
        return RolRepository.findById(id);
    }

    @Override
    public Rol save(Rol Rol) {
        return RolRepository.save(Rol);
    }

    @Override
    public Rol update(Long id, Rol updatedRol) {
        return RolRepository.findById(id).map(existingRol -> {
            existingRol.setNombre(updatedRol.getNombre());
            existingRol.setDescripcion(updatedRol.getDescripcion());
            return RolRepository.save(existingRol);
        }).orElseThrow(() -> new RuntimeException("Rol no encontrado con el ID: " + id));
    }

    @Override
    public void deleteById(Long id) {
        RolRepository.deleteById(id);
    }
}
