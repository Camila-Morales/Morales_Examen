package com.espe.usuario.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.espe.usuario.models.Usuario;
import com.espe.usuario.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements com.espe.usuario.services.UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) repository.findAll();
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
