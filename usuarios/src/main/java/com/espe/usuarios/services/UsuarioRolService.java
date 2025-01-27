package com.espe.usuarios.services;

import com.espe.usuarios.client.RolClienteRest;
import com.espe.usuarios.model.Rol;
import com.espe.usuarios.model.UsuarioRol;
import com.espe.usuarios.repositories.UsuarioRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioRolService {

    @Autowired
    private UsuarioRolRepository UsuarioRolRepository;

    @Autowired
    private RolClienteRest roleClientRest;

    public List<UsuarioRol> findByUserId(Long userId) {
        return UsuarioRolRepository.findByUserId(userId);
    }

    public List<UsuarioRol> findByRoleId(Long roleId) {
        return UsuarioRolRepository.findByRoleId(roleId);
    }

    public Optional<UsuarioRol> assignRoleToUser(Long userId, Long roleId) {
        Rol role = roleClientRest.findById(roleId);
        if (role == null) {
            return Optional.empty();
        }

        UsuarioRol UsuarioRol = new UsuarioRol();
        UsuarioRol.setUserId(userId);
        UsuarioRol.setRoleId(roleId);

        return Optional.of(UsuarioRolRepository.save(UsuarioRol));
    }

    public void revokeRoleFromUser(Long userId, Long roleId) {
        List<UsuarioRol> UsuarioRols = UsuarioRolRepository.findByUserId(userId);
        UsuarioRols.stream()
                .filter(ur -> ur.getRoleId().equals(roleId))
                .findFirst()
                .ifPresent(UsuarioRolRepository::delete);
    }
}