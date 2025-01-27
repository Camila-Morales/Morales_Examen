package com.espe.usuarios.services;

import com.espe.usuarios.model.Usuario;
import com.espe.usuarios.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository UsuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) UsuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return UsuarioRepository.findById(id);
    }

    @Override
    public Usuario save(Usuario Usuario) {
        return UsuarioRepository.save(Usuario);
    }

    @Override
    public Usuario update(Long id, Usuario updatedUsuario) {
        return UsuarioRepository.findById(id).map(existingUsuario -> {
            existingUsuario.setNombre(updatedUsuario.getNombre());
            existingUsuario.setApellido(updatedUsuario.getApellido());
            existingUsuario.setEmail(updatedUsuario.getEmail());
            existingUsuario.setFechaNacimiento(updatedUsuario.getFechaNacimiento());
            existingUsuario.setTelefono(updatedUsuario.getTelefono());
            return UsuarioRepository.save(existingUsuario);
        }).orElseThrow(() -> new RuntimeException("Usuario no encontrado con el ID: " + id));
    }

    @Override
    public void deleteById(Long id) {
        UsuarioRepository.deleteById(id);
    }
}
