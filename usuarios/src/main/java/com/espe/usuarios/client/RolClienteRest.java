package com.espe.usuarios.client;

import com.espe.usuarios.model.Rol;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "roles", url = "localhost:8005/api/roles")
public interface RolClienteRest {
    @GetMapping("/{id}")
    Rol findById(@PathVariable Long id);
}