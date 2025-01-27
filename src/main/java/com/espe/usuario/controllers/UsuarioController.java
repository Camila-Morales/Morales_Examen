package com.espe.usuario.controllers;

import com.espe.usuario.models.Usuario;
import com.espe.usuario.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Obtener todos los usuarios
    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.findAll();
    }

    // Obtener un usuario por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.findById(id);
        return usuario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo usuario
    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        Usuario savedUsuario = usuarioService.save(usuario);
        return ResponseEntity.status(201).body(savedUsuario);
    }

    // Actualizar un usuario existente
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuarioDetails) {
        Optional<Usuario> existingUsuarioOpt = usuarioService.findById(id);
        if (existingUsuarioOpt.isPresent()) {
            Usuario existingUsuario = existingUsuarioOpt.get();
            existingUsuario.setNombre(usuarioDetails.getNombre());
            existingUsuario.setApellido(usuarioDetails.getApellido());
            existingUsuario.setEmail(usuarioDetails.getEmail());
            existingUsuario.setUsername(usuarioDetails.getUsername());
            existingUsuario.setPassword(usuarioDetails.getPassword());
            existingUsuario.setFechaNacimiento(usuarioDetails.getFechaNacimiento());
            existingUsuario.setTelefono(usuarioDetails.getTelefono());

            Usuario updatedUsuario = usuarioService.save(existingUsuario);
            return ResponseEntity.ok(updatedUsuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un usuario por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.findById(id);
        if (usuario.isPresent()) {
            usuarioService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
