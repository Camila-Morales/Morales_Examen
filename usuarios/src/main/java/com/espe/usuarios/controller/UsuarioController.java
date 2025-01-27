package com.espe.usuarios.controller;

import com.espe.usuarios.model.Usuario;
import com.espe.usuarios.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService UsuarioService;

    @GetMapping
    public List<Usuario> listAll() {
        return UsuarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Usuario> Usuario = UsuarioService.findById(id);
        return Usuario.isPresent() ? ResponseEntity.ok(Usuario.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Usuario Usuario) {
        return ResponseEntity.status(201).body(UsuarioService.save(Usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody Usuario updatedUsuario) {
        try {
            Usuario Usuario = UsuarioService.update(id, updatedUsuario);
            return ResponseEntity.ok(Usuario);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Usuario> Usuario = UsuarioService.findById(id);
        if (Usuario.isPresent()) {
            UsuarioService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
