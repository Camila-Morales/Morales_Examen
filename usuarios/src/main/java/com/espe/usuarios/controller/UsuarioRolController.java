package com.espe.usuarios.controller;

import com.espe.usuarios.model.UsuarioRol;
import com.espe.usuarios.services.UsuarioRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registro")
public class UsuarioRolController {

    @Autowired
    private UsuarioRolService UsuarioRolService;

    @PostMapping("/{userId}/roles/{roleId}")
    public ResponseEntity<?> assignRole(@PathVariable Long userId, @PathVariable Long roleId) {
        return UsuarioRolService.assignRoleToUser(userId, roleId)
                .map(role -> ResponseEntity.status(201).body(role))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{userId}/roles")
    public List<UsuarioRol> listRoles(@PathVariable Long userId) {
        return UsuarioRolService.findByUserId(userId);
    }

    @GetMapping("/roles/{roleId}/users")
    public List<UsuarioRol> listUsersByRole(@PathVariable Long roleId) {
        return UsuarioRolService.findByRoleId(roleId);
    }

    @DeleteMapping("/{userId}/roles/{roleId}")
    public ResponseEntity<?> revokeRole(@PathVariable Long userId, @PathVariable Long roleId) {
        UsuarioRolService.revokeRoleFromUser(userId, roleId);
        return ResponseEntity.noContent().build();
    }
}