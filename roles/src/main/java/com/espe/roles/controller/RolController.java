package com.espe.roles.controller;

import com.espe.roles.model.Rol;
import com.espe.roles.services.RolService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolService RolService;

    @GetMapping
    public List<Rol> listAll() {
        return RolService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Rol> Rol = RolService.findById(id);
        return Rol.isPresent() ? ResponseEntity.ok(Rol.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Rol Rol) {
        return ResponseEntity.status(201).body(RolService.save(Rol));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody Rol updatedRol) {
        try {
            Rol Rol = RolService.update(id, updatedRol);
            return ResponseEntity.ok(Rol);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Rol> Rol = RolService.findById(id);
        if (Rol.isPresent()) {
            RolService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
